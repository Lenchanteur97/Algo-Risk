import javax.swing.JFrame;

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
}

