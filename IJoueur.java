package IJoueur;


import java.util.ArrayList;

import Exception.HearthstoneException;
import ICarte.ICarte;

public interface IJoueur {
	public final static int MAX_MANA=10;
	public final static int TAILLE_DECK=20;
	Heros getHeros();
	String getPseudo();
	public void setPseudo(String pseudo) throws HearthstoneException;
	int getMana();
	int getStockMana();
	ArrayList<ICarte> getMain();
	ArrayList<ICarte> getJeu();
	ArrayList<ICarte> getDeck();
	public void setJeu(ArrayList<ICarte> jeu);
	ICarte getCarteEnJeu(String nomCarte);
	ICarte getCarteEnMain(String nomCarteMain);
	void prendreTour()throws HearthstoneException;
	void finirTour()throws HearthstoneException;
	void pioche() throws HearthstoneException;
	void jouerCarte(ICarte carte)throws HearthstoneException;
	void utiliserCarte(ICarte carte,Object cible) throws HearthstoneException;
	void utiliserPouvoir(Object cible)throws HearthstoneException;
	void perdreCarte(ICarte carte)throws HearthstoneException;
	void ajoutercarte(ICarte carte) throws HearthstoneException;
	public ICarte getCarteMain(int position) throws HearthstoneException;
	public ICarte getCarteJeu(int position) throws HearthstoneException;
	String toStringmain();
	String toStringjeu();
	int getPositionJeu(ICarte c);
}
