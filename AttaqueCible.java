package ICapacite;

import Exception.HearthstoneException;
import ICarte.*;
import IJoueur.*;

public class AttaqueCible implements ICapacite {

	String nom; 
	String description;
	int att; 

	
	
	public AttaqueCible(String nom, String description, int att) {
	setNom(nom);
	setDescription(description);
	setAtt(att);
	}
	
	public int getAtt() {
		return att;
	}
	public void setAtt(int att) {
		this.att = att;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AttaqueDuHero other = (AttaqueDuHero) obj;
		if (att != other.att)
			return false;
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
	@Override
	public String toString() {
		return "AttaqueDuHero [nom=" + nom + ", description=" + description + ", att=" + att + "]";
	}
	@Override
	public void executerEffetDebutTour() throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executerEffetFinTour() throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executerAction(Object cible) throws HearthstoneException {
		
		if (((Serviteur) cible).getCapacite().getNom().equals("Provocation")) {
			((Serviteur) cible).setPointdevie(((Serviteur) cible).getPointdevie()
					- this.getAtt());
		} else {
			for (ICarte c : ((Serviteur) cible).getAdversaire().getJeu()) {
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
			if (cible instanceof Serviteur)
				((Serviteur) cible).setPointdevie(((Serviteur) cible).getPointdevie() - this.getAtt());
			else
			
				((Heros) cible).setPointdevie(((Heros) cible).getPointdevie() - this.getAtt());}
		    
		}
	

	@Override
	public void executerEffetMiseEnJeu(Object cible) throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executerEffetDisparition(Object cible) throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}

	public String getNom() {
		return nom;
	}

	public String getDescription() {
		return description;
	}


	}



