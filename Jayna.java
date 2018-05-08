
public class Jayna extends Heros {
	String nom;
	ICapacite pouvoir;

	public Jayna() {
		this.setNom("Jayna");
		this.setPouvoir(new BouleDeFeu());
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public ICapacite getPouvoir() {
		return this.pouvoir;
	}

	public void setPouvoir(ICapacite pouvoir) {
		this.pouvoir = pouvoir;
	}

	@Override
	public String toString() {
		return "Jayna [nom=" + nom + ", pouvoir=" + pouvoir + "]";
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jayna other = (Jayna) obj;
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

}
