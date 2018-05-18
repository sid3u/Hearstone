package ICapacité;

import ICarte.Serviteur;
import IJoueur.Heros;

public class BouleDeFeu implements ICapacite {
	String nom;
	String description;

	public BouleDeFeu() {
		this.setNom("BouleDeFeu");
		this.setDescription("Inflige 1 point de dégat au personnage ciblé");
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

	public void executerEffetDebutTour() {

	}

	public void executerEffetFinTour() {

	}

	public void executerAction(Object cible) {
		
	}

	public void executerEffetMiseEnJeu(Object cible) {
		if (cible instanceof Serviteur) {
			((Serviteur) cible)
					.setPointdevie(((Serviteur) cible).getPointdevie() - 1);
		} else if (cible instanceof Heros) {
			((Heros) cible).setPointdevie(((Heros) cible).getPointdevie() - 1);
		}
	}

	public void executerEffetDisparition(Object cible) {
		// TODO Auto-generated method stub

	}

}
