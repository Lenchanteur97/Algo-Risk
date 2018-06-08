import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class FenDialogDeplacement extends JDialog{
	private static final long serialVersionUID = 1L;
	
	private Territoire T1,T2;
	private ArrayList<Armée> ListeSoldats;
	private ArrayList<Armée> ListeCavaliers;
	private ArrayList<Armée> ListeCanons;
	private ArrayList<Armée> ListeSoldatsDeplacementRestant;
	private ArrayList<Armée> ListeCavaliersDeplacementRestant;
	private ArrayList<Armée> ListeCanonsDeplacementRestant;
	private int nbMaxSoldats;
	private int nbMaxCavaliers;
	private int nbMaxCanons;
	private int nbTroupes;
	private JPanel PanneauControle;
	private JPanel PanneauMilieu;
	private JPanel PanneauHaut;
	private JPanel PanneauChoixSoldat;
	private JPanel PanneauChoixCavalier;
	private JPanel PanneauChoixCanon;
	private JLabel Info;
	private JLabel nbSoldats;
	private JLabel nbCavaliers;
	private JLabel nbCanons;
	private JButton BoutonValiderDeplacement;
	private JButton BoutonAnnulerDeplacement;
	private JButton AjouterSoldat;
	private JButton SupprimerSoldat;
	private JButton AjouterCavalier;
	private JButton SupprimerCavalier;
	private JButton AjouterCanon;
	private JButton SupprimerCanon;
	Interface fenetre;
	
	public FenDialogDeplacement(Territoire T1, Territoire T2, Interface fenetre) {
		super();
		this.fenetre=fenetre;
		this.setTitle("Déplacement");
		this.setModal(false);
		this.setSize(420,550);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		this.T1=T1;
		this.T2=T2;
		this.ListeSoldats = new ArrayList<Armée>();
		this.ListeCavaliers = new ArrayList<Armée>();
		this.ListeCanons = new ArrayList<Armée>();
		this.ListeSoldatsDeplacementRestant=T1.UniteAvecDeplacements("Soldat");
		this.ListeCavaliersDeplacementRestant=T1.UniteAvecDeplacements("Cavalier");
		this.ListeCanonsDeplacementRestant=T1.UniteAvecDeplacements("Canon");
		this.nbMaxSoldats=T1.UniteAvecDeplacements("Soldat").size();
		this.nbMaxCavaliers=T1.UniteAvecDeplacements("Cavalier").size();
		this.nbMaxCanons=T1.UniteAvecDeplacements("Canon").size();
		this.nbTroupes = 0;
		
		PanneauHaut = new JPanel();
			Info = new JLabel("Sélectionnez les troupes à déplacer :");
			Info.setFont(new Font("Arial",Font.PLAIN,22));
			Info.setHorizontalAlignment(SwingConstants.CENTER);
			Info.setVerticalAlignment(SwingConstants.CENTER);
		PanneauHaut.add(Info);
		this.add(PanneauHaut);
		PanneauHaut.setBounds(0, 20, 400, 40);
		
		PanneauMilieu = new JPanel();
		PanneauMilieu.setSize(400,400);
		PanneauMilieu.setLayout(new GridLayout(3,1,10,10));
			PanneauChoixSoldat = new JPanel();
			PanneauChoixSoldat.setSize(400,90);
			PanneauChoixSoldat.setLayout(null);
				PanneauSoldat ImageSoldat = new PanneauSoldat();
				nbSoldats = new JLabel(Integer.toString(ListeSoldats.size()));
				nbSoldats.setFont(new Font("Arial",Font.BOLD,25));
				nbSoldats.setHorizontalAlignment(SwingConstants.CENTER);
				nbSoldats.setVerticalAlignment(SwingConstants.CENTER);
				AjouterSoldat = new JButton("+");
				AjouterSoldat.setFont(new Font("Arial",Font.BOLD,25));
				AjouterSoldat.addActionListener(new BoutonAjouterSoldat());
				SupprimerSoldat = new JButton("-");
				SupprimerSoldat.setFont(new Font("Arial",Font.BOLD,25));
				SupprimerSoldat.addActionListener(new BoutonSupprimerSoldat());
			PanneauChoixSoldat.add(ImageSoldat);
			PanneauChoixSoldat.add(SupprimerSoldat);
			PanneauChoixSoldat.add(nbSoldats);
			PanneauChoixSoldat.add(AjouterSoldat);	
			ImageSoldat.setBounds(0,0,100,100);
			SupprimerSoldat.setBounds(125, 25, 50, 50);
			nbSoldats.setBounds(225, 0, 55, 100);
			AjouterSoldat.setBounds(325, 25, 50, 50);
		PanneauMilieu.add(PanneauChoixSoldat);
			
			PanneauChoixCavalier = new JPanel();
			PanneauChoixCavalier.setSize(400,90);
			PanneauChoixCavalier.setLayout(null);
				PanneauCavalier ImageCavalier = new PanneauCavalier();
				nbCavaliers = new JLabel(Integer.toString(ListeCavaliers.size()));
				nbCavaliers.setFont(new Font("Arial",Font.BOLD,25));
				nbCavaliers.setHorizontalAlignment(SwingConstants.CENTER);
				nbCavaliers.setVerticalAlignment(SwingConstants.CENTER);
				AjouterCavalier = new JButton("+");
				AjouterCavalier.setFont(new Font("Arial",Font.BOLD,25));
				AjouterCavalier.addActionListener(new BoutonAjouterCavalier());
				SupprimerCavalier = new JButton("-");
				SupprimerCavalier.setFont(new Font("Arial",Font.BOLD,25));
				SupprimerCavalier.addActionListener(new BoutonSupprimerCavalier());
			PanneauChoixCavalier.add(ImageCavalier);
			PanneauChoixCavalier.add(SupprimerCavalier);
			PanneauChoixCavalier.add(nbCavaliers);
			PanneauChoixCavalier.add(AjouterCavalier);
			ImageCavalier.setBounds(0,0,100,100);
			SupprimerCavalier.setBounds(125, 25, 50, 50);
			nbCavaliers.setBounds(225, 0, 55, 100);
			AjouterCavalier.setBounds(325, 25, 50, 50);
		PanneauMilieu.add(PanneauChoixCavalier);
		
			PanneauChoixCanon = new JPanel();
			PanneauChoixCanon.setSize(400,90);
			PanneauChoixCanon.setLayout(null);
				PanneauCanon ImageCanon = new PanneauCanon();
				nbCanons = new JLabel(Integer.toString(ListeCanons.size()));
				nbCanons.setFont(new Font("Arial",Font.BOLD,25));
				nbCanons.setHorizontalAlignment(SwingConstants.CENTER);
				nbCanons.setVerticalAlignment(SwingConstants.CENTER);
				AjouterCanon = new JButton("+");
				AjouterCanon.setSize(50,50);
				AjouterCanon.setHorizontalAlignment(SwingConstants.CENTER);
				AjouterCanon.setFont(new Font("Arial",Font.BOLD,25));
				AjouterCanon.addActionListener(new BoutonAjouterCanon());
				SupprimerCanon = new JButton("-");
				SupprimerCanon.setFont(new Font("Arial",Font.BOLD,25));
				SupprimerCanon.addActionListener(new BoutonSupprimerCanon());
			PanneauChoixCanon.add(ImageCanon);
			PanneauChoixCanon.add(SupprimerCanon);
			PanneauChoixCanon.add(nbCanons);
			PanneauChoixCanon.add(AjouterCanon);
			ImageCanon.setBounds(0,0,100,100);
			SupprimerCanon.setBounds(125, 25, 50, 50);
			nbCanons.setBounds(225, 0, 55, 100);
			AjouterCanon.setBounds(325, 25, 50, 50);
		PanneauMilieu.add(PanneauChoixCanon);
		this.add(PanneauMilieu);
		PanneauMilieu.setBounds(10, 60, 400, 350);
		
		PanneauControle = new JPanel();
		PanneauControle.setSize(400,100);
		PanneauControle.setLayout(null);
			BoutonValiderDeplacement = new JButton("Valider");
			BoutonValiderDeplacement.setFont(new Font("Arial",Font.PLAIN,22));
			BoutonValiderDeplacement.addActionListener(new BoutonValiderDeplacement());
			BoutonAnnulerDeplacement = new JButton("Annuler");
			BoutonAnnulerDeplacement.setFont(new Font("Arial",Font.PLAIN,22));
			BoutonAnnulerDeplacement.addActionListener(new BoutonAnnulerDeplacement());
		PanneauControle.add(BoutonValiderDeplacement);
		PanneauControle.add(BoutonAnnulerDeplacement);
		BoutonValiderDeplacement.setBounds(45,20,140,60);
		BoutonAnnulerDeplacement.setBounds(225,20,140,60);
		this.add(PanneauControle);
		PanneauControle.setBounds(0, 400, 400, 80);
		VerifBoutons();
		this.setVisible(true);
		
	}
	
	// Action rÃ©alisÃ©e quand on clique sur le bouton supprimer Soldat
	public class BoutonSupprimerSoldat implements ActionListener{
		 public void actionPerformed(ActionEvent e) {
			 ListeSoldatsDeplacementRestant.add(ListeSoldats.get(0));
			 ListeSoldats.remove(0);
			 nbSoldats.setText(Integer.toString(ListeSoldats.size()));
			 VerifBoutons();
		 }
	}
// Action rÃ©alisÃ©e quand on clique sur le bouton ajouter Soldat
	public class BoutonAjouterSoldat implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ListeSoldats.add(ListeSoldatsDeplacementRestant.get(0));
			ListeSoldatsDeplacementRestant.remove(0);
			nbSoldats.setText(Integer.toString(ListeSoldats.size()));
			VerifBoutons();
		}
	}
