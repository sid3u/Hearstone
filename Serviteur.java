package Serviteur;
import ICarte;


public abstract class Serviteur implements ICarte {
	int PointDeVie;
	String nom;
	int cout;
	int attaque;
	
	public Serviteur (int pdv, int cout,String nom,int attaque)
	{
		this.setPointDeVie(pdv);
		this.setCout(cout);
		this.setNom(nom);
		this.setAttaque(attaque);
	}

	public int getAttaque() {
		return attaque;
	}

	public void setAttaque(int attaque) {
		this.attaque = attaque;
	}

	public int getPointDeVie() {
		return PointDeVie;
	}

	public void setPointDeVie(int pointDeVie) {
		PointDeVie = pointDeVie;
	}

	public String getNom() {
		return nom;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Serviteur other = (Serviteur) obj;
		if (PointDeVie != other.PointDeVie)
			return false;
		if (cout != other.cout)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
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
		return "Serviteur [PointDeVie=" + PointDeVie + ", nom=" + nom
				+ ", cout=" + cout + "]";
	}
	
	IJoueur getProprietaire();
	public abstract void executerEffetDebutTour(Object cible);
	public abstract void executerEffetFinTour();
	public abstract void executerAction(Object cible);
	public abstract void executerEffetMiseEnJeu(Object cible);
	public abstract void executerEffetDisparition(Object cible);
	public abstract boolean disparait();
}
