package ICapacité;
import ICarte.Serviteur;
import IJoueur.Heros;





public class BouleDeFeu implements ICapacite {
	String nom;
	String description;
	int degat;

	public BouleDeFeu() {
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

	public void executerEffetDebutTour() {

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

	public void executerEffetMiseEnJeu(Object cible) {

	}

	public void executerEffetDisparition(Object cible) {
		// TODO Auto-generated method stub
		
	}

	
}
