import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Panneau extends JPanel {
	private static final long serialVersionUID = 1L;
	ArrayList<BoutonRond> ListeBoutons = new ArrayList<BoutonRond>();
	
	
	public Panneau(ArrayList<Joueur> ListeJoueurs, ArrayList<Territoire> ListeTerritoires) { // Création du panneau central
		
		this.setLayout(null);
		
		JPanel PanneauBoutons = new JPanel(); // Création d'un panneau avec les boutons des territoires
		PanneauBoutons.setLayout(null);
		PanneauBoutons.setPreferredSize(new Dimension(1900,1000));
		PanneauBoutons.setOpaque(true);
		for (Territoire T : ListeTerritoires) {
			BoutonRond B = new BoutonRond("+",T);
			B.setOpaque(true);
			PanneauBoutons.add(B);
			B.setLocation(T.PosXBouton, T.PosYBouton);
			ListeBoutons.add(B);
		}
		this.add(PanneauBoutons);
		PanneauBoutons.setLocation(0,0);
		
		JPanel PanneauLegende = new JPanel(); // Création du panneau avec la légende
		PanneauLegende.setSize(100*ListeJoueurs.size(),70);
		PanneauLegende.setLayout(null);
		PanneauLegende.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK),"Liste des joueurs"));
		int i=0;
		for (Joueur J : ListeJoueurs) {
			JLabel Acronyme = new JLabel(J.acronyme);
			Acronyme.setBounds(35+i*50+i*40, 20, 50, 35);
			Acronyme.setVerticalAlignment(SwingConstants.CENTER);
			Acronyme.setHorizontalAlignment(SwingConstants.CENTER);
			Acronyme.setOpaque(true);
			Acronyme.setBackground(J.couleur);
			Acronyme.setFont(new Font("Arial",Font.BOLD,22));
			PanneauLegende.add(Acronyme);
			i++;
		}
		this.add(PanneauLegende);
		PanneauLegende.setLocation(1920-PanneauLegende.getWidth()-5, 0);
	}

	
	public ArrayList<BoutonRond> getListeBoutons() {
		return ListeBoutons;
	}
}
