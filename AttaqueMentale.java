package ICapacité;
import Exception.HearthstoneException;
import IJoueur.Joueur;


public class AttaqueMentale implements ICapacite{
	String description;
	String nom;
	
	public AttaqueMentale()
	{
		this.setNom("BouleDeFeu");
		this.setDescription("Inflige 5 points de dégats aux héros");
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

	public String toString() {
		return "AttaqueMentale [description=" + getDescription() + "]";
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		AttaqueMentale other = (AttaqueMentale) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		return true;
	}
	
	public void executerEffetFinTour()throws HearthstoneException{
	
	}
	
	public void executerAction(Object cible)throws HearthstoneException{
	
	}
	
	public void executerEffetMiseEnJeu(Object cible)throws HearthstoneException{
		((Joueur)cible).getHeros().setPointdevie(((Joueur)cible).getHeros().getPointdevie() -5);
	}
	
	public void executerEffetDisparition(Object cible)throws HearthstoneException{
		
	}

	public void executerEffetDebutTour() throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}
	
}
