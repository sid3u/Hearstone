

public interface ICarte {
	String getNom();
	int getCout();
	IJoueur getProprietaire();
	void executerEffetDebutTour(Object cible);
	void executerEffetFinTour();
	void executerAction(Object cible);
	void executerEffetMiseEnJeu(Object cible);
	void executerEffetDisparition(Object cible);
	boolean disparait();
}
