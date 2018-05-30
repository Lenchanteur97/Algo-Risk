
import javax.swing.JButton;
import java.awt.*;
import java.awt.geom.*;

public class BoutonRond extends JButton {
	Territoire Territoire;
	private static final long serialVersionUID = 1L;
	
public BoutonRond(String label, Territoire T) {
    super(label);
    this.Territoire=T;
    setPreferredSize(new Dimension(20,20));
    setContentAreaFilled(false);
  }

  protected void paintComponent(Graphics g) {
    g.setColor(Color.BLUE);
    g.fillOval(0, 0, getSize().width-1,getSize().height-1);

    super.paintComponent(g);
  }

  protected void paintBorder(Graphics g) {
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
