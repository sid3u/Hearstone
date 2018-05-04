
public class Jayna extends Heros {
	String nom;
	ICapacite pouvoir;
	
	public Jayna ()
	{
		this.setNom("Jayna");
		this.setPouvoir(new BouleDeFeu());
	}
	
	public String getNom()
	{
		return this.nom;
	}
	
	public void setNom(String nom)
	{
		this.nom=nom;
	}
	
	public ICapacite getPouvoir()
	{
		return this.pouvoir;
	}
	
	public void setPouvoir(ICapacite pouvoir)
	{
		this.pouvoir=pouvoir;
	}
	
	
}
