
import java.awt.BorderLayout;
import java.awt.Component;
import java.util.ArrayList;

public class MainRisk {

	public static void main(String[] args) {
		// Cr√©ation des ArrayList contenant les informations n√©cessaires au jeu
		ArrayList<Missions> ListeMissions= new ArrayList<Missions>();
		ArrayList<Joueur> ListeJoueurs = new ArrayList<Joueur>();
		ArrayList<Territoire> ListeTerritoires = new ArrayList<Territoire>();
		ArrayList<Region> ListeRegions = new ArrayList<Region>();
		
		
		// Initialisation de la fentre et de la carte du monde
		Interface fenetre = new Interface(ListeJoueurs);
		
		// Affichage d'une pop-up r√©cup√©rant le nombre de joueurs et leurs acronymes et crÈÈ les joueurs
		FenetreNombreJoueur ChoixJoueurs = new FenetreNombreJoueur(fenetre,"Choix du nombre de joueurs",true,ListeJoueurs);
		
		//Cr√©ation des missions en fonction du nombre de joueurs dans la partie
				GenererMissions(ListeJoueurs.size(), ListeMissions);
				//Attribution des missions √† chaque joueur
				for (Joueur J : ListeJoueurs) {
					J.AttribuerMissions(ListeMissions);
					System.out.println(J.acronyme+" "+J.Mission.toString());
				}

				
				//Cr√©ation des regions et des territoires
				GenererRegionsTerritoires(ListeRegions, ListeTerritoires);
				// Affichage des regions en console pour vÈrifier que le code marche
				for (Region reg : ListeRegions) {
					System.out.print(reg.toString());
				}
				// Affichage des territoires en console pour vÈrifier que le code marche
				for (Territoire ter : ListeTerritoires) {
					System.out.print(ter.TerritoiresProches.toString());
					System.out.println(ter.PosXBouton+","+ter.PosYBouton);
				}

				
				
				//Attribution des territoires ‡ chaque joueur
				ArrayList<Territoire> ListeTerritoiresRestants = new ArrayList<Territoire>();//On crÈÈ une liste avec tous les territoires pour pouvoir la modifier en gardant ListeTerritoires intacte
				ListeTerritoiresRestants.addAll(ListeTerritoires);
				AttribuerTerritoires(ListeJoueurs, ListeTerritoires, ListeTerritoiresRestants);
				
				// Verification sur les territoires de chaque joueurs
				for(Joueur J: ListeJoueurs) {
					System.out.println(" ");
					System.out.print(J.acronyme);
					System.out.print(J.TerritoiresJoueur.toString());
					System.out.println(J.CouleurToString());
				}

		//Test PanneauAjoutArmÈe
				//On cree une liste qui contiendra les panneaux d'ajout d'armees de chaque joueur
				ArrayList<PanneauAjoutArmee> ListePanneauAjoutArmee = new ArrayList<PanneauAjoutArmee>();
				for(Joueur J : ListeJoueurs) {
					ListePanneauAjoutArmee.add(new PanneauAjoutArmee(J));
				}
				
				//Boucle qui passe d'un joueur ‡ un autre lors que celui ci finalise ses ajout d'armees
				int i=0;
					while(i<=ListeJoueurs.size()){
						if(i==ListeJoueurs.size() && ((PanneauAjoutArmee) ListePanneauAjoutArmee.get(i-1)).getFinalisation() == true){//Quand le dernier joueur a valider son ajout d'armee
							fenetre.remove((Component) ListePanneauAjoutArmee.get(i-1));
							break;
						}
						else if (i!=0 && i!=ListeJoueurs.size()){//Supprime ‡ partir du 2eme joueur le panneau du joueur precedent
							fenetre.remove((Component) ListePanneauAjoutArmee.get(i-1));
						}
						if(i<ListeJoueurs.size()) {//Cree un panneau au joueur i
							fenetre.getContentPane().add((Component) ListePanneauAjoutArmee.get(i),BorderLayout.CENTER);
							fenetre.validate();
						}
						if(((PanneauAjoutArmee) ListePanneauAjoutArmee.get(i)).getFinalisation() == true) {//Incremente i si le joueur valide son ajout d'armee
							i+=1;							
						}
					}
					
					// Ajout de la carte et de la lÈgende des joueurs dans la fenetre de jeu
					Panneau Panneau = new Panneau(ListeJoueurs,ListeTerritoires);
					fenetre.getContentPane().add(Panneau,BorderLayout.CENTER);
					fenetre.validate();
					//Placement des armees sur les territoires par les joueurs
					Panneau.AjouterNomJoueur(ListeJoueurs.get(0));
					fenetre.getContentPane().repaint();
					fenetre.validate();
				
	
	}
							
	
				
				
				

		

	
	
	
	

