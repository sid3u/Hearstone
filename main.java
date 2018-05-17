package main;
import IJoueur.*;
import ICarte.*;
import IPlateau.*;
import ICapacité.*;

public class main {

	public static void main(String[] args) {
		// Creation du plateau
		Plateau plateau = new Plateau();
		
		// Creation des capacités
		ICapacite crideguerre = (ICapacite) new CriDeGuerre();
		ICapacite bouledefeu = (ICapacite) new BouleDeFeu();
		ICapacite attaquem = (ICapacite) new AttaqueMentale();
		
		// Creation des héros
		Heros rexxar = new Heros("Rexxar",crideguerre);
		Heros jayna = new Heros("Jayna",bouledefeu);
		Heros rex = new Heros("lol",attaquem);
		
		// Creation des joueurs
		Joueur joueur1 = new Joueur(rexxar, "Vincent");
		Joueur joueur2 = new Joueur(jayna, "Nassym");
		
		// Ajout des joueurs dans le plateau
		plateau.ajouterJoueur(joueur1);
		plateau.ajouterJoueur(joueur2);
		
		// Création des cartes
		
		
	}

}
