package ICapacite;


import java.util.ArrayList;

import Exception.HearthstoneException;
import ICarte.*;
import IJoueur.IJoueur;
import IJoueur.Joueur;


public class ImageMiroir extends Capacite implements ICapacite{
	private Serviteur serviteur;
	
	public ImageMiroir(String nom, String description,IJoueur adversaire) throws HearthstoneException {
		super(nom,description);
		ICapacite charge = new Charge();
		serviteur = new Serviteur ("Serviteur mirroir",2,0,0,charge,adversaire);
	}

	 public void executerEffetDebutTour() throws HearthstoneException {
		
	}

	
	public void executerEffetFinTour() throws HearthstoneException{
	}

	
	public void executerAction(Object cible) throws HearthstoneException {
	}

	
	public void executerEffetMiseEnJeu(Object cible) throws HearthstoneException {
		
		for(int i = 1; i <= 2; i++) {
			ArrayList<ICarte> liste = ((Joueur) cible).getJeu();
			liste.add(((ICarte)serviteur));
			((Joueur) cible).setJeu(liste);
		}
	}


	public void executerEffetDisparition(Object cible) throws HearthstoneException {	
	}

}