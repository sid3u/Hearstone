package IJoueur;


import java.util.ArrayList;

import Exception.HearthstoneException;
import ICarte.ICarte;




public interface IJoueur {
	public final static int MAX_MANA=10;
	public final static int TAILLE_DECK=15;
	Heros getHeros();
	String getPseudo();
	int getMana();
	int getStockMana();
	ArrayList<ICarte> getMain();
	ArrayList<ICarte> getJeu();
	ICarte getCarteEnJeu(String nomCarte);
	ICarte getCarteEnMain(String nomCarteMain);
	void prendreTour();
	void finirTour();
	void pioche();
	void jouerCarte(ICarte carte);
	void utiliserCarte(ICarte carte,Object cible) throws HearthstoneException;
	void utiliserPouvoir(Object cible)throws HearthstoneException;
	void perdreCarte(ICarte carte);
	void ajoutercarte(ICarte carte) throws HearthstoneException;
	public ICarte getCarteMain(int position) throws HearthstoneException;
	public ICarte getCarteJeu(int position) throws HearthstoneException;
	String toStringmain();
	String toStringjeu();
}
