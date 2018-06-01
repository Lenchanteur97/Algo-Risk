import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

//import FenetreNombreJoueur.BoutonListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanneauAjoutArmee extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	ArrayList<BoutonRond> ListeBoutons = new ArrayList<BoutonRond>();
	
	boolean Finalisation = false;
	ImageIcon Soldat;
	ImageIcon Cavalier;
	ImageIcon Canon;
	
	public PanneauAjoutArmee(Joueur J) {
		super();
		
		//On charge les images de soldat cavalier et canon
		//this.Soldat = new ImageIcon(getClass().getResource("icon-soldat.png")); // On charge l'image du soldat
		//this.Cavalier = new ImageIcon(getClass().getResource("icon-cavalier.png")); // On charge l'image du soldat
		//this.Canon = new ImageIcon(getClass().getResource("icon-canon.png")); // On charge l'image du soldat

		//On definit notre panneau taille, couleur
		this.setPreferredSize(new Dimension(1914,1045));
		this.setBackground(new Color(0,0,0,0));
		this.setLayout(null);
		
		//On ajoute un bouton à chaque territoire du joueur
		for(Territoire T : J.TerritoiresJoueur) {
				BoutonRond B = new BoutonRond("+",J.couleur);
				B.addActionListener(this);
				this.add(B);
				B.setBounds(T.PosXBouton-12, T.PosYBouton-45, 20, 20);
				ListeBoutons.add(B);
			}
		
		//On met en bas à droite un bouton pour valider l'ajout des armees
		JPanel PanneauJoueurEnCours = new JPanel();
		PanneauJoueurEnCours.setLayout(new FlowLayout());
		PanneauJoueurEnCours.setBackground(new Color(0,0,0,0));
		JLabel NomJoueur = new JLabel("Tour de jeu : ");
		JLabel NomJoueur2 = new JLabel(J.acronyme);
		NomJoueur.setFont(new Font("Arial",Font.BOLD,32));
		NomJoueur.setVerticalAlignment(SwingConstants.CENTER);
		NomJoueur.setHorizontalAlignment(SwingConstants.CENTER);
		NomJoueur2.setFont(new Font("Arial",Font.BOLD,32));
		NomJoueur2.setOpaque(true);
		NomJoueur2.setBackground(J.couleur);
		NomJoueur2.setVerticalAlignment(SwingConstants.CENTER);
		NomJoueur2.setHorizontalAlignment(SwingConstants.CENTER);
		NomJoueur2.setPreferredSize(new Dimension(100,50));
		JButton BoutonFinalisation = new JButton("Fin du tour");
		BoutonFinalisation.addActionListener(new BoutonFinalisation());
		BoutonFinalisation.setPreferredSize(new Dimension(100,50));
		PanneauJoueurEnCours.add(NomJoueur);
		PanneauJoueurEnCours.add(NomJoueur2);
		PanneauJoueurEnCours.add(BoutonFinalisation);
		this.add(PanneauJoueurEnCours);
		PanneauJoueurEnCours.setBounds(800, 0, 500, 60);
	}
	

	public ArrayList<BoutonRond> getListeBoutons() {
		return ListeBoutons;
	}
	
	//public void paintComponent(Graphics g) {
		//super.paintComponent(g);
	    //g.drawImage(Soldat.getImage(), 0, 1000, 50, 1050, this);
	    //g.drawImage(Cavalier.getImage(), 150, 1000, 200, 1050, this);
	    //g.drawImage(Canon.getImage(), 250, 1000, 300, 1050, this);
	//}
	
	// Action réalisée quand on clique sur le bouton Valider
		public class BoutonFinalisation implements ActionListener{
		    public void actionPerformed(ActionEvent e) {
		    	Finalisation = true;
		    }
		  }
		
		
	@Override
	public void actionPerformed(ActionEvent e) {
		//x
		//ListeTerritoire.get(x).ListeTroupes.)
	}
	
	public boolean getFinalisation() {
		return this.Finalisation;
	}
	

}
