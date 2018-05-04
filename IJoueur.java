
import java.util.ArrayList;



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
	void utiliserCarte(ICarte carte,Object cible);
	void utiliserPouvoir(Object cible);
	void perdreCarte(ICarte carte);
}
