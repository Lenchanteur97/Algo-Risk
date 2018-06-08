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

public class FenDialogAttaque extends JDialog{
	private static final long serialVersionUID = 1L;
	
	private Territoire T1,T2;
	private ArrayList<Armée> ListeSoldatsAttaqueRestant;
	private ArrayList<Armée> ListeCavaliersAttaqueRestant;
	private ArrayList<Armée> ListeCanonsAttaqueRestant;
	private int nbMaxSoldats;
	private int nbMaxCavaliers;
	private int nbMaxCanons;
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
	private JButton BoutonValiderAttaque;
	private JButton BoutonAnnulerAttaque;
	private JButton AjouterSoldat;
	private JButton SupprimerSoldat;
	private JButton AjouterCavalier;
	private JButton SupprimerCavalier;
	private JButton AjouterCanon;
	private JButton SupprimerCanon;
	private ArrayList<Armée> ListeTroupesAttaque;
	private ArrayList<Armée> ListeTroupesDefense;
	Interface fenetre;
	
	public FenDialogAttaque(Territoire T1, Territoire T2, Interface fenetre) {
		super();
		this.fenetre=fenetre;
		this.setTitle("Attaque");
		this.setModal(false);
		this.setSize(420,550);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		this.T1=T1;
		this.T2=T2;
		this.ListeTroupesAttaque = new ArrayList<Armée>();
		this.ListeTroupesDefense = new ArrayList<Armée>();
		this.ListeSoldatsAttaqueRestant=T1.UniteAvecDeplacements("Soldat");
		this.ListeCavaliersAttaqueRestant=T1.UniteAvecDeplacements("Cavalier");
		this.ListeCanonsAttaqueRestant=T1.UniteAvecDeplacements("Canon");
		this.nbMaxSoldats = T1.ListeSoldat.size();
		this.nbMaxCavaliers = T1.ListeCavalier.size();
		this.nbMaxCanons = T1.ListeCanon.size();
		
		PanneauHaut = new JPanel();
			Info = new JLabel("Sélectionnez les troupes pour attaquer :");
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
				nbSoldats = new JLabel(Integer.toString(NbrArmee(ListeTroupesAttaque, "Soldat")));
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
				nbCavaliers = new JLabel(Integer.toString(NbrArmee(ListeTroupesAttaque, "Cavalier")));
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
				nbCanons = new JLabel(Integer.toString(NbrArmee(ListeTroupesAttaque, "Canon")));
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
			BoutonValiderAttaque = new JButton("Valider");
			BoutonValiderAttaque.setFont(new Font("Arial",Font.PLAIN,22));
			BoutonValiderAttaque.addActionListener(new BoutonValiderAttaque());
			BoutonAnnulerAttaque = new JButton("Annuler");
			BoutonAnnulerAttaque.setFont(new Font("Arial",Font.PLAIN,22));
			BoutonAnnulerAttaque.addActionListener(new BoutonAnnulerAttaque());
		PanneauControle.add(BoutonValiderAttaque);
		PanneauControle.add(BoutonAnnulerAttaque);
		BoutonValiderAttaque.setBounds(45,20,140,60);
		BoutonAnnulerAttaque.setBounds(225,20,140,60);
		this.add(PanneauControle);
		PanneauControle.setBounds(0, 400, 400, 80);
		VerifBoutons();
		this.setVisible(true);
		
	}
	
	// Action rÃ©alisÃ©e quand on clique sur le bouton supprimer Soldat
	public class BoutonSupprimerSoldat implements ActionListener{
		 public void actionPerformed(ActionEvent e) {
			 ListeSoldatsAttaqueRestant.add(PremiereArmee(ListeTroupesAttaque,"Soldat"));
			 ListeTroupesAttaque.remove(PremiereArmee(ListeTroupesAttaque,"Soldat"));
			 nbSoldats.setText(Integer.toString(NbrArmee(ListeTroupesAttaque,"Soldat")));
			 VerifBoutons();
		 }
	}
// Action rÃ©alisÃ©e quand on clique sur le bouton ajouter Soldat
	public class BoutonAjouterSoldat implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ListeTroupesAttaque.add(ListeSoldatsAttaqueRestant.get(0));
			ListeSoldatsAttaqueRestant.remove(0);
			nbSoldats.setText(Integer.toString(NbrArmee(ListeTroupesAttaque,"Soldat")));
			VerifBoutons();
		}
	}
