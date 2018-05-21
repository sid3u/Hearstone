package ICapacite;

import Exception.HearthstoneException;

public interface ICapacite {
	String getNom();
	String getDescription();
	void executerEffetDebutTour()throws HearthstoneException;
	void executerEffetFinTour()throws HearthstoneException;
	void executerAction(Object cible)throws HearthstoneException;
	void executerEffetMiseEnJeu(Object cible)throws HearthstoneException;
	void executerEffetDisparition(Object cible)throws HearthstoneException;
}
