package ICapacite;

import Exception.HearthstoneException;

public class Charge extends Capacite implements ICapacite {
   
	
	public Charge() {
    	super("Charge","Permet d'attaquer sans attendre de tour");
    }
    

public void executerEffetDebutTour() throws HearthstoneException {
}

public void executerEffetFinTour() throws HearthstoneException {
}

public void executerAction(Object cible) throws HearthstoneException {
}

public void executerEffetMiseEnJeu(Object cible) throws HearthstoneException {
}

public void executerEffetDisparition(Object cible) throws HearthstoneException {
} 

}