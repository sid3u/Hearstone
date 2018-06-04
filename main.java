package main;

import java.util.Scanner;

import Exception.HearthstoneException;
import IJoueur.*;
import ICarte.*;
import IPlateau.*;
import ICapacite.*;

public class main {

	public static void main() {
		// Creation du plateau
		Plateau plateau = Plateau.getInstance();

		// Creation des capacités
		ICapacite crideguerre = (ICapacite) new InvocationServiteur("Cri de guerre","Invocation d'un serviteur", 1,1, "Murloc");
		ICapacite charge = (ICapacite) new Charge();
		ICapacite attaquemental = (ICapacite) new AttaqueDuHero("Attaque mentale","Inflige 5 points de d�gat au h�ros", 5);
		ICapacite bonusdehurlevent = (ICapacite) new EffetPermanent("Bonus de hurlevent","Effet permanent sur les autres serviteurs alli�s donnant un bonus de 1/1",1,1);
		ICapacite bonusduchefderaid = (ICapacite) new EffetPermanent("Bonus du chef de raid","Ajoute 1/0 au serviteur alli� ",1,0);
		ICapacite provocation = (ICapacite) new Provocation();
		ICapacite attaquedulepreux = (ICapacite) new AttaqueDuHero("Attaque du l�preux","Inflige 2 ServiteurPoint de d�gats au h�ros", 2);
		ICapacite golemisation = (ICapacite) new InvocationServiteur("Gol�misation","Invoque un	Golem endomag� +2/+1 qui n'a aucune	capacite",2,1,"Golem endomag�");
		ICapacite attaquemassive = (ICapacite) new AttaqueTotal("Attaque Massive ","Inflige 4 points de d�gats � tous les serviteurs adverses",4);
		ICapacite attaquedugivre = (ICapacite) new AttaqueCible("Attaque du givre","Inflige 3 points de d�gats au personnage cibl�", 3);
		ICapacite intelligencedesarcanes = (ICapacite) new Piocher("Intelligence des arcanes","Pioche deux cartes",2);
		ICapacite imagemirroir = (ICapacite) new ImageMiroir("Image miroir","Invoque deux serviteurs de Jaina ayant 0/2 et provocation");
		ICapacite explosionpyrotechnique = (ICapacite) new AttaqueCible("Explosion pyrotechnique","Inflige de 10 points de d�gats au personnage cibl�",10);
		ICapacite busardaffame = (ICapacite) new Piocher("Busard affam�", " Pioche une carte",1);
		ICapacite marqueduchasseur = (ICapacite) new MarqueduChasseur();
		ICapacite tirdesarcanes = (ICapacite) new AttaqueCible("Tir des arcanes","Inflige deux points de g�dats au personnage",2);
		ICapacite lachezleschiens = (ICapacite) new InvocationChiens("Invocations des chiens", "Invoque des wouaf wouaf");
		ICapacite ordredetuer = (ICapacite) new AttaqueCible("Ordre de tuer","Inflige 3 points de d�gars au personnage cibl�",3);
		ICapacite bouledefeu = (ICapacite) new AttaqueCible("Boule de feu", " Inflige 1 point de d�gat au personnage cibl�", 1);
		ICapacite rex = (ICapacite) new AttaqueTotal("Cri de guerre","tous les serviteurs prennent cher",2);
		
		// Creation des héros 
				Heros rexxar = new Heros("Rexxar", rex);
				Heros jayna = new Heros("Jayna", bouledefeu);
				
				int k,j;
				while (plateau.estDemarree() == false)
				{
					System.out.println("1-Voulez-vous ajouter un joueur avec rexxar? ");
			
					System.out.println("2-Voulez vous démarrer la partie?");
					switch (k) {
					case 1:
						
						Scanner scan = new Scanner(System.in);
						System.out.println("Saississez votre nom");
					    String str = scan.nextLine();
					    
					    System.out.println("1-Rexxar ou 2-Jayna?");
					    
					    switch (l){
					    case 1 :
					    	IJoueur joueur1 = new Joueur(rexxar,str);
					    	plateau.ajouterJoueur(joueur1);
					    	
					    	break;
					    case 2 :	
					    	IJoueur joueur2 = new Joueur(rexxar,str);
					    	plateau.ajouterJoueur(joueur2);
					    	
					 
					    	break:
					
					}
					
					
					
					
					
					
				}
				// Ajout des joueurs dans le plateau
				plateau.ajouterJoueur(joueur1);
				plateau.ajouterJoueur(joueur2);
		// Creation des cartes neutre du joueur 1

	    ICarte Chassemareemurloc_j1 = new Serviteur("Chasse-mar�e murloc",1,2,2, crideguerre,joueur1);
	    ICarte Charge_j1 = new Sort("charge",1,charge,joueur1);
	    ICarte Attaquementale_j1 = new Sort("Attaque mentale", 2, attaquemental,joueur1);
	    ICarte Championdehurlevent_j1 = new Serviteur("Champion de Hurlevent",6,7,6, bonusdehurlevent,joueur1);
	    ICarte Chefderaid_j1 = new Serviteur("Chef de raid", 2,3,2, bonusduchefderaid,joueur1);
	    ICarte Gardedebaiedubutin_j1 = new Serviteur("Garde de Baie-Du-Butin", 4, 5,5, provocation,joueur1);
	    ICarte Lamissillieretemeraire_j1 = new Serviteur("La missili�re t�m�raire", 2,6,5, charge,joueur1);
	    ICarte Logremagi_j1 = new Serviteur("L'ogre-magi",4,4,4,provocation,joueur1);
	    ICarte Archimage_j1 = new Serviteur("Archimage",7,6,4,provocation,joueur1);
	    ICarte Gnomelepreux_j1 = new Serviteur("Gnome l�preux", 1,1,1, attaquedulepreux,joueur1);
	    ICarte Golemdesmoissons_j1 = new Serviteur("Golem des moissons", 3,3,2, golemisation,joueur1);
	    
	    // Creation des cartes neutres du joueur 2
	    ICarte Chassemareemurloc_j2 = new Serviteur("Chasse-mar�e murloc",1,2,2, crideguerre,joueur2);
	    ICarte Charge_j2 = new Sort("charge",1,charge,joueur2);
	    ICarte Attaquementale_j2 = new Sort("Attaque mentale", 2, attaquemental,joueur2);
	    ICarte Championdehurlevent_j2 = new Serviteur("Champion de Hurlevent",6,7,6, bonusdehurlevent,joueur2);
	    ICarte Chefderaid_j2 = new Serviteur("Chef de raid", 2,3,2, bonusduchefderaid,joueur2);
	    ICarte Gardedebaiedubutin_j2 = new Serviteur("Garde de Baie-Du-Butin", 4, 5,5, provocation,joueur2);
	    ICarte Lamissillieretemeraire_j2 = new Serviteur("La missili�re t�m�raire", 2,6,5, charge,joueur2);
	    ICarte Logremagi_j2 = new Serviteur("L'ogre-magi",4,4,4,provocation,joueur2);
	    ICarte Archimage_j2 = new Serviteur("Archimage",7,6,4,provocation,joueur2);
	    ICarte Gnomelepreux_j2 = new Serviteur("Gnome l�preux", 1,1,1, attaquedulepreux,joueur2);
	    ICarte Golemdesmoissons_j2 = new Serviteur("Golem des moissons", 3,3,2, golemisation,joueur2);
	    
	    // Creations des cartes de Jaina 
	    
	    ICarte Chocdeflamme = new Sort("Choc de flamme",7,attaquemassive);
	    ICarte Eclairdegivre = new Sort("Eclair de givre", 2, attaquedugivre);
	    ICarte Intelligencedesarcanes = new Sort("Intelligence des arcanes", 2, intelligencedesarcanes);
	    ICarte Explosionpyrotechnique = new Sort("Explosion pyrotechnique", 10, explosionpyrotechnique);
	 //   ICarte Imagemirroir = new Sort("Image mirroir", 1, imagemirroir);
	   
	    //Creation des cartes de Rexxar
	    
	    ICarte Busardaffame = new Serviteur("Busard affam�",2,5,3, busardaffame);
	    ICarte Marqueduchasseur = new Sort("Marque du chasseur", 1, marqueduchasseur);
	    ICarte Tirdesarcanes = new Sort("Tir des arcanes", 1, tirdesarcanes);
	 //   ICarte Lachezleschiens = new Sort("L�chez les chiens", 3, lachezleschiens);
	    ICarte Ordredetuer = new Sort("Ordre de tuer", 3, ordredetuer);
	    

		// ajout des cartes dans le deck des joueurs
		try {
			joueur1.ajoutercarte(Chassemareemurloc);
			joueur1.ajoutercarte(Charge);
			joueur1.ajoutercarte(Attaquementale);
			joueur1.ajoutercarte(Championdehurlevent);
			joueur1.ajoutercarte(Chefderaid);
			joueur1.ajoutercarte(Gardedebaiedubutin);
			joueur1.ajoutercarte(Lamissillieretemeraire);
			joueur1.ajoutercarte(Logremagi);
			joueur1.ajoutercarte(Archimage);
			joueur1.ajoutercarte(Gnomelepreux);
			joueur1.ajoutercarte(Golemdesmoissons);
			joueur1.ajoutercarte(Chocdeflamme);
			joueur1.ajoutercarte(Eclairdegivre);
			joueur1.ajoutercarte(Intelligencedesarcanes);
		//	joueur1.ajoutercarte(Imagemirroir);
			joueur1.ajoutercarte(Explosionpyrotechnique);
		
			
			joueur2.ajoutercarte(Chassemareemurloc);
			joueur2.ajoutercarte(Charge);
			joueur2.ajoutercarte(Attaquementale);
			joueur2.ajoutercarte(Championdehurlevent);
			joueur2.ajoutercarte(Chefderaid);
			joueur2.ajoutercarte(Gardedebaiedubutin);
			joueur2.ajoutercarte(Lamissillieretemeraire);
			joueur2.ajoutercarte(Logremagi);
			joueur2.ajoutercarte(Archimage);
			joueur2.ajoutercarte(Gnomelepreux);
			joueur2.ajoutercarte(Golemdesmoissons);
			joueur2.ajoutercarte(Busardaffame);
			joueur2.ajoutercarte(Marqueduchasseur);
			joueur2.ajoutercarte(Tirdesarcanes);
	//		joueur2.ajoutercarte(Lachezleschiens);
			joueur2.ajoutercarte(Ordredetuer);
			
			
			
		} catch (HearthstoneException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		// On commence la partie
		plateau.demarrerPartie();
		
		int pdvjoueur1 = plateau.getJoueur1().getHeros().getPointdevie();
		int pdvjoueur2 = plateau.getJoueur2().getHeros().getPointdevie();
		int i = 0;
		
			 while ((pdvjoueur1 >=  0) && (pdvjoueur2 >=0)){
				if (i %2 == 0) {
					plateau.setJoueurCourant(joueur1);
				} else {
					plateau.setJoueurCourant(joueur2);
				}
				
				IJoueur actif = plateau.getJoueurCourant();
				IJoueur dort = plateau.getAdversaire(actif);
				
				actif.pioche();
				int pos = actif.getMain().size();
				System.out.println("Vous avez pioché"
						+ actif.getCarteMain(pos).toString());
				
				System.out.println("Vous avez " + actif.getStockMana()
						+ " mana\n" + "Vous avez " + actif.toStringmain()
						+ " en main\n" + "Vous avez " + actif.toStringjeu()
						+ " en jeu\n" + "Votre adversaire a "
						+ dort.toStringjeu() + " en jeux\n");
				actif.prendreTour();
				Scanner sc = new Scanner(System.in);
				int k = sc.nextInt();
				/*
				System.out.println("1.Voulez vous attaquer? \n"
						+ "2.Voulez vous utiliser la capacité spéciale de votre heros? \n" + "3.Voulez vous jouer une carte?\n"
						+ "4.Voulez vous piocher?\n" + "5.Voulez vous passer votre tour?\n");
 */
				switch (k) {
				case 1:
					System.out
							.println("Avec quelle carte voulez vous attaquer?"
									+ actif.toStringjeu());
					Scanner carteutilise = new Scanner(System.in);
					int utilise = carteutilise.nextInt();

					System.out.println("Quelle carte voulez vous attaquer?"
							+ "dort.toStringjeu()");
					Scanner carteattaque = new Scanner(System.in);
					int saisie = carteattaque.nextInt();

					try {
						actif.utiliserCarte(actif.getCarteJeu(utilise - 1),
								dort.getCarteJeu(saisie - 1));
					} catch (HearthstoneException e) {
						e.printStackTrace();
					}

					break;

				case 2:
					System.out.println("Quelle carte voulez vous jouer?"
							+ actif.toStringmain());
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
					
					
					
				default:


				}

			}
			if ((pdvjoueur1 == 0) && (pdvjoueur2 == 0))
			{
				plateau.gagnerPartie(joueur2);
				plateau.gagnerPartie(joueur1);
			}
			else if (pdvjoueur1 == 0){
				plateau.gagnerPartie(joueur2);
			}
			else
			{
				plateau.gagnerPartie(joueur1);
			}
		}

	}
}
