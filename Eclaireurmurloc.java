package ICarte;


import IJoueur.Heros;
import IJoueur.IJoueur;
import ICarte.Serviteur;


public class Eclaireurmurloc extends Serviteur implements ICarte  {
	public Eclaireurmurloc ()
	{
		super(1,0,"Eclaireur Murloc",1);
	}
	
	public void executerEffetDebutTour(Object cible) {

	}

	public void executerEffetFinTour() {

	}

	public void executerAction(Object cible) {
		if (cible instanceof Serviteur) {
			((Serviteur) cible)
					.setPointDeVie(((Serviteur) cible).PointDeVie - 1);
		} else if (cible instanceof Heros) {
			((Heros) cible).setPointDeVie(((Heros) cible).PointDeVie - 1);
		}
	}

	public void executerEffetMiseEnJeu() {
		IJoueur proprietaire = this.getProprietaire();
		proprietaire.getJeu().add(ChasseMareeMurloc);

	}

	public void executerEffetDisparition(Object cible) {

	}

	public boolean disparait() {
		if (this.PointDeVie == 0) {
			return true;
		} else {
			return false;
		}
	}

	public IJoueur getProprietaire() {
		// TODO Auto-generated method stub
		return ;
	}

	@Override
	public void executerEffetMiseEnJeu(Object cible) {
		// TODO Auto-generated method stub
		
	}
}
