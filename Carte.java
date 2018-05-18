package ICarte;

import Exception.HearthstoneException;
import ICapacité.ICapacite;
import IJoueur.IJoueur;


public abstract class Carte implements ICarte {
	String nom;
	int cout;
	IJoueur proprietaire;
	ICapacite capacite;

	public Carte(String nom, int cout, ICapacite capacite, IJoueur proprietaire) {
		this.setNom(nom);
		this.setCout(cout);
		this.setCapacite(capacite);
		this.setProprietaire(proprietaire);
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

	public ICapacite getCapacite() {
		return capacite;
	}

	public void setCapacite(ICapacite capacite) {
		this.capacite = capacite;
	}

	public IJoueur getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(IJoueur proprietaire) {
		this.proprietaire = proprietaire;
	}
	
	public abstract void executerEffetDebutTour(Object cible) throws HearthstoneException;
	public abstract void executerEffetFinTour() throws HearthstoneException;
	public abstract void executerAction(Object cible) throws HearthstoneException;
	public abstract void executerEffetMiseEnJeu(Object cible)throws HearthstoneException;
	public abstract void executerEffetDisparition(Object cible)throws HearthstoneException;
	public abstract boolean disparait();

	@Override
	public String toString() {
		return   nom ;
	}
}
