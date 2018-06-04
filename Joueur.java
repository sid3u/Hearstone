package IJoueur;

import java.util.ArrayList;
import java.util.Random;

import Exception.HearthstoneException;
import ICarte.ICarte;
import ICarte.Sort;
import ICarte.Serviteur;
import IJoueur.Heros;
import IPlateau.Plateau;

public class Joueur implements IJoueur {

	private Heros heros;
	private String pseudo;
	private int stockmana;
	private int mana;
	private ArrayList<ICarte> main;
	private ArrayList<ICarte> jeu;
	private ArrayList<ICarte> deck;

	public Joueur(Heros h, String p) throws HearthstoneException {
		setHeros(h);
		setPseudo(p);
		main = new ArrayList<ICarte>();
		jeu = new ArrayList<ICarte>();
		deck = new ArrayList<ICarte>();
	}

	public int getStockmana() {
		return stockmana;
	}

	public Heros getHeros() {
		return heros;
	}

	public void setHeros(Heros heros) {
		this.heros = heros;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) throws HearthstoneException {
		if (pseudo == null)
			throw new HearthstoneException("Pseudo null");
		else if (pseudo.trim().isEmpty())
			throw new HearthstoneException("Nom non viable");
		else
			this.pseudo = pseudo;
	}

	public int getStockMana() {
		return this.stockmana;
	}

	public void setStockmana(int stockmana) throws HearthstoneException {
		if (stockmana < 0)
			throw new HearthstoneException("Stock de mana inférieur à 0");
		else if (stockmana > MAX_MANA)
			throw new HearthstoneException("Stock de mana dépassé");
		this.stockmana = stockmana;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) throws HearthstoneException {
		if (mana < 0)
			throw new HearthstoneException("Mana inférieur à 0");
		else if (mana > MAX_MANA)
			throw new HearthstoneException("Stock de mana dépassé");
		this.mana = mana;
	}

	public ArrayList<ICarte> getMain() {
		return main;
	}

	public void setMain(ArrayList<ICarte> main) {
		this.main = main;
	}

	public ArrayList<ICarte> getJeu() {
		return jeu;
	}

	public void setJeu(ArrayList<ICarte> jeu) {
		this.jeu = jeu;
	}

	public ArrayList<ICarte> getDeck() {
		return deck;
	}

	public void setDeck(ArrayList<ICarte> deck) {
		this.deck = deck;
	}



	public boolean containsmain(String nomcarte) {
		for (ICarte c : this.getMain()) {
			if (c.getNom().equals(nomcarte))
				return true;
		}
		return false;
	}

	public boolean containsjeu(String nomcarte) {
		for (ICarte c : this.getJeu()) {
			if (c.getNom().equals(nomcarte))
				return true;
		}
		return false;
	}

	public String toStringjeu() {
		String chaine = "";
		int i = 1;
		for (ICarte c : this.getJeu()) {
			chaine = chaine + i+"- " + c.toString()+"\n";
			i += 1;
		}
		if (i == 1) return ("rien");
		return chaine;
	}
	
	public String toStringmain() {
		String chaine = "";
		int i = 1;
		for (ICarte c : this.getMain()) {
			chaine = chaine + i +"- "+ c.toString()+"\n";
			i += 1;
		}
		if (i == 1) return ("rien");
		return chaine;
	}

	public ICarte getCarteJeu(int position) throws HearthstoneException {
		if ((position < this.getJeu().size()) && (position > this.getJeu().size())) {
			throw new HearthstoneException("Position incompatible avec la taille du jeu");
		}
		return this.getJeu().get(position - 1);
	}

	public ICarte getCarteMain(int position) throws HearthstoneException {
		if ((position < this.getMain().size()) && (position > this.getMain().size())) {
			throw new HearthstoneException("Position incompatible avec la taille du jeu");
		}
		return this.getMain().get(position - 1);
	}

	public ICarte getCarteEnJeu(String nomcarte) {

		if (containsjeu(nomcarte)) {
			int i = 0;
			{
				for (ICarte c : jeu) {
					if (c.getNom().equals(nomcarte)) {
						return jeu.get(i);
					} else
						i++;
				}
			}

		}
		return null;
	}

