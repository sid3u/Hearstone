package IJoueur;

import Exception.HearthstoneException;
import ICapacite.ICapacite;

public class Heros {
	private int pointdevie;
	private String nom;
	private ICapacite pouvoir;
	private boolean utiliserpouvoir;

	public Heros(String nom, ICapacite pouvoir) throws HearthstoneException {
		this.setPointdevie(15);
		this.setNom(nom);
		this.setPouvoir(pouvoir);
		this.setUtiliserpouvoir(false);
	}

	public boolean isUtiliserpouvoir() {
		return utiliserpouvoir;
	}

	public void setUtiliserpouvoir(boolean utiliserpouvoir) {
		this.utiliserpouvoir = utiliserpouvoir;
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

	public ICapacite getPouvoir() {
		return pouvoir;
	}

	public void setPouvoir(ICapacite pouvoir) {
		this.pouvoir = pouvoir;
	}

	public void setPointdevie(int pdv) throws HearthstoneException {
		if (pdv < 0)
			throw new HearthstoneException("Points de vie inférieur à 0");
		this.pointdevie = pdv;
	}

	public int getPointdevie() {
		return this.pointdevie;
	}

	@Override
	public String toString() {
		return "Heros [pointdevie=" + pointdevie + ", nom=" + nom + ", pouvoir=" + pouvoir + "]";
	}
}
