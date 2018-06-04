package IPlateau;

import java.util.ArrayList;

import Exception.HearthstoneException;
import ICarte.ICarte;
import IJoueur.Heros;
import IJoueur.IJoueur;

public interface IPlateau {
	void ajouterJoueur(IJoueur joueur) throws HearthstoneException;
	IJoueur getJoueurCourant();
	void setJoueurCourant(IJoueur joueur)throws HearthstoneException;
	IJoueur getAdversaire(IJoueur joueur)throws HearthstoneException;
	void demarrerPartie()throws HearthstoneException;
	boolean estDemarree();
	void finTour(IJoueur joueur)throws HearthstoneException;
	void gagnerPartie(IJoueur joueur)throws HearthstoneException;
	public ArrayList<IJoueur> getJoueurs();
	public void cartesDisparaissent() throws HearthstoneException;
}
