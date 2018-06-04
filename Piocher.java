package ICapacite;

import Exception.HearthstoneException;
import IJoueur.*;

public class Piocher extends Capacite implements ICapacite {

	private int nombre;

	public Piocher(String nom, String description, int nombre) {
		super(nom,description);
		setNombre(nombre);
	}

	public int getNombre() {
		return nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}

	public String toString() {
		return "Piocher [nombre=" + nombre + "]";
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Piocher other = (Piocher) obj;
		if (nombre != other.nombre)
			return false;
		return true;
	}

	public void executerEffetDebutTour() throws HearthstoneException {
	}

	public void executerEffetFinTour() throws HearthstoneException {
	}

	public void executerAction(Object cible) throws HearthstoneException {
	}

	public void executerEffetMiseEnJeu(Object cible) throws HearthstoneException {
		for (int i=0;i<nombre;i++) {
			if (((IJoueur)cible).getDeck().size() == 0) throw new HearthstoneException("deck vide");
			((IJoueur)cible).pioche();
		}
	}

	public void executerEffetDisparition(Object cible) throws HearthstoneException {
	}

}
