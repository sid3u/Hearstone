package ICapacite;

import Exception.HearthstoneException;
import ICarte.ICarte;
import ICarte.Serviteur;
import IJoueur.Heros;

public class AttaqueCible extends Capacite implements ICapacite {

	private int att;

	public AttaqueCible(String nom, String description, int att) {
		super(nom,description);
		setAtt(att);
	}

	public int getAtt() {
		return att;
	}

	public void setAtt(int att) {
		this.att = att;
	}
	
	public String toString() {
		return "AttaqueCible [att=" + att + "]";
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AttaqueCible other = (AttaqueCible) obj;
		if (att != other.att)
			return false;
		return true;
	}

	public void executerEffetDebutTour() throws HearthstoneException {
	}

	public void executerEffetFinTour() throws HearthstoneException {
	}

	public void executerAction(Object cible) throws HearthstoneException {
	}

	public void executerEffetMiseEnJeu(Object cible) throws HearthstoneException {
		if ((cible instanceof Serviteur) || (cible instanceof Heros)) {
			if (((Serviteur) cible).getCapacite().getNom().equals("Provocation")) {
				((Serviteur) cible).setPointdevie(((Serviteur)cible).getPointdevie() - this.getAtt());
			} else {
				parcoursProvocation(cible);
			}
			if (cible instanceof Serviteur) {
				((Serviteur) cible).setPointdevie(((Serviteur) cible).getPointdevie() - this.getAtt());
			} else {
				((Heros) cible).setPointdevie(((Heros) cible).getPointdevie() - this.getAtt());
			}
		}
	}
	
	public void parcoursProvocation(Object cible) throws HearthstoneException {
		for (ICarte c : ((ICarte)cible).getAdversaire().getJeu()) {
			if ((c != cible) && (c instanceof Serviteur) && (((Serviteur) c).getCapacite().getNom().equals("Provocation"))) {
				throw new HearthstoneException(
						"Vous essayer d'attaquer un Serviteur alors que" + c.getNom() + "a provocation");
			} else if ((((Serviteur) c).getCapacite().getNom().equals("Provocation")) && (cible instanceof Heros)) {
				throw new HearthstoneException(
						"Vous essayez d'attaquer le heros alors que" + c.getNom() + " a provocation");
			}
		}
	}

	public void executerEffetDisparition(Object cible) throws HearthstoneException {
	}

}
