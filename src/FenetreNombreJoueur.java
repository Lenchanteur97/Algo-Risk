import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FenetreNombreJoueur extends JDialog {
	private static final long serialVersionUID = 1L;
	public int nbJoueurs;
	private JButton b1,b2,b3,b4,b5;
	private boolean BoutonDejaActionner = false; // Je défini ici le layout de ma fenetre
	private ArrayList<JFormattedTextField> ListeTextField = new ArrayList<JFormattedTextField>();
	private BorderLayout BL = new BorderLayout();
	private ArrayList<Joueur> ListeDesJoueurs;
	
	public FenetreNombreJoueur(JFrame parent, String title, boolean modal, ArrayList<Joueur> ListeJoueurs) {
		//On appelle le construteur de JDialog correspondant
	    super(parent, title, modal);
	    ListeDesJoueurs = ListeJoueurs; // On modifiera les éléments de la ListeJoueurs par référence
	    // On définit les paramètres de notre boite de dialogue
	    this.setSize(300,100);
	    this.setLayout(BL);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);  
		// Création d'un panel avec 5 boutons permettant de choisir le nombre de joueurs
		JPanel PanNbJoueurs = new JPanel();
		PanNbJoueurs.setSize(300,40);
		PanNbJoueurs.setLayout(new GridLayout(1,5, 5, 10));
		JButton b1 = new JButton("2");
		JButton b2 = new JButton("3");
		JButton b3 = new JButton("4");
		JButton b4 = new JButton("5");
		JButton b5 = new JButton("6");
		b1.addActionListener(new Button1Action()); // Ici on affecte les actions de chaques boutons
		b2.addActionListener(new Button2Action());
		b3.addActionListener(new Button3Action());
		b4.addActionListener(new Button4Action());
		b5.addActionListener(new Button5Action());
		PanNbJoueurs.add(b1);
		PanNbJoueurs.add(b2);
		PanNbJoueurs.add(b3);
		PanNbJoueurs.add(b4);
		PanNbJoueurs.add(b5);
		
		this.add(PanNbJoueurs, BorderLayout.NORTH); // Positionnement du panel en haut de la fenetre
		this.setVisible(true);
	}
	
	public void ChoixAcronymes(int nbJoueurs) {
		if (BoutonDejaActionner==true) { // Si l'utilisateur avait deja cliqué sur le nombre de joueurs, je retire la partie du milieu et du bas pour les re-afficher
			this.remove(BL.getLayoutComponent(BorderLayout.CENTER)); 
			this.remove(BL.getLayoutComponent(BorderLayout.SOUTH));
		}
		setSize(300,100+58*nbJoueurs);
		JPanel PanAcronymes = new JPanel();
		for (int i=0;i<nbJoueurs;i++) { // On cree des label et des zones de texte pour que les utilisateurs entrent leurs acronymes
			JLabel LabelAcronyme = new JLabel("Acronyme Joueur n°"+(i+1)+" :");
			LabelAcronyme.setSize(50,30);
			JFormattedTextField SaisieAcronyme = new JFormattedTextField(new MasqueAcronyme());
			SaisieAcronyme.setPreferredSize(new Dimension(200, 30));
			ListeTextField.add(SaisieAcronyme);
			PanAcronymes.add(LabelAcronyme);
			PanAcronymes.add(SaisieAcronyme);
		}
		JPanel PanControl = new JPanel(); 
		JButton OK_BOUTON = new JButton("Valider"); // Création d'un bouton valider
		OK_BOUTON.addActionListener(new BoutonListener());
		PanControl.add(OK_BOUTON);
		
		this.add(PanAcronymes, BorderLayout.CENTER); // Ajout du panel contenant les zones de texte au centre
		this.add(PanControl, BorderLayout.SOUTH);
		
		BoutonDejaActionner = true;
	}
	
	// Pour chaque bouton correspondant aux nombres de joueurs, on récupère ce nombre et on affiche la seconde partie de la fenetre de dialogue qui récupère les acronymes des joueurs
	public class Button1Action implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
	        nbJoueurs=2;
	        ChoixAcronymes(nbJoueurs);
	  }}
	public class Button2Action implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
	        nbJoueurs=3;
	        ChoixAcronymes(nbJoueurs);
	  }}
	public class Button3Action implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
	        nbJoueurs=4;
	        ChoixAcronymes(nbJoueurs);
	  }}
	public class Button4Action implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
	        nbJoueurs=5;
	        ChoixAcronymes(nbJoueurs);
	  }}
	public class Button5Action implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
	        nbJoueurs=6;
	        ChoixAcronymes(nbJoueurs);
	  }}
	
	// Action réalisée quand on clique sur le bouton Valider
	public class BoutonListener implements ActionListener{
	    public void actionPerformed(ActionEvent e) { 
	    	Color[] ListeCouleurs = {Color.red, Color.blue, Color.green, Color.yellow, Color.cyan, Color.magenta}; // Liste des couleurs pour les joueurs
	    	int i=0;
	    	if (AcronymesValides(ListeTextField)) {
	    		for (JFormattedTextField Jtext : ListeTextField) {
		    		ListeDesJoueurs.add(new Joueur(Jtext.getText(),ListeCouleurs[i])); // On créé des joueur avec comme acronymes ceux entrés dans les champs de texte
		    		i++;
		    	}
	    		setVisible(false); // On retire la fenetre de dialogue
	            dispose();
	    	}
            
	    }
	    public boolean AcronymesValides(ArrayList<JFormattedTextField> ListeTextField) { // Fonction qui renvoie true si les acronymes font 3 caractères
	    	boolean sendData = true;
	    	for (JFormattedTextField Jtext : ListeTextField) {
	    		if (Jtext.getText().length()!=3) { // On vérifie que tous les acronymes des joueurs sont définis avec une longueur de 3
	    			sendData=false;
	    		}
	    	}
	    	return sendData;
	    }
	  }
}