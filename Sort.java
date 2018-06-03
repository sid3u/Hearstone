package ICarte;

import Exception.HearthstoneException;
import ICapacite.ICapacite;

public class Sort extends Carte {

	public Sort(String nom, int cout, ICapacite capacite) throws HearthstoneException {
		super(nom, cout, capacite);
	}

	public String toString() {
		return "Sort [nom=" + super.getNom() + ", cout=" + super.getCout() + "]";
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sort other = (Sort) obj;
		if (super.getCout() != other.getCout())
			return false;
		if (super.getNom() == null) {
			if (other.getNom() != null)
				return false;
		} else if (!super.getNom().equals(other.getNom()))
			return false;
		return true;
	}

	public void executerEffetDebutTour(Object cible) {
	}

	public void executerEffetFinTour() {
	}

	public void executerAction(Object cible) throws HearthstoneException {
		throw new HearthstoneException("Vous ne pouvez pas attaquer avec cette carte");
	}

	public void executerEffetMiseEnJeu(Object cible) throws HearthstoneException {
		this.getCapacite().executerEffetMiseEnJeu(cible);
	}

	public void executerEffetDisparition(Object cible) {
	}

	public boolean disparait() {
		return true;
	}
}
