import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class PanneauCavalier extends JPanel {
	private static final long serialVersionUID = 1L;
	ImageIcon img;
	
	public PanneauCavalier() {
		this.img = new ImageIcon(getClass().getResource("icone-cheval.png")); // On charge l'image de fond
		this.setBackground(new Color(0,0,0,0));
		}
	
	public void paintComponent(Graphics g) { // Ajout d'une image en fond
			super.paintComponent(g);
		    g.drawImage(img.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
	}
}