import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class Panneau extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	ArrayList<BoutonRond> ListeBoutons = new ArrayList<BoutonRond>();
	
	
	public Panneau(ArrayList<Joueur> ListeJoueurs) { // Création du panneau central
		super();
		this.setPreferredSize(new Dimension(1914,1045));
		this.setBackground(new Color(0,0,0,0));
		this.setLayout(null);
		
		// Ici, on créé une légende avec la liste des joueurs
		JPanel PanneauLegende = new JPanel();
		TitledBorder BordureTitreLegende = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Liste des joueurs");
		PanneauLegende.setLayout(null);
		PanneauLegende.setBackground(new Color(0,0,0,0));
		PanneauLegende.setBorder(BordureTitreLegende);
		int i=0;
		for (Joueur J : ListeJoueurs) { // Pour chaque joueur, on affiche un carré avec son acronyme et sa couleur
			JLabel Acronyme = new JLabel(J.acronyme);
			Acronyme.setOpaque(true);
			Acronyme.setBackground(J.couleur);
			Acronyme.setVerticalAlignment(SwingConstants.CENTER);
			Acronyme.setHorizontalAlignment(SwingConstants.CENTER);
			Acronyme.setFont(new Font("Arial",Font.BOLD,22));
			PanneauLegende.add(Acronyme);
			Acronyme.setBounds(25+65*i+25*i, 20, 65, 35);
			Acronyme.setBackground(J.couleur);
			i++;
			for(Territoire T : J.TerritoiresJoueur) { // Pour chaque territoire on ajoute un bouton à la position indiquée dans chaque territoire
				BoutonRond B = new BoutonRond("+",J.couleur);
				B.addActionListener(this);
				this.add(B);
				B.setBounds(T.PosXBouton-12, T.PosYBouton-45, 20, 20);
				ListeBoutons.add(B);
			}
		}
		this.add(PanneauLegende);
		PanneauLegende.setBounds(0, 0, 25+90*ListeJoueurs.size(), 70);
	}
	
	public ArrayList<BoutonRond> getListeBoutons() {
		return ListeBoutons;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		for (int i=0;i<ListeBoutons.size();i++) {
			if (arg0.getSource()==ListeBoutons.get(i)) {
				System.out.println("Vous avez cliqué sur le bouton"+i);
			}
		}
	}
}
