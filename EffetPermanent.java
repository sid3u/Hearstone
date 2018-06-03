package ICapacite;

import Exception.HearthstoneException;
import IJoueur.*;
import ICarte.*;

public class EffetPermanent implements ICapacite {
	private String nom;
	private String description;
	private int batt;
	private int bdef;

	public EffetPermanent(String nom, String description, int batt, int bdef) {
		setNom(nom);
		setDescription(description);
		setBatt(batt);
		setBdef(bdef);
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

	public int getBatt() {
		return batt;
	}

	public void setBatt(int batt) {
		this.batt = batt;
	}

	public int getBdef() {
		return bdef;
	}

	public void setBdef(int bdef) {
		this.bdef = bdef;
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
		// TODO Auto-generated method stub

	}

	@Override
	public void executerEffetMiseEnJeu(Object cible) throws HearthstoneException {
		for (ICarte c : ((Joueur) cible).getJeu()) {
			((Serviteur) c).setPointdevie(((Serviteur) c).getPointdevie() + bdef);
			((Serviteur) c).setAttaque(((Serviteur) c).getAttaque() + batt);
		}
	}

	@Override
	public void executerEffetDisparition(Object cible) throws HearthstoneException {
		for (ICarte c : ((Joueur) cible).getJeu()) {
			((Serviteur) c).setPointdevie(((Serviteur) c).getPointdevie() - bdef);
			((Serviteur) c).setAttaque(((Serviteur) c).getAttaque() - batt);

		}

	}
}