import java.util.ArrayList;

public class Joueur {
	public String acronyme;
	public int nbRegions;
	public Missions Mission;
	public ArrayList<Territoire> TerritoiresJoueur;
	
	public Joueur(String acronyme) {
		this.acronyme = acronyme;
		this.TerritoiresJoueur = new ArrayList<Territoire>();
	}
	
	//Methode
	
	//Attribution une mission à chaque joueur
	public void AttribuerMissions(ArrayList<Missions> ListeMissions) {
			int a = GenererNbAleatoire(0, ListeMissions.size()-1);
			this.Mission = ListeMissions.get(a);
		}
	
	//Fonction generer nb aléat
	public static int GenererNbAleatoire(int a, int b) {
		int nombreAleatoire = a + (int)(Math.random() * ((b - a) + 1));
		return nombreAleatoire;
	}

}
