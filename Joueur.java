package IJoueur;

import java.util.ArrayList;
import java.util.Scanner;

import ICarte.ICarte;
import ICarte.Serviteur;

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

	public int getStockmana() {
		return stockmana;
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

	}

	public void finirTour() {

	}

	public void pioche() {
		ICarte l;
		l = deck.get(0);
		main.add(l);
		deck.remove(0);
	}

	public void jouerCarte(ICarte carte) {
		System.out
				.println("Donnez le numero de la carte que vous voulez jouer");
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		jeu.add(main.get(i - 1));
		main.remove(i - 1);
	}

	public void utiliserCarte(ICarte carte, Object cible) {
		if ((cible instanceof Heros) || (cible instanceof Serviteur)) {
			carte.executerAction(cible);
		}
	}

	public void utiliserPouvoir(Object cible) {

	}

	public void perdreCarte(ICarte carte) {
		
	}

	public int getStockMana() {
		// TODO Auto-generated method stub
		return 0;
	}

}