	//Initialisation des missions en fonction du nombre de joueurs
	public static void GenererMissions(int nbJoueurs,ArrayList<Missions> ListeMissions) {		
		switch(nbJoueurs) {
			case(2):
				Missions M1_2 = new Missions("Conquerir tous les territoires");
				Missions M2_2 = new Missions("Controler 3 regions et au moins 18 territoires");
				Missions M3_2 = new Missions("Controler 30 territoires");
				Missions M4_2 = new Missions("Controler la plus grosse region + 1 autre region");
				ListeMissions.add(M1_2);
				ListeMissions.add(M2_2);
				ListeMissions.add(M3_2);
				ListeMissions.add(M4_2);
				break;
			case(3):
				Missions M1_3 = new Missions("Detruire le joueur X");
				Missions M2_3 = new Missions("Conquerir tous les territoires");
				Missions M3_3 = new Missions("Controler 3 regions et au moins 18 territoires");
				Missions M4_3 = new Missions("Controler 18 territoires avec au moins 2 armees");
				Missions M5_3 = new Missions("Controler 30 territoires");
				Missions M6_3 = new Missions("Controler la plus grosse region + 1 autre region");
				ListeMissions.add(M1_3);
				ListeMissions.add(M2_3);
				ListeMissions.add(M3_3);
				ListeMissions.add(M4_3);
				ListeMissions.add(M5_3);
				ListeMissions.add(M6_3);
				break;
			case(4):
				Missions M1_4 = new Missions("Detruire le joueur X");
				Missions M2_4 = new Missions("Controler 3 regions et au moins 18 territoires ");
				Missions M3_4 = new Missions("Controler 18 territoires avec au moins 2 armees");
				Missions M4_4 = new Missions("Controler 24 territoires");
				Missions M5_4 = new Missions("Controler la plus grosse r√©gion + 1 autre region");
				ListeMissions.add(M1_4);
				ListeMissions.add(M2_4);
				ListeMissions.add(M3_4);
				ListeMissions.add(M4_4);
				ListeMissions.add(M5_4);
				break;
			case(5):
				Missions M1_5 = new Missions("Detruire le joueur X");
				Missions M2_5 = new Missions("Controler 3 regions et au moins 18 territoires");
				Missions M3_5 = new Missions("Controler 18 territoires avec au moins 2 armees");
				Missions M4_5 = new Missions("Controler 24 territoires ");
				Missions M5_5 = new Missions("Controler la plus grosse region + 1 autre region");
				ListeMissions.add(M1_5);
				ListeMissions.add(M2_5);
				ListeMissions.add(M3_5);
				ListeMissions.add(M4_5);
				ListeMissions.add(M5_5);
				break;
			case(6):
				Missions M1_6 = new Missions("Detruire le joueur X");
				Missions M2_6 = new Missions("Controler 3 regions et au moins 18 territoires");
				Missions M3_6 = new Missions("Controler 18 territoires avec au moins 2 armees");
				Missions M4_6 = new Missions("Controler 21 territoires");
				Missions M5_6 = new Missions("Controler la plus grosse region + 1 autre region");
				ListeMissions.add(M1_6);
				ListeMissions.add(M2_6);
				ListeMissions.add(M3_6);
				ListeMissions.add(M4_6);
				ListeMissions.add(M5_6);
				break;
		}
	}
	
	//Initioalisation des regions et des territoires
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
		for(int i=0 ; i<ListeRegions.size(); i++) {
			for(int j=0; j<Territoires[i].length; j++) {
				Territoire T = new Territoire(Territoires[i][j], ListeRegions.get(i)); // On instancie les territoires de chaque r√©gion
				ListeTerritoires.add(T); // On ajoute ce territoire √† l'arraylist contenant tous les territoires
				ListeRegions.get(i).Territoires.add(T); // On ajoute ce territoire √† l'arraylist Territoire de chaques r√©gions
			}
		}
		//Initialisation des territoires proches
		int [][] TerritoiresProchesTab = {
				{1,3,23}, {0,3,2,4}, {5,13}, {0,1,4,6}, {1,3,4,5,6,7}, {2,4,7}, {3,4,7,8}, {4,5,6,8}, {6,7,9},
				{8,10,11}, {9,11,12}, {9,10,12,36}, {10,11},
				{2,14,19}, {13,15,16,19}, {13,16,17,36}, {14,15,17,18}, {15,16,18,31,36,37}, {16,17,19,20,24,31},{13,14,18},
				{18,21,24,28}, {20,22,25,26,28}, {21,23,25}, {0,22,25,26,27} ,{18,21,28,31} ,{21,22,23,26}, {21,23,25,27,28}, {23,26}, {20,21,24,26,29,30,31}, {28,30,32}, {28,29,31}, {17,18,24,28,30,37,39}, 
				{29,33,34}, {32,34,35}, {32,33,35}, {33,34},
				{11,15,17,37,38,39}, {17,31,36,39}, {36,37,39,40}, {31,36,37,38,40,41}, {38,39,41}, {39,40}
				};
		int [][] PositionBouton = {
				{141,293},{331,302},{702,187},{319,383},{448,391},{551,387},{338,474},{457,505},{400,598},
				{548,680},{549,793},{647,766},{577,907},
				{807,296},{899,391},{917,441},{974,407},{1015,453},{1096,370},{995,287},
				{1240,337},{1382,279},{1523,286},{1678,290},{1239,445},{1466,373},{1496,445},{1605,506},{1403,514},{1419,623},{1295,575},{1126,527},
				{1478,716},{1623,748},{1540,859},{1645,875},
				{904,607},{1022,564},{1016,721},{1087,666},{1029,837},{1141,821}
				};
		
