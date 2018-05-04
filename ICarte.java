
public class ICarte {
	//Membres
	String nom;
	int cout;
	//Constructeur
	ICarte (String nom, int cout)
	{
		this.nom=nom;
		this.cout=cout;
	}
	//setters et getters
	public void setNom(String nom)
	{
		this.nom=nom;
	}
	public String getNom()
	{
		return this.nom;
	}
	public void setCout(int cout)
	{
		this.cout=cout;
	}
	public int getCout()
	{
		return this.cout;
	}
}
