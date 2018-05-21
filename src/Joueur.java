import java.util.ArrayList;

public class Joueur {
	public String acronyme;
	public int nbRegions;
	public Missions Mission;
	public ArrayList<Territoire> TerritoiresJoueur;
	
	public Joueur(String acronyme, int nbTerritoires, int nbRegions) {
		this.acronyme = acronyme;
	}
	
	//Methode
	
	//Attribution une missions à chaque joueurs
	public void AttribuerMissions(ArrayList<Missions> ListeMissions) {
			int a = GenererNbAleatoire(0, ListeMissions.size()-1);
			this.Mission = ListeMissions.get(a);
		}
	
	//Attribution des territoires à chaque joueur
		public void AttribuerTerritoires(int nbJoueurs,ArrayList<Territoire> ListeTerritoires) {
			
			int nbTerritoireMax = ListeTerritoires.size()/nbJoueurs;//On calcule le nombre de territoires à attribuer à chaque joueur
			ArrayList<Territoire> ListeTerritoiresRestants = new ArrayList<Territoire>();//On créé une liste avec tous les territoires pour pouvoir la modifier en gardant ListeTerritoires intacte
			ListeTerritoiresRestants.addAll(ListeTerritoires);
			
			for(int i=0; i<=nbTerritoireMax; i++) {
				
				int y= GenererNbAleatoire(0, ListeTerritoiresRestants.size());
				TerritoiresJoueur.add(ListeTerritoiresRestants.get(y));
				ListeTerritoiresRestants.remove(ListeTerritoiresRestants.get(y));
				System.out.println(ListeTerritoires);
			}
			
		}
	
	//Fonction generer nb aléat
	public static int GenererNbAleatoire(int a, int b) {
		int nombreAleatoire = a + (int)(Math.random() * ((b - a) + 1));
		return nombreAleatoire;
	}

}
