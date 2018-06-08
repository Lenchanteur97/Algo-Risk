
public class Armée {
	public final String Type;
	public final int Cout;
	public final int PuissanceMin;
	public final int PuissanceMax;
	public final int PriorDef;
	public final int PriorAtt;
	public int nbDeplacement;
	public boolean Detruit;
	
	public Armée(String type) {
		this.Detruit=false;
		this.Type = type;

		if(type == "Soldat") {
			this.Cout = 1;
			this.PuissanceMin = 1;
			this.PuissanceMax = 6;
			this.PriorDef = 1;
			this.PriorAtt = 2;
			this.nbDeplacement = 2;
		}
		else if (type == "Cavalier") {
			this.Cout = 3;
			this.PuissanceMin = 2;
			this.PuissanceMax = 7;
			this.PriorDef = 3;
			this.PriorAtt = 1;
			this.nbDeplacement = 3;
		}
		else if(type == "Canon") {
			this.Cout = 7;
			this.PuissanceMin = 4;
			this.PuissanceMax = 9;
			this.PriorDef = 2;
			this.PriorAtt = 3;
			this.nbDeplacement = 1;
		}
		else{
			this.Cout = 0;
			this.PuissanceMin = 0;
			this.PuissanceMax = 0;
			this.PriorDef = 0;
			this.PriorAtt = 0;
			this.nbDeplacement = 0;
			System.out.println("Cette armée n'existe pas, veuillez utiliser une armée de ces choix 'Soldat', 'Cavalier' ou 'Canon'");
		}
	}

	public void setDetruit(boolean b) {
		this.Detruit=b;
	}
	
	
	
}
