package ICapacite;

import Exception.HearthstoneException;
import ICarte.Serviteur;

public class MarqueduChasseur extends Capacite implements ICapacite {

	public MarqueduChasseur() {
		super("Marque du chasseur", "Reduit à 1 le nombre de points de vie de la cible");
	}

	public void executerEffetDebutTour() throws HearthstoneException {
	}

	public void executerEffetFinTour() throws HearthstoneException {
	}

	public void executerAction(Object cible) throws HearthstoneException {
	}

	public void executerEffetMiseEnJeu(Object cible) throws HearthstoneException {
		((Serviteur) cible).setPointdevie(1);
	}

	public void executerEffetDisparition(Object cible) throws HearthstoneException {
	}

}
