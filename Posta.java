	public class Posta{
	protected int postnaStevilka;
	protected String naziv;
	
	public Posta(int stevilka, String naziv){
		this.postnaStevilka=stevilka;
		this.naziv=naziv;
	}
	public int vrniStevilko(){   	//getter!
		return this.postnaStevilka;
	}
	public String vrniNaziv(){
		return this.naziv;
	}
	public String toString(){
		return String.format("%d %s", this.postnaStevilka, this.naziv);
	}
}