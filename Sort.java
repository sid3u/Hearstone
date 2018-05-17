package ICarte;
import IJoueur.IJoueur;


public class Sort implements ICarte {
	String nom;
	int cout;
	IJoueur proprietaire;
	
	public Sort(String nom, int cout) {
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

	public IJoueur getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(IJoueur proprietaire) {
		this.proprietaire = proprietaire;
	}

	public  void executerEffetDebutTour(Object cible) {
	}

	public void executerEffetFinTour() {
	}

	public void executerAction(Object cible) {
	}

	public void executerEffetMiseEnJeu(Object cible) {
		this.executerEffetMiseEnJeu(cible);
	}

	public void executerEffetDisparition(Object cible) {
	}

	public boolean disparait() {
		return true;
	}
}
