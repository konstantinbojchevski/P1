public class Pismo{
	Posta izvorna;
	Posta ciljna;
	public static int enotaRazdalje1;
	public static int enotaCene1;
	public static int priporocnina1;

	private boolean priporoceno;
	private int razdajla;
	private char vrsta;
	
	public Pismo(Posta izvorna, Posta ciljna, boolean jePriporoceno, int razdajla){
		this.izvorna=izvorna;
		this.ciljna=ciljna;
		this.priporoceno=jePriporoceno;
		this.razdajla=razdajla;
	}
	public String toString(){
		char c;
		if(this.priporoceno) c = 'P';
		else c = 'N';
		return String.format("%s -> %s (%d km) [%c]", this.izvorna, 
		this.ciljna, this.razdajla, c);
	}
	public boolean izviraOd(Posta posta){
		return(this.izvorna.equals(posta));
	}
	public boolean staIzvorInCiljIsta(){
		return(this.izvorna==this.ciljna);
	}
	public boolean imaIstiCiljKot(Pismo pismo){
		return (this.ciljna==pismo.ciljna);
	}
	public static boolean imataIstiCilj(Pismo p1, Pismo p2){
		return (p1.ciljna==p2.ciljna);
	}
	public int cena(){
			int cena = (int) (Math.ceil(this.razdajla/enotaRazdalje1)+1)*enotaCene1;
			if(this.priporoceno) cena += priporocnina1;
			return cena;
		}
	public static void nastaviKonstanteZaCeno(int enotaRazdalje, int enotaCene, int priporocnina){
		enotaRazdalje1=enotaRazdalje;
		enotaCene1=enotaCene;
		priporocnina1=priporocnina;
	}
	public boolean jeDrazjeOd(Pismo pismo){
		if(this.cena() > pismo.cena()) return true;
		else return false;
	}
	public static Pismo vrniDrazje(Pismo p1, Pismo p2){
		if(p1.cena() > p2.cena()) return p1;
		else return p2;
	}
	public Pismo izdelajPovratno(){
		Pismo vrati = new Pismo(this.ciljna, this.izvorna, this.priporoceno, this.razdajla);
		return vrati;
	}
}