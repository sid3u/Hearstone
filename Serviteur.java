package ICarte;

import ICapacité.ICapacite;
import IJoueur.Heros;
import IJoueur.IJoueur;
import IPlateau.IPlateau;
import IPlateau.Plateau;

public class Serviteur implements ICarte {
	public int pointdevie;
	String nom;
	int cout;
	int attaque;
	boolean disparait;
	ICapacite capacite;
	IJoueur proprietaire;
	IJoueur adversaire = Plateau.getInstance().getAdversaire(proprietaire);
	IPlateau plateau = Plateau.getInstance();

	public Serviteur(int pdv, int cout, String nom, int attaque,
			ICapacite capacite, IJoueur proprietaire) {
		this.setNom(nom);
		this.setPointDeVie(pdv);
		this.setCout(cout);
		this.setAttaque(attaque);
		this.setProprietaire(proprietaire);
	}

	public boolean isDisparait() {
		return disparait;
	}

	public void setDisparait(boolean disparait) {
		this.disparait = disparait;
	}

	public ICapacite getCapacite() {
		return capacite;
	}

	public void setCapacite(ICapacite capacite) {
		this.capacite = capacite;
	}

	public int getPointdevie() {
		return pointdevie;
	}

	public void setPointdevie(int pointdevie) {
		this.pointdevie = pointdevie;
	}

	public void setProprietaire(IJoueur proprietaire) {
		this.proprietaire = proprietaire;
	}

	public Serviteur(String nom, int pdv, int cout, int attaque) {
		this.setPointDeVie(pdv);
		this.setCout(cout);
		this.setNom(nom);
		this.setAttaque(attaque);
	}

	public int getAttaque() {
		return attaque;
	}

	public void setAttaque(int attaque) {
		this.attaque = attaque;
	}

	public int getPointDeVie() {
		return pointdevie;
	}

	public void setPointDeVie(int pointDeVie) {
		pointdevie = pointDeVie;
	}

	public String getNom() {
		return nom;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Serviteur other = (Serviteur) obj;
		if (pointdevie != other.pointdevie)
			return false;
		if (cout != other.cout)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
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

	public String toString() {
		return "Serviteur [pointdevie=" + pointdevie + ", nom=" + nom
				+ ", cout=" + cout + "]";
	}

	public IJoueur getProprietaire() {
		return this.proprietaire;
	}

	public void executerEffetDebutTour(Object cible) {
		this.capacite.executerEffetDebutTour();
	}

	public void executerEffetFinTour() {
		this.capacite.executerEffetFinTour();
	}

	public void executerAction(Object cible) throws HearthstoneException{
			if (( cible instanceof Serviteur ) || (cible instanceof  Heros))
			{
				if (((Serviteur)cible).capacite.getNom().equals("Provocation"))
				{
					((Serviteur)cible).pointdevie-= this.attaque;
				}
				else {
					for (ICarte c : adversaire.getJeu())
					{
						if ((c != cible) && (c instanceof Serviteur) && (((Serviteur)c).getCapacite().equals("Provocation")))
						{
							throw HearthstoneException("Vous essayer d'attaquer un Serviteur alors que" + c.getNom() + "a provocation" );
						}
						else if ((((Serviteur)c).getCapacite().equals("Provocation") ) && (cible instanceof Heros))
						{
							throws HearthstoneException("Vous essayez d'attaquer un heros alors qu'un serviteur a provocation");
						}
					}
					((Serviteur)cible).pointdevie-=this.attaque;
				}
			}
			else if (cible instanceof Heros){
				
			}
			if ((cible instanceof Heros ) &&(this.capacite.getNom().equals("Charge")))
			{
				
			}
			
		}
	}

	public void executerEffetMiseEnJeu(Object cible) {
		this.capacite.executerEffetMiseEnJeu(cible);
	}

	public void executerEffetDisparition(Object cible) {
		this.capacite.executerEffetDisparition(cible);
	}

	public boolean disparait() {
		if (this.pointdevie == 0) {
			return true;
		} else {
			return false;
		}
	}
}
