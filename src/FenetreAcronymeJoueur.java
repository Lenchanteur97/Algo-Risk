import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FenetreAcronymeJoueur extends JDialog{
	private static final long serialVersionUID = 1L;
	
	public FenetreAcronymeJoueur(ActionListener actionListener, String title, boolean modal, int NombreJoueurs) {
		//On appelle le construteur de JDialog correspondant
	    super();
	    // Création d'une boite de dialogue pour récupérer l'acronyme de chaque joueur
		  this.setSize(300,50*NombreJoueurs);
		  this.setLocationRelativeTo(null);
		  this.getContentPane().setLayout(new GridLayout(NombreJoueurs+1, 1, 0, 5));
		  this.setResizable(false);
		  this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		  // Création de panels récupérant l'acronyme de chaque joueurs
		  ArrayList<JFormattedTextField> ListeTextField = new ArrayList<JFormattedTextField>();
		  for (int i=1;i<=NombreJoueurs;i++) {
			  JPanel PanNomJoueur = new JPanel();
			  PanNomJoueur.setLayout(new GridLayout(1,2));
			  JFormattedTextField SaisieAcronyme = new JFormattedTextField(new MasqueAcronyme());
			  SaisieAcronyme.setPreferredSize(new Dimension(200, 30));
			  JLabel LabelAcronyme = new JLabel("Acronyme Joueur n°"+i+" :");
			  PanNomJoueur.add(LabelAcronyme);
			  PanNomJoueur.add(SaisieAcronyme);
			  this.add(PanNomJoueur);
			  ListeTextField.add(SaisieAcronyme);
		  }
		  // Création d'un panel avec un bouton valider
		  JPanel PanControl = new JPanel();
		  JButton OK_BOUTON = new JButton("Valider");
		  PanControl.add(OK_BOUTON);
		  this.setVisible(true);
		  
		  OK_BOUTON.addActionListener(new ActionListener(){ // Action réalisée quand on clique sur le bouton valider
		      
				public void actionPerformed(ActionEvent arg0) {
					  ArrayList<Joueur> ListeJoueurs = new ArrayList<Joueur>();
			          for (JFormattedTextField Acronyme : ListeTextField) {
			        	    Joueur J = new Joueur(Acronyme.getText(),0,0);
			        	    ListeJoueurs.add(J);
			          }
			          dispose();
				}});
		  
	}
}
