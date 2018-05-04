package Sort;

import ICarte;
import IJoueur;

public abstract class Sort implements ICarte {
	String nom;
	int cout;

	public Sort (String nom, int cout)
	{
		this.setNom(nom);
		this.setCout(cout);
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getCout() {
		return cout;
	}

	public void setCout(int cout) {
		this.cout = cout;
	}

	public String toString() {
		return "Sort [nom=" + nom + ", cout=" + cout + "]";
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sort other = (Sort) obj;
		if (cout != other.cout)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}
	IJoueur getProprietaire();
	public abstract void executerEffetDebutTour(Object cible);
	public abstract void executerEffetFinTour();
	public abstract void executerAction(Object cible);
	public abstract void executerEffetMiseEnJeu(Object cible);
	public abstract void executerEffetDisparition(Object cible);
	public abstract boolean disparait();
}
