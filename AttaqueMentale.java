package ICapacité;
import ICarte.Sort;
import IJoueur.IJoueur;
import IJoueur.Joueur;


public class AttaqueMentale implements ICapacite{
	String description;
	String nom;
	int degat;
	
	public AttaqueMentale()
	{
		this.setNom("BouleDeFeu");
		this.setDegat(1);
		this.setDescription("Inflige 5 points de dégats aux héros");
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getDegat() {
		return degat;
	}

	public void setDegat(int degat) {
		this.degat = degat;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String toString() {
		return "AttaqueMentale [description=" + description + "]";
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
	
public void executerEffetDebutTour(Object cible){
		
	}
	
	public void executerEffetFinTour(){
	
	}
	
	public void executerAction(Object cible){
	
	}
	
	public void executerEffetMiseEnJeu(Object cible){
		((Joueur)cible).getHeros().PointDeVie -=5;
	}
	
	public void executerEffetDisparition(Object cible){
		
	}
	

	public void executerEffetDebutTour() {
		// TODO Auto-generated method stub
		
	}
}
