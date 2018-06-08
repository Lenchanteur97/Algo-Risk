import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Interface extends JFrame {
	private static final long serialVersionUID = 1L;
	Panneau PanneauPrincipal;
	boolean PanneauPrincipalAffiche;
	ArrayList<Joueur> ListeJoueurs;
	ArrayList<Territoire> ListeTerritoires;
	int NumJoueur = 0;
	int NumJoueurInitialisation;
	PanneauAjoutArmee PanneauAjoutArmee;
	ArrayList<BoutonRond> ListeBoutonsInitialisation;
	int nbArmeesDistribuees;
	boolean PremierTourPasse = false;
	int nbSoldatBase;
	int nbCavalierBase;
	int nbCanonBase;

	
	// Initialisation de la carte
	public Interface(ArrayList<Joueur> ListeJoueurs) {
		// Création de la fenetre
		this.setTitle("Risk");
		this.setSize(1920, 1080);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);	
		PanneauImage Image = new PanneauImage(); // On ajoute l'image en fond
		this.setContentPane(Image);
		this.setVisible(true);
		this.PanneauPrincipalAffiche=false;
		this.ListeJoueurs = ListeJoueurs;
	}
	public void AfficherPanneauAjoutArmee(int NumJoueurInitialisation) {
		this.NumJoueurInitialisation = NumJoueurInitialisation;
		if(NumJoueurInitialisation==0) {
			this.PanneauAjoutArmee = new PanneauAjoutArmee(ListeJoueurs.get(NumJoueurInitialisation), CalculArmeeDistribution());
			PanneauAjoutArmee.getAjouterSoldat().addActionListener(new BoutonAjouterSoldat());
			PanneauAjoutArmee.getAjouterCavalier().addActionListener(new BoutonAjouterCavalier());
			PanneauAjoutArmee.getAjouterCanon().addActionListener(new BoutonAjouterCanon());
			PanneauAjoutArmee.getSupprimerSoldat().addActionListener(new BoutonSupprimerSoldat());
			PanneauAjoutArmee.getSupprimerCavalier().addActionListener(new BoutonSupprimerCavalier());
			PanneauAjoutArmee.getSupprimerCanon().addActionListener(new BoutonSupprimerCanon());
			PanneauAjoutArmee.getBoutonFinalisation().addActionListener(new BoutonFinalisation());
			this.ListeBoutonsInitialisation=PanneauAjoutArmee.getListeBoutonsInitialisation();
			for(BoutonRond BR : PanneauAjoutArmee.ListeBoutonsInitialisation) {
				BR.addActionListener(new BoutonRondInitialisationAction());
			}
			this.getContentPane().add(PanneauAjoutArmee);
			PanneauAjoutArmee.setBounds(0,0,1914,1045);
			this.validate();
		}
		else if(NumJoueurInitialisation>0 && NumJoueurInitialisation<ListeJoueurs.size()) {
			this.getContentPane().remove(PanneauAjoutArmee);
			this.PanneauAjoutArmee = new PanneauAjoutArmee(ListeJoueurs.get(NumJoueurInitialisation), CalculArmeeDistribution());
			PanneauAjoutArmee.getAjouterSoldat().addActionListener(new BoutonAjouterSoldat());
			PanneauAjoutArmee.getAjouterCavalier().addActionListener(new BoutonAjouterCavalier());
			PanneauAjoutArmee.getAjouterCanon().addActionListener(new BoutonAjouterCanon());
			PanneauAjoutArmee.getSupprimerSoldat().addActionListener(new BoutonSupprimerSoldat());
			PanneauAjoutArmee.getSupprimerCavalier().addActionListener(new BoutonSupprimerCavalier());
			PanneauAjoutArmee.getSupprimerCanon().addActionListener(new BoutonSupprimerCanon());
			PanneauAjoutArmee.getBoutonFinalisation().addActionListener(new BoutonFinalisation());
			this.ListeBoutonsInitialisation=PanneauAjoutArmee.getListeBoutonsInitialisation();
			for(BoutonRond BR : PanneauAjoutArmee.ListeBoutonsInitialisation) {
				BR.addActionListener(new BoutonRondInitialisationAction());
			}
			this.getContentPane().add(PanneauAjoutArmee);
			this.validate();
		}
	}
	
	
	public void AfficherPanneauAjoutArmee(int NumJoueurInitialisation,int nbArmeesDistribution ) {
		this.NumJoueurInitialisation = NumJoueurInitialisation;
		this.nbArmeesDistribuees =  nbArmeesDistribution;
		if(NumJoueurInitialisation==0) {
			this.PanneauAjoutArmee = new PanneauAjoutArmee(ListeJoueurs.get(NumJoueurInitialisation), nbArmeesDistribuees);
			VerificationBoutonsContenuTerritoire();
			PanneauAjoutArmee.AfficherMission.addActionListener(new BoutonAfficherMission());
			PanneauAjoutArmee.getAjouterSoldat().addActionListener(new BoutonAjouterSoldat());
			PanneauAjoutArmee.getAjouterCavalier().addActionListener(new BoutonAjouterCavalier());
			PanneauAjoutArmee.getAjouterCanon().addActionListener(new BoutonAjouterCanon());
			PanneauAjoutArmee.getSupprimerSoldat().addActionListener(new BoutonSupprimerSoldat());
			PanneauAjoutArmee.getSupprimerCavalier().addActionListener(new BoutonSupprimerCavalier());
			PanneauAjoutArmee.getSupprimerCanon().addActionListener(new BoutonSupprimerCanon());
			PanneauAjoutArmee.getBoutonFinalisation().addActionListener(new BoutonFinalisation());
			this.ListeBoutonsInitialisation=PanneauAjoutArmee.getListeBoutonsInitialisation();
			for(BoutonRond BR : PanneauAjoutArmee.ListeBoutonsInitialisation) {
				BR.addActionListener(new BoutonRondInitialisationAction());
			}
			this.getContentPane().add(PanneauAjoutArmee);
			PanneauAjoutArmee.setBounds(0,0,1914,1045);
			this.validate();
		}
		else if(NumJoueurInitialisation>0 && NumJoueurInitialisation<ListeJoueurs.size()) {
			this.getContentPane().remove(PanneauAjoutArmee);
			this.PanneauAjoutArmee = new PanneauAjoutArmee(ListeJoueurs.get(NumJoueurInitialisation), nbArmeesDistribuees);
			VerificationBoutonsContenuTerritoire();
			PanneauAjoutArmee.AfficherMission.addActionListener(new BoutonAfficherMission());
			PanneauAjoutArmee.getAjouterSoldat().addActionListener(new BoutonAjouterSoldat());
			PanneauAjoutArmee.getAjouterCavalier().addActionListener(new BoutonAjouterCavalier());
			PanneauAjoutArmee.getAjouterCanon().addActionListener(new BoutonAjouterCanon());
			PanneauAjoutArmee.getSupprimerSoldat().addActionListener(new BoutonSupprimerSoldat());
			PanneauAjoutArmee.getSupprimerCavalier().addActionListener(new BoutonSupprimerCavalier());
			PanneauAjoutArmee.getSupprimerCanon().addActionListener(new BoutonSupprimerCanon());
			PanneauAjoutArmee.getBoutonFinalisation().addActionListener(new BoutonFinalisation());
			this.ListeBoutonsInitialisation=PanneauAjoutArmee.getListeBoutonsInitialisation();
			for(BoutonRond BR : PanneauAjoutArmee.ListeBoutonsInitialisation) {
				BR.addActionListener(new BoutonRondInitialisationAction());
			}
			this.getContentPane().add(PanneauAjoutArmee);
			this.validate();
		}		
	}
	// Action réalisée quand on clique sur le bouton supprimer Soldat
	
	
	//Action realisee si on appui sur le bouton supprimer soldat
	public class BoutonSupprimerSoldat implements ActionListener{
					 public void actionPerformed(ActionEvent e) {
						  nbArmeesDistribuees = nbArmeesDistribuees+1;
						  //Mise a jour du label qui affiche le nombre d'armees qu'il reste a placer
						  PanneauAjoutArmee.nbArmeesRestantes.setText("Il vous reste "+ Integer.toString(nbArmeesDistribuees) +" armees a placer");
						  //Suppression du soldat de la liste soldat du territoire
						  PanneauAjoutArmee.Joueur.TerritoiresJoueur.get(PanneauAjoutArmee.indice).ListeSoldat.remove(0);
						  //Verification de l'activation des boutons ou non pas une fonction et verification de l'activation du bouton finalisation
						  VerificationBoutonsContenuTerritoire();
						  VerificationBoutonFinalisation();
						  //Mise a jour du label qui affiche le nb de soldats du territoire
						  PanneauAjoutArmee.NbSoldats.setText(Integer.toString(PanneauAjoutArmee.Joueur.TerritoiresJoueur.get(PanneauAjoutArmee.indice).ListeSoldat.size()));
						  Update();
					 }
		}
			// Action réalisée quand on clique sur le bouton ajouter Soldat
				
	public class BoutonAjouterSoldat implements ActionListener{
					public void actionPerformed(ActionEvent e) {
						nbArmeesDistribuees = nbArmeesDistribuees-1;
						//Mise a jour du label qui affiche le nombre d'armees qu'il reste a placer
						PanneauAjoutArmee.nbArmeesRestantes.setText("Il vous reste "+ Integer.toString(nbArmeesDistribuees) +" armees a placer");
						//Creation d'un soldat dans la liste soldat du territoire
						PanneauAjoutArmee.Joueur.TerritoiresJoueur.get(PanneauAjoutArmee.indice).ListeSoldat.add(new Arm�e("Soldat"));
						//Mise a jour du label qui affichge le nombre de soldats du territoire
						PanneauAjoutArmee.NbSoldats.setText(Integer.toString(PanneauAjoutArmee.Joueur.TerritoiresJoueur.get(PanneauAjoutArmee.indice).ListeSoldat.size()));
						VerificationBoutonsContenuTerritoire();
						VerificationBoutonFinalisation();
					}	 
				}
			// Action réalisée quand on clique sur le bouton supprimer Cavalier
				
	public class BoutonSupprimerCavalier implements ActionListener{
					 public void actionPerformed(ActionEvent e) {
						 nbArmeesDistribuees = nbArmeesDistribuees+3;
						//Mise a jour du label qui affiche le nombre d'armees qu'il reste a placer
						 PanneauAjoutArmee.nbArmeesRestantes.setText("Il vous reste "+ Integer.toString(nbArmeesDistribuees) +" armees a placer");
						//Suppression du cavalier de la liste cavaier du territoire
						 PanneauAjoutArmee.Joueur.TerritoiresJoueur.get(PanneauAjoutArmee.indice).ListeCavalier.remove(0);
						//Mise a jour du label qui affiche le nb de cavaliers du territoire
						 PanneauAjoutArmee.NbCavaliers.setText(Integer.toString(PanneauAjoutArmee.Joueur.TerritoiresJoueur.get(PanneauAjoutArmee.indice).ListeCavalier.size()));
						//Verification de l'activation des boutons ou non pas une fonction et verification de l'activation du bouton finalisation
						 VerificationBoutonsContenuTerritoire();
						 VerificationBoutonFinalisation();
					 Update();
					 }
		}
			//Action realisee quand on clique sur le bouton ajouter Cavalier
				
	public class BoutonAjouterCavalier implements ActionListener{
					public void actionPerformed(ActionEvent e) {
						nbArmeesDistribuees = nbArmeesDistribuees-3;
						//Mise a jour du label qui affiche le nombre d'armees qu'il reste a placer
						PanneauAjoutArmee.nbArmeesRestantes.setText("Il vous reste "+ Integer.toString(nbArmeesDistribuees) +" armees a placer");
						//Creation d'un cavalier dans la liste soldat du territoire
						PanneauAjoutArmee.Joueur.TerritoiresJoueur.get(PanneauAjoutArmee.indice).ListeCavalier.add(new Arm�e("Cavalier"));
						//Mise a jour du label qui affichge le nombre de cavaliers du territoire
						PanneauAjoutArmee.NbCavaliers.setText(Integer.toString(PanneauAjoutArmee.Joueur.TerritoiresJoueur.get(PanneauAjoutArmee.indice).ListeCavalier.size()));
						VerificationBoutonsContenuTerritoire();
						VerificationBoutonFinalisation();
							Update();
					}	 
				}
			//Action réalisée quand on clique sur le bouton supprimer Canon
				
	public class BoutonSupprimerCanon implements ActionListener{
					 public void actionPerformed(ActionEvent e) {
						 nbArmeesDistribuees = nbArmeesDistribuees+7;
						//Mise a jour du label qui affiche le nombre d'armees qu'il reste a placer
						 PanneauAjoutArmee.nbArmeesRestantes.setText("Il vous reste "+ Integer.toString(nbArmeesDistribuees) +" armees a placer");
						//Suppression du canon de la liste cavaier du territoire
						 PanneauAjoutArmee.Joueur.TerritoiresJoueur.get(PanneauAjoutArmee.indice).ListeCanon.remove(0);
						//Mise a jour du label qui affiche le nb de canons du territoire
						 PanneauAjoutArmee.NbCanons.setText(Integer.toString(PanneauAjoutArmee.Joueur.TerritoiresJoueur.get(PanneauAjoutArmee.indice).ListeCanon.size()));
						//Verification de l'activation des boutons ou non pas une fonction et verification de l'activation du bouton finalisation
						 VerificationBoutonsContenuTerritoire();
						 VerificationBoutonFinalisation();
					 Update();
					 }
		}
			//Action realisee quand on clique sur le bouton ajouter Canon
				
	public class BoutonAjouterCanon implements ActionListener{
					public void actionPerformed(ActionEvent e) {
						nbArmeesDistribuees = nbArmeesDistribuees-7;
						//Mise a jour du label qui affiche le nombre d'armees qu'il reste a placer
						PanneauAjoutArmee.nbArmeesRestantes.setText("Il vous reste "+ Integer.toString(nbArmeesDistribuees) +" armees a placer");
						//Creation d'un canon dans la liste soldat du territoire
						PanneauAjoutArmee.Joueur.TerritoiresJoueur.get(PanneauAjoutArmee.indice).ListeCanon.add(new Arm�e("Canon"));
						//Mise a jour du label qui affichge le nombre de canons du territoire
						PanneauAjoutArmee.NbCanons.setText(Integer.toString(PanneauAjoutArmee.Joueur.TerritoiresJoueur.get(PanneauAjoutArmee.indice).ListeCanon.size()));
						VerificationBoutonsContenuTerritoire();
						VerificationBoutonFinalisation();
					Update();		
					}	 
				}	

				
			// Action réalisée quand on clique sur le bouton Valider
				
	public class BoutonFinalisation implements ActionListener{
				    public void actionPerformed(ActionEvent e) {
				    	//Si le 1er tour n'est pas passe
				    	if(PremierTourPasse == false) {
				    		//On affiche l'ajout des armees pour chaque joueur
				    		if(NumJoueurInitialisation<ListeJoueurs.size()-1) {
				    		AfficherPanneauAjoutArmee(NumJoueurInitialisation+1, CalculArmeeDistribution());
					    	}
					    	else { // Quand l'initialisation est finie pour tous les joueurs, on d�marre le jeu
					    		RetirerPanneauAjoutArmee();
					    		AjouterPanneauPrincipal(ListeJoueurs, ListeTerritoires, NumJoueur);
					    		Update();
					    	}
				    	}
				    	//Si le 1er tour est passe a chaque finalisation de renforts on afiche la page du joueur qui a finaliser ses renforts
				    	else if(PremierTourPasse == true) {
				    		//On repasse son nobre de conquetes a zero
				    		ListeJoueurs.get(NumJoueur).nbConquetes= 0;
				    		if(NumJoueur==0) {
				    			RetirerPanneauAjoutArmee();
				    			AjouterPanneauPrincipal(ListeJoueurs, ListeTerritoires, NumJoueur);
				    			Update();
				    		}
				    		else if(NumJoueur!=0 && NumJoueur<ListeJoueurs.size()-1) {
				    			RetirerPanneauAjoutArmee();
				    			AjouterPanneauPrincipal(ListeJoueurs, ListeTerritoires, NumJoueur);
				    			Update();
				    		}
				    		else if(NumJoueur==ListeJoueurs.size()-1) {
				    			RetirerPanneauAjoutArmee();
				    			AjouterPanneauPrincipal(ListeJoueurs, ListeTerritoires, NumJoueur);
				    			Update();
				    		}
				    		
				    		
				    	}
				    	
				    }
				}
			
				
			//Action realisee quand on clique sur un bouton rond
				
	public class BoutonRondInitialisationAction implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//Si le premier tour n'est pas passe
			if(PremierTourPasse == false) {
				PanneauAjoutArmee.indice = 0;
			//On recupere l'indice qui fait correspondre le territoire et le bouton
			for(int i=0; i<ListeBoutonsInitialisation.size(); i+=1) {
				if (e.getSource()==ListeBoutonsInitialisation.get(i)) {
					PanneauAjoutArmee.indice=i;
				}
			}
			//On a donc les donnees du territoire en cliquant sur le bouton et on affiche les donnees de ce territoire
			PanneauAjoutArmee.AffichageContenuTerritoire(PanneauAjoutArmee.Joueur.TerritoiresJoueur.get(PanneauAjoutArmee.indice));
			VerificationBoutonsContenuTerritoire();
			getContentPane().validate();
			Update();
			}
			else if(PremierTourPasse==true) {
				PanneauAjoutArmee.indice = 0;
				for(int i=0; i<ListeBoutonsInitialisation.size(); i+=1) {
					if (e.getSource()==ListeBoutonsInitialisation.get(i)) {
						PanneauAjoutArmee.indice=i;
					}
					nbSoldatBase = PanneauAjoutArmee.Joueur.TerritoiresJoueur.get(PanneauAjoutArmee.indice).ListeSoldat.size();
					nbCavalierBase = PanneauAjoutArmee.Joueur.TerritoiresJoueur.get(PanneauAjoutArmee.indice).ListeCavalier.size();
					nbCanonBase = PanneauAjoutArmee.Joueur.TerritoiresJoueur.get(PanneauAjoutArmee.indice).ListeCanon.size();
				}
				PanneauAjoutArmee.AffichageContenuTerritoire(PanneauAjoutArmee.Joueur.TerritoiresJoueur.get(PanneauAjoutArmee.indice));
				VerificationBoutonsContenuTerritoire();
				getContentPane().validate();
				Update();
			}
			
		}
}
				
	private class BoutonFinTourAction implements ActionListener {
		@SuppressWarnings("static-access")
		public void actionPerformed(ActionEvent e) {  
			//On test si le premier tour est pass� pour afficher les bonnes pages
	    	if(PremierTourPasse == false) {
	    		//Si le premier tour n'est pas passe et que c'est au premier joueur de jouer on lui affiche ses pages
	    		if(NumJoueur==0) {
	    			RetirerPanneauPrincipal();
	    			AjouterPanneauPrincipal(ListeJoueurs, ListeTerritoires, 1);
	    		}
	    		//Si le premier tour n'est pas passe et que c'est a un joueur entre le permier et le dernier de jouer on lui affiche ses pages
	    		else if(NumJoueur<ListeJoueurs.size()-1 && NumJoueur!=0) {
	    			RetirerPanneauPrincipal();
	    			AjouterPanneauPrincipal(ListeJoueurs, ListeTerritoires, NumJoueur+1);
	    		}
	    		//Si le premier tour n'est pas passe et que c'est au dernier joueur de jouer on lui affiche ses pages et on passe le numero du joueur a 0
	    		else if(NumJoueur == ListeJoueurs.size()-1) {
	    			RetirerPanneauPrincipal();
	    			AfficherPanneauAjoutArmee(0,CalculRenfortDistribution(ListeJoueurs.get(NumJoueur)));
	    			PremierTourPasse = true;
	    			NumJoueur = 0;
	    		}   		
	    	}
	    	//Si le premier tour est passe alors on doit avant chaque tour de jeux afficher la page renfort du joueur qui joue
	    	else if(PremierTourPasse == true) {
	    		//Verification elimination d'un joueur 
	    		for(Joueur J: ListeJoueurs) {
	    			if(J.TerritoiresJoueur.size()==0) {
	    				J.Elimine=true;
	    				ListeJoueurs.remove(J);
	    			}
	    		}
	    		//Attribution region joueur qui se trouve DANS LE MAIN
	    		
	    		if(ListeJoueurs.size()==1) {
	    			JOptionPane PopupVictoire = new JOptionPane();
	    			PopupVictoire.showMessageDialog(null, "Le joueur : "+ListeJoueurs.get(0).acronyme.toString()+" a gagne!!!!", "Victoire", JOptionPane.INFORMATION_MESSAGE);
	    		}
	    		//Affichage page renfort du deuxieme joueur si c'est le premier joueur qui fini son tour
	    		if(NumJoueur == 0) {
	    			RetirerPanneauPrincipal();
	    			NumJoueur+=1;
	    			AfficherPanneauAjoutArmee(NumJoueur,CalculRenfortDistribution(ListeJoueurs.get(NumJoueur)));
	    			
	    		}//Affichage page renfort du n-1ieme joueur si c'est le n-ieme joueur qui fini son tour
	    		else if(NumJoueur!=0 && NumJoueur<ListeJoueurs.size()-1) {
	    			RetirerPanneauPrincipal();
	    			NumJoueur+=1;
	    			AfficherPanneauAjoutArmee(NumJoueur,CalculRenfortDistribution(ListeJoueurs.get(NumJoueur)));
	    			
	    		}
	    		//Affichage page renfort du premier joueur si c'est le dernier joueur qui fini son tour
	    		else if(NumJoueur==ListeJoueurs.size()-1) {
	    			RetirerPanneauPrincipal();
	    			NumJoueur=0;
	    			AfficherPanneauAjoutArmee(NumJoueur,CalculRenfortDistribution(ListeJoueurs.get(NumJoueur)));
	    			
	    		}
	    	}
	    }
	}
	
	private class BoutonAfficherMission implements ActionListener {
		@SuppressWarnings("static-access")
		public void actionPerformed(ActionEvent e) {
			JOptionPane PopupMission = new JOptionPane();
			PopupMission.showMessageDialog(null, "Votre mission est : "+ListeJoueurs.get(NumJoueurInitialisation).Mission.toString(), "Mission", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	
	public void Update() {
		this.validate();
	}
	
	// Cette fonction permet d'ajouter le panneau principal à la fenetre et de retirer celui deja présent
	public void AjouterPanneauPrincipal(ArrayList<Joueur> ListeJoueurs, ArrayList<Territoire> ListeTerritoires, int NumJoueur) {
		this.ListeJoueurs=ListeJoueurs;
		this.ListeTerritoires=ListeTerritoires;
		this.NumJoueur=NumJoueur;
			this.PanneauPrincipal = new Panneau(ListeJoueurs,ListeTerritoires,this.NumJoueur);
			PanneauPrincipal.getBoutonFinTour().addActionListener(new BoutonFinTourAction());
			this.getContentPane().add(PanneauPrincipal);
			PanneauPrincipal.setBounds(0, 0, 1914, 1045);
			this.validate();
		if(NumJoueur == ListeJoueurs.size()-1){
			PanneauPrincipalAffiche=true;
		
		}
		
	}
	
	public void RetirerPanneauPrincipal() {
		this.getContentPane().remove(PanneauPrincipal);
	}
	
	public void RetirerPanneauAjoutArmee() {
		this.getContentPane().remove(PanneauAjoutArmee);
	}
	
	public int CalculArmeeDistribution() {
		int nbArmeesDistribuees;
		int nbJoueurs = ListeJoueurs.size();
		if(nbJoueurs == 2) {
			nbArmeesDistribuees = 40;
		}
		else if(nbJoueurs == 3) {
			nbArmeesDistribuees = 35;
		}
		else if(nbJoueurs == 4) {
			nbArmeesDistribuees = 30;
		}
		else if(nbJoueurs==5) {
			nbArmeesDistribuees = 25;
		}
		else {
			nbArmeesDistribuees = 20;
		}
		return nbArmeesDistribuees;
	}
	
	public int CalculRenfortDistribution(Joueur J) {
		int nbRenfort =0;
		int BonusTerritoires =(int) Math.floor((J.TerritoiresJoueur.size())/3);
		int BonusRegions = 0;
		if(J.RegionsJoueur.size()!=0) {
			for(int i=0; i<J.RegionsJoueur.size(); i+=1) {
				BonusRegions = (int) (BonusRegions + Math.floor(J.RegionsJoueur.get(i).Territoires.size()/2));
			}
		}
		int BonusConquetes =0;
		if(J.nbConquetes!=0) {
			while(J.nbConquetes!=0) {
				BonusConquetes = BonusConquetes + GenererNbAleatoire(0,1);
				J.nbConquetes= J.nbConquetes-1;
			}
		}
		nbRenfort = BonusTerritoires+BonusRegions+BonusConquetes;
		return nbRenfort;
	}
	
	public int getnbArmeesDistribuees() {
		return nbArmeesDistribuees;
	}
	
	public void VerificationBoutonsContenuTerritoire () {
		if (PremierTourPasse==false) {
			if(PanneauAjoutArmee.Joueur.TerritoiresJoueur.get(PanneauAjoutArmee.indice).ListeSoldat.size()!=0) {
				PanneauAjoutArmee.SupprimerSoldat.setEnabled(true);
				PanneauAjoutArmee.AjouterSoldat.setEnabled(true);
			}
			if(PanneauAjoutArmee.Joueur.TerritoiresJoueur.get(PanneauAjoutArmee.indice).ListeCavalier.size()!=0) {
				PanneauAjoutArmee.SupprimerCavalier.setEnabled(true);
				PanneauAjoutArmee.AjouterCavalier.setEnabled(true);
			}
			if(PanneauAjoutArmee.Joueur.TerritoiresJoueur.get(PanneauAjoutArmee.indice).ListeCanon.size()!=0) {
				PanneauAjoutArmee.SupprimerCanon.setEnabled(true);
				PanneauAjoutArmee.AjouterCanon.setEnabled(true);
			}
			if(PanneauAjoutArmee.Joueur.TerritoiresJoueur.get(PanneauAjoutArmee.indice).ListeSoldat.size()==0) {
				PanneauAjoutArmee.SupprimerSoldat.setEnabled(false);
				PanneauAjoutArmee.AjouterSoldat.setEnabled(true);
			}
			if(PanneauAjoutArmee.Joueur.TerritoiresJoueur.get(PanneauAjoutArmee.indice).ListeCavalier.size()==0) {
				PanneauAjoutArmee.SupprimerCavalier.setEnabled(false);
				PanneauAjoutArmee.AjouterCavalier.setEnabled(true);
			}
			if(PanneauAjoutArmee.Joueur.TerritoiresJoueur.get(PanneauAjoutArmee.indice).ListeCanon.size()==0) {
				PanneauAjoutArmee.SupprimerCanon.setEnabled(false);
				PanneauAjoutArmee.AjouterCanon.setEnabled(true);
			}
			if(nbArmeesDistribuees-1<0) {
				PanneauAjoutArmee.AjouterSoldat.setEnabled(false);
			}
			if(nbArmeesDistribuees-3<0) {
				PanneauAjoutArmee.AjouterCavalier.setEnabled(false);
			}
			if(nbArmeesDistribuees-7<0) {
				PanneauAjoutArmee.AjouterCanon.setEnabled(false);
			}
		}
		if(PremierTourPasse==true) {
			if(PanneauAjoutArmee.Joueur.TerritoiresJoueur.get(PanneauAjoutArmee.indice).ListeSoldat.size()!=nbSoldatBase) {
				PanneauAjoutArmee.SupprimerSoldat.setEnabled(true);
				PanneauAjoutArmee.AjouterSoldat.setEnabled(true);
			}
			if(PanneauAjoutArmee.Joueur.TerritoiresJoueur.get(PanneauAjoutArmee.indice).ListeCavalier.size()!=nbCavalierBase) {
				PanneauAjoutArmee.SupprimerCavalier.setEnabled(true);
				PanneauAjoutArmee.AjouterCavalier.setEnabled(true);
			}
			if(PanneauAjoutArmee.Joueur.TerritoiresJoueur.get(PanneauAjoutArmee.indice).ListeCanon.size()!=nbCanonBase) {
				PanneauAjoutArmee.SupprimerCanon.setEnabled(true);
				PanneauAjoutArmee.AjouterCanon.setEnabled(true);
			}
			if(PanneauAjoutArmee.Joueur.TerritoiresJoueur.get(PanneauAjoutArmee.indice).ListeSoldat.size()==nbSoldatBase) {
				PanneauAjoutArmee.SupprimerSoldat.setEnabled(false);
				PanneauAjoutArmee.AjouterSoldat.setEnabled(true);
			}
			if(PanneauAjoutArmee.Joueur.TerritoiresJoueur.get(PanneauAjoutArmee.indice).ListeCavalier.size()==nbCavalierBase) {
				PanneauAjoutArmee.SupprimerCavalier.setEnabled(false);
				PanneauAjoutArmee.AjouterCavalier.setEnabled(true);
			}
			if(PanneauAjoutArmee.Joueur.TerritoiresJoueur.get(PanneauAjoutArmee.indice).ListeCanon.size()==nbCanonBase) {
				PanneauAjoutArmee.SupprimerCanon.setEnabled(false);
				PanneauAjoutArmee.AjouterCanon.setEnabled(true);
			}
			if(nbArmeesDistribuees-1<0) {
				PanneauAjoutArmee.AjouterSoldat.setEnabled(false);
			}
			if(nbArmeesDistribuees-3<0) {
				PanneauAjoutArmee.AjouterCavalier.setEnabled(false);
			}
			if(nbArmeesDistribuees-7<0) {
				PanneauAjoutArmee.AjouterCanon.setEnabled(false);
			}
		}
		
			
	}
	
	public void VerificationBoutonFinalisation() {
		boolean ValidationNoArmee = false;
		boolean ValidationTerritoires = true;
		
		for(int i=0; i<ListeJoueurs.get(NumJoueurInitialisation).TerritoiresJoueur.size(); i+=1) {
			if(ListeJoueurs.get(NumJoueurInitialisation).TerritoiresJoueur.get(i).ListeSoldat.size()==0 && ListeJoueurs.get(NumJoueurInitialisation).TerritoiresJoueur.get(i).ListeCavalier.size()==0 && ListeJoueurs.get(NumJoueurInitialisation).TerritoiresJoueur.get(i).ListeCanon.size()==0) {
				ValidationTerritoires = false;
			}
		}
		if(nbArmeesDistribuees==0) {
			ValidationNoArmee = true;
		}
		if(ValidationTerritoires != false && ValidationNoArmee == true) {
			PanneauAjoutArmee.BoutonFinalisation.setEnabled(true);
		}
		else {
			PanneauAjoutArmee.BoutonFinalisation.setEnabled(false);
		}
		
	}
	
	public int GenererNbAleatoire(int a, int b) {
		int nombreAleatoire = a + (int)(Math.random() * ((b - a) + 1));
		return nombreAleatoire;
	}
}

