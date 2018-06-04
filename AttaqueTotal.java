package ICapacite;

import java.util.ArrayList;

import Exception.HearthstoneException;
import ICarte.*;
import IJoueur.*;

public class AttaqueTotal extends Capacite implements ICapacite {
	int att;

	public AttaqueTotal(String nom, String description, int att) {
		super(nom, description);
		setAtt(att);
	}

	public int getAtt() {
		return att;
	}

	public void setAtt(int att) {
		this.att = att;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AttaqueTotal other = (AttaqueTotal) obj;
		if (att != other.att)
			return false;
		return true;
	}

	public String toString() {
		return "AttaqueTotal [att=" + att + "]";
	}

	public void executerEffetDebutTour() throws HearthstoneException {
	}

	public void executerEffetFinTour() throws HearthstoneException {
	}

	public void executerAction(Object cible) throws HearthstoneException {
	}

	public void executerEffetMiseEnJeu(Object cible) throws HearthstoneException {
		ArrayList<ICarte> liste = new ArrayList<ICarte>();
		liste = ((Joueur) cible).getJeu();
		for (ICarte c : liste) {
			if (c instanceof Serviteur) {
				((Serviteur) c).setPointdevie(((Serviteur) c).getPointdevie() - this.getAtt());
			}
		}
	}

	public void executerEffetDisparition(Object cible) throws HearthstoneException {
	}

}
