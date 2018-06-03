package ICarte;

import Exception.HearthstoneException;
import ICapacite.ICapacite;

public abstract class Carte implements ICarte {
	private String nom;
	private int cout;
	private ICapacite capacite;

	public Carte(String nom, int cout, ICapacite capacite) throws HearthstoneException {
		this.setNom(nom);
		this.setCout(cout);
		this.setCapacite(capacite);
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) throws HearthstoneException {
		if (nom == null)
			throw new HearthstoneException("Nom null");
		if (nom.trim().isEmpty())
			throw new HearthstoneException("Nom non viable");
		this.nom = nom;
	}

	public int getCout() {
		return cout;
	}

	public void setCout(int cout) throws HearthstoneException {
		if (cout < 0)
			throw new HearthstoneException("Cout null");
		this.cout = cout;
	}

	public ICapacite getCapacite() {
		return capacite;
	}

	public void setCapacite(ICapacite capacite) {
		this.capacite = capacite;
	}

	public abstract void executerEffetDebutTour(Object cible) throws HearthstoneException;

	public abstract void executerEffetFinTour() throws HearthstoneException;

	public abstract void executerAction(Object cible) throws HearthstoneException;

	public abstract void executerEffetMiseEnJeu(Object cible) throws HearthstoneException;

	public abstract void executerEffetDisparition(Object cible) throws HearthstoneException;

	public abstract boolean disparait();

	@Override
	public String toString() {
		return nom;
	}
}
