package ICarte;

import Exception.HearthstoneException;
import ICapacite.*;
import IJoueur.*;

public class Serviteur extends Carte implements ICarte {
	private int pointdevie;
	private int attaque;
	private boolean disparait;
	private boolean peutattaquer;

	public Serviteur(String nom, int pdv, int cout, int attaque, ICapacite capacite,IJoueur proprietaire) throws HearthstoneException {
		super(nom, cout, capacite,proprietaire);
		this.setPointdevie(pdv);
		this.setAttaque(attaque);
		this.setCapacite(capacite);
		this.setPeutattaquer(false);
	}

	public Serviteur(String nom, int pdv,int cout, int attaque,IJoueur proprietaire) throws HearthstoneException { // invocation sans capacite
		super(nom, 0, null,proprietaire);
		this.setPointdevie(pdv);
		this.setAttaque(attaque);
		this.setPeutattaquer(false);
	}

	public boolean isPeutattaquer() {
		return peutattaquer;
	}

	public void setPeutattaquer(boolean peutattaquer) throws HearthstoneException {
		this.peutattaquer = peutattaquer;
	}

	public boolean isDisparait() {
		return disparait;
	}

	public void setDisparait(boolean disparait) {
		this.disparait = disparait;
	}

	public int getPointdevie() {
		return pointdevie;
	}

	public void setPointdevie(int pointdevie) throws HearthstoneException {
		if (pointdevie < 0)
			throw new HearthstoneException("Points de vie negatif");
		this.pointdevie = pointdevie;
	}

	public int getAttaque() {
		return attaque;
	}

	public void setAttaque(int attaque) throws HearthstoneException{
		if (attaque < 0) throw new HearthstoneException("Une attaque ne peut être négative");
		this.attaque = attaque;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Serviteur other = (Serviteur) obj;
		if (attaque != other.attaque)
			return false;
		if (disparait != other.disparait)
			return false;
		if (peutattaquer != other.peutattaquer)
			return false;
		if (pointdevie != other.pointdevie)
			return false;
		return true;
	}

	public String toString() {
		return "Serviteur [pointdevie=" + this.getPointdevie() + ", nom=" + this.getNom() + ", cout=" + this.getCout()
				+ "]";
	}

	public void executerEffetDebutTour(Object cible) throws HearthstoneException {
		this.getCapacite().executerEffetDebutTour();
	}

	public void executerEffetFinTour() throws HearthstoneException {
		this.getCapacite().executerEffetFinTour();
	}

	public void executerAction(Object cible) throws HearthstoneException {
		if ((this.getCapacite().getNom().equals("Charge")) && (this.isPeutattaquer() == false)) {
			this.setPeutattaquer(true);
		}
		if ((cible instanceof Serviteur) || (cible instanceof Heros) && (this.isPeutattaquer() == true)) {
			if (((Serviteur) cible).getCapacite().getNom().equals("Provocation")) {
				((Serviteur) cible).setPointdevie(this.getPointdevie() - this.getAttaque());
			} else {
				parcoursProvocation(cible);
			}
			if (cible instanceof Serviteur) {
				((Serviteur) cible).setPointdevie(((Serviteur) cible).getPointdevie() - this.getAttaque());
			} else {
				((Heros) cible).setPointdevie(((Heros) cible).getPointdevie() - this.getAttaque());
			}
		}
	}

	public void parcoursProvocation(Object cible) throws HearthstoneException {
		for (ICarte c : this.getAdversaire().getJeu()) {
			if ((c != cible) && (c instanceof Serviteur) && (((Serviteur) c).getCapacite().getNom().equals("Provocation"))) {
				throw new HearthstoneException(
						"Vous essayer d'attaquer un Serviteur alors que" + c.getNom() + "a provocation");
			} else if ((((Serviteur) c).getCapacite().getNom().equals("Provocation")) && (cible instanceof Heros)) {
				throw new HearthstoneException(
						"Vous essayez d'attaquer le heros alors que" + c.getNom() + " a provocation");
			}
		}
	}

	public void executerEffetMiseEnJeu(Object cible) throws HearthstoneException {
		this.getCapacite().executerEffetMiseEnJeu(cible);
	}

	public void executerEffetDisparition(Object cible) throws HearthstoneException {
		this.getCapacite().executerEffetDisparition(cible);
	}

	public boolean disparait() {
		if (this.getPointdevie() == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public IJoueur getAdversaire(IJoueur joueur) {
		// TODO Auto-generated method stub
		return null;
	}

}
