import java.awt.Color;
import java.util.ArrayList;

public class Territoire {
	
	// Attributs
	public final int id;
	public Joueur joueur;
	public int nbSoldat;
	public int nbCavalier;
	public int nbCanon;
	public ArrayList<Territoire> TerritoireProche;
	public final Region Region;
	private final double [] abcisses;
	private final double [] ordonnees;
	private final Color couleur;	
}