// Action rÃ©alisÃ©e quand on clique sur le bouton supprimer Cavalier
	public class BoutonSupprimerCavalier implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ListeCavaliersAttaqueRestant.add(PremiereArmee(ListeTroupesAttaque,"Cavalier"));
			ListeTroupesAttaque.remove(PremiereArmee(ListeTroupesAttaque,"Cavalier"));
			nbCavaliers.setText(Integer.toString(NbrArmee(ListeTroupesAttaque,"Cavalier")));
			VerifBoutons();
		 }
	}
//Action realisee quand on clique sur le bouton ajouter Cavalier
	public class BoutonAjouterCavalier implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ListeTroupesAttaque.add(ListeCavaliersAttaqueRestant.get(0));
			ListeCavaliersAttaqueRestant.remove(0);
			nbCavaliers.setText(Integer.toString(NbrArmee(ListeTroupesAttaque,"Cavalier")));
			VerifBoutons();
		}	 
	}
//Action rÃ©alisÃ©e quand on clique sur le bouton supprimer Canon
	public class BoutonSupprimerCanon implements ActionListener{
		 public void actionPerformed(ActionEvent e) {
			 ListeCanonsAttaqueRestant.add(PremiereArmee(ListeTroupesAttaque,"Canon"));
			 ListeTroupesAttaque.remove(PremiereArmee(ListeTroupesAttaque,"Canon"));
			 nbCanons.setText(Integer.toString(NbrArmee(ListeTroupesAttaque,"Canon")));
			 VerifBoutons();
		 }
	}
