import java.util.ArrayList;

public class Deplacement_Attaque {
	
	// Attributs
	private Territoire Territoire1;
	private Territoire Territoire2;
	private ArrayList<Arm�e> ListeAttaquant;
	private ArrayList<Arm�e> ListeDefense;
	FenDialogDeplacement DialogDeplacement;
	FenDialogAttaque DialogAttaque;
	Interface fenetre;
	
	
	public Deplacement_Attaque(ArrayList<Territoire> ListeTerritoiresChoisis, Interface fenetre) {
		this.fenetre=fenetre;
		Territoire1=ListeTerritoiresChoisis.get(0);
		Territoire2=ListeTerritoiresChoisis.get(1);
		ListeAttaquant = new ArrayList<Arm�e>();
		ListeDefense = new ArrayList<Arm�e>();
		System.out.println(Territoire1.nom+Territoire2.nom);
		DeplacementOuAttaque(Territoire1, Territoire2);
	}

	private void DeplacementOuAttaque(Territoire T1, Territoire T2) {
		if (T1.Joueur.equals(T2.Joueur)) {
			System.out.println("Same player");
			// On ouvre une fenetre de dialogue pour demander au joueur les unit�es � d�placer
			DialogDeplacement = new FenDialogDeplacement(T1,T2,fenetre); 
		}
		else {
			System.out.println("Different player");
			// On ouvre une fenetre de dialogue pour demander au joueur les unit�es pour attaquer
			DialogAttaque = new FenDialogAttaque(T1,T2,fenetre);
		}
	}
	
	public Territoire getT1() {
		return Territoire1;
	}
	public Territoire getT2() {
		return Territoire2;
	}
}
