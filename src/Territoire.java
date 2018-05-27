import java.util.ArrayList;

public class Territoire {
	
	public Joueur joueur;
	public String nom;
	public ArrayList<Arm�e> ListeTroupes;
	public ArrayList<Territoire> TerritoiresProches;
	public final Region Region;
	
	public Territoire(String nom, Region region) {
		this.nom = nom;
		Region = region;
		this.TerritoiresProches = new ArrayList<Territoire>();
	}
	
	
	//Methodes
	
	//Fonction recuperer le nom d'un territoire 
	public String toString() {
		return " "+this.nom;
	}	

	
}
