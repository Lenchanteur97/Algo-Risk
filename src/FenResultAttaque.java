import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class FenResultAttaque extends JDialog {
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Armée> ListeTroupesAttaque;
	private ArrayList<Armée> ListeAttaqueTrie;
	private ArrayList<Integer>ListeNombresAleatoiresAttaque;
	private ArrayList<Integer>ListeNombresAleatoiresAttaqueTrie;
	private ArrayList<Armée> ListeTroupesDefense;
	private ArrayList<Armée> ListeDefenseTrie;
	private ArrayList<Integer> ListeNombresAleatoiresDefense;
	private ArrayList<Integer> ListeNombresAleatoiresDefenseTrie;
	private Interface fenetre;
	int nb;
	Territoire T1;
	Territoire T2;
	
	public FenResultAttaque(Territoire T1, ArrayList<Armée> ListeTroupesAttaque, Territoire T2,ArrayList<Armée> ListeTroupesDefense, Interface fenetre) {
		
		this.T1=T1;
		this.T2=T2;
		this.setTitle("Resultats de l'attaque");
		this.setSize(450,120+Math.min(ListeTroupesAttaque.size(), ListeTroupesDefense.size())*80);
		this.setModal(false);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		
		this.fenetre=fenetre;
		this.ListeAttaqueTrie = new ArrayList<Armée>();
		this.ListeDefenseTrie = new ArrayList<Armée>();
		this.ListeNombresAleatoiresAttaqueTrie = new ArrayList<Integer>();
		this.ListeNombresAleatoiresDefenseTrie = new ArrayList<Integer>();
		this.ListeTroupesAttaque=ListeTroupesAttaque;
		// Initialisation de la liste contenant les numéros aléatoires de chaque troupe
		ListeNombresAleatoiresAttaque = new ArrayList<Integer>();
		ListeNombresAleatoiresDefense = new ArrayList<Integer>();
		for (Armée A : ListeTroupesAttaque) {
			ListeNombresAleatoiresAttaque.add(GenererNbAleatoire(A.PuissanceMin,A.PuissanceMax));
		}
		this.ListeTroupesDefense=ListeTroupesDefense;
		ListeNombresAleatoiresDefense = new ArrayList<Integer>();
		for (Armée A : ListeTroupesDefense) {
			ListeNombresAleatoiresDefense.add(GenererNbAleatoire(A.PuissanceMin,A.PuissanceMax));
		}
		
		TrierListe(ListeTroupesAttaque,ListeNombresAleatoiresAttaque,ListeTroupesDefense,ListeNombresAleatoiresDefense);
		
		JPanel PanneauHaut = new JPanel();
		PanneauHaut.setLayout(null);
		JLabel labelAttaque = new JLabel("Attaquant");
		labelAttaque.setHorizontalAlignment(SwingConstants.CENTER);
		labelAttaque.setVerticalAlignment(SwingConstants.CENTER);
		labelAttaque.setFont(new Font("Arial",Font.BOLD,20));
		PanneauHaut.add(labelAttaque);
		labelAttaque.setBounds(50, 0, 100, 50);
		JLabel labelDefense = new JLabel("Defenseur");
		labelDefense.setHorizontalAlignment(SwingConstants.CENTER);
		labelDefense.setVerticalAlignment(SwingConstants.CENTER);
		labelDefense.setFont(new Font("Arial",Font.BOLD,20));
		PanneauHaut.add(labelDefense);
		labelDefense.setBounds(275, 0, 100, 50);
		this.add(PanneauHaut);
		PanneauHaut.setBounds(10, 0, 450, 60);
		
		
		for (int i=0;i<Math.min(ListeAttaqueTrie.size(), ListeDefenseTrie.size());i++) {
			nb=0;
			JPanel PanneauCentre = new JPanel();
			PanneauCentre.setLayout(null);
			
			if (ListeAttaqueTrie.get(i).Type=="Soldat") {
				PanneauSoldat PanneauImageSoldat = new PanneauSoldat();
				PanneauCentre.add(PanneauImageSoldat);
				PanneauImageSoldat.setBounds(10,0,50,50);
			}
			else if (ListeAttaqueTrie.get(i).Type=="Cavalier") {
				PanneauCavalier PanneauImageCavalier = new PanneauCavalier();
				PanneauCentre.add(PanneauImageCavalier);
				PanneauImageCavalier.setBounds(10,0,50,50);
			}
			else if (ListeAttaqueTrie.get(i).Type=="Canon") {
				PanneauCanon PanneauImageCanon = new PanneauCanon();
				PanneauCentre.add(PanneauImageCanon);
				PanneauImageCanon.setBounds(10,0,50,50);
			}
			
			JLabel NbAttaque = new JLabel(Integer.toString(ListeNombresAleatoiresAttaqueTrie.get(i)));
			NbAttaque.setHorizontalAlignment(SwingConstants.CENTER);
			NbAttaque.setVerticalAlignment(SwingConstants.CENTER);
			NbAttaque.setFont(new Font("Arial",Font.BOLD,22));
			PanneauCentre.add(NbAttaque);
			NbAttaque.setBounds(70, 0, 50, 50);
			
			if (ListeNombresAleatoiresAttaqueTrie.get(i)>ListeNombresAleatoiresDefenseTrie.get(i)) {
				ListeTroupesDefense.get(i).setDetruit(true);
				PanneauVictoire PanneauVictoire = new PanneauVictoire();
				PanneauCentre.add(PanneauVictoire);
				PanneauVictoire.setBounds(130, 0, 50, 50);
				PanneauDe PanneauDe = new PanneauDe();
				PanneauCentre.add(PanneauDe);
				PanneauDe.setBounds(190, 0, 50, 50);
				PanneauDefaite PanneauDefaite = new PanneauDefaite();
				PanneauCentre.add(PanneauDefaite);
				PanneauDefaite.setBounds(250, 0, 50, 50);
			}
			else {
				ListeTroupesAttaque.get(i).setDetruit(true);
				PanneauDefaite PanneauDefaite = new PanneauDefaite();
				PanneauCentre.add(PanneauDefaite);
				PanneauDefaite.setBounds(130, 0, 50, 50);
				PanneauDe PanneauDe = new PanneauDe();
				PanneauCentre.add(PanneauDe);
				PanneauDe.setBounds(190, 0, 50, 50);
				PanneauVictoire PanneauVictoire = new PanneauVictoire();
				PanneauCentre.add(PanneauVictoire);
				PanneauVictoire.setBounds(250, 0, 50, 50);
			}
			
			JLabel NbDefense = new JLabel(Integer.toString(ListeNombresAleatoiresDefenseTrie.get(i)));
			NbDefense.setHorizontalAlignment(SwingConstants.CENTER);
			NbDefense.setVerticalAlignment(SwingConstants.CENTER);
			NbDefense.setFont(new Font("Arial",Font.BOLD,22));
			PanneauCentre.add(NbDefense);
			NbDefense.setBounds(310, 0, 50, 50);
			
			if (ListeDefenseTrie.get(i).Type=="Soldat") {
				PanneauSoldat PanneauImageSoldat = new PanneauSoldat();
				PanneauCentre.add(PanneauImageSoldat);
				PanneauImageSoldat.setBounds(370, 0, 50, 50);
			}
			else if (ListeDefenseTrie.get(i).Type=="Cavalier") {
				PanneauCavalier PanneauImageCavalier = new PanneauCavalier();
				PanneauCentre.add(PanneauImageCavalier);
				PanneauImageCavalier.setBounds(370, 0, 50, 50);
			}
			else if (ListeDefenseTrie.get(i).Type=="Canon") {
				PanneauCanon PanneauImageCanon = new PanneauCanon();
				PanneauCentre.add(PanneauImageCanon);
				PanneauImageCanon.setBounds(370, 0, 50, 50);
			}
			
			this.add(PanneauCentre);
			PanneauCentre.setBounds(0, 60+i*75, 430, 50);
			nb++;
		}
		if (ListeAttaqueTrie.size()!=nb) {
			JPanel PanneauBas = new JPanel();
			PanneauBas.setLayout(null);
			if (ListeAttaqueTrie.get(ListeAttaqueTrie.size()-1).Type=="Soldat") {
				PanneauSoldat PanneauImageSoldat = new PanneauSoldat();
				PanneauBas.add(PanneauImageSoldat);
				PanneauImageSoldat.setBounds(10,0,50,50);
			}
			else if (ListeAttaqueTrie.get(ListeAttaqueTrie.size()-1).Type=="Cavalier") {
				PanneauCavalier PanneauImageCavalier = new PanneauCavalier();
				PanneauBas.add(PanneauImageCavalier);
				PanneauImageCavalier.setBounds(10,0,50,50);
			}
			else if (ListeAttaqueTrie.get(ListeAttaqueTrie.size()-1).Type=="Canon") {
				PanneauCanon PanneauImageCanon = new PanneauCanon();
				PanneauBas.add(PanneauImageCanon);
				PanneauImageCanon.setBounds(10,0,50,50);
			}
			
			JLabel NbAttaque = new JLabel(Integer.toString(ListeNombresAleatoiresAttaqueTrie.get(ListeAttaqueTrie.size()-1)));
			NbAttaque.setHorizontalAlignment(SwingConstants.CENTER);
			NbAttaque.setVerticalAlignment(SwingConstants.CENTER);
			NbAttaque.setFont(new Font("Arial",Font.BOLD,22));
			PanneauBas.add(NbAttaque);
			NbAttaque.setBounds(70, 0, 50, 50);
			PanneauVictoire PanneauVictoire = new PanneauVictoire();
			PanneauBas.add(PanneauVictoire);
			PanneauVictoire.setBounds(130, 0, 50, 50);
			PanneauDe PanneauDe = new PanneauDe();
			PanneauBas.add(PanneauDe);
			PanneauVictoire.setBounds(190, 0, 50, 50);
			
			this.add(PanneauBas);
			PanneauBas.setBounds(0, 60+nb*75, 430, 50);
		}
		if (ListeDefenseTrie.size()!=nb) {
			JPanel PanneauBas = new JPanel();
			PanneauBas.setLayout(null);
			PanneauDe PanneauDe = new PanneauDe();
			PanneauBas.add(PanneauDe);
			PanneauDe.setBounds(190, 0, 50, 50);
			PanneauVictoire PanneauVictoire = new PanneauVictoire();
			PanneauBas.add(PanneauVictoire);
			PanneauVictoire.setBounds(250, 0, 50, 50);
			JLabel NbDefense = new JLabel(Integer.toString(ListeNombresAleatoiresDefenseTrie.get(ListeDefenseTrie.size()-1)));
			NbDefense.setHorizontalAlignment(SwingConstants.CENTER);
			NbDefense.setVerticalAlignment(SwingConstants.CENTER);
			NbDefense.setFont(new Font("Arial",Font.BOLD,22));
			PanneauBas.add(NbDefense);
			NbDefense.setBounds(310, 0, 50, 50);
			if (ListeDefenseTrie.get(ListeDefenseTrie.size()-1).Type=="Soldat") {
				PanneauSoldat PanneauImageSoldat = new PanneauSoldat();
				PanneauBas.add(PanneauImageSoldat);
				PanneauImageSoldat.setBounds(370, 0, 50, 50);
			}
			else if (ListeDefenseTrie.get(ListeDefenseTrie.size()-1).Type=="Cavalier") {
				PanneauCavalier PanneauImageCavalier = new PanneauCavalier();
				PanneauBas.add(PanneauImageCavalier);
				PanneauImageCavalier.setBounds(370, 0, 50, 50);
			}
			else if (ListeDefenseTrie.get(ListeDefenseTrie.size()-1).Type=="Canon") {
				PanneauCanon PanneauImageCanon = new PanneauCanon();
				PanneauBas.add(PanneauImageCanon);
				PanneauImageCanon.setBounds(370, 0, 50, 50);
			}
			this.add(PanneauBas);
			PanneauBas.setBounds(0, 60+nb*75, 450, 50);
		}
		
		JButton OkBouton = new JButton("OK");
		OkBouton.setFont(new Font("Arial", Font.BOLD, 24));
		OkBouton.addActionListener(new OKBouton());
		this.add(OkBouton);
		OkBouton.setBounds(170,this.getHeight()-80,100,40);
		
		this.setVisible(true);
	}
	
	//Fonction qui genere un nombre aleatoire
		public static int GenererNbAleatoire(int a, int b) {
			int nombreAleatoire = a + (int)(Math.random() * ((b - a) + 1));
			return nombreAleatoire;
		}
		
	// Fonction qui trie une liste en fonction des nombres aleatoires obtenus par chaqu'une des troupes et de la priorité Attaque/Defense
	public void TrierListe(ArrayList<Armée> ListeTroupesAttaque, ArrayList<Integer> ListeNombresAttaque, ArrayList<Armée> ListeTroupesDefense, ArrayList<Integer> ListeNombresDefense) {
		this.ListeAttaqueTrie.addAll(ListeTroupesAttaque);
		this.ListeNombresAleatoiresAttaqueTrie.addAll(ListeNombresAttaque);
		this.ListeDefenseTrie.addAll(ListeTroupesDefense);
		this.ListeNombresAleatoiresDefenseTrie.addAll(ListeNombresDefense);
		
		TriSelect(ListeNombresAleatoiresAttaqueTrie,ListeAttaqueTrie);
		TriSelect(ListeNombresAleatoiresDefenseTrie,ListeDefenseTrie);
		
		// On classe ensuite les égalités en fonction de la priorité att/def
		for (int i=0;i<ListeNombresAleatoiresAttaqueTrie.size()-1;i++) {
			if (ListeNombresAleatoiresAttaqueTrie.get(i)==ListeNombresAleatoiresAttaqueTrie.get(i+1) && ListeAttaqueTrie.get(i).PriorAtt>ListeAttaqueTrie.get(i+1).PriorAtt) {
				int nb1=ListeNombresAleatoiresAttaqueTrie.get(i);
				int nb2=ListeNombresAleatoiresAttaqueTrie.get(i+1);
				Armée A1=ListeAttaqueTrie.get(i);
				Armée A2=ListeAttaqueTrie.get(i+1);
				
				ListeNombresAleatoiresAttaqueTrie.remove(nb1);
				ListeNombresAleatoiresAttaqueTrie.remove(nb2);
				ListeNombresAleatoiresAttaqueTrie.add(i, nb2);
				ListeNombresAleatoiresAttaqueTrie.add(i+1, nb1);
				
				ListeAttaqueTrie.remove(A1);
				ListeAttaqueTrie.remove(A2);
				ListeAttaqueTrie.add(i, A2);
				ListeAttaqueTrie.add(i+1, A1);
			}
		}
		for (int i=0;i<ListeNombresAleatoiresDefenseTrie.size()-1;i++) {
			if (ListeNombresAleatoiresDefenseTrie.get(i)==ListeNombresAleatoiresDefenseTrie.get(i+1) && ListeDefenseTrie.get(i).PriorDef>ListeDefenseTrie.get(i+1).PriorDef) {
				int nb1=ListeNombresAleatoiresDefenseTrie.get(i);
				int nb2=ListeNombresAleatoiresDefenseTrie.get(i+1);
				Armée A1=ListeDefenseTrie.get(i);
				Armée A2=ListeDefenseTrie.get(i+1);
				
				ListeNombresAleatoiresDefenseTrie.remove(nb1);
				ListeNombresAleatoiresDefenseTrie.remove(nb2);
				ListeNombresAleatoiresDefenseTrie.add(i, nb2);
				ListeNombresAleatoiresDefenseTrie.add(i+1, nb1);
				
				ListeDefenseTrie.remove(A1);
				ListeDefenseTrie.remove(A2);
				ListeDefenseTrie.add(i, A2);
				ListeDefenseTrie.add(i+1, A1);
			}
		}
	}

	public void TriSelect (ArrayList<Integer> ListeNombresAleatoires, ArrayList<Armée> ListeArmeeAttaque) { 
        int n = ListeNombresAleatoires.size()-1; 
        for ( int i = 1; i <= n-1; i++) 
         {
           int m = i;
           for ( int j = i+1; j <= n; j++)   {
              if (ListeNombresAleatoires.get(j)< ListeNombresAleatoires.get(m))
                  m = j ; // indice mémorisé 
           //on échange les positions
              int temp = ListeNombresAleatoires.get(m);
              int temp2 = ListeNombresAleatoires.get(i);
              Armée temp3 = ListeArmeeAttaque.get(m);
              Armée temp4 = ListeArmeeAttaque.get(i);
              
              ListeNombresAleatoires.remove(m);
              ListeNombresAleatoires.add(m,temp2);
              ListeNombresAleatoires.remove(i);
              ListeNombresAleatoires.add(i, temp);
              
              ListeArmeeAttaque.remove(m);
              ListeArmeeAttaque.add(m,temp3);
              ListeArmeeAttaque.remove(i);
              ListeArmeeAttaque.add(i, temp4);
           }
        }
	}
	
	class OKBouton implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
	    	for (Armée A : ListeDefenseTrie) {
	    		if (A.Detruit==false) {
	    			if(A.Type=="Soldat") {
	    				T2.ListeSoldat.add(A);
	    			}
	    			else if(A.Type=="Cavalier") {
	    				T2.ListeCavalier.add(A);
	    			}
	    			else if(A.Type=="Canon") {
	    				T2.ListeCanon.add(A);
	    			}
	    		}
	    	}
	    	if (T2.ListeSoldat.size()+T2.ListeCavalier.size()+T2.ListeCanon.size()==0) {
	    		
	    		T2.Joueur.TerritoiresJoueur.remove(T2);
	    		T1.Joueur.TerritoiresJoueur.add(T2);
	    		
	    		T2.Joueur=T1.Joueur;
	    		for (Armée A : ListeAttaqueTrie) {
		    		if (A.Detruit==false) {
		    			A.nbDeplacement=A.nbDeplacement-1;
		    			if(A.Type=="Soldat") {
		    				T2.ListeSoldat.add(A);
		    			}
		    			else if(A.Type=="Cavalier") {
		    				T2.ListeCavalier.add(A);
		    			}
		    			else if(A.Type=="Canon") {
		    				T2.ListeCanon.add(A);
		    			}
		    		}
		    	}
	    	}
	    	else {
	    		for (Armée A : ListeAttaqueTrie) {
		    		if (A.Detruit==false) {
		    			if(A.Type=="Soldat") {
		    				T1.ListeSoldat.add(A);
		    			}
		    			else if(A.Type=="Cavalier") {
		    				T1.ListeCavalier.add(A);
		    			}
		    			else if(A.Type=="Canon") {
		    				T1.ListeCanon.add(A);
		    			}
		    		}
		    	}
	    	}
	    	setVisible(false);
	        dispose();
	        fenetre.getContentPane().remove(fenetre.PanneauPrincipal);
	        Panneau PanneauPrincipal = new Panneau(fenetre.ListeJoueurs,fenetre.ListeTerritoires,fenetre.NumJoueur,fenetre);
	        fenetre.PanneauPrincipal=PanneauPrincipal;
	        fenetre.getContentPane().add(PanneauPrincipal);
	        fenetre.validate();
	  }}
}
