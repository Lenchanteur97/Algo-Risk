import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Interface extends JFrame {
	private static final long serialVersionUID = 1L;

	// Initialisation de la carte
	public Interface() {
		// Création de la fenetre
		this.setTitle("Risk");
		this.setSize(1920, 1080);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		// Ajout de la carte en fond		
		this.setContentPane(new Panneau());
		
	}
	
	public void AjouterLegendeJoueurs(ArrayList<Joueur> ListeJoueurs) { // Ajout de la légende à l'interface graphique
		JPanel PanneauLegende = new JPanel();
		PanneauLegende.setSize(120*ListeJoueurs.size(),70);
		PanneauLegende.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK),"Liste des joueurs"));
		for (Joueur J : ListeJoueurs) {
			JLabel Acronyme = new JLabel(J.acronyme);
			Acronyme.setSize(70,30);
			Acronyme.setVerticalAlignment(SwingConstants.CENTER);
			Acronyme.setHorizontalAlignment(SwingConstants.CENTER);
			Acronyme.setOpaque(true);
			Acronyme.setBackground(J.couleur);
			Acronyme.setFont(new Font("Arial",Font.BOLD,24));
			PanneauLegende.add(Acronyme);
		}
		this.getContentPane().add(PanneauLegende);
		PanneauLegende.setLocation(1920-PanneauLegende.getWidth()-5, 0);
	}
}

