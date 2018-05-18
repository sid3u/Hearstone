package IJoueur;

import java.util.ArrayList;
import java.util.Random;

import Exception.HearthstoneException;
import ICarte.ICarte;
import ICarte.Serviteur;
import ICarte.Sort;
import IJoueur.Heros; 

public class Joueur implements IJoueur {

	Heros heros;
	String pseudo;
	int stockmana;
	int mana;
	ArrayList<ICarte> main;
	ArrayList<ICarte> jeu;
	ArrayList<ICarte> deck;
	public Joueur(Heros h, String p) {
		heros = h;
		pseudo = p;
		main = new ArrayList<ICarte>();
		jeu = new ArrayList<ICarte>();
		deck = new ArrayList<ICarte>();
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

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public int getStockMana() {
		return this.stockmana;
	}
	public void setStockmana(int stockmana) {
		this.stockmana = stockmana;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
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
	
	public ICarte getCarteJeu(int position) throws HearthstoneException
	{
		if ((position < this.getJeu().size()) && (position> this.getJeu().size()))
		{
			throw new HearthstoneException("Position incompatible avec la taille du jeu");
		}
		return this.getJeu().get(position-1);
	}
	
	public ICarte getCarteMain(int position) throws HearthstoneException
	{
		if ((position < this.getMain().size()) && (position> this.getMain().size()))
		{
			throw new HearthstoneException("Position incompatible avec la taille du jeu");
		}
		return this.getMain().get(position-1);
	}
	
	public ICarte getCarteEnJeu(String nomCarte) {

		if (jeu.contains(nomCarte)) {
			int i = 0;
			{
				for (ICarte c : jeu) {
					if (c.getNom() == nomCarte) {
						return jeu.get(i);
					} else
						i++;
				}
			}

		}
		return null;
	}

	public ICarte getCarteEnMain(String nomCarteMain) {

		if (main.contains(nomCarteMain)) {
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

	public void prendreTour() {
		 System.out.println("1.Voulez vous attaquer? \n" +
							"2.Voulez vous utiliser la capacité spéciale de votre heros? \n" +
							"3.Voulez vous jouer une carte?\n" +
							"4.Voulez vous piocher?\n" +
							"5.Voulez vous passer votre tour?\n");
	}

	public String toStringjeu() {
		String chaine = null;
		int i=1;
		for (ICarte c : this.getJeu())
		{
			chaine = chaine +i+c.toString();
			i+=1;
		}
		return chaine;
	}
	
	public String toStringmain() {
		String chaine = null;
		int i=1;
		for (ICarte c : this.getMain())
		{
			chaine = chaine +i+c.toString();
			i+=1;
		}
		return chaine;
	}

	public void finirTour() {
		
	}

	public void pioche() {
		Random r = new Random();
		int max = this.getDeck().size() ;
		int nb = 0 + r.nextInt(max - 0);

		ICarte pioche = this.getDeck().get(nb);
		
		ArrayList<ICarte> main = this.getMain();
		main.add(pioche);
		this.setMain(main);
		
		ArrayList<ICarte> deck = this.getDeck();
		deck.remove(nb);
		this.setDeck(deck);
	}

	public void jouerCarte(ICarte carte) {
		ArrayList<ICarte> jeu = this.getJeu();
		jeu.add(carte);
		this.setJeu(jeu);
		
		ArrayList<ICarte> main = this.getMain();
		main.remove(carte);
		this.setMain(main);
	}

	public void utiliserCarte(ICarte carte, Object cible) throws HearthstoneException {
		if ((cible instanceof Heros) || (cible instanceof Serviteur) && (carte.getCout()<=this.getStockMana())){
			carte.executerAction(cible);
			this.setStockmana(this.getStockMana()-carte.getCout());
		}
		else if (cible instanceof Sort)
		{
			throw new HearthstoneException("Vous ne pouvez pas attaquer un sort");
		}
		else
		{
			throw new HearthstoneException("Vous ne disposez pas d'assez de mana");
		}
	}

	public void utiliserPouvoir(Object cible) throws HearthstoneException {
             heros.getPouvoir().executerAction(cible);
	}

	public void perdreCarte(ICarte carte) {
		if ( carte.disparait() == true)
			jeu.remove(carte);
	}


	public ArrayList<ICarte> getDeck() {
		return deck;
	}

	public void setDeck(ArrayList<ICarte> deck) {
		this.deck = deck;
	}

	public void ajoutercarte(ICarte carte) throws HearthstoneException {
		if (this.getDeck().size()+1 > TAILLE_DECK)
		{
			throw new HearthstoneException("La taille du deck est déja à son maximum");
		}
		else
		{	
			ArrayList<ICarte> deck = this.getDeck();
			deck.add(carte);
			this.setDeck(deck);
		}
	}

}
