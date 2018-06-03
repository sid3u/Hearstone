package ICapacite;

import Exception.HearthstoneException;
import ICarte.Serviteur;

public class MarqueduChasseur implements ICapacite {
   
	String nom; 
	String description;
	
	public MarqueduChasseur(String nom, String Description) {
    	setNom(nom);
    	setDescription(description);   	
    }
    
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

@Override
public void executerEffetDebutTour() throws HearthstoneException {
	// TODO Auto-generated method stub
	
}
@Override
public void executerEffetFinTour() throws HearthstoneException {
	// TODO Auto-generated method stub
	
}
@Override
public void executerAction(Object cible) throws HearthstoneException {
	((Serviteur) cible).setPointdevie(1);
}
@Override
public void executerEffetMiseEnJeu(Object cible) throws HearthstoneException {
	// TODO Auto-generated method stub
	
}
@Override
public void executerEffetDisparition(Object cible) throws HearthstoneException {
	// TODO Auto-generated method stub
	
} 

}
