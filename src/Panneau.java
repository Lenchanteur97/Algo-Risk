import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class Panneau extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	ArrayList<BoutonRond> ListeBoutons = new ArrayList<BoutonRond>();
	ArrayList<Joueur> ListeJoueurs;
	int NumJoueur;
	ArrayList<Territoire> ListeTerritoires;
	ImageIcon image_soldat;
	ImageIcon image_cavalier;
	ImageIcon image_canon;
	JPanel PanneauJoueurEnCours;
	JButton BoutonFinTour;
	boolean BoutonRondClique = false;
	int indice;
	ArrayList<Territoire> TerritoiresAttDepl;
	Deplacement_Attaque DeplAtt;
	Territoire T1;
	Territoire T2;
	boolean FinDeplacement;
	FenDialogDeplacement DialogDeplacement;
	JButton BoutonValiderDeplacement;
	Interface fenetre;
	
	public Panneau(ArrayList<Joueur> ListeJoueurs, ArrayList<Territoire> ListeTerritoires, int NumJoueur, Interface fenetre) { // Création du panneau central
		super();
		this.fenetre=fenetre;
		this.ListeJoueurs=ListeJoueurs;
		this.NumJoueur=NumJoueur;
		this.ListeTerritoires = ListeTerritoires;
		this.TerritoiresAttDepl = new ArrayList<Territoire>();
		this.image_soldat = new ImageIcon(getClass().getResource("icone-soldat.png"));
		this.image_cavalier = new ImageIcon(getClass().getResource("icone-cavalier.png"));
		this.image_canon = new ImageIcon(getClass().getResource("icone-canon.png"));
		this.setPreferredSize(new Dimension(1914,1045));
		this.setBackground(new Color(0,0,0,0));
		this.setLayout(null);
		this.FinDeplacement=false;
		
		// Ici, on créé une légende avec la liste des joueurs
		JPanel PanneauLegende = new JPanel();
		int i=0;
		for (Joueur J : ListeJoueurs) {
			JLabel Acronyme = new JLabel(J.acronyme);
			Acronyme.setOpaque(true);
			Acronyme.setBackground(J.couleur);
			Acronyme.setVerticalAlignment(SwingConstants.CENTER);
			Acronyme.setHorizontalAlignment(SwingConstants.CENTER);
			Acronyme.setFont(new Font("Arial",Font.BOLD,22));
			PanneauLegende.add(Acronyme);
			Acronyme.setBounds(25+65*i+25*i, 20, 65, 35);
			Acronyme.setBackground(J.couleur);
			i++;
		}
		TitledBorder BordureTitreLegende = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Liste des joueurs");
		PanneauLegende.setLayout(null);
		PanneauLegende.setBackground(new Color(0,0,0,0));
		PanneauLegende.setBorder(BordureTitreLegende);
		
		for (Territoire T : ListeTerritoires) { // Pour chaque territoire, on affiche un bouton avec l'acronyme et la couleur du joueur qui le possède
			BoutonRond B = new BoutonRond("+",T.Joueur.couleur);
			B.addActionListener(this);
			this.add(B);
			B.setBounds(T.PosXBouton-12, T.PosYBouton-45, 20, 20);
			ListeBoutons.add(B);
			
			// Au dessus de chaque bouton on va positionner 3 images qui représentent les unités et le nombre d'unité présentes
			JPanel PanneauInfo = new JPanel();
			PanneauInfo.setLayout(null);
			PanneauInfo.setBackground(new Color(0,0,0,0));
			PanneauInfo.setPreferredSize(new Dimension(120,30));
			JPanel PanneauSoldat = new PanneauSoldat();
			JLabel labelNbSoldat = new JLabel();
			labelNbSoldat.setText(Integer.toString(T.ListeSoldat.size()));
			labelNbSoldat.setFont(new Font("Arial",Font.BOLD,12));
			JPanel PanneauCavalier = new PanneauCavalier();
			JLabel labelNbCavalier = new JLabel();
			labelNbCavalier.setFont(new Font("Arial",Font.BOLD,12));
			labelNbCavalier.setText(Integer.toString(T.ListeCavalier.size()));
			JPanel PanneauCanon = new PanneauCanon();
			JLabel labelNbCanon = new JLabel();
			labelNbCanon.setFont(new Font("Arial",Font.BOLD,12));
			labelNbCanon.setText(Integer.toString(T.ListeCanon.size()));
			PanneauInfo.add(PanneauSoldat);
			PanneauSoldat.setBounds(0, 0, 20, 20);
			PanneauInfo.add(labelNbSoldat);
			labelNbSoldat.setBounds(20, 0, 10, 20);
			PanneauInfo.add(PanneauCavalier);
			PanneauCavalier.setBounds(30, 0, 20, 20);
			PanneauInfo.add(labelNbCavalier);
			labelNbCavalier.setBounds(50, 0, 10, 20);
			PanneauInfo.add(PanneauCanon);
			PanneauCanon.setBounds(60, 0, 20, 20);
			PanneauInfo.add(labelNbCanon);
			labelNbCanon.setBounds(80, 0, 10, 20);
			this.add(PanneauInfo);
			PanneauInfo.setBounds(T.PosXBouton-12-30, T.PosYBouton-45-20, 90, 20);
		}
		this.add(PanneauLegende);
		PanneauLegende.setBounds(0, 0, 25+90*ListeJoueurs.size(), 70);
		
		// On créé un panneau indiquant qui doit joueur, avec un bouton fin du tour et un autre pour afficher la mission secrète
		JPanel PanneauJoueurEnCours = new JPanel();
		PanneauJoueurEnCours.setLayout(null);
		PanneauJoueurEnCours.setBackground(new Color(0,0,0,0));
		JLabel NomJoueur = new JLabel("Tour de jeu : ");
		JLabel NomJoueur2 = new JLabel(ListeJoueurs.get(NumJoueur).acronyme);
		NomJoueur.setFont(new Font("Arial",Font.BOLD,32));
		NomJoueur.setVerticalAlignment(SwingConstants.CENTER);
		NomJoueur.setHorizontalAlignment(SwingConstants.CENTER);
		NomJoueur2.setFont(new Font("Arial",Font.BOLD,32));
		NomJoueur2.setOpaque(true);
		NomJoueur2.setBackground(ListeJoueurs.get(NumJoueur).couleur);
		NomJoueur2.setVerticalAlignment(SwingConstants.CENTER);
		NomJoueur2.setHorizontalAlignment(SwingConstants.CENTER);
		BoutonFinTour = new JButton("Fin du tour"); // On créé un bouton fin de tour
		BoutonFinTour.setFont(new Font("Arial", Font.BOLD, 20));
		JButton AfficherMission = new JButton("Afficher la mission");
		AfficherMission.addActionListener(new AfficherMission());
		AfficherMission.setFont(new Font("Arial", Font.ITALIC, 15));
		PanneauJoueurEnCours.add(NomJoueur);
		NomJoueur.setBounds(0, 0, 225, 50);
		PanneauJoueurEnCours.add(NomJoueur2);
		NomJoueur2.setBounds(225, 0, 100, 50);
		PanneauJoueurEnCours.add(BoutonFinTour);
		BoutonFinTour.setBounds(350, 0, 150, 50);
		PanneauJoueurEnCours.add(AfficherMission);
		AfficherMission.setBounds(900, 0, 200, 50);
		this.add(PanneauJoueurEnCours);
		PanneauJoueurEnCours.setBounds(800, 0, 1100, 60);
		
		JPanel PanneauInfoAttaque = new JPanel();
		PanneauInfoAttaque.setLayout(new GridLayout(2,1));
		PanneauInfoAttaque.setBackground(new Color(0,0,0,0));
			JLabel Info = new JLabel("Cliquez sur un de vos territoires puis sur un territoire");
			Info.setFont(new Font("Arial",Font.PLAIN,28));
			JLabel Info2 = new JLabel("adjacent pour attaquer ou déplacer des troupes");
			Info2.setFont(new Font("Arial",Font.PLAIN,28));
			PanneauInfoAttaque.add(Info);
			PanneauInfoAttaque.add(Info2);
		this.add(PanneauInfoAttaque);
		PanneauInfoAttaque.setBounds(750, 900, 700, 60);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) { // Action réalisée quand on clique sur un bouton associé à un territoire
		for (int i=0;i<ListeBoutons.size();i++) {
			if (arg0.getSource()==ListeBoutons.get(i)) {
				indice = i; // On récupère l'indice du bouton dans la liste qui est aussi celui du territoire
			}
		}
		if (TerritoiresAttDepl.size()!=1) {
			TerritoiresAttDepl.add(ListeTerritoires.get(indice));
		}
		else if (TerritoiresAttDepl.size()==1) {
			TerritoiresAttDepl.add(ListeTerritoires.get(indice));
			if (TerritoiresAttDepl.get(0).TerritoiresAdjacents(TerritoiresAttDepl.get(1))==true) {
				DeplAtt = new Deplacement_Attaque(TerritoiresAttDepl,fenetre);
				DialogDeplacement = DeplAtt.DialogDeplacement;
			}
			TerritoiresAttDepl.clear(); // On réinitialise la liste
		}
	}
	
	
	private class AfficherMission implements ActionListener {
		@SuppressWarnings("static-access")
		public void actionPerformed(ActionEvent e) {
			JOptionPane PopupMission = new JOptionPane();
			PopupMission.showMessageDialog(null, "Votre mission est : "+ListeJoueurs.get(NumJoueur).Mission.toString(), "Mission", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public JButton getBoutonFinTour() {
		return BoutonFinTour;
	}
	
	public Deplacement_Attaque getDeplAtt() {
		return DeplAtt;
	}
}
