package ICapacite;

import Exception.HearthstoneException;

public class Charge implements ICapacite {
   
	private String nom; 
	private String description;
	
	public Charge(String nom, String Description) {
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
	
}
@Override
public void executerEffetMiseEnJeu(Object cible) throws HearthstoneException {
	((ICarte.Serviteur) cible).setPeutattaquer(true);	
}
@Override
public void executerEffetDisparition(Object cible) throws HearthstoneException {
	// TODO Auto-generated method stub
	
} 

}