import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;


public class PanneauTourJoueur extends JPanel {
	private static final long serialVersionUID = 1L;
	boolean FinTour = false;
	
	public PanneauTourJoueur(Joueur J) {
		this.setPreferredSize(new Dimension(1914,1045));
		this.setBackground(new Color(0,0,0,120));
		this.setLayout(null);
		
		
	}
	
	
}
