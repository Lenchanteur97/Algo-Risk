import java.util.ArrayList;

public class Territoire {
	
	// Attributs
	public Joueur joueur;
	public String nom;
	public ArrayList<Arm�e> ListeTroupes;
	public ArrayList<Territoire> TerritoiresProches;
	public final Region Region;
	
	public Territoire(String nom, Region region) {
		this.nom = nom;
		Region = region;
	}
	
	
}
