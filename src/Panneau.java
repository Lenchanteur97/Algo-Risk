import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class Panneau extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	ArrayList<BoutonRond> ListeBoutons = new ArrayList<BoutonRond>();
	ArrayList<Joueur> ListeJoueurs;
	ArrayList<Territoire> ListeTerritoires;
	ImageIcon image_soldat;
	ImageIcon image_cavalier;
	ImageIcon image_canon;
	
	
	public Panneau(ArrayList<Joueur> ListeJoueurs, ArrayList<Territoire> ListeTerritoires) { // Création du panneau central
		super();
		this.ListeJoueurs=ListeJoueurs;
		this.ListeTerritoires=ListeTerritoires;
		this.image_soldat = new ImageIcon(getClass().getResource("icone-soldat.png"));
		this.image_cavalier = new ImageIcon(getClass().getResource("icone-cavalier.png"));
		this.image_canon = new ImageIcon(getClass().getResource("icone-canon.png"));
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
			for(Territoire T : J.TerritoiresJoueur) { // Pour chaque territoire on ajoute un bouton à la position indiquée dans chaque territoire et un panel indiquant le nombre de chaques unités
				BoutonRond B = new BoutonRond("+",J.couleur);
				B.addActionListener(this);
				this.add(B);
				B.setBounds(T.PosXBouton-12, T.PosYBouton-45, 20, 20);
				ListeBoutons.add(B);
				
				JPanel PanneauInfo = new JPanel();
				PanneauInfo.setLayout(null);
				PanneauInfo.setBackground(new Color(0,0,0,0));
				PanneauInfo.setPreferredSize(new Dimension(120,30));
				JPanel PanneauSoldat = new PanneauSoldat();
				JLabel labelNbSoldat = new JLabel();
				//labelNbSoldat.setText(Integer.toString(T.NombreUnite("Soldat")));
				labelNbSoldat.setText("1");
				labelNbSoldat.setFont(new Font("Arial",Font.BOLD,12));
				JPanel PanneauCavalier = new PanneauCavalier();
				JLabel labelNbCavalier = new JLabel();
				labelNbCavalier.setText("2");
				labelNbCavalier.setFont(new Font("Arial",Font.BOLD,12));
				//labelNbCavalier.setText(Integer.toString(T.NombreUnite("Cavalier")));
				JPanel PanneauCanon = new PanneauCanon();
				JLabel labelNbCanon = new JLabel();
				labelNbCanon.setText("3");
				labelNbCanon.setFont(new Font("Arial",Font.BOLD,12));
				//labelNbCanon.setText(Integer.toString(T.NombreUnite("Canon")));
				PanneauInfo.add(PanneauSoldat);
				PanneauSoldat.setBounds(0, 0, 20, 20);
				PanneauInfo.add(labelNbSoldat);
				labelNbSoldat.setBounds(20, 0, 10, 20);
				PanneauInfo.add(PanneauCavalier);
				PanneauCavalier.setBounds(30, 0, 20, 20);
				PanneauInfo.add(labelNbCavalier);
				labelNbCavalier.setBounds(50, 0, 10, 20);
				PanneauInfo.add(PanneauCanon);
				PanneauCanon.setBounds(60, 0, 20, 20);
				PanneauInfo.add(labelNbCanon);
				labelNbCanon.setBounds(80, 0, 10, 20);
				this.add(PanneauInfo);
				PanneauInfo.setBounds(T.PosXBouton-12-30, T.PosYBouton-45-20, 90, 20);	
			}
		}
		this.add(PanneauLegende);
		PanneauLegende.setBounds(0, 0, 25+90*ListeJoueurs.size(), 70);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) { // Action réalisée quand on clique sur un territoire
		for (int i=0;i<ListeBoutons.size();i++) {
			if (arg0.getSource()==ListeBoutons.get(i)) {
				
			}
		}
	}
}
