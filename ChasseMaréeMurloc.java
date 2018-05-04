package Serviteur;

import Sort.Sort;



public class ChasseMareeMurloc extends Serviteur {
	String nomcapacite;
	String Description;
	
	public ChasseMareeMurloc (){
		super(1,2,"Chasse-marée murloc",2);
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
	
	public void executerEffetDebutTour(Object cible){
		
	}
	
	public void executerEffetFinTour(){
	
	}
	
	public void executerAction(Object cible){
		if (!cible instanceof Sort)
		{
			cible.PointDeVie-= 2;
		}
	}
	
	public void executerEffetMiseEnJeu(){
		proprietaire = this.getProprietaire();
		proprietaire.getJeu().add(ChasseMaréeMurloc);
		
	}
	
	public void executerEffetDisparition(Object cible){
		
	}
	
	public boolean disparait(){
		if (this.PointDeVie == 0){
			return true;
		}
		else
		{
			return false;
		}
	}
}
