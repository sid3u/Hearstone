
public class BouleDeFeu implements ICapacite{
	String nom;
	String description;
	int degat;
	
	public BouleDeFeu ()
	{
		this.setNom("BouleDeFeu");
		this.setDescription("Inflige 1 point de dégat au personnage ciblé");
		this.setDegat(1);
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

	public int getDegat() {
		return degat;
	}

	public void setDegat(int degat) {
		this.degat = degat;
	}
	
	void executerEffetDebutTour(){
		
	}
	void executerEffetFinTour(){
		
	}
	void executerAction(Heros cible);
	{
		
	}
	void executerEffetMiseEnJeu(Heros cible)
	{
		cible.setPointDeVie(cible.PointDeVie-1);
	}
	void executerEffetDisparition(Heros cible);

	public void executerAction(Object cible) {
		// TODO Auto-generated method stub
		
	}

	public void executerEffetMiseEnJeu(Object cible) {
		// TODO Auto-generated method stub
		
	}

	public void executerEffetDisparition(Object cible) {
		// TODO Auto-generated method stub
		
	}
	
}
