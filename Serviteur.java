package ICarte;

import Exception.HearthstoneException;
import ICapacité.ICapacite;
import IJoueur.Heros;
import IJoueur.IJoueur;
import IPlateau.IPlateau;
import IPlateau.Plateau;

public class Serviteur extends Carte {
	public int pointdevie;
	int attaque;
	boolean disparait;
	boolean peutattaquer;
	IJoueur adversaire = Plateau.getInstance().getAdversaire(this.proprietaire);
	IPlateau plateau = Plateau.getInstance();

	public Serviteur(String nom,int pdv, int cout,  int attaque ,ICapacite capacite,
			IJoueur proprietaire) {
		super(nom, cout, capacite, proprietaire);
		this.setPointdevie(pdv);
		this.setAttaque(attaque);
		this.setCapacite(capacite);
		this.setPeutattaquer(false);
	}

	public Serviteur(String nom,int pdv, int cout,  int attaque ,
			IJoueur proprietaire) {
		super(nom, cout, null, proprietaire); // si le serviteur n'a pas de capacité on l'a met à null
		this.setPointdevie(pdv);
		this.setAttaque(attaque);
		this.setCapacite(null);
		this.setPeutattaquer(false);
	}

	public ICapacite getCapacite() {
		return capacite;
	}

	public void setCapacite(ICapacite capacite) {
		this.capacite = capacite;
	}

	public boolean isPeutattaquer() {
		return peutattaquer;
	}

	public void setPeutattaquer(boolean peutattaquer) {
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

	public void setPointdevie(int pointdevie) {
		this.pointdevie = pointdevie;
	}

	public int getAttaque() {
		return attaque;
	}

	public void setAttaque(int attaque) {
		this.attaque = attaque;
	}

	public int getPointdevie1() {
		return pointdevie;
	}

	public IJoueur getAdversaire() {
		return adversaire;
	}

	public void setAdversaire(IJoueur adversaire) {
		this.adversaire = adversaire;
	}

	public IPlateau getPlateau() {
		return plateau;
	}

	public void setPlateau(IPlateau plateau) {
		this.plateau = plateau;
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
		return "Serviteur [pointdevie=" + this.getPointdevie() + ", nom="
				+ this.getNom() + ", cout=" + this.getCout() + "]";
	}

	public IJoueur getProprietaire() {
		return this.getProprietaire();
	}

	public void executerEffetDebutTour(Object cible)
			throws HearthstoneException {
		this.getCapacite().executerEffetDebutTour();
	}

	public void executerEffetFinTour() throws HearthstoneException {
		this.getCapacite().executerEffetFinTour();
	}

	public void executerAction(Object cible) throws HearthstoneException {
		if (this.getCapacite().equals("Charge")
				&& (this.isPeutattaquer() == false)) {
			this.setPeutattaquer(true);
		}
		if ((cible instanceof Serviteur) || (cible instanceof Heros)
				&& (this.isPeutattaquer() == true)) {
			if (((Serviteur) cible).getCapacite().getNom()
					.equals("Provocation")) {
				((Serviteur) cible).setPointdevie(this.getPointdevie()
						- this.getAttaque());
			} else {
				for (ICarte c : this.getAdversaire().getJeu()) {
					if ((c != cible)
							&& (c instanceof Serviteur)
							&& (((Serviteur) c).getCapacite()
									.equals("Provocation"))) {
						throw new HearthstoneException(
								"Vous essayer d'attaquer un Serviteur alors que"
										+ c.getNom() + "a provocation");
					} else if ((((Serviteur) c).getCapacite()
							.equals("Provocation")) && (cible instanceof Heros)) {
						throw new HearthstoneException(
								"Vous essayez d'attaquer un heros alors que"
										+ c.getNom() + " a provocation");
					}
				}
				if (cible instanceof Serviteur) {
					((Serviteur) cible).setPointdevie(((Serviteur) cible)
							.getPointdevie() - this.getAttaque());
				} else {
					((Heros) cible).setPointdevie(((Heros) cible)
							.getPointdevie() - this.getAttaque());
				}
			}
		} else {
			throw new HearthstoneException("Vous ne pouvez pas attaquer");
		}

	}

	public void executerEffetMiseEnJeu(Object cible)
			throws HearthstoneException {
		this.getCapacite().executerEffetMiseEnJeu(cible);
	}

	public void executerEffetDisparition(Object cible)
			throws HearthstoneException {
		this.getCapacite().executerEffetDisparition(cible);
	}

	public boolean disparait() {
		if (this.getPointdevie() == 0) {
			return true;
		} else {
			return false;
		}
	}

}
