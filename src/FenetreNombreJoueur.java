import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FenetreNombreJoueur extends JDialog {
	private static final long serialVersionUID = 1L;
	
	public FenetreNombreJoueur(JFrame parent, String title, boolean modal, ArrayList<Joueur> ListeJoueurs) {
		//On appelle le construteur de JDialog correspondant
	    super(parent, title, modal);
	    
	    // On définit les paramètres de notre boite de dialogue
	    this.setSize(300,130);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);    
	    // Création d'un panel avec une combo box permettant de choisir le nombre de joueurs
		JComboBox<Integer> Options = new JComboBox<Integer>();
		Options.addItem(2);
		Options.addItem(3);
		Options.addItem(4);
		Options.addItem(5);
		Options.addItem(6);
		JLabel OptionsLabel = new JLabel("Choix du nombre de joueurs :");
		JPanel PanJoueurs = new JPanel();
		PanJoueurs.setBorder(BorderFactory.createTitledBorder("Veuillez choisir le nombre de joueurs :"));
	    PanJoueurs.setPreferredSize(new Dimension(250, 50));
		PanJoueurs.add(OptionsLabel);
		PanJoueurs.add(Options);
		PanJoueurs.setVisible(true);
		// Création d'un panel avec un bouton valider
		JPanel PanControl = new JPanel();
		JButton OK_BOUTON = new JButton("Valider");
		PanControl.add(OK_BOUTON);
		PanControl.setVisible(true);
		this.getContentPane().add(PanJoueurs, BorderLayout.NORTH); // Positionnement des deux panels dans la fenetre de dialogue
		this.getContentPane().add(PanControl, BorderLayout.SOUTH);
		this.setVisible(true);
		
		
		OK_BOUTON.addActionListener(new ActionListener(){ // Action réalisée quand on clique sur le bouton valider
		      
			public void actionPerformed(ActionEvent arg0) {
		    	  final int NombreJoueurs=(int)Options.getSelectedItem(); // On récupère le nombre de joueurs entré par les joueurs quand ils cliquent sur valider
		          setVisible(false); // On retire la fenetre de dialogue seulement quand le nombre de joueurs est défini
		          System.out.println(NombreJoueurs);
		          // Affichage d'une pop-up récupérant les acronymes des joueurs
		  		  FenetreAcronymeJoueur ChoixAcronymes = new FenetreAcronymeJoueur(this,"Choix des acronymes des joueurs",true,NombreJoueurs,ListeJoueurs);
			}});	
	}
}
