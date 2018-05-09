package IJoueur;

import ICapacité.ICapacite;


public class Heros {
	public int PointDeVie;
	String nom;
	ICapacite pouvoir;
	
	public Heros(String nom,ICapacite pouvoir)
	{
		this.setPointDeVie(15);
		this.setNom(nom);
		this.setPouvoir(pouvoir);
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public ICapacite getPouvoir() {
		return pouvoir;
	}

	public void setPouvoir(ICapacite pouvoir) {
		this.pouvoir = pouvoir;
	}

	public void setPointDeVie( int pdv )
	{
		this.PointDeVie = pdv;
	}
	
	public int getPointDeVie()
	{
		return this.PointDeVie;
	}
}
