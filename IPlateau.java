
public interface IPlateau {
	void ajouterJoueur(IJoueur joueur);
	IJoueur getJoueurCourant();
	void setJoueurCourant(IJoueur joueur);
	IJoueur getAdversaire(IJoueur joueur);
	void demarrerPartie();
	boolean estDemarree();
	void finTour(IJoueur joueur);
	void gagnerPartie(IJoueur joueur);
}
