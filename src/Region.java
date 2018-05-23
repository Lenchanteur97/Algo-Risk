import java.util.ArrayList;

public class Region {
	public ArrayList<Territoire> Territoires;
	public final String nom;
	
	public Region(String nom) {
		this.Territoires = new ArrayList<Territoire>();
		this.nom = nom;
	}
	
	public String toString() {
			return " "+this.nom;
	}
}
