package ICapacite;

import Exception.HearthstoneException;

public interface ICapacite {
	public String getNom();
	public String getDescription();
	public void executerEffetDebutTour()throws HearthstoneException;
	public void executerEffetFinTour()throws HearthstoneException;
	public void executerAction(Object cible)throws HearthstoneException;
	public void executerEffetMiseEnJeu(Object cible)throws HearthstoneException;
	public void executerEffetDisparition(Object cible)throws HearthstoneException;
}
