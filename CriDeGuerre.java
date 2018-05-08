import java.util.ArrayList;

public class CriDeGuerre implements ICapacite {
	String nom;
	String description;
	int degat;

	public CriDeGuerre() {
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

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CriDeGuerre other = (CriDeGuerre) obj;
		if (degat != other.degat)
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

	public String toString() {
		return "CriDeGuerre [nom=" + nom + ", description=" + description
				+ ", degat=" + degat + "]";
	}

	public void executerEffetDebutTour() {

	}

	public void executerEffetFinTour() {

	}

	public void executerAction(Object cible) {
		ArrayList<ICarte> liste = ((Joueur)cible).getJeu();

		for (ICarte carte : liste) {
			if (carte instanceof Serviteur) {
				((Serviteur) carte)
						.setPointDeVie(((Serviteur) carte).PointDeVie - 1);
			}
		}
	}

	public void executerEffetMiseEnJeu(Object cible) {

	}

	public void executerEffetDisparition(Object cible) {
		
	}


}
