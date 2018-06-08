import java.util.ArrayList;

public class MainRisk {

	public static void main(String[] args) {
		// CrÃ©ation des ArrayList contenant les informations nÃ©cessaires au jeu
		ArrayList<Missions> ListeMissions= new ArrayList<Missions>();
		ArrayList<Joueur> ListeJoueurs = new ArrayList<Joueur>();
		ArrayList<Territoire> ListeTerritoires = new ArrayList<Territoire>();
		ArrayList<Region> ListeRegions = new ArrayList<Region>();
		
		
		// Initialisation de la fentre et de la carte du monde
		Interface fenetre = new Interface(ListeJoueurs, ListeTerritoires);
		
		// Affichage d'une pop-up rÃ©cupÃ©rant le nombre de joueurs et leurs acronymes et créé les joueurs
		FenetreNombreJoueur ChoixJoueurs = new FenetreNombreJoueur(fenetre,"Choix du nombre de joueurs",true,ListeJoueurs);
		
		//CrÃ©ation des missions en fonction du nombre de joueurs dans la partie
				GenererMissions(ListeJoueurs.size(), ListeMissions);
				//Attribution des missions Ã  chaque joueur
				for (Joueur J : ListeJoueurs) {
					J.AttribuerMissions(ListeMissions);
					System.out.println(J.acronyme+" "+J.Mission.toString());
				}

				
				//CrÃ©ation des regions et des territoires
				GenererRegionsTerritoires(ListeRegions, ListeTerritoires);
				// Affichage des regions en console pour vérifier que le code marche
				for (Region reg : ListeRegions) {
					System.out.print(reg.toString());
				}
				// Affichage des territoires en console pour vérifier que le code marche
				for (Territoire ter : ListeTerritoires) {
					System.out.print(ter.TerritoiresProches.toString());
					System.out.println(ter.PosXBouton+","+ter.PosYBouton);
				}

				
				
				//Attribution des territoires à chaque joueur
				ArrayList<Territoire> ListeTerritoiresRestants = new ArrayList<Territoire>();//On créé une liste avec tous les territoires pour pouvoir la modifier en gardant ListeTerritoires intacte
				ListeTerritoiresRestants.addAll(ListeTerritoires);
				AttribuerTerritoires(ListeJoueurs, ListeTerritoires, ListeTerritoiresRestants);
				
				// Verification sur les territoires de chaque joueurs
				for(Joueur J: ListeJoueurs) {
					System.out.println(" ");
					System.out.print(J.acronyme);
					System.out.print(J.TerritoiresJoueur.toString());
					System.out.println(J.CouleurToString());
				}
				
		//Test PanneauAjoutArmée
				int NumJoueurInitialisation = 0;
				// On initialise tous les territoires et quand tout est initialis�, le jeu se lance
				fenetre.AfficherPanneauAjoutArmee(NumJoueurInitialisation, fenetre.CalculArmeeDistribution());
				
				
				
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
				Missions M5_4 = new Missions("Controler la plus grosse rÃ©gion + 1 autre region");
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
				Territoire T = new Territoire(Territoires[i][j], ListeRegions.get(i)); // On instancie les territoires de chaque rÃ©gion
				ListeTerritoires.add(T); // On ajoute ce territoire Ã  l'arraylist contenant tous les territoires
				ListeRegions.get(i).Territoires.add(T); // On ajoute ce territoire Ã  l'arraylist Territoire de chaques rÃ©gions
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
		
		while(ListeTerritoiresRestants.size()!=reste) {//Boucle qui s'execute tant que la liste TerritoiresRestants n'est pas égale au reste du nombre de territoires par le nombre de joueurs
			for(int i=0; i<nbJoueurs; i+=1) {//Boucle qui a chaque passage attribu au joueur i un territoire aleatoire
				int y= GenererNbAleatoire(0, ListeTerritoiresRestants.size()-1);
				ListeJoueur.get(i).TerritoiresJoueur.add(ListeTerritoiresRestants.get(y));
				ListeTerritoiresRestants.remove(ListeTerritoiresRestants.get(y));
				}

			}
		int i=1;
		//Si le reste de la division n'est pas nul alors il reste deux territoires à attribuer
		while(reste!=0) {
			ListeJoueur.get(ListeJoueur.size()-i).TerritoiresJoueur.add(ListeTerritoiresRestants.get(reste-1));
			ListeTerritoiresRestants.remove(ListeTerritoiresRestants.get(reste-1));
			i+=1;
			reste=reste-1;
		}
		
		// On ajoute maintenant le joueur dans les territoires
		for(Joueur J : ListeJoueur) {
			for (Territoire T : J.TerritoiresJoueur) {
				T.setJoueur(J);
			}
		}
	
	}
	
	//Fonction qui attribu � un joueur une region s'il en controle tous les territoires
	public void AtttributerRegion(ArrayList<Region>ListeRegions) {
		boolean VerificationRegion = true;
		//On prend chaque region pour parcourir ses territoires
			for(Region R: ListeRegions) {
				//Pour chaque territoire d'une region on verifie si son possesseur est diff�rent du suivant
				for(int i=0; i<R.Territoires.size()-1;i+=1) {
					
					//Si oui on affecte false a notre verification
					if(R.Territoires.get(i).Joueur!=R.Territoires.get(i+1).Joueur) {
						VerificationRegion = false;
					}
				}
				//Si la verification est validee a la fin de la liste des territoires on recupere le joueur et on lui ajoutons la region validee dans sa liste regions
				Joueur Joueur = R.Territoires.get(0).Joueur;
				if(VerificationRegion == true) {
					Joueur.RegionsJoueur.add(R);
				}
				//Si la verification n'est pas validee alors le joueur n'a pas tous les territoires de la region
				for(int i=0; i<Joueur.RegionsJoueur.size(); i+=1) {
					//Si en plus le joueur dans sa liste region a toujour la region alors on la supprime
					if(VerificationRegion == false && Joueur.RegionsJoueur.get(i)==R) {
						Joueur.RegionsJoueur.remove(i);
					}
				}
					
			}
		}
		
	//Fonction qui genere un nombre aleatoire
	public static int GenererNbAleatoire(int a, int b) {
		int nombreAleatoire = a + (int)(Math.random() * ((b - a) + 1));
		return nombreAleatoire;
	}
	
	
}