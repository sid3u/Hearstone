package ICapacite;

import Exception.HearthstoneException;

public abstract class Capacite implements ICapacite {
	private String nom;
	private String description;
	
	public Capacite(String nom, String description) {
		this.setNom(nom);
		this.setDescription(description);
	}

	private void setNom(String nom) {
		this.nom = nom;
	}

	private void setDescription(String description) {
		this.description = description;
	}

	public String getNom() {
		return this.nom;
	}
	
	public
	String getDescription() {
		return this.description;
	}

	public abstract void executerEffetDebutTour() throws HearthstoneException;

	public abstract void executerEffetFinTour() throws HearthstoneException;

	public abstract void executerAction(Object cible) throws HearthstoneException;

	public abstract void executerEffetMiseEnJeu(Object cible) throws HearthstoneException;

	public abstract void executerEffetDisparition(Object cible) throws HearthstoneException;

}
