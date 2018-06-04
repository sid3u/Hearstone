package ICarte;

import Exception.HearthstoneException;
import ICapacite.ICapacite;
import IJoueur.IJoueur;
import IPlateau.IPlateau;
import IPlateau.Plateau;

public abstract class Carte implements ICarte {
	private String nom;
	private String description;
	private int cout;
	private ICapacite capacite;
	IJoueur proprietaire;
	IJoueur adversaire;
	private IPlateau plateau = Plateau.getInstance();

	public Carte(String nom,String description, int cout, ICapacite capacite,IJoueur proprietaire) throws HearthstoneException {
		this.setNom(nom);
		this.setCout(cout);
		this.setCapacite(capacite);
		this.setProprietaire(proprietaire);
		this.setAdversaire(proprietaire);
		this.setDescription(description);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
	
	public IJoueur getAdversaire() {
		return this.adversaire;
	}
	
	public void setAdversaire(IJoueur prop) throws HearthstoneException{
		for (IJoueur j : plateau.getJoueurs())
			if (j != prop) this.adversaire = j;
	}
	
	public IJoueur getProprietaire() {
		return this.proprietaire;
	}
	
	public void setProprietaire(IJoueur proprietaire)throws HearthstoneException
	{

		this.proprietaire=proprietaire;
	}
	
	@Override
	public String toString() {
		return "Carte [ nom = " + nom + ", description = " + description + ", cout = " + cout + ", capacite = " + capacite
				+ ", proprietaire = " + proprietaire + ", adversaire = " + adversaire + ", plateau = " + plateau + " ]";
	}

	public IPlateau getPlateau() {
		return plateau;
	}

	public void setPlateau(IPlateau plateau) throws HearthstoneException{
		if (plateau == null) throw new HearthstoneException("Plateau null");
		this.plateau = plateau;
	}

	public abstract void executerEffetDebutTour(Object cible) throws HearthstoneException;

	public abstract void executerEffetFinTour() throws HearthstoneException;

	public abstract void executerAction(Object cible) throws HearthstoneException;

	public abstract void executerEffetMiseEnJeu(Object cible) throws HearthstoneException;

	public abstract void executerEffetDisparition(Object cible) throws HearthstoneException;

	public abstract boolean disparait();

	
}
