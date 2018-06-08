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
	
	public ArrayList<Armée> UniteAvecDeplacements(String Type) { // Fonction qui retourne une liste contenant les unitées à qui il reste des déplacements
		ArrayList<Armée> ListeArmeeDeplacement = new ArrayList<Armée>();
		if (Type=="Soldat") {
			for (Armée A : this.ListeSoldat) {
				if (A.nbDeplacement!=0) {
					ListeArmeeDeplacement.add(A);
				}
			}
		}
		else if (Type=="Cavalier") {
			for (Armée A : this.ListeCavalier) {
				if (A.nbDeplacement!=0) {
					ListeArmeeDeplacement.add(A);
				}
			}
		}
		else if (Type=="Canon") {
			for (Armée A : this.ListeCanon) {
				if (A.nbDeplacement!=0) {
					ListeArmeeDeplacement.add(A);
				}
			}
		}
		return ListeArmeeDeplacement;
	}
}
