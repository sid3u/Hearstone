package ICapacite;


	import java.util.ArrayList;

import Exception.HearthstoneException;
import ICarte.*;
import IJoueur.Joueur;
import IPlateau.*;

	public class InvocationChiens extends Capacite implements ICapacite {
		
		private Serviteur chien;
		
		public InvocationChiens(String nom, String description) throws HearthstoneException {
			super (nom,description);
			@SuppressWarnings("unused")
			Serviteur chien = new Serviteur("Chiens",1,0,1,null);
		
		}

		 public void executerEffetDebutTour() throws HearthstoneException {
			
		}

		
		public void executerEffetFinTour() throws HearthstoneException{
		}

		
		public void executerAction(Object cible) throws HearthstoneException {
		}

		
		public void executerEffetMiseEnJeu(Object cible) throws HearthstoneException {
		
			int nbserviteur = Plateau.getInstance().getAdversaire((Joueur) cible).getJeu().size();
			this.chien.setProprietaire(Plateau.getInstance().getJoueurCourant());
			
			for(int i = 1; i <= nbserviteur; i++) {
				
				ArrayList<ICarte> liste = ((Joueur) cible).getJeu();
				liste.add(((ICarte)chien));
				((Joueur) cible).setJeu(liste);
			}
				
		}


		public void executerEffetDisparition(Object cible) throws HearthstoneException {	
		}

}
