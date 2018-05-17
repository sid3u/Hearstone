package IPlateau;



import IJoueur.IJoueur;


public class Plateau implements IPlateau {
	private static Plateau instance = null;
	IJoueur joueur1;
	IJoueur joueur2;
	boolean tourjoueur1;
	boolean tourjoueur2;
	boolean partie;
	
	private Plateau(){
		partie = false;
		tourjoueur1 = false;
		tourjoueur2 = false;
		}
	
	public static Plateau getInstance(){
		if (instance == null)
		{
			instance = new Plateau();
		}
		return instance;
	}
	
	public void ajouterJoueur(IJoueur joueur){
		if (joueur1 == null)
		{
			joueur1 = joueur;
		}
		else
		{
			joueur2 = joueur;
		}
	}
	
	public IJoueur getJoueurCourant() {
		if (tourjoueur1 == true)
		{
			return joueur1;
		}
		else
		{
			return joueur2;
		}
	}
	
	public void setJoueurCourant(IJoueur joueur) {
		if (joueur1.equals(joueur))
		{
			tourjoueur1 = true;
		}
		else {
			tourjoueur2 = true;
		}
	}
	
	public IJoueur getAdversaire(IJoueur joueur) {
		if (joueur1.equals(joueur))
		{
			return joueur2;
		}
		else {
			return joueur1;
		}
	}
	
	public void demarrerPartie() {
		partie = true;
	}
	
	public boolean estDemarree() {
		return partie;
	}
	
	public void finTour(IJoueur joueur) {
		if (joueur1.equals(joueur))
		{
			tourjoueur1 = false;
		}
		else {
			tourjoueur2 = false;
		}
	}
	
	public void gagnerPartie(IJoueur joueur) {
		
	}
}
