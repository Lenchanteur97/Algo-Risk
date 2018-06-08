import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

//import FenetreNombreJoueur.BoutonListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;


public class PanneauAjoutArmee extends JPanel {
	private static final long serialVersionUID = 1L;
	ArrayList<BoutonRond> ListeBoutonsInitialisation = new ArrayList<BoutonRond>();
	
	boolean Finalisation = false;
	ImageIcon image_soldat;
	ImageIcon image_cavalier;
	ImageIcon image_canon;
	Joueur Joueur;
	int indice;
	boolean VerifAffichageContenuTerritoire;
	JPanel ContenuTerritoire;
	JButton SupprimerSoldat;
	JButton AjouterSoldat;
	JLabel NbSoldats;
	JButton SupprimerCavalier;
	JButton AjouterCavalier;
	JLabel NbCavaliers;
	JButton SupprimerCanon;
	JButton AjouterCanon;
	JLabel NbCanons;
	JButton BoutonFinalisation;
	TitledBorder BordureTitreContenuTerritoire;
	JLabel nbArmeesRestantes ;
	int nbArmeesDistribuees;
	JButton AfficherMission;

	public PanneauAjoutArmee(Joueur J, int  nbArmeesDistribuees ) {
		super();
		this.Joueur = J;
		this.VerifAffichageContenuTerritoire = true;
		this.SupprimerSoldat = new JButton("-");
		this.SupprimerCavalier = new JButton("-");
		this.SupprimerCanon = new JButton("-");
		this.AjouterSoldat = new JButton("+");
		this.AjouterCavalier = new JButton("+");
		this.AjouterCanon = new JButton("+");
		this.nbArmeesDistribuees = nbArmeesDistribuees;
		this.nbArmeesRestantes = new JLabel();
		
		
		//On charge les images de soldat cavalier et canon
		this.image_soldat = new ImageIcon(getClass().getResource("icone-soldat.png"));
		this.image_cavalier = new ImageIcon(getClass().getResource("icone-cavalier.png"));
		this.image_canon = new ImageIcon(getClass().getResource("icone-canon.png"));

		//On definit notre panneau taille, couleur
		this.setPreferredSize(new Dimension(1914,1045));
		this.setBackground(new Color(0,0,0,0));
		this.setLayout(null);
		
		//On ajoute un bouton à chaque territoire du joueur
		for(Territoire T : J.TerritoiresJoueur) {
				BoutonRond B = new BoutonRond("+",J.couleur);
				this.add(B);
				B.setBounds(T.PosXBouton-12, T.PosYBouton-45, 20, 20);
				ListeBoutonsInitialisation.add(B);
			}
		
		//Affiche un panneau qui selon le tour affiche le nom du joueur et un bouton pour finaliser son action
		JPanel PanneauJoueurEnCours = new JPanel();
		PanneauJoueurEnCours.setLayout(null);
		PanneauJoueurEnCours.setBackground(new Color(0,0,0,0));
			nbArmeesRestantes = new JLabel("Il vous reste "+ Integer.toString(nbArmeesDistribuees) +" armees a placer");
			nbArmeesRestantes.setFont(new Font("Arial",Font.BOLD,20));
			nbArmeesRestantes.setVerticalAlignment(SwingConstants.CENTER);
			nbArmeesRestantes.setHorizontalAlignment(SwingConstants.CENTER);
			nbArmeesRestantes.setBackground(new Color(255,255,255,255));
			JLabel NomJoueur = new JLabel("Placement des armees : ");
			JLabel NomJoueur2 = new JLabel(J.acronyme);
			NomJoueur.setFont(new Font("Arial",Font.BOLD,32));
			NomJoueur.setVerticalAlignment(SwingConstants.CENTER);
			NomJoueur.setHorizontalAlignment(SwingConstants.CENTER);
			NomJoueur2.setFont(new Font("Arial",Font.BOLD,32));
			NomJoueur2.setOpaque(true);
			NomJoueur2.setBackground(J.couleur);
			NomJoueur2.setVerticalAlignment(SwingConstants.CENTER);
			NomJoueur2.setHorizontalAlignment(SwingConstants.CENTER);
			BoutonFinalisation = new JButton("Finalisation");
			BoutonFinalisation.setFont(new Font("Arial", Font.BOLD, 20));
			BoutonFinalisation.setPreferredSize(new Dimension(150,50));
			BoutonFinalisation.setEnabled(false);
			AfficherMission = new JButton("Afficher la mission");
			AfficherMission.setFont(new Font("Arial", Font.ITALIC, 15));
			
			
			PanneauJoueurEnCours.add(nbArmeesRestantes);
			nbArmeesRestantes.setBounds(0,0,300,50);
			PanneauJoueurEnCours.add(NomJoueur);
			NomJoueur.setBounds(575, 0, 500, 50);
			PanneauJoueurEnCours.add(NomJoueur2);
			NomJoueur2.setBounds(1025, 0, 100, 50);
			PanneauJoueurEnCours.add(BoutonFinalisation);
			BoutonFinalisation.setBounds(1150, 0, 150, 50);
			PanneauJoueurEnCours.add(AfficherMission);
			AfficherMission.setBounds(1700, 0, 200, 50);
			this.add(PanneauJoueurEnCours);
			PanneauJoueurEnCours.setBounds(0, 0, 1900, 60);
	}
	
	
	public void AffichageContenuTerritoire(Territoire T) {
		if(VerifAffichageContenuTerritoire == true) {
			this.ContenuTerritoire=CreerContenuTerritoire();
		}
		else {
			remove(ContenuTerritoire);
			this.ContenuTerritoire=CreerContenuTerritoire();
		}
		VerifAffichageContenuTerritoire = false;
		this.add(ContenuTerritoire);	
		ContenuTerritoire.setBounds(0, 585, 410, 450);
	}
		

