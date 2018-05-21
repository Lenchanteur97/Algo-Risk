
import java.util.ArrayList;

public class MainRisk {

	public static void main(String[] args) {
		// Cr�ation des ArrayList contenant les informations n�cessaires au jeu
		ArrayList<Missions> ListeMissions= new ArrayList<Missions>();
		ArrayList<Joueur> ListeJoueurs = new ArrayList<Joueur>();
		ArrayList<Territoire> ListeTerritoires = new ArrayList<Territoire>();
		ArrayList<Region> ListeRegions = new ArrayList<Region>();
		
		
		// Initialisation de la carte
		Interface fenetre = new Interface();
		
		
		// Affichage d'une pop-up r�cup�rant le nombre de joueurs qui va ensuite appeler une pop-up pour r�cup�rer l'acronyme des joueurs
		FenetreNombreJoueur ChoixJoueurs = new FenetreNombreJoueur(fenetre,"Choix du nombre de joueurs",true,ListeJoueurs);
		
		//Cr�ation des missions en fonction du nombre de joueurs dans la partie
		GenererMissions(ListeJoueurs.size(), ListeMissions);
		//Attribution des missions � chaque joueur
		for (Joueur J : ListeJoueurs) {
			J.AttribuerMissions(ListeMissions);
		}
		
		//Cr�ation des regions et des territoires
		GenererRegionsTerritoires(ListeRegions, ListeTerritoires);
	}
	
	
	
	

	//Initialisation des missions en fonction du nombre de joueurs
	public static void GenererMissions(int nbJoueurs,ArrayList<Missions> ListeMissions) {		
		switch(nbJoueurs) {
			case(2):
				Missions M1_2 = new Missions("Conqu�rir tous les territoires");
				Missions M2_2 = new Missions("Contr�ler 3 r�gions et au moins 18 territoires");
				Missions M3_2 = new Missions("Contr�ler 30 territoires");
				Missions M4_2 = new Missions("Contr�ler la plus grosse r�gion + 1 autre r�gion");
				ListeMissions.add(M1_2);
				ListeMissions.add(M2_2);
				ListeMissions.add(M3_2);
				ListeMissions.add(M4_2);
				break;
			case(3):
				Missions M1_3 = new Missions("D�truire le joueur X");
				Missions M2_3 = new Missions("Conqu�rir tous les territoires");
				Missions M3_3 = new Missions("Contr�ler 3 r�gions et au moins 18 territoires");
				Missions M4_3 = new Missions("Contr�ler 18 territoires avec au moins 2 arm�es");
				Missions M5_3 = new Missions("Contr�ler 30 territoires");
				Missions M6_3 = new Missions("Contr�ler la plus grosse r�gion + 1 autre r�gion");
				ListeMissions.add(M1_3);
				ListeMissions.add(M2_3);
				ListeMissions.add(M3_3);
				ListeMissions.add(M4_3);
				ListeMissions.add(M5_3);
				ListeMissions.add(M6_3);
				break;
			case(4):
				Missions M1_4 = new Missions("D�truire le joueur X");
				Missions M2_4 = new Missions("Contr�ler 3 r�gions et au moins 18 territoires ");
				Missions M3_4 = new Missions("Contr�ler 18 territoires avec au moins 2 arm�es");
				Missions M4_4 = new Missions("Contr�ler 24 territoires");
				Missions M5_4 = new Missions("Contr�ler la plus grosse r�gion + 1 autre r�gion");
				ListeMissions.add(M1_4);
				ListeMissions.add(M2_4);
				ListeMissions.add(M3_4);
				ListeMissions.add(M4_4);
				ListeMissions.add(M5_4);
				break;
			case(5):
				Missions M1_5 = new Missions("D�truire le joueur X");
				Missions M2_5 = new Missions("Contr�ler 3 r�gions et au moins 18 territoires");
				Missions M3_5 = new Missions("Contr�ler 18 territoires avec au moins 2 arm�es");
				Missions M4_5 = new Missions("Contr�ler 24 territoires ");
				Missions M5_5 = new Missions("Contr�ler la plus grosse r�gion + 1 autre r�gion");
				ListeMissions.add(M1_5);
				ListeMissions.add(M2_5);
				ListeMissions.add(M3_5);
				ListeMissions.add(M4_5);
				ListeMissions.add(M5_5);
				break;
			case(6):
				Missions M1_6 = new Missions("D�truire le joueur X");
				Missions M2_6 = new Missions("Contr�ler 3 r�gions et au moins 18 territoires");
				Missions M3_6 = new Missions("Contr�ler 18 territoires avec au moins 2 arm�es");
				Missions M4_6 = new Missions("Contr�ler 21 territoires");
				Missions M5_6 = new Missions("Contr�ler la plus grosse r�gion + 1 autre r�gion");
				ListeMissions.add(M1_6);
				ListeMissions.add(M2_6);
				ListeMissions.add(M3_6);
				ListeMissions.add(M4_6);
				ListeMissions.add(M5_6);
				break;
		}
	}
	
	//Initialisation des regions et des territoires 
	public static void GenererRegionsTerritoires(ArrayList<Region> ListeRegions, ArrayList<Territoire> ListeTerritoires) {
		//Initialisation des regions
		String [] NomRegions = {"NA", "SA", "EU", "AS", "AU", "AF"};
		for (String str : NomRegions) {
			ListeRegions.add(new Region(str));
		}
		
		//Initialisation des territoires
		String [][] Territoires = {{"NA1", "NA2", "NA3", "NA4", "NA5", "NA6", "NA7", "NA8", "NA9"},
									{"SA1" ,"SA2" ,"SA3" ,"SA4"},
									{"EU1", "EU2", "EU3", "EU4", "EU5", "EU6", "EU7"},
									{"AS1", "AS2", "AS3", "AS4", "AS5", "AS6", "AS7", "AS8", "AS9", "AS10", "AS11", "AS12"},
									{"AU1", "AU2", "AU3", "AU4"},
									{"AF1", "AF2", "AF3", "AF4", "AF5", "AF6"}};
		for(int i=0 ; i<Territoires.length; i++) {
			for(int j=0; j<Territoires[i].length; j++) {
				Territoire T = new Territoire(Territoires[i][j], ListeRegions.get(i)); // On instancie les territoires de chaque r�gion
				ListeTerritoires.add(T); // On ajoute ce territoire � l'arraylist contenant tous les territoires
				ListeRegions.get(i).Territoires.add(T); // On ajoute ce territoire � l'arraylist Territoire de chaques r�gions
			}
			
		}
		
	}
	
}