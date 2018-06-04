package ICapacite;

import java.util.ArrayList;

import Exception.HearthstoneException;
import ICarte.*;
import IJoueur.Joueur;
import IPlateau.Plateau;

public class InvocationServiteur extends Capacite implements ICapacite {
	private int att;
	private int pdv;
	private Serviteur muray;
	String nominvoc;

	public InvocationServiteur(String nom, String description, int pdv, int att, String nominvoc)
			throws HearthstoneException {
		super(nom, description);
		setPdv(pdv);
		setAtt(att);
		muray = new Serviteur(nominvoc, pdv, 0, att,null);
		
	}

	public int getPdv() {
		return pdv;
	}

	private void setPdv(int pdv) throws HearthstoneException {
		if (pdv < 0) throw new HearthstoneException("Points de vie négatif");
		this.pdv = pdv;
	}

	public int getAtt() {
		return att;
	}

	private void setAtt(int att) {
		this.att = att;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvocationServiteur other = (InvocationServiteur) obj;
		if (att != other.att)
			return false;
		if (muray == null) {
			if (other.muray != null)
				return false;
		} else if (!muray.equals(other.muray))
			return false;
		if (nominvoc == null) {
			if (other.nominvoc != null)
				return false;
		} else if (!nominvoc.equals(other.nominvoc))
			return false;
		if (pdv != other.pdv)
			return false;
		return true;
	}

	public String toString() {
		return "InvocationServiteur [pdv=" + pdv + ", att=" + att + ", muray=" + muray + ", nominvoc=" + nominvoc + "]";
	}

	public void executerEffetDebutTour() throws HearthstoneException {

	}

	public void executerEffetFinTour() throws HearthstoneException {
	}

	public void executerAction(Object cible) throws HearthstoneException {
	}

	public void executerEffetMiseEnJeu(Object cible) throws HearthstoneException {
		this.muray.setProprietaire(Plateau.getInstance().getJoueurCourant());
		ArrayList<ICarte> liste = ((Joueur) cible).getJeu();
		liste.add(((ICarte) muray));
		((Joueur) cible).setJeu(liste);
	}

	public void executerEffetDisparition(Object cible) throws HearthstoneException {
	}

}
