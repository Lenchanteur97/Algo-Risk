import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;

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
	
	// Initialisation de la carte
	public Interface(ArrayList<Joueur> ListeJoueurs) {
		// Création de la fenetre
		this.ListeJoueurs=ListeJoueurs;
		this.setTitle("Risk");
		this.setSize(1920, 1080);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setAlwaysOnTop(true);
		PanneauImage Image = new PanneauImage(); // On ajoute l'image en fond
		this.setContentPane(Image);
		this.setVisible(true);
		this.PanneauPrincipalAffiche=false;
		this.ListeJoueurs = ListeJoueurs;
	}
	
	public void AfficherPanneauAjoutArmee(int NumJoueurInitialisation) {
		this.NumJoueurInitialisation = NumJoueurInitialisation;
		if(NumJoueurInitialisation==0) {
			this.PanneauAjoutArmee = new PanneauAjoutArmee(ListeJoueurs.get(NumJoueurInitialisation));
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
			this.PanneauAjoutArmee = new PanneauAjoutArmee(ListeJoueurs.get(NumJoueurInitialisation));
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
				public class BoutonSupprimerSoldat implements ActionListener{
					 public void actionPerformed(ActionEvent e) {
						  PanneauAjoutArmee.Joueur.TerritoiresJoueur.get(PanneauAjoutArmee.indice).ListeSoldat.remove(0);
						  PanneauAjoutArmee.NbSoldats.setText(Integer.toString(PanneauAjoutArmee.Joueur.TerritoiresJoueur.get(PanneauAjoutArmee.indice).ListeSoldat.size()));
						  if(PanneauAjoutArmee.Joueur.TerritoiresJoueur.get(PanneauAjoutArmee.indice).ListeSoldat.size()!=0) {
							  PanneauAjoutArmee.SupprimerSoldat.setEnabled(true);
							}
							else if(PanneauAjoutArmee.Joueur.TerritoiresJoueur.get(PanneauAjoutArmee.indice).ListeSoldat.size()==0) {
								PanneauAjoutArmee.SupprimerSoldat.setEnabled(false);
							}
						  Update();
					 }
		}
			// Action réalisée quand on clique sur le bouton ajouter Soldat
				public class BoutonAjouterSoldat implements ActionListener{
					public void actionPerformed(ActionEvent e) {
						PanneauAjoutArmee.Joueur.TerritoiresJoueur.get(PanneauAjoutArmee.indice).ListeSoldat.add(new Arm�e("Soldat"));
						PanneauAjoutArmee.NbSoldats.setText(Integer.toString(PanneauAjoutArmee.Joueur.TerritoiresJoueur.get(PanneauAjoutArmee.indice).ListeSoldat.size()));
							if(PanneauAjoutArmee.Joueur.TerritoiresJoueur.get(PanneauAjoutArmee.indice).ListeSoldat.size()!=0) {
								PanneauAjoutArmee.SupprimerSoldat.setEnabled(true);
							}
							else if(PanneauAjoutArmee.Joueur.TerritoiresJoueur.get(PanneauAjoutArmee.indice).ListeSoldat.size()==0) {
								PanneauAjoutArmee.SupprimerSoldat.setEnabled(false);
							}
						Update();
					}	 
				}
			// Action réalisée quand on clique sur le bouton supprimer Cavalier
				public class BoutonSupprimerCavalier implements ActionListener{
					 public void actionPerformed(ActionEvent e) {
						 PanneauAjoutArmee.Joueur.TerritoiresJoueur.get(PanneauAjoutArmee.indice).ListeCavalier.remove(0);
						 PanneauAjoutArmee.NbCavaliers.setText(Integer.toString(PanneauAjoutArmee.Joueur.TerritoiresJoueur.get(PanneauAjoutArmee.indice).ListeCavalier.size()));
						  if(PanneauAjoutArmee.Joueur.TerritoiresJoueur.get(PanneauAjoutArmee.indice).ListeCavalier.size()!=0) {
							  PanneauAjoutArmee.SupprimerCavalier.setEnabled(true);
							}
							else if(PanneauAjoutArmee.Joueur.TerritoiresJoueur.get(PanneauAjoutArmee.indice).ListeCavalier.size()==0) {
								PanneauAjoutArmee.SupprimerCavalier.setEnabled(false);
							}
					 Update();
					 }
		}
			//Action realisee quand on clique sur le bouton ajouter Cavalier
				public class BoutonAjouterCavalier implements ActionListener{
					public void actionPerformed(ActionEvent e) {
						PanneauAjoutArmee.Joueur.TerritoiresJoueur.get(PanneauAjoutArmee.indice).ListeCavalier.add(new Arm�e("Cavalier"));
						PanneauAjoutArmee.NbCavaliers.setText(Integer.toString(PanneauAjoutArmee.Joueur.TerritoiresJoueur.get(PanneauAjoutArmee.indice).ListeCavalier.size()));
							if(PanneauAjoutArmee.Joueur.TerritoiresJoueur.get(PanneauAjoutArmee.indice).ListeCavalier.size()!=0) {
								PanneauAjoutArmee.SupprimerCavalier.setEnabled(true);
							}
							else if(PanneauAjoutArmee.Joueur.TerritoiresJoueur.get(PanneauAjoutArmee.indice).ListeCavalier.size()==0) {
								PanneauAjoutArmee.SupprimerCavalier.setEnabled(false);
							}
							Update();
					}	 
				}
			//Action réalisée quand on clique sur le bouton supprimer Canon
				public class BoutonSupprimerCanon implements ActionListener{
					 public void actionPerformed(ActionEvent e) {
						 PanneauAjoutArmee.Joueur.TerritoiresJoueur.get(PanneauAjoutArmee.indice).ListeCanon.remove(0);
						 PanneauAjoutArmee.NbCanons.setText(Integer.toString(PanneauAjoutArmee.Joueur.TerritoiresJoueur.get(PanneauAjoutArmee.indice).ListeCanon.size()));
						  if(PanneauAjoutArmee.Joueur.TerritoiresJoueur.get(PanneauAjoutArmee.indice).ListeCanon.size()!=0) {
							  PanneauAjoutArmee.SupprimerCanon.setEnabled(true);
							}
							else if(PanneauAjoutArmee.Joueur.TerritoiresJoueur.get(PanneauAjoutArmee.indice).ListeCanon.size()==0) {
								PanneauAjoutArmee.SupprimerCanon.setEnabled(false);
							}
					 Update();
					 }
		}
			//Action realisee quand on clique sur le bouton ajouter Canon
				public class BoutonAjouterCanon implements ActionListener{
					public void actionPerformed(ActionEvent e) {
						PanneauAjoutArmee.Joueur.TerritoiresJoueur.get(PanneauAjoutArmee.indice).ListeCanon.add(new Arm�e("Canon"));
						PanneauAjoutArmee.NbCanons.setText(Integer.toString(PanneauAjoutArmee.Joueur.TerritoiresJoueur.get(PanneauAjoutArmee.indice).ListeCanon.size()));
							if(PanneauAjoutArmee.Joueur.TerritoiresJoueur.get(PanneauAjoutArmee.indice).ListeCanon.size()!=0) {
								PanneauAjoutArmee.SupprimerCanon.setEnabled(true);
							}
							else if(PanneauAjoutArmee.Joueur.TerritoiresJoueur.get(PanneauAjoutArmee.indice).ListeCanon.size()==0) {
								PanneauAjoutArmee.SupprimerCanon.setEnabled(false);
							}
					Update();		
					}	 
				}	

			// Action réalisée quand on clique sur le bouton Valider
				public class BoutonFinalisation implements ActionListener{
				    public void actionPerformed(ActionEvent e) {
				    	if(NumJoueurInitialisation<ListeJoueurs.size()-1) {
				    		AfficherPanneauAjoutArmee(NumJoueurInitialisation+1);
				    	}
				    	else { // Quand l'initialisation est finie pour tous les joueurs, on d�marre le jeu
				    		getContentPane().remove(PanneauAjoutArmee);
				    		AjouterPanneauPrincipal(ListeJoueurs, ListeTerritoires, NumJoueur);
				    		Update();
				    	}
				    }
				}
					
			//Action realisee quand on clique sur un bouton rond
				public class BoutonRondInitialisationAction implements ActionListener{
						public void actionPerformed(ActionEvent e) {
							PanneauAjoutArmee.indice = 0;
							for(int i=0; i<ListeBoutonsInitialisation.size(); i+=1) {
								if (e.getSource()==ListeBoutonsInitialisation.get(i)) {
									PanneauAjoutArmee.indice=i;
								}
							}
							PanneauAjoutArmee.AffichageContenuTerritoire(PanneauAjoutArmee.Joueur.TerritoiresJoueur.get(PanneauAjoutArmee.indice));
							getContentPane().validate();
							Update();
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
		if (PanneauPrincipalAffiche==false) {
			this.PanneauPrincipal = new Panneau(ListeJoueurs,ListeTerritoires,this.NumJoueur);
			PanneauPrincipal.getBoutonFinTour().addActionListener(new BoutonFinTourAction());
			this.getContentPane().add(PanneauPrincipal);
			PanneauPrincipal.setBounds(0, 0, 1914, 1045);
			this.validate();
		}
		else {
			this.RetirerPanneauPrincipal();
			this.PanneauPrincipal = new Panneau(ListeJoueurs,ListeTerritoires,this.NumJoueur);
			PanneauPrincipal.getBoutonFinTour().addActionListener(new BoutonFinTourAction());
			this.getContentPane().add(PanneauPrincipal);
			this.validate();
		}
		PanneauPrincipalAffiche=true;
	}
	
	public void RetirerPanneauPrincipal() {
		this.getContentPane().remove(PanneauPrincipal);
	}
	
	private class BoutonFinTourAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
	    	AjouterPanneauPrincipal(ListeJoueurs, ListeTerritoires, (NumJoueur+1)%ListeJoueurs.size());
	    }
	}
	
	
}