// Action rÃ©alisÃ©e quand on clique sur le bouton supprimer Cavalier
	public class BoutonSupprimerCavalier implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ListeCavaliersDeplacementRestant.add(ListeCavaliers.get(0));
			ListeCavaliers.remove(0);
			nbCavaliers.setText(Integer.toString(ListeCavaliers.size()));
			VerifBoutons();
		 }
	}
//Action realisee quand on clique sur le bouton ajouter Cavalier
	public class BoutonAjouterCavalier implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ListeCavaliers.add(ListeCavaliersDeplacementRestant.get(0));
			ListeCavaliersDeplacementRestant.remove(0);
			nbCavaliers.setText(Integer.toString(ListeCavaliers.size()));
			VerifBoutons();
		}	 
	}
//Action rÃ©alisÃ©e quand on clique sur le bouton supprimer Canon
	public class BoutonSupprimerCanon implements ActionListener{
		 public void actionPerformed(ActionEvent e) {
			 ListeCanonsDeplacementRestant.add(ListeCanons.get(0));
			 ListeCanons.remove(0);
			 nbCanons.setText(Integer.toString(ListeCanons.size()));
			 VerifBoutons();
		 }
	}
//Action realisee quand on clique sur le bouton ajouter Canon
	public class BoutonAjouterCanon implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ListeCanons.add(ListeCanonsDeplacementRestant.get(0));
			ListeCanonsDeplacementRestant.remove(0);
			nbCanons.setText(Integer.toString(ListeCanons.size()));
			VerifBoutons();
		}	 
	}
		public class BoutonAnnulerDeplacement implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}	 
		}
		public class BoutonValiderDeplacement implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				for (Armée A : ListeSoldats) {
					T1.ListeSoldat.remove(A);
					A.nbDeplacement=A.nbDeplacement-1;
					T2.ListeSoldat.add(A);
				}
				for (Armée A : ListeCavaliers) {
					T1.ListeCavalier.remove(A);
					A.nbDeplacement=A.nbDeplacement-1;
					T2.ListeCavalier.add(A);
				}
				for (Armée A : ListeCanons) {
					T1.ListeCanon.remove(A);
					A.nbDeplacement=A.nbDeplacement-1;
					T2.ListeCanon.add(A);
				}
				setVisible(false);
				dispose();
				fenetre.getContentPane().remove(fenetre.PanneauPrincipal);
				Panneau PanneauPrincipal = new Panneau(fenetre.ListeJoueurs,fenetre.ListeTerritoires,fenetre.NumJoueur,fenetre);
				fenetre.getContentPane().add(PanneauPrincipal);
				fenetre.PanneauPrincipal=PanneauPrincipal;
				fenetre.validate();
			}	 
		}
	
	public void VerifBoutons() { // Conditions sur les boutons
		// On active ou désactive les boutons supprimer quand la liste des troupes à déplacer est vide ou pas
		if (ListeSoldats.size()==0) {
			SupprimerSoldat.setEnabled(false);
		}
		else if (ListeSoldats.size()!=0) {
			SupprimerSoldat.setEnabled(true);
		}
		if (ListeCavaliers.size()==0) {
			SupprimerCavalier.setEnabled(false);
		}
		else if (ListeCavaliers.size()!=0) {
			SupprimerCavalier.setEnabled(true);
		}
		if (ListeCanons.size()==0) {
			SupprimerCanon.setEnabled(false);
		}
		else if (ListeCanons.size()!=0) {
			SupprimerCanon.setEnabled(true);
		}
		// On active ou désactive les boutons ajouter quand la liste des troupes à déplacer atteint la taille maximale
		if (ListeSoldats.size()==nbMaxSoldats) {
			AjouterSoldat.setEnabled(false);
		}
		else if (ListeSoldats.size()!=nbMaxSoldats) {
			AjouterSoldat.setEnabled(true);
		}
		if (ListeCavaliers.size()==nbMaxCavaliers) {
			AjouterCavalier.setEnabled(false);
		}
		else if (ListeCavaliers.size()!=nbMaxSoldats) {
			AjouterCavalier.setEnabled(true);
		}
		if (ListeCanons.size()==nbMaxCanons) {
			AjouterCanon.setEnabled(false);
		}
		else if (ListeCanons.size()!=nbMaxCanons) {
			AjouterCanon.setEnabled(true);
		}
		// On désactive les boutons ajouter quand il ne reste qu'une troupe sur le territoire de départ
		if (ListeSoldats.size()+ListeCavaliers.size()+ListeCanons.size()==nbMaxSoldats+nbMaxCavaliers+nbMaxCanons-1) {
			AjouterSoldat.setEnabled(false);
			AjouterCavalier.setEnabled(false);
			AjouterCanon.setEnabled(false);
		}
		// On active ou desactive le bouton valider quand l'utilisateur n'a pas choisi de troupes
		if (ListeSoldats.size()+ListeCavaliers.size()+ListeCanons.size()==0) {
			BoutonValiderDeplacement.setEnabled(false);
		}
		else {
			BoutonValiderDeplacement.setEnabled(true);
		}
	}
	
	public JButton getBoutonValiderDeplacement() {
		return BoutonValiderDeplacement;
	}
	
	public ArrayList<Armée> getListeSoldats() {
		return ListeSoldats;
	}
	public ArrayList<Armée> getListeCavaliers() {
		return ListeCavaliers;
	}
	public ArrayList<Armée> getListeCanons() {
		return ListeCanons;
	}
	
}
