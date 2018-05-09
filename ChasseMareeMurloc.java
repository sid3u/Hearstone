package ICarte;

import IJoueur.Heros;
import IJoueur.IJoueur;



public class ChasseMareeMurloc extends Serviteur {
	String nomcapacite;
	String Description;
	IJoueur joueur;

	public ChasseMareeMurloc() {
		super(1, 2, "Chasse-marée murloc", 2);
		this.setNomcapacite("Cri de Guerre");
		this.setDescription("Invoque un serviteur 1pdv et 1 point d'attaque");
	}

	public String getNomcapacite() {
		return nomcapacite;
	}

	public void setNomcapacite(String nomcapacite) {
		this.nomcapacite = nomcapacite;
	}

	public String getDescription() {
		return Description;
	}

	@Override
	public String toString() {
		return "ChasseMareeMurloc [nomcapacite=" + nomcapacite
				+ ", Description=" + Description + "]";
	}

	public void setDescription(String description) {
		Description = description;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChasseMareeMurloc other = (ChasseMareeMurloc) obj;
		if (Description == null) {
			if (other.Description != null)
				return false;
		} else if (!Description.equals(other.Description))
			return false;
		if (nomcapacite == null) {
			if (other.nomcapacite != null)
				return false;
		} else if (!nomcapacite.equals(other.nomcapacite))
			return false;
		return true;
	}

	public void executerEffetDebutTour(Object cible) {

	}

	public void executerEffetFinTour() {

	}

	public void executerAction(Object cible) {
		if (cible instanceof Serviteur) {
			((Serviteur) cible)
					.setPointDeVie(((Serviteur) cible).PointDeVie - 1);
		} else if (cible instanceof Heros) {
			((Heros) cible).setPointDeVie(((Heros) cible).PointDeVie - 1);
		}
	}

	public void executerEffetMiseEnJeu() {
		IJoueur proprietaire = this.getProprietaire();
		proprietaire.getJeu().add(ChasseMareeMurloc);

	}

	public void executerEffetDisparition(Object cible) {

	}

	public boolean disparait() {
		if (this.PointDeVie == 0) {
			return true;
		} else {
			return false;
		}
	}

	public IJoueur getProprietaire() {
		// TODO Auto-generated method stub
		return ;
	}

	@Override
	public void executerEffetMiseEnJeu(Object cible) {
		// TODO Auto-generated method stub
		
	}
}
