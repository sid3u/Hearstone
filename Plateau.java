package IPlateau;

import java.util.ArrayList;

import Exception.HearthstoneException;
import ICarte.ICarte;
import ICarte.Serviteur;
import IJoueur.Heros;
import IJoueur.IJoueur;

public class Plateau implements IPlateau {
	private static Plateau instance = null;
	private ArrayList<IJoueur> joueurs;
	private boolean partie;
	private IJoueur joueurCourant;
	boolean jayna;
	boolean rexxar;

	private Plateau() throws HearthstoneException {
		setPartie(false);
		joueurs = new ArrayList<IJoueur>();
		joueurCourant = null;
		setJayna(false);
		setRexxar(false);
	}

	public String toString() {
		return "Plateau [joueurs=" + joueurs + ", partie=" + partie + ", joueurCourant=" + joueurCourant + ", jayna="
				+ jayna + ", rexxar=" + rexxar + "]";
	}

	public boolean isJayna() {
		return jayna;
	}

	public void setJayna(boolean jayna) {
		this.jayna = jayna;
	}

	public boolean isRexxar() {
		return rexxar;
	}

	public void setRexxar(boolean rexxar) {
		this.rexxar = rexxar;
	}

	public boolean isPartie() {
		return partie;
	}

	public void setPartie(boolean partie) throws HearthstoneException {
		if (estDemarree() == true)
			throw new HearthstoneException("Partie déja lancé");
		this.partie = partie;
	}

	public static Plateau getInstance() throws HearthstoneException {
		if (instance == null) {
			instance = new Plateau();
		}
		return instance;
	}

	public ArrayList<IJoueur> getJoueurs() {
		return joueurs;
	}

	private void setJoueurs(ArrayList<IJoueur> joueurs) {
		this.joueurs = joueurs;
	}

	public void add(IJoueur joueur) {
		ArrayList<IJoueur> newlist = new ArrayList<IJoueur>();
		newlist = this.getJoueurs();
		newlist.add(joueur);
		setJoueurs(newlist);
	}

	public void ajouterJoueur(IJoueur joueur) throws HearthstoneException {
		if (this.getJoueurs().size() >= 2)
			throw new HearthstoneException("Il y a déja trop de joueurs");
		if (joueur == null)
			throw new HearthstoneException("Joueur null");
		add(joueur);
	}

	public IJoueur getJoueurCourant() {
		return joueurCourant;
	}

	public void setJoueurCourant(IJoueur joueur) throws HearthstoneException {
		if (joueur == null)
			throw new HearthstoneException("Joueur null");
		this.joueurCourant = joueur;
	}

	public IJoueur getAdversaire(IJoueur joueur) throws HearthstoneException {
		if (joueur == null)
			throw new HearthstoneException("Joueur null");
		for (IJoueur j : this.getJoueurs()) {
			if (j != joueur)
				return j;
		}
		return null;
	}

	public void demarrerPartie() throws HearthstoneException {
		if (this.getJoueurs().size() != 2)
			throw new HearthstoneException("Vous voulez lancer une partie alors qu'il n'y a pas 2 joueurs");
		partie = true;
	}

	public boolean estDemarree() {
		return partie;
	}

	public void finTour(IJoueur joueur) throws HearthstoneException {
		if (joueur != getJoueurCourant())
			throw new HearthstoneException("Vous ne pouvez pas passer votre tour si ce n'est pas à vous de jouer");
		for (IJoueur j : getJoueurs()) {
			if (j != joueur)
				setJoueurCourant(j);
		}
	}

	public void gagnerPartie(IJoueur joueur) throws HearthstoneException {
		int pdvadverse = getAdversaire(joueur).getHeros().getPointdevie();
		if (pdvadverse > 0)
			throw new HearthstoneException("Vous trichez, vous n'avez pas gagné, retournez au combat");
		setPartie(false);
	}

	public void cartesDisparaissent() throws HearthstoneException {
		for (IJoueur j : getJoueurs()) {
			for (ICarte c : j.getJeu()) {
				if (((Serviteur) c).disparait())
				{
					j.perdreCarte(c);
				}
			}
		}
	}
	
}
