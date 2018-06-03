package ICapacite;

import java.util.ArrayList;

import Exception.HearthstoneException;
import ICarte.*;
import IJoueur.Joueur;



public class InvocationServiteur implements ICapacite {
	String nom;
	String description;
	int Pdv;
	int Att;
	Serviteur Muray;
	String NomInvocation;
	
	public InvocationServiteur(String nom, String description, int Pdv, int Att, String NomInvocation) {
		setNom(nom);
		setDescription(description);
		Muray.setNom(NomInvocation);
		Muray.setPointdevie(Pdv);
		Muray.setAttaque(Att);
		
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

	public int getPdv() {
		return Pdv;
	}

	public void setPdv(int pdv) {
		Pdv = pdv;
	}

	public int getAtt() {
		return Att;
	}

	public void setAtt(int att) {
		Att = att;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvocationServiteur other = (InvocationServiteur) obj;
		if (Att != other.Att)
			return false;
		if (Pdv != other.Pdv)
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
		return "InvocationServiteur [nom=" + nom + ", description=" + description + ", Pdv=" + Pdv + ", Att=" + Att
				+ "]";
	}

	 public void executerEffetDebutTour() throws HearthstoneException {
		
	}

	
	public void executerEffetFinTour() throws HearthstoneException{
	}

	
	public void executerAction(Object cible) throws HearthstoneException {
	}

	
	public void executerEffetMiseEnJeu(Object cible) throws HearthstoneException {
	
		ArrayList<ICarte> liste = ((Joueur) cible).getJeu();
		Muray.setProprietaire((Joueur) cible);
		liste.add(((ICarte) Muray));
		((Joueur) cible).setJeu(liste);
			
	}


	public void executerEffetDisparition(Object cible) throws HearthstoneException {	
	}






}
