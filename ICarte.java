package ICarte;

import Exception.HearthstoneException;
import IJoueur.IJoueur;


public interface ICarte {
	String getNom();
	int getCout();
	void executerEffetDebutTour(Object cible) throws HearthstoneException;
	void executerEffetFinTour() throws HearthstoneException;
	void executerAction(Object cible) throws HearthstoneException;
	void executerEffetMiseEnJeu(Object cible)throws HearthstoneException;
	void executerEffetDisparition(Object cible)throws HearthstoneException;
	boolean disparait();
	public String toString();
	public IJoueur getAdversaire(IJoueur joueur);
	public IJoueur getProprietaire();
}
