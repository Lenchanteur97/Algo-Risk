
import java.util.ArrayList;

public class MainRisk {

	public static void main(String[] args) {
		// Initialisation de la carte
		Interface fenetre = new Interface();
		
		// Cr�ation d'une arraylist qui va contenir les joueurs
		ArrayList<Joueur> ListeJoueurs = new ArrayList<Joueur>();
		// Affichage d'une pop-up r�cup�rant le nombre de joueurs qui va ensuite appeler une pop-up pour r�cup�rer l'acronyme des joueurs
		FenetreNombreJoueur ChoixJoueurs = new FenetreNombreJoueur(fenetre,"Choix du nombre de joueurs",true,ListeJoueurs);
	}
}

