import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class PanneauVictoire extends JPanel {
	private static final long serialVersionUID = 1L;
	ImageIcon img;
	
	public PanneauVictoire() {
		this.img = new ImageIcon(getClass().getResource("ImageGagne.png")); // On charge l'image de fond
		}
	
	public void paintComponent(Graphics g) { // Ajout d'une image en fond
			super.paintComponent(g);
		    g.drawImage(img.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
	}
}
