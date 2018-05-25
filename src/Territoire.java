import java.util.ArrayList;

public class Territoire {
	
	public Joueur joueur;
	public String nom;
	public ArrayList<Armée> ListeTroupes;
	public ArrayList<Territoire> TerritoiresProches;
	public final Region Region;
	
	public Territoire(String nom, Region region) {
		this.nom = nom;
		Region = region;
	}
	
	
	//Methodes
	
	//Fonction recuperer le nom d'un territoire 
	public String toString() {
		return " "+this.nom;
	}
	
	//Rempli la liste des territoires proches
	
}