	public JPanel CreerContenuTerritoire() {
		ContenuTerritoire = new JPanel();
		BordureTitreContenuTerritoire = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Armees du territoire");
		ContenuTerritoire.setLayout(new GridLayout(3,1));
		ContenuTerritoire.setBackground(new Color(255,255,255,255));
		ContenuTerritoire.setBorder(BordureTitreContenuTerritoire);
		
		
			JPanel PanneauAjoutSoldat = new JPanel();
			PanneauAjoutSoldat.setLayout(null);
			PanneauAjoutSoldat.setBackground(new Color(0,0,0,0));
			PanneauAjoutSoldat.setPreferredSize(new Dimension(400,150));
				PanneauSoldat PanneauSoldat = new PanneauSoldat();
				SupprimerSoldat.setFont(new Font("Arial", Font.BOLD, 40));
				AjouterSoldat.setFont(new Font("Arial", Font.BOLD, 25));
				NbSoldats = new JLabel("", JLabel.CENTER);
				NbSoldats.setText(Integer.toString(Joueur.TerritoiresJoueur.get(indice).ListeSoldat.size()));
				NbSoldats.setFont(new Font("Arial",Font.BOLD,40));
				
				PanneauAjoutSoldat.add(PanneauSoldat);
				PanneauSoldat.setBounds(0, 0, 170, 145);
				PanneauAjoutSoldat.add(SupprimerSoldat);
				SupprimerSoldat.setBounds(180,50,50,50);
				PanneauAjoutSoldat.add(NbSoldats);
				NbSoldats.setBounds(240,0,100,145);
				PanneauAjoutSoldat.add(AjouterSoldat);
				AjouterSoldat.setBounds(350,50,50,50);
				ContenuTerritoire.add(PanneauAjoutSoldat);
				
			
			
			JPanel PanneauAjoutCavalier = new JPanel();
			PanneauAjoutCavalier.setLayout(null);
			PanneauAjoutCavalier.setBackground(new Color(0,0,0,0));
			PanneauAjoutSoldat.setPreferredSize(new Dimension(400,150));
				PanneauCavalier PanneauCavalier = new PanneauCavalier();
				SupprimerCavalier.setFont(new Font("Arial", Font.BOLD, 40));
				AjouterCavalier.setFont(new Font("Arial", Font.BOLD, 25));
				NbCavaliers = new JLabel("", JLabel.CENTER);
				NbCavaliers.setText(Integer.toString(Joueur.TerritoiresJoueur.get(indice).ListeCavalier.size()));
				NbCavaliers.setFont(new Font("Arial",Font.BOLD,40));
				NbCavaliers.setBackground(new Color(255,255,255,255));
				
				
				PanneauAjoutCavalier.add(PanneauCavalier);
				PanneauCavalier.setBounds(0, 0, 170, 145);
				PanneauAjoutCavalier.add(SupprimerCavalier);
				SupprimerCavalier.setBounds(180,50,50,50);
				PanneauAjoutCavalier.add(NbCavaliers);
				NbCavaliers.setBounds(240,0,100,145);
				PanneauAjoutCavalier.add(AjouterCavalier);
				AjouterCavalier.setBounds(350,50,50,50);
				ContenuTerritoire.add(PanneauAjoutCavalier);
		
			
			JPanel PanneauAjoutCanon = new JPanel();
			PanneauAjoutCanon.setLayout(null);
			PanneauAjoutCanon.setBackground(new Color(0,0,0,0));
			PanneauAjoutSoldat.setPreferredSize(new Dimension(400,150));
				PanneauCanon PanneauCanon = new PanneauCanon();
				SupprimerCanon.setFont(new Font("Arial", Font.BOLD, 40));
				AjouterCanon.setFont(new Font("Arial", Font.BOLD, 25));
				NbCanons = new JLabel("", JLabel.CENTER);
				NbCanons.setText(Integer.toString(Joueur.TerritoiresJoueur.get(indice).ListeCanon.size()));
				NbCanons.setFont(new Font("Arial",Font.BOLD,40));
				NbCanons.setBackground(new Color(255,255,255,255));
				
				PanneauAjoutCanon.add(PanneauCanon);
				PanneauCanon.setBounds(0, 0, 170, 145);
				PanneauAjoutCanon.add(SupprimerCanon);
				SupprimerCanon.setBounds(180,50,50,50);
				PanneauAjoutCanon.add(NbCanons);
				NbCanons.setBounds(240,0,100,145);
				PanneauAjoutCanon.add(AjouterCanon);
				AjouterCanon.setBounds(350,50,50,50);
				ContenuTerritoire.add(PanneauAjoutCanon);
		
			return ContenuTerritoire;
	}

//Getter
	
	public Joueur getJoueur() {
		return Joueur;
	}


	public int getIndice() {
		return indice;
	}


	public boolean isVerifAffichageContenuTerritoire() {
		return VerifAffichageContenuTerritoire;
	}


	public JPanel getContenuTerritoire() {
		return ContenuTerritoire;
	}


	public JButton getSupprimerSoldat() {
		return SupprimerSoldat;
	}


	public JButton getAjouterSoldat() {
		return AjouterSoldat;
	}


	public JLabel getNbSoldats() {
		return NbSoldats;
	}


	public JButton getSupprimerCavalier() {
		return SupprimerCavalier;
	}


	public JButton getAjouterCavalier() {
		return AjouterCavalier;
	}


	public JLabel getNbCavaliers() {
		return NbCavaliers;
	}


	public JButton getSupprimerCanon() {
		return SupprimerCanon;
	}


	public JButton getAjouterCanon() {
		return AjouterCanon;
	}


	public JLabel getNbCanons() {
		return NbCanons;
	}

	public JButton getBoutonFinalisation() {
		return BoutonFinalisation;
	}

	public ArrayList<BoutonRond> getListeBoutonsInitialisation(){
		return ListeBoutonsInitialisation;
	}




	




}
