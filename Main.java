package main;

import java.util.Scanner;

import Exception.HearthstoneException;
import IJoueur.*;
import ICarte.*;
import IPlateau.*;
import ICapacite.*;

public class Main {
	public static void main(String[] args) throws HearthstoneException {
		// Creation du plateau
		Plateau plateau = Plateau.getInstance();

		// Creation des capacités
		
		ICapacite charge = (ICapacite) new Charge();
		ICapacite attaquemental = (ICapacite) new AttaqueDuHero("Attaque mentale", "Inflige 5 points de dégat au héros",
				5);
		ICapacite bonusdehurlevent = (ICapacite) new EffetPermanent("Bonus de hurlevent",
				"Effet permanent sur les autres serviteurs alliés donnant un bonus de 1/1", 1, 1);
		ICapacite bonusduchefderaid = (ICapacite) new EffetPermanent("Bonus du chef de raid",
				"Ajoute 1/0 au serviteur allié ", 1, 0);
		ICapacite provocation = (ICapacite) new Provocation();
		ICapacite attaquedulepreux = (ICapacite) new AttaqueDuHero("Attaque du lépreux",
				"Inflige 2 ServiteurPoint de dégats au héros", 2);
		ICapacite attaquemassive = (ICapacite) new AttaqueTotal("Attaque Massive ",
				"Inflige 4 points de dégats à tous les serviteurs adverses", 4);
		ICapacite attaquedugivre = (ICapacite) new AttaqueCible("Attaque du givre",
				"Inflige 3 points de dégats au personnage ciblé", 3);
		ICapacite intelligencedesarcanes = (ICapacite) new Piocher("Intelligence des arcanes", "Pioche deux cartes", 2);
		ICapacite explosionpyrotechnique = (ICapacite) new AttaqueCible("Explosion pyrotechnique",
				"Inflige de 10 points de dégats au personnage ciblé", 10);
		ICapacite busardaffame = (ICapacite) new Piocher("Busard affamé", " Pioche une carte", 1);
		ICapacite marqueduchasseur = (ICapacite) new MarqueduChasseur();
		ICapacite tirdesarcanes = (ICapacite) new AttaqueCible("Tir des arcanes",
				"Inflige deux points de dégats au personnage", 2);
		ICapacite ordredetuer = (ICapacite) new AttaqueCible("Ordre de tuer",
				"Inflige 3 points de dégats au personnage ciblé", 3);
		ICapacite bouledefeu = (ICapacite) new AttaqueCible("Boule de feu",
				" Inflige 1 point de dégat au personnage ciblé", 1);
		ICapacite attaquetot = (ICapacite) new AttaqueTotal("Cri de guerre", "tous les serviteurs prennent cher", 2);

		// Creation des héros
		Heros rexxar = new Heros("Rexxar", attaquetot);
		Heros jayna = new Heros("Jayna", bouledefeu);

		IJoueur joueur1 = new Joueur(rexxar, "nomavecrexxar");
		IJoueur joueur2 = new Joueur(jayna, "nomavecjayna");
		
		// Création des capacités d'invocation qui requierent un proprietaire
		ICapacite crideguerre_j1 = (ICapacite) new InvocationServiteur("Cri de guerre", "Invocation d'un serviteur", 1, 1,
				"Murloc",joueur1);
		ICapacite golemisation_j1 = (ICapacite) new InvocationServiteur("Golémisation",
				"Invoque un	Golem endommagé +2/+1 qui n'a aucune capacite", 2, 1, "Golem endomagé",joueur1);
		ICapacite lachezleschiens = (ICapacite) new InvocationChiens("Invocations des chiens",
				"Invoque des wouaf wouaf",joueur1);
		
		ICapacite crideguerre_j2 = (ICapacite) new InvocationServiteur("Cri de guerre", "Invocation d'un serviteur", 1, 1,
				"Murloc",joueur2);
		ICapacite golemisation_j2 = (ICapacite) new InvocationServiteur("Golémisation",
				"Invoque un	Golem endommagé +2/+1 qui n'a aucune capacite", 2, 1, "Golem endomagé",joueur2);
		ICapacite imagemirroir = (ICapacite) new ImageMiroir("Image miroir",
				"Invoque deux serviteurs de Jaina ayant 0/2 et provocation",joueur2);
		
		// Cartes du joueur 1
		ICarte Chassemareemurloc_j1 = new Serviteur("Chasse-marée murloc","Invocation d'un serviteur +1/+1", 1, 2, 2, crideguerre_j1, joueur1);
		ICarte Charge_j1 = new Sort("Charge","Charge", 1, charge, joueur1);
		ICarte Attaquementale_j1 = new Sort("Attaque mentale","Inflige 5 points de dégats aux héros", 2, attaquemental, joueur1);
		ICarte Championdehurlevent_j1 = new Serviteur("Champion de Hurlevent","Effet permanent sur les autres serviteurs alliés +1/0", 6, 7, 6, bonusdehurlevent, joueur1);
		ICarte Chefderaid_j1 = new Serviteur("Chef de raid","Effet permanent sur les autres serviteurs alliés +1/0", 2, 3, 2, bonusduchefderaid, joueur1);
		ICarte Gardedebaiedubutin_j1 = new Serviteur("Garde de Baie-Du-Butin","Provocation", 4, 5, 5, provocation, joueur1);
		ICarte Lamissillieretemeraire_j1 = new Serviteur("La missiliére téméraire","Charge", 2, 6, 5, charge, joueur1);
		ICarte Logremagi_j1 = new Serviteur("L'ogre-magi","Provocation", 4, 4, 4, provocation, joueur1);
		ICarte Archimage_j1 = new Serviteur("Archimage","Provocation", 7, 6, 4, provocation, joueur1);
		ICarte Gnomelepreux_j1 = new Serviteur("Gnome lépreux","Attaque	 du	 lépreux, inflige 2" ,1, 1, 1, attaquedulepreux, joueur1);
		ICarte Golemdesmoissons_j1 = new Serviteur("Golem des moissons","Invoque un	Golem endomagé +2/+1 qui n'a aucune	capacité", 3, 3, 2, golemisation_j1, joueur1);

		// Cartes de rexxar joueur 1
		ICarte Busardaffame = new Serviteur("Busard affamé","Pioche 1 carte", 2, 5, 3, busardaffame, joueur1);
		ICarte Marqueduchasseur = new Sort("Marque du chasseur","Abaisse à un point de vie le personnage ciblé", 1, marqueduchasseur, joueur1);
		ICarte Tirdesarcanes = new Sort("Tir des arcanes","Inflige 2 points de dégats au personnage", 1, tirdesarcanes, joueur1);
		ICarte Lachezleschiens = new Sort("Lachez les chiens", "Invocation de chiens",3, lachezleschiens, joueur1);
		ICarte Ordredetuer = new Sort("Ordre de tuer","Inflige 3 points de dégats au personnage ciblé", 3, ordredetuer, joueur1);

		// Cartes joueur 2
		ICarte Chassemareemurloc_j2 = new Serviteur("Chasse-marée murloc","Invocation d'un serviteur +1/+1 ", 1, 2, 2, crideguerre_j2, joueur2);
		ICarte Charge_j2 = new Sort("charge","Charge", 1, charge, joueur2);
		ICarte Attaquementale_j2 = new Sort("Attaque mentale","Inflige 5 points	de	dégâts	au	héros", 2, attaquemental, joueur2);
		ICarte Championdehurlevent_j2 = new Serviteur("Champion de Hurlevent","Effet permanent sur les autres serviteurs alliés donnant un bonus +1/+1", 6, 7, 6, bonusdehurlevent, joueur2);
		ICarte Chefderaid_j2 = new Serviteur("Chef de raid","Effet permanent sur les autres serviteurs alliés de +1/0", 2, 3, 2, bonusduchefderaid, joueur2);
		ICarte Gardedebaiedubutin_j2 = new Serviteur("Garde de Baie-Du-Butin","Provocation", 4, 5, 5, provocation, joueur2);
		ICarte Lamissillieretemeraire_j2 = new Serviteur("La missiliére téméraire","Charge", 2, 6, 5, charge, joueur2);
		ICarte Logremagi_j2 = new Serviteur("L'ogre-magi","Provocation", 4, 4, 4, provocation, joueur2);
		ICarte Archimage_j2 = new Serviteur("Archimage","Provocation", 7, 6, 4, provocation, joueur2);
		ICarte Gnomelepreux_j2 = new Serviteur("Gnome lépreux","Attaque	 du	 lépreux, inflige 2", 1, 1, 1, attaquedulepreux, joueur2);
		ICarte Golemdesmoissons_j2 = new Serviteur("Golem des moissons","Invoque un	Golem endomagé +2/+1 qui n'a aucune	capacité", 3, 3, 2, golemisation_j2, joueur2);

		// Cartes jayna joueur 2
		ICarte Chocdeflamme = new Sort("Choc de flamme","Inflige 4 points de dégats à tous les serviteurs adverse", 7, attaquemassive, joueur2);
		ICarte Eclairdegivre = new Sort("Eclair de givre","Inflige 3 points de dégats au personnage ciblé", 2, attaquedugivre, joueur2);
		ICarte Intelligencedesarcanes = new Sort("Intelligence des arcanes","Pioche 2 cartes", 2, intelligencedesarcanes, joueur2);
		ICarte Explosionpyrotechnique = new Sort("Explosion pyrotechnique","Inflige 10 points de dégats au personnages ciblé", 10, explosionpyrotechnique, joueur2);
		ICarte Imagemirroir = new Sort("Image mirroir","Invoque 2 serviteurs de Jayna ayant 0/+2 avec provocation", 1, imagemirroir, joueur2);

		try {
			joueur1.ajoutercarte(Chassemareemurloc_j1);
			joueur1.ajoutercarte(Charge_j1);
			joueur1.ajoutercarte(Attaquementale_j1);
			joueur1.ajoutercarte(Championdehurlevent_j1);
			joueur1.ajoutercarte(Chefderaid_j1);
			joueur1.ajoutercarte(Gardedebaiedubutin_j1);
			joueur1.ajoutercarte(Lamissillieretemeraire_j1);
			joueur1.ajoutercarte(Logremagi_j1);
			joueur1.ajoutercarte(Archimage_j1);
			joueur1.ajoutercarte(Gnomelepreux_j1);
			joueur1.ajoutercarte(Golemdesmoissons_j1);
			joueur1.ajoutercarte(Busardaffame);
			joueur1.ajoutercarte(Marqueduchasseur);
			joueur1.ajoutercarte(Tirdesarcanes);
			joueur1.ajoutercarte(Lachezleschiens);
			joueur1.ajoutercarte(Ordredetuer);

			joueur2.ajoutercarte(Chassemareemurloc_j2);
			joueur2.ajoutercarte(Charge_j2);
			joueur2.ajoutercarte(Attaquementale_j2);
			joueur2.ajoutercarte(Championdehurlevent_j2);
			joueur2.ajoutercarte(Chefderaid_j2);
			joueur2.ajoutercarte(Gardedebaiedubutin_j2);
			joueur2.ajoutercarte(Lamissillieretemeraire_j2);
			joueur2.ajoutercarte(Logremagi_j2);
			joueur2.ajoutercarte(Archimage_j2);
			joueur2.ajoutercarte(Gnomelepreux_j2);
			joueur2.ajoutercarte(Golemdesmoissons_j2);
			joueur2.ajoutercarte(Chocdeflamme);
			joueur2.ajoutercarte(Eclairdegivre);
			joueur2.ajoutercarte(Intelligencedesarcanes);
			joueur2.ajoutercarte(Imagemirroir);
			joueur2.ajoutercarte(Explosionpyrotechnique);

		} catch (HearthstoneException e) {
			e.printStackTrace();
		}

		boolean error = false;
		do {
			Scanner scan = new Scanner(System.in);
			System.out.println("Saississez le nom du joueur avec Rexxar");
			String str = scan.nextLine();
			try {
				joueur1.setPseudo(str);
				error = true;
			} catch (HearthstoneException e) {
				e.printStackTrace();
			}
		} while (error != true);
		try {
			plateau.ajouterJoueur(joueur1);
		} catch (HearthstoneException e) {
			e.printStackTrace();
		}
		error = false;
		do {
			Scanner scan1 = new Scanner(System.in);
			System.out.println("Saississez le nom du joueur avec Jayna");
			String str1 = scan1.nextLine();
			try {
				joueur2.setPseudo(str1);
				error = true;
			} catch (HearthstoneException e) {
				e.printStackTrace();
			}

		} while (error != true);
		try {
			plateau.ajouterJoueur(joueur2);
		} catch (HearthstoneException e) {
			e.printStackTrace();
		}

		// On commence la partie
		try {
			plateau.demarrerPartie();
		} catch (HearthstoneException e) {
			e.printStackTrace();
		}

		int pdvj1 = 0;
		int pdvj2 = 0;
		int i = 0;
		joueur1 = plateau.getJoueurs().get(0);
		joueur2 = plateau.getJoueurs().get(1);

		do  {
			
			boolean erreur = false;
			pdvj1 = joueur1.getHeros().getPointdevie();
			pdvj2 = joueur2.getHeros().getPointdevie();

			if (i % 2 == 0) {
				plateau.setJoueurCourant(joueur1);
			} else {
				plateau.setJoueurCourant(joueur2);
			}

			IJoueur actif = plateau.getJoueurCourant();
			IJoueur dort = plateau.getAdversaire(actif);
			try {
				actif.prendreTour();
				plateau.cartesDisparaissent();
			} catch (HearthstoneException e) {
				e.printStackTrace();
			}
			int pos = actif.getMain().size();
			System.out.println("Vous avez pioché " + actif.getCarteMain(pos).toString() + ".\n");

			System.out.println("Vous avez " + actif.getStockMana() + " mana.\n" + "Vous avez " + actif.toStringmain()
					+ " en main.\n" + "Vous avez " + actif.toStringjeu() + " en jeu.\n" + "Votre adversaire a "
					+ dort.toStringjeu() + " en jeu.\n");
			
			do {
			// Le joueur choisi ce qu'il veut faire
			System.out.println("1.Voulez vous attaquer? \n" + "2.Voulez vous jouer une carte?\n"
					+ "3.Voulez vous utiliser la capacité spéciale de votre heros? \n"
					+ "4.Voulez vous passer votre tour?\n");
			Scanner sc = new Scanner(System.in);
			int k = sc.nextInt();
			switch (k) {
			case 1:
				System.out.println("Avec quelle carte voulez vous attaquer?" + actif.toStringjeu());
				Scanner carteutilise = new Scanner(System.in);
				int utilise = carteutilise.nextInt();

				System.out.println("Quelle carte voulez vous attaquer?" + "dort.toStringjeu()");
				Scanner carteattaque = new Scanner(System.in);
				int saisie = carteattaque.nextInt();

				try {
					actif.utiliserCarte(actif.getCarteJeu(utilise - 1), dort.getCarteJeu(saisie - 1));
					erreur = true;
				} catch (HearthstoneException e) {
					e.printStackTrace();
				}

				break;

			case 2:
				System.out.println("Quelle carte voulez vous jouer?" + actif.toStringmain());
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

			case 3:
				if (actif.getHeros().equals(jayna)) {
					System.out.println("Quelle carte voulez vous attaquer?\n" + dort.toStringjeu());
					Scanner herosutilise = new Scanner(System.in);
					int numero = herosutilise.nextInt();

					try {
						actif.utiliserPouvoir(dort.getCarteJeu(numero - 1));
						System.out.println("Votre heros a infligé 1 point de dégat à " + dort.getCarteJeu(numero - 1).toString() +"\n");
					} catch (HearthstoneException e) {
						e.printStackTrace();
					}
				} else {
					try {
						actif.utiliserPouvoir(dort);
						System.out.println("Rexxar a infligé 3 ");
					} catch (HearthstoneException e) {
						e.printStackTrace();
					}
				}
				break;
			case 4:
				System.out.println("Vous passez votre tour, " + "Vous avez " + actif.toStringmain() + " en main\n "
						+ "Vous avez " + actif.toStringjeu() + " en jeu\n " + "Votre adversaire a " + dort.toStringjeu()
						+ " en jeux\n");
				actif.finirTour();
				break;
			default:

			}
			}while (erreur != true);
			i++;

		}while((pdvj1 > 0) && (pdvj2 > 0));
		/*
		 * if ((pdvjoueur1 == 0) && (pdvjoueur2 == 0)) { plateau.gagnerPartie(joueur2);
		 * plateau.gagnerPartie(joueur1); } else if (pdvjoueur1 == 0){
		 * plateau.gagnerPartie(joueur2); } else { plateau.gagnerPartie(joueur1); }
		 */
	}

}
