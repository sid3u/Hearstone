package ICapacité;

import java.util.ArrayList;

import Exception.HearthstoneException;
import ICarte.ICarte;
import ICarte.Serviteur;
import IJoueur.Joueur;

public class CriDeGuerre implements ICapacite {
	String nom;
	String description;

	public CriDeGuerre() {
		this.setNom("Cri de guerre");
		this.setDescription("Inflige 2 points de dégats à tous les serviteurs");
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CriDeGuerre other = (CriDeGuerre) obj;
		
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}

	public String toString() {
		return "CriDeGuerre [nom=" + nom + ", description=" + description
				 + "]";
	}

	public void executerEffetDebutTour()throws HearthstoneException {

	}

	public void executerEffetFinTour()throws HearthstoneException {

	}

	public void executerAction(Object cible)throws HearthstoneException {
		
	}

	public void executerEffetMiseEnJeu(Object cible) throws HearthstoneException{
		ArrayList<ICarte> liste = ((Joueur) cible).getJeu();

		for (ICarte carte : liste) {
			if (carte instanceof Serviteur) {
				((Serviteur) carte)
						.setPointdevie(((Serviteur) carte).getPointdevie() - 2);
			}
		}
	}

	public void executerEffetDisparition(Object cible) throws HearthstoneException{

	}

}
