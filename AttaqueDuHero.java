package ICapacite;

import Exception.HearthstoneException;
import IJoueur.Heros;

public class AttaqueDuHero extends Capacite implements ICapacite {

	private int att;

	public AttaqueDuHero(String nom, String description, int att) throws HearthstoneException {
		super(nom, description);
		setAtt(att);
	}

	public int getAtt() {
		return att;
	}

	
	public void setAtt(int att) throws HearthstoneException{
		if (att <= 0 ) throw new HearthstoneException("attaque négative ou nul");
		this.att = att;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AttaqueDuHero other = (AttaqueDuHero) obj;
		if (att != other.att)
			return false;
		return true;
	}

	public String toString() {
		return "AttaqueDuHero [att=" + att + "]";
	}

	public void executerEffetDebutTour() throws HearthstoneException {
	}

	public void executerEffetFinTour() throws HearthstoneException {
	}

	public void executerAction(Object cible) throws HearthstoneException {
	}

	public void executerEffetMiseEnJeu(Object cible) throws HearthstoneException {
		((Heros) cible).setPointdevie(((Heros) cible).getPointdevie() - getAtt());
	}
	
	public void executerEffetDisparition(Object cible) throws HearthstoneException {

	}
}
