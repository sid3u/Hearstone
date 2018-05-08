
public class Rexxar extends Heros {
	String nom;
	ICapacite pouvoir;

	public Rexxar() {
		this.setNom("Rexxar");
		this.setPouvoir(new CriDeGuerre());
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public ICapacite getPouvoir() {
		return pouvoir;
	}

	public void setPouvoir(ICapacite pouvoir) {
		this.pouvoir = pouvoir;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rexxar other = (Rexxar) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (pouvoir == null) {
			if (other.pouvoir != null)
				return false;
		} else if (!pouvoir.equals(other.pouvoir))
			return false;
		return true;
	}

	public String toString() {
		return "Rexxar [nom=" + nom + ", pouvoir=" + pouvoir + "]";
	}
}
