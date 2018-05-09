import java.util.ArrayList;

public class Plateau implements IPlateau {

	private ArrayList<IJoueur> LesJoueurs;
	
	private Plateau(){
	LesJoueurs = new ArrayList<IJoueur>();
		}
	

	public void ajouterJoueur(IJoueur joueur){
		if (LesJoueurs.size() < 2)
		    LesJoueurs.add(joueur);
	};
	
	public IJoueur getJoueurCourant() {
		return null;
	}
	public void setJoueurCourant(IJoueur joueur) {
	}
	
	public IJoueur getAdversaire(IJoueur joueur) {
		for ( IJoueur e : LesJoueurs ){
			if (!e.equals(joueur))
			   return e;
		}
		return null; 
	}
	
	public void demarrerPartie() {
	}
	public boolean estDemarree() {
		return false;
	}
	public void finTour(IJoueur joueur) {
	}
	public void gagnerPartie(IJoueur joueur) {
	}











}

	/*	ça doit surement servir dans le main à crée un plateau truc du singleton
	  	static private Plateau plateau = null;
		static public Plateau getIntouve(){
			if (plateau == null)
				plateau = new Plateau();
			return plateau; */