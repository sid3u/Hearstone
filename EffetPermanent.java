package ICapacite;

import Exception.HearthstoneException;
import IJoueur.*;
import ICarte.*;

public class EffetPermanent extends Capacite implements ICapacite {
	private int batt;
	private int bdef;

	public EffetPermanent(String nom, String description, int batt, int bdef) throws HearthstoneException {
		super(nom,description);
		setBatt(batt);
		setBdef(bdef);
	}

	public int getBatt() {
		return batt;
	}

	public void setBatt(int batt) throws HearthstoneException{
		if (batt < 0 ) throw new HearthstoneException("attaque négative ou nul");
		this.batt = batt;
	}

	public int getBdef() {
		return bdef;
	}

	public void setBdef(int bdef) throws HearthstoneException{
		if (bdef< 0 ) throw new HearthstoneException("défense négative ou nul");
		this.bdef = bdef;
	}

	public String toString() {
		return "EffetPermanent [batt=" + batt + ", bdef=" + bdef + "]";
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EffetPermanent other = (EffetPermanent) obj;
		if (batt != other.batt)
			return false;
		if (bdef != other.bdef)
			return false;
		return true;
	}

	public void executerEffetDebutTour() throws HearthstoneException {
	}

	public void executerEffetFinTour() throws HearthstoneException {
	}

	public void executerAction(Object cible) throws HearthstoneException {
	}

	public void executerEffetMiseEnJeu(Object cible) throws HearthstoneException {
		for (ICarte c : ((Joueur) cible).getJeu()) {
			((Serviteur) c).setPointdevie(((Serviteur) c).getPointdevie() + bdef);
			((Serviteur) c).setAttaque(((Serviteur) c).getAttaque() + batt);
		}
	}

	public void executerEffetDisparition(Object cible) throws HearthstoneException {
		for (ICarte c : ((Joueur) cible).getJeu()) {
			((Serviteur) c).setPointdevie(((Serviteur) c).getPointdevie() - bdef);
			((Serviteur) c).setAttaque(((Serviteur) c).getAttaque() - batt);

		}

	}
}