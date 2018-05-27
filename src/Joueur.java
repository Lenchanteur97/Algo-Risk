import java.awt.Color;
import java.util.ArrayList;

public class Joueur {
	public String acronyme;
	public int nbRegions;
	public Missions Mission;
	public ArrayList<Territoire> TerritoiresJoueur;
	public Color couleur;
	
	public Joueur(String acronyme, Color couleur) {
		this.acronyme = acronyme;
		this.couleur = couleur;
		this.TerritoiresJoueur = new ArrayList<Territoire>();
	}
	
	//Attribution une mission à chaque joueur
	public void AttribuerMissions(ArrayList<Missions> ListeMissions) {
			int a = GenererNbAleatoire(0, ListeMissions.size()-1);
			this.Mission = ListeMissions.get(a);
		}
	
	//Attribution des territoires à chaque joueur
	public void AttribuerTerritoires(ArrayList<Joueur> ListeJoueur,ArrayList<Territoire> ListeTerritoires) {
			int nbJoueurs = ListeJoueur.size();
			int nbTerritoireMax = ListeTerritoires.size()/nbJoueurs;//On calcule le nombre de territoires à attribuer à chaque joueur (division euclidienne sans prendre en compte le reste)
			ArrayList<Territoire> ListeTerritoiresRestants = new ArrayList<Territoire>();//On créé une liste avec tous les territoires pour pouvoir la modifier en gardant ListeTerritoires intacte
			ListeTerritoiresRestants.addAll(ListeTerritoires);
			
			for(int i=0; i<nbTerritoireMax; i++) {//On créé une boucle qui se repetera le nombre de foix qu'il y aura de territoires à attribuer aux joueurs
				
				int y= GenererNbAleatoire(0, ListeTerritoiresRestants.size()-1);//On prend un nombre aléatoire dans les indexes de la liste des territoires à attribuer
				TerritoiresJoueur.add(ListeTerritoiresRestants.get(y));//On l'ajoute à la liste des territoires du joueur en question
				ListeTerritoiresRestants.remove(ListeTerritoiresRestants.get(y));//Et on la supprime de la liste des territoires à attribuer car il vient d'etre attribué
				//Test qui affiche le nom du joueur à qui on attribue le territoire et le territoire que l'on lui attribu
				System.out.println(this.acronyme);
				System.out.println(ListeTerritoires.get(y).toString());
			}
			
		}
	
	//Fonction generer nb aléat
	public static int GenererNbAleatoire(int a, int b) {
		int nombreAleatoire = a + (int)(Math.random() * ((b - a) + 1));
		return nombreAleatoire;
	}

}
