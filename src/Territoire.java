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
	
	public boolean TerritoiresAdjacents(Territoire T) {
		boolean verif;
		if (this.TerritoiresProches.contains(T)) {
			verif = true;
		}
		else {
			verif = false;
		}
		return verif;
	}
	
	public ArrayList<Arm�e> UniteAvecDeplacements(String Type) { // Fonction qui retourne une liste contenant les unit�es � qui il reste des d�placements
		ArrayList<Arm�e> ListeArmeeDeplacement = new ArrayList<Arm�e>();
		if (Type=="Soldat") {
			for (Arm�e A : this.ListeSoldat) {
				if (A.nbDeplacement!=0) {
					ListeArmeeDeplacement.add(A);
				}
			}
		}
		else if (Type=="Cavalier") {
			for (Arm�e A : this.ListeCavalier) {
				if (A.nbDeplacement!=0) {
					ListeArmeeDeplacement.add(A);
				}
			}
		}
		else if (Type=="Canon") {
			for (Arm�e A : this.ListeCanon) {
				if (A.nbDeplacement!=0) {
					ListeArmeeDeplacement.add(A);
				}
			}
		}
		return ListeArmeeDeplacement;
	}
}
