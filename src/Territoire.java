import java.util.ArrayList;

public class Territoire {
	public Joueur Joueur;
	public String nom;
	public ArrayList<Armée> ListeSoldat;
	public ArrayList<Armée> ListeCavalier;
	public ArrayList<Armée> ListeCanon;
	public ArrayList<Territoire> TerritoiresProches;
	public final Region Region;
	public int PosXBouton;
	public int PosYBouton;
	
	public Territoire(String nom, Region region) {
		this.nom = nom;
		Region = region;
		this.TerritoiresProches = new ArrayList<Territoire>();
		this.ListeSoldat = new ArrayList<Armée>();
		this.ListeCavalier = new ArrayList<Armée>();
		this.ListeCanon = new ArrayList<Armée>();
	}
	
	//Fonction recuperer le nom d'un territoire 
	public String toString() {
		return " "+this.nom;
	}	
	
	public void setJoueur(Joueur J) {
		this.Joueur=J;
	}

	
}
