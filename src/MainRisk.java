import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainRisk {

	public static void main(String[] args) {
		// Initialisation de la carte
		Interface fenetre = new Interface();
		
		
		// Affichage d'une pop-up récupérant le nombre de joueurs 
		JDialog ChoixJoueurs = new JDialog(fenetre,"Choix du nombre de joueurs",true);
		ChoixJoueurs.setSize(300,130);
		ChoixJoueurs.setLocationRelativeTo(null);
		ChoixJoueurs.setResizable(false);
		ChoixJoueurs.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);    
	    // Combo box avec le nombre de joueurs possibles
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
		JPanel PanControl = new JPanel();
		JButton OK_BOUTON = new JButton("Valider");
		OK_BOUTON.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent arg0) {
		    	  final int NombreJoueurs=(int)Options.getSelectedItem();
		          ChoixJoueurs.setVisible(false);
		          System.out.println(NombreJoueurs);
		      }      
		});
		PanControl.add(OK_BOUTON);
		PanControl.setVisible(true);
		ChoixJoueurs.getContentPane().add(PanJoueurs, BorderLayout.NORTH);
		ChoixJoueurs.getContentPane().add(PanControl, BorderLayout.SOUTH);
		ChoixJoueurs.setVisible(true);

	}
}

