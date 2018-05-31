import java.util.ArrayList;

public class Territoire {
	public Joueur Joueur;
	public String nom;
	public ArrayList<Armée> ListeTroupes;
	public ArrayList<Territoire> TerritoiresProches;
	public final Region Region;
	public int PosXBouton;
	public int PosYBouton;
	
	public Territoire(String nom, Region region) {
		this.nom = nom;
		Region = region;
		this.TerritoiresProches = new ArrayList<Territoire>();
	}
	
	public int NombreUnite(String type) {
		int nbTroupes=0;
		for (Armée Troupe : this.ListeTroupes) {
			if (Troupe.Type==type) {
				nbTroupes++;
			}
		}
		return nbTroupes;		
	}
	//Fonction recuperer le nom d'un territoire 
	public String toString() {
		return " "+this.nom;
	}	
	
	public void setJoueur(Joueur J) {
		this.Joueur=J;
	}

	
}
