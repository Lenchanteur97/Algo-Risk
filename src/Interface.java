import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Interface extends JFrame {
	private static final long serialVersionUID = 1L;
	Panneau PanneauPrincipal;
	boolean PanneauPrincipalAffiche;
	ArrayList<Joueur> ListeJoueurs;
	ArrayList<Territoire> ListeTerritoires;
	int NumJoueur;

	// Initialisation de la carte
	public Interface(ArrayList<Joueur> ListeJoueurs) {
		// Création de la fenetre
		this.ListeJoueurs=ListeJoueurs;
		this.setTitle("Risk");
		this.setSize(1920, 1080);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		PanneauImage Image = new PanneauImage(); // On ajoute l'image en fond
		this.setContentPane(Image);
		this.setVisible(true);
		this.PanneauPrincipalAffiche=false;
	}
	
	// Cette fonction permet d'ajouter le panneau principal à la fenetre et de retirer celui deja présent
	public void AjouterPanneauPrincipal(ArrayList<Joueur> ListeJoueurs, ArrayList<Territoire> ListeTerritoires, int NumJoueur) {
		this.ListeJoueurs=ListeJoueurs;
		this.ListeTerritoires=ListeTerritoires;
		this.NumJoueur=NumJoueur;
		if (PanneauPrincipalAffiche==false) {
			this.PanneauPrincipal = new Panneau(ListeJoueurs,ListeTerritoires,this.NumJoueur);
			PanneauPrincipal.getBoutonFinTour().addActionListener(new BoutonFinTourAction());
			this.getContentPane().add(PanneauPrincipal);
			PanneauPrincipal.setBounds(0, 0, 1914, 1045);
			this.validate();
		}
		else {
			this.RetirerPanneauPrincipal();
			this.PanneauPrincipal = new Panneau(ListeJoueurs,ListeTerritoires,this.NumJoueur);
			PanneauPrincipal.getBoutonFinTour().addActionListener(new BoutonFinTourAction());
			this.getContentPane().add(PanneauPrincipal);
			this.validate();
		}
		PanneauPrincipalAffiche=true;
	}
	
	public void RetirerPanneauPrincipal() {
		this.getContentPane().remove(PanneauPrincipal);
	}
	
	private class BoutonFinTourAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
	    	AjouterPanneauPrincipal(ListeJoueurs, ListeTerritoires, (NumJoueur+1)%ListeJoueurs.size());
	    }
	}
	
	
}

