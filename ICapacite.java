package ICapacité;

public interface ICapacite {
	String getNom();
	String getDescription();
	void executerEffetDebutTour();
	void executerEffetFinTour();
	void executerAction(Object cible);
	void executerEffetMiseEnJeu(Object cible);
	void executerEffetDisparition(Object cible);
}
