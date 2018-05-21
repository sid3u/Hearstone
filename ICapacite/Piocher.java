package ICapacite;

import java.util.ArrayList;
import java.util.Random;

import Exception.HearthstoneException;
import ICarte.*;
import IJoueur.*;


public class Piocher implements ICapacite{

	public Piocher(String nom, String description, int nombre) {
		setNom(nom);
		setDescription(description);
		setNombre(nombre);
	}
	
	
	
	@Override
	public String toString() {
		return "Piocher [nom=" + nom + ", description=" + description + "]";
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Piocher other = (Piocher) obj;
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

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	String nom;
	String description;
	int nombre;
	
	public int getNombre() {
		return nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}

	@Override
	public String getNom() {
		// TODO Auto-generated method stub
		return nom;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return description;
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
		for(int i = 1; i <= getNombre(); i++) {
		Random r = new Random();
		int max = ((Joueur) cible).getDeck().size() ;
		int nb = 0 + r.nextInt(max - 0);

		ICarte pioche = ((Joueur) cible).getDeck().get(nb);
		ArrayList<ICarte> main = ((Joueur) cible).getMain();
		main.add(pioche);
		((Joueur) cible).setMain(main);
		
		ArrayList<ICarte> deck = ((Joueur) cible).getDeck();
		deck.remove(nb);
		((Joueur) cible).setDeck(deck);
		}
	}

	@Override
	public void executerEffetMiseEnJeu(Object cible) throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executerEffetDisparition(Object cible) throws HearthstoneException {
		// TODO Auto-generated method stub
		
	}

}
