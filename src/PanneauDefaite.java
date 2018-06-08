import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class PanneauDefaite extends JPanel {
	private static final long serialVersionUID = 1L;
	ImageIcon img;
	
	public PanneauDefaite() {
		this.img = new ImageIcon(getClass().getResource("ImagePerdu.png")); // On charge l'image de fond
		}
	
	public void paintComponent(Graphics g) { // Ajout d'une image en fond
			super.paintComponent(g);
		    g.drawImage(img.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
	}
}
