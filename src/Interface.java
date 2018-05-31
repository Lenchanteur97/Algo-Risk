import java.util.ArrayList;

import javax.swing.JFrame;

public class Interface extends JFrame {
	private static final long serialVersionUID = 1L;

	// Initialisation de la carte
	public Interface(ArrayList<Joueur> ListeJoueurs) {
		// Création de la fenetre
		this.setTitle("Risk");
		this.setSize(1920, 1080);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setAlwaysOnTop(true);
		PanneauImage Image = new PanneauImage();
		this.setContentPane(Image);
		this.setVisible(true);
	}
}

