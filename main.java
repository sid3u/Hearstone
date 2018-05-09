
import IPlateau.Plateau;
import IJoueur.Joueur;

public class main {

	public static void main(String[] args) {
		Plateau plateau = new Plateau();
		
		Joueur joueur1 = new Joueur(Rexxar rexxar, "Vincent");
		Joueur joueur2 = new Joueur(Jayna jayna, "Nassym");
		plateau.ajouterJoueur(joueur1,joueur2);
	}

}