//Action realisee quand on clique sur le bouton ajouter Canon
	public class BoutonAjouterCanon implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ListeTroupesAttaque.add(ListeCanonsAttaqueRestant.get(0));
			ListeCanonsAttaqueRestant.remove(0);
			nbCanons.setText(Integer.toString(NbrArmee(ListeTroupesAttaque,"Canon")));
			VerifBoutons();
		}	 
	}
		public class BoutonAnnulerAttaque implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}	 
		}
	
	public void VerifBoutons() { // Conditions sur les boutons
		// On active ou désactive les boutons supprimer quand la liste des troupes à déplacer est vide ou pas
		if (NbrArmee(ListeTroupesAttaque,"Soldat")==0) {
			SupprimerSoldat.setEnabled(false);
		}
		else if (NbrArmee(ListeTroupesAttaque,"Soldat")!=0) {
			SupprimerSoldat.setEnabled(true);
		}
		if (NbrArmee(ListeTroupesAttaque,"Cavalier")==0) {
			SupprimerCavalier.setEnabled(false);
		}
		else if (NbrArmee(ListeTroupesAttaque,"Cavalier")!=0) {
			SupprimerCavalier.setEnabled(true);
		}
		if (NbrArmee(ListeTroupesAttaque,"Canon")==0) {
			SupprimerCanon.setEnabled(false);
		}
		else if (NbrArmee(ListeTroupesAttaque,"Canon")!=0) {
			SupprimerCanon.setEnabled(true);
		}
		// On active ou désactive les boutons ajouter quand la liste des troupes à déplacer atteint la taille maximale
		if (NbrArmee(ListeTroupesAttaque,"Soldat")==nbMaxSoldats) {
			AjouterSoldat.setEnabled(false);
		}
		else if (NbrArmee(ListeTroupesAttaque,"Soldat")!=nbMaxSoldats) {
			AjouterSoldat.setEnabled(true);
		}
		if (NbrArmee(ListeTroupesAttaque,"Cavalier")==nbMaxCavaliers) {
			AjouterCavalier.setEnabled(false);
		}
		else if (NbrArmee(ListeTroupesAttaque,"Cavalier")!=nbMaxSoldats) {
			AjouterCavalier.setEnabled(true);
		}
		if (NbrArmee(ListeTroupesAttaque,"Canon")==nbMaxCanons) {
			AjouterCanon.setEnabled(false);
		}
		else if (NbrArmee(ListeTroupesAttaque,"Canon")!=nbMaxCanons) {
			AjouterCanon.setEnabled(true);
		}
		// On désactive les boutons ajouter quand il ne reste qu'une troupe sur le territoire de départ
		if (ListeTroupesAttaque.size()==3) {
			AjouterSoldat.setEnabled(false);
			AjouterCavalier.setEnabled(false);
			AjouterCanon.setEnabled(false);
		}
		if (ListeTroupesAttaque.size()==0) {
			BoutonValiderAttaque.setEnabled(false);
		}
		else {
			BoutonValiderAttaque.setEnabled(true);
		}
	}
	
	public JButton getBoutonValiderAttaque() {
		return BoutonValiderAttaque;
	}
	
	public int NbrArmee(ArrayList<Armée> ListeTroupes, String Type) {
		int i=0;
		for (Armée A : ListeTroupes) {
			if (A.Type==Type) {
				i++;
			}
		}
		return i;
	}
	public Armée PremiereArmee(ArrayList<Armée> ListeTroupes, String Type) {
		for (Armée A : ListeTroupes) {
			if (A.Type==Type) {
				return A;
			}
		}
		return null;
	}
	
	public void ListeDeDefense() { // Cette fonction va choisir les troupes qui vont défendre l'attaque
		if (T2.ListeSoldat.size()+T2.ListeCavalier.size()+T2.ListeCanon.size()==1) {
			while(ListeTroupesDefense.size()!=1) {
				if(T2.UniteAvecDeplacements("Soldat").size()!=0) {
					ListeTroupesDefense.add(T2.UniteAvecDeplacements("Soldat").get(0));
					T2.ListeSoldat.remove(T2.UniteAvecDeplacements("Soldat").get(0));
				}
				else if(T2.UniteAvecDeplacements("Cavalier").size()!=0) {
					ListeTroupesDefense.add(T2.UniteAvecDeplacements("Cavalier").get(0));
					T2.ListeCavalier.remove(T2.UniteAvecDeplacements("Cavalier").get(0));
				}
				else if(T2.UniteAvecDeplacements("Canon").size()!=0) {
					ListeTroupesDefense.add(T2.UniteAvecDeplacements("Canon").get(0));
					T2.ListeCanon.remove(T2.UniteAvecDeplacements("Canon").get(0));
				}
			}
		}
		else if (T2.ListeSoldat.size()+T2.ListeCavalier.size()+T2.ListeCanon.size()>1) {
			while(ListeTroupesDefense.size()!=2) {
				if(T2.UniteAvecDeplacements("Soldat").size()!=0) {
					ListeTroupesDefense.add(T2.UniteAvecDeplacements("Soldat").get(0));
					T2.ListeSoldat.remove(T2.UniteAvecDeplacements("Soldat").get(0));
				}
				else if(T2.UniteAvecDeplacements("Cavalier").size()!=0) {
					ListeTroupesDefense.add(T2.UniteAvecDeplacements("Cavalier").get(0));
					T2.ListeCavalier.remove(T2.UniteAvecDeplacements("Cavalier").get(0));
				}
				else if(T2.UniteAvecDeplacements("Canon").size()!=0) {
					ListeTroupesDefense.add(T2.UniteAvecDeplacements("Canon").get(0));
					T2.ListeCanon.remove(T2.UniteAvecDeplacements("Canon").get(0));
				}
			}
		}
		
	}
	
	public class BoutonValiderAttaque implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			for (Armée A : ListeTroupesAttaque) {
				if (A.Type=="Soldat") {
					T1.ListeSoldat.remove(A);
					
				}
				if (A.Type=="Cavalier") {
					T1.ListeCavalier.remove(A);
					
				}
				if (A.Type=="Canon") {
					T1.ListeCanon.remove(A);
					
				}
			}
			ListeDeDefense();
			setVisible(false);
			dispose();
			
			// On lance la fenetre de résultat de l'attaque
			System.out.println("Lancer Attaque");
			FenResultAttaque ResultatAttaque = new FenResultAttaque(T1,ListeTroupesAttaque,T2,ListeTroupesDefense,fenetre);
		}	 
	}
	
}