	public ICarte getCarteEnMain(String nomCarteMain) {

		if (containsmain(nomCarteMain)) {
			int i = 0;
			{
				for (ICarte c : main) {
					if (c.getNom() == nomCarteMain) {
						return main.get(i);
					} else
						i++;
				}
			}
		}
		return null;
	}

	public void prendreTour() throws HearthstoneException {
		// On permet au héros d'utiliser son pouvoir
		heros.setUtiliserpouvoir(false);
		// On verifie que le joueur est bien le joueur courant
		if (!(Plateau.getInstance().getJoueurCourant() == this))
			throw new HearthstoneException("Le joueur qui prend le tour n'est pas le joueur courant");
		// On pioche
		this.pioche();
		// On permet aux cartes présentes de pouvoir attaquer et on execute l'effet de
		// début de tour
		for (ICarte c : this.getJeu()) {
			if (c instanceof Serviteur) {
				if (((Serviteur) c).isPeutattaquer() == false)
					((Serviteur) c).setPeutattaquer(true);
				((Serviteur) c).executerEffetDebutTour(((Serviteur) c).getAdversaire());
			}
		}
		// On augmente le mana jusque 10
		if (getMana() < 10) {
			setMana(getMana() + 1);
		}
		// On reinitialise le stock de mana
		setStockmana(getMana());
	}

	public void finirTour() throws HearthstoneException {
		if (!(Plateau.getInstance().getJoueurCourant() == this))
			throw new HearthstoneException("Vous ne pouvez pas passer le tour vu que ce n'est pas à vous de jouer");
		for (ICarte c : this.getJeu()) {
			c.executerEffetFinTour();
		}
	}

	public void pioche() throws HearthstoneException {
		if (this.getDeck().size() == 0)
			throw new HearthstoneException("Vous n'avez plus de carte, vous ne pouvez plus piocher");
		Random r = new Random();
		int max = this.getDeck().size();
		int nb = 0 + r.nextInt(max - 0);

		ICarte pioche = this.getDeck().get(nb);

		ArrayList<ICarte> main = this.getMain();
		main.add(pioche);
		this.setMain(main);

		ArrayList<ICarte> deck = this.getDeck();
		deck.remove(nb);
		this.setDeck(deck);
	}

	public void jouerCarte(ICarte carte) throws HearthstoneException {
		if ((this.getStockMana() - carte.getCout() < 0))
			throw new HearthstoneException("Vous n'avez pas assez de mana pour executer cette action");
		if (this.getStockMana() - carte.getCout() >= 0) {
			this.setStockmana(this.getStockMana() - carte.getCout());
			ArrayList<ICarte> jeu = this.getJeu();
			jeu.add(carte);
			this.setJeu(jeu);

			ArrayList<ICarte> main = this.getMain();
			main.remove(carte);
			this.setMain(main);
		}
	}

	public void utiliserCarte(ICarte carte, Object cible) throws HearthstoneException {
		if ((cible instanceof Heros) || (cible instanceof Serviteur) && (carte.getCout() <= this.getStockMana())) {
			carte.executerAction(cible);
		} else if (cible instanceof Sort) {
			throw new HearthstoneException("Vous ne pouvez pas attaquer un sort");
		}
	}

	public void utiliserPouvoir(Object cible) throws HearthstoneException {
		if (heros.isUtiliserpouvoir() == true)
			throw new HearthstoneException("Vous avez déjà utilisé son pouvoir ce tour");
		heros.getPouvoir().executerEffetMiseEnJeu(cible);
		heros.setUtiliserpouvoir(true);
	}

	public void perdreCarte(ICarte carte) throws HearthstoneException{
		if (getJeu().size() == 0) throw new HearthstoneException("Vous n'avez aucune carte à faire disparaitre");
		if (carte.disparait() == true)
			jeu.remove(carte);
	}

	public void ajoutercarte(ICarte carte) throws HearthstoneException {
		if (this.getDeck().size() + 1 > TAILLE_DECK) {
			throw new HearthstoneException("La taille du deck est déja à son maximum");
		} else {
			ArrayList<ICarte> deck = this.getDeck();
			deck.add(carte);
			this.setDeck(deck);
		}
	}
	
	public int getPositionJeu (ICarte cherche)
	{
		int i = 0;
		for (ICarte c : this.getJeu())
		{
			if (c.equals(cherche)) return i;
			i++;
		}
		return 20;
	}

}