		for(int i=0 ; i<ListeTerritoires.size() ; i++) {
			for(int j=0; j<TerritoiresProchesTab[i].length; j++) {
				ListeTerritoires.get(i).TerritoiresProches.add(ListeTerritoires.get(TerritoiresProchesTab[i][j]));//A chaque territoire on lui attribu plusieurs territoires proches dans son array liste territoires proches
			}
			ListeTerritoires.get(i).PosXBouton=PositionBouton[i][0];
			ListeTerritoires.get(i).PosYBouton=PositionBouton[i][1];
			
		}
		
		

	}
	
	//Attribution des territoires au joueurs en fonction de leur nombre
	public static void AttribuerTerritoires(ArrayList<Joueur> ListeJoueur,ArrayList<Territoire> ListeTerritoires, ArrayList<Territoire> ListeTerritoiresRestants) {
		
		int nbJoueurs = ListeJoueur.size();
		int reste = ListeTerritoires.size()%nbJoueurs;
		
		while(ListeTerritoiresRestants.size()!=reste) {//Boucle qui s'execute tant que la liste TerritoiresRestants n'est pas Ègale au reste du nombre de territoires par le nombre de joueurs
			for(int i=0; i<nbJoueurs; i+=1) {//Boucle qui a chaque passage attribu au joueur i un territoire aleatoire
				int y= GenererNbAleatoire(0, ListeTerritoiresRestants.size()-1);
				ListeJoueur.get(i).TerritoiresJoueur.add(ListeTerritoiresRestants.get(y));
				ListeTerritoiresRestants.remove(ListeTerritoiresRestants.get(y));
				}

			}
		int i=1;
		//Si le reste de la division n'est pas nul alors il reste deux territoires ‡ attribuer
		while(reste!=0) {
			ListeJoueur.get(ListeJoueur.size()-i).TerritoiresJoueur.add(ListeTerritoiresRestants.get(reste-1));
			ListeTerritoiresRestants.remove(ListeTerritoiresRestants.get(reste-1));
			i+=1;
			reste=reste-1;
		}
	
	}

	//Placement des armÈes
	public static void PlacerArmee(ArrayList<Joueur> ListeJoueur) {
		int nbJoueurs = ListeJoueur.size();
		int nbArmees;
		
		//On initialise la varriable nombre d'armees ‡ distribuer ‡ chaque joueurs en fonction du nombre de joueurs
		switch(nbJoueurs) {
		case(2):
			nbArmees=40;
			break;
		case(3):
			nbArmees=35;
			break;
		case(4):
			nbArmees=30;
			break;
		case(5):
			nbArmees=25;
			break;
		case(6):
			nbArmees=20;
			break;
		}
		
		//Tour ‡ tour le joueur en question selectionne chaqu'un de ses territoires et y ajoute les armees qu'il veut (il est obligatoire d'avoir au moins 1 armee par territoire
		//et il faut placer le nombre d'armees qu'on a pour chaque joueurs)
		for(int i=0; i<nbJoueurs; i+=1) {
			//On selectionne le premier joueur
			//On affiche la carte avec des points seulement dans ses territoires
			//Quand il clique sur un de ses territoires on lui affiche en bas les 3 images d'armees possible a placer et le nombre d'armee qu'il lui reste a placer
		}
			
	}
		
	//Fonction qui genere un nombre aleatoire
	public static int GenererNbAleatoire(int a, int b) {
		int nombreAleatoire = a + (int)(Math.random() * ((b - a) + 1));
		return nombreAleatoire;
	}
	
}