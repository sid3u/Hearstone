package ICapacite;


import java.util.ArrayList;

import Exception.HearthstoneException;
import IJoueur.Joueur;
import ICarte.*;


public class ImageMiroir {
	
	String nom;
	String description;
	Serviteur serviteur;
	ICapacite charge;
	
	
	public ImageMiroir(String nom, String description) {
		setNom(nom);
		setDescription(description);	
		serviteur.setAttaque(0);
		serviteur.setPointdevie(2);
	
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
	
		
		charge = new Piocher("lol","lol",3);
		
		for(int i = 1; i <= 2; i++) {
		ArrayList<ICarte> liste = ((Joueur) cible).getJeu();
		serviteur.setProprietaire((Joueur) cible);	
		serviteur.setCapacite(charge);
		liste.add(((ICarte) serviteur));
		((Joueur) cible).setJeu(liste);
		}
			
	}


	public void executerEffetDisparition(Object cible) throws HearthstoneException {	
	}

}