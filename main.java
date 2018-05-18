package main;
import java.util.Scanner;

import Exception.HearthstoneException;
import IJoueur.*;
import ICarte.*;
import IPlateau.*;
import ICapacité.*;

public class main {
	public static void main(String[] args) {
		// Creation du plateau
		Plateau plateau = Plateau.getInstance();
		
		// Creation des capacités
		ICapacite crideguerre = (ICapacite) new CriDeGuerre();
		ICapacite bouledefeu = (ICapacite) new BouleDeFeu();
		ICapacite attaquementale = (ICapacite) new AttaqueMentale();
		
		// Creation des héros
		Heros rexxar = new Heros("Rexxar",crideguerre);
		Heros jayna = new Heros("Jayna",bouledefeu);
		
		// Creation des joueurs
		Joueur joueur1 = new Joueur(rexxar, "Vincent");
		Joueur joueur2 = new Joueur(jayna, "Nassym");
		
		// Ajout des joueurs dans le plateau
		plateau.ajouterJoueur(joueur1);
		plateau.ajouterJoueur(joueur2);
		
		// Création des cartes
		ICarte chassemareemurlocvincent = new Serviteur ("Chasse-marée murloc",1,2,2,crideguerre,joueur1);
		ICarte chassemareemurlocnassym = new Serviteur ("Chasse-marée murloc",1,2,2,crideguerre,joueur2);
		
		
		//ajout des cartes dans le deck des joueurs
		try {
			joueur1.ajoutercarte(chassemareemurlocvincent);
		} catch (HearthstoneException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			joueur2.ajoutercarte(chassemareemurlocnassym);
		} catch (HearthstoneException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// On commence la partie
		plateau.demarrerPartie();
		
		for (int i =0;i<=10;i++)
		{
			for (int j=0;j<=1;j++)
			{
				if (j==0)
				{
					plateau.setJoueurCourant(joueur1);
				}
				else
				{
					plateau.setJoueurCourant(joueur2);
				}
				IJoueur actif = plateau.getJoueurCourant();
				IJoueur dort = plateau.getAdversaire(actif);
				System.out.println( "Vous avez" + actif.getStockMana() + "mana\n"+
									"Vous avez "+actif.toStringmain()+" en main\n" +
									"Vous avez "+actif.toStringjeu()+" en jeu\n" +
									"Votre adversaire a "+dort.toStringjeu()+" en jeux\n");
				actif.prendreTour();
				Scanner sc = new Scanner(System.in);
				int k = sc.nextInt();
				
				switch (k)
				{
				  case 1:
						  System.out.println("Avec quelle carte voulez vous attaquer?" +
						  					 actif.toStringjeu());
						  Scanner carteutilise = new Scanner(System.in);
						  int utilise = carteutilise.nextInt();
						  
						  System.out.println("Quelle carte voulez vous attaquer?" +
						  					 "dort.toStringjeu()");
						  Scanner carteattaque = new Scanner(System.in);
						  int saisie = carteattaque.nextInt();
						  
						  try {
							actif.utiliserCarte(actif.getCarteJeu(utilise-1), dort.getCarteJeu(saisie-1));
						  } catch (HearthstoneException e) {
							e.printStackTrace();
						  }

				    break;      
				    
				  case 3:
					  		System.out.println("Quelle carte voulez vous jouer?" +
					  							actif.toStringmain());
					  		Scanner cartejouer = new Scanner(System.in);
					  		int jouer = cartejouer.nextInt();
					  		
							ICarte carteajouer;
							try {
								carteajouer = actif.getCarteMain(jouer);
								actif.jouerCarte(carteajouer);
							} catch (HearthstoneException e) {
								e.printStackTrace();
							}
					break;
					
				  case 4: 
					  		actif.pioche();
					break;
				  default:

				    ;             

				}
				
			}
		}
		
		
	}
}
