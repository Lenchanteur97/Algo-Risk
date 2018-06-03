import java.util.ArrayList;

public class Territoire {
	public Joueur Joueur;
	public String nom;
	public ArrayList<Arm�e> ListeSoldat;
	public ArrayList<Arm�e> ListeCavalier;
	public ArrayList<Arm�e> ListeCanon;
	public ArrayList<Territoire> TerritoiresProches;
	public final Region Region;
	public int PosXBouton;
	public int PosYBouton;
	
	public Territoire(String nom, Region region) {
		this.nom = nom;
		Region = region;
		this.TerritoiresProches = new ArrayList<Territoire>();
		this.ListeSoldat = new ArrayList<Arm�e>();
		this.ListeCavalier = new ArrayList<Arm�e>();
		this.ListeCanon = new ArrayList<Arm�e>();
	}
	
	//Fonction recuperer le nom d'un territoire 
	public String toString() {
		return " "+this.nom;
	}	
	
	public void setJoueur(Joueur J) {
		this.Joueur=J;
	}

	
}
