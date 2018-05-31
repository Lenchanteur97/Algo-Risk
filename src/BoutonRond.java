
import javax.swing.JButton;
import java.awt.*;
import java.awt.geom.*;

public class BoutonRond extends JButton {
	Color couleur;
	private static final long serialVersionUID = 1L;
	
public BoutonRond(String label, Color couleur) {
    super(label);
    this.couleur=couleur;
    setPreferredSize(new Dimension(20,20));
    setContentAreaFilled(false);
  }

  protected void paintComponent(Graphics g) {
	super.paintComponent(g);
    g.setColor(couleur);
    g.fillOval(0, 0, getSize().width-1,getSize().height-1);
  }

  protected void paintBorder(Graphics g) {
	  super.paintBorder(g);
    g.setColor(getForeground());
    g.drawOval(0, 0, getSize().width-1,     getSize().height-1);
  }

  Shape shape; // Cela permet de se proteger des erreurs
  public boolean contains(int x, int y) {
    if (shape == null || 
      !shape.getBounds().equals(getBounds())) {
      shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
    }
    return shape.contains(x, y);
  }
}
