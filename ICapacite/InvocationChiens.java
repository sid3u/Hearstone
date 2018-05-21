package ICapacite;


	import java.util.ArrayList;

import Exception.HearthstoneException;
	import IJoueur.Joueur;
	import ICarte.*;
	import IPlateau.*;

	public class InvocationChiens {
		
		String nom;
		String description;
		Serviteur chien;
		ICapacite charge;
		
		
		public InvocationChiens(String nom, String description) {
			setNom(nom);
			setDescription(description);	
			chien.setAttaque(1);
			chien.setPointdevie(1);
		
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		 public void executerEffetDebutTour() throws HearthstoneException {
			
		}

		
		public void executerEffetFinTour() throws HearthstoneException{
		}

		
		public void executerAction(Object cible) throws HearthstoneException {
		}

		
		public void executerEffetMiseEnJeu(Object cible) throws HearthstoneException {
		
			int nbserviteur = Plateau.getInstance().getAdversaire((Joueur) cible).getJeu().size();
			charge = new Piocher("lol","lol",3);
			
			for(int i = 1; i <= nbserviteur; i++) {
			ArrayList<ICarte> liste = ((Joueur) cible).getJeu();
			chien.setProprietaire((Joueur) cible);	
			chien.setCapacite(charge);
			liste.add(((ICarte) chien));
			((Joueur) cible).setJeu(liste);
			}
				
		}


		public void executerEffetDisparition(Object cible) throws HearthstoneException {	
		}

}
