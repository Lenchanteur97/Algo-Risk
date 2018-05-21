import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import jdk.nashorn.internal.runtime.options.Options;

public class FenetreNombreJoueur extends JDialog {
	private static final long serialVersionUID = 1L;
	public int nbJoueurs;
	private JButton b1,b2,b3,b4,b5;

	public FenetreNombreJoueur(JFrame parent, String title, boolean modal, ArrayList<Joueur> ListeJoueurs) {
		//On appelle le construteur de JDialog correspondant
	    super(parent, title, modal);
	    
	    // On définit les paramètres de notre boite de dialogue
	    this.setSize(300,130);
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
		b1.addActionListener(new Button1Action()); // Ici on définit les actions de chaques boutons
		b2.addActionListener(new Button2Action());
		b3.addActionListener(new Button3Action());
		b4.addActionListener(new Button4Action());
		b5.addActionListener(new Button5Action());
		PanNbJoueurs.add(b1);
		PanNbJoueurs.add(b2);
		PanNbJoueurs.add(b3);
		PanNbJoueurs.add(b4);
		PanNbJoueurs.add(b5);
		
		JLabel OptionsLabel = new JLabel("Choix du nombre de joueurs :");
		// Création d'un panel avec un bouton valider
		JPanel PanControl = new JPanel();
		JButton OK_BOUTON = new JButton("Valider");
		PanControl.add(OK_BOUTON);
		OK_BOUTON.addActionListener(new BoutonListener());
		PanControl.setVisible(true);
		this.getContentPane().add(PanNbJoueurs, BorderLayout.NORTH); // Positionnement des deux panels dans la fenetre de dialogue
		this.getContentPane().add(PanControl, BorderLayout.SOUTH);
		this.setVisible(true);
	}
	
	public class Button1Action implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
	        nbJoueurs=2;
	        System.out.println(nbJoueurs);
	  }}
	public class Button2Action implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
	        nbJoueurs=3;
	        System.out.println(nbJoueurs);
	  }}
	public class Button3Action implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
	        nbJoueurs=4;
	        System.out.println(nbJoueurs);
	  }}
	public class Button4Action implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
	        nbJoueurs=5;
	        System.out.println(nbJoueurs);
	  }}
	public class Button5Action implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
	        nbJoueurs=6;
	        System.out.println(nbJoueurs);
	  }}
	
	
	public class BoutonListener implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
    	  // FenetreAcronymeJoueur ChoixAcronymes = new FenetreAcronymeJoueur(this,"Choix des acronymes des joueurs",true,NombreJoueurs);
          setVisible(false); // On retire la fenetre de dialogue seulement quand le nombre de joueurs est défini
          dispose();
          System.out.println(nbJoueurs);
	    }
	  }
}