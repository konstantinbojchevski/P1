
public class Oseba {

    private String ime;
    private String priimek;
    private char spol;
    private int letoRojstva;
    private Oseba oce;
    private Oseba mati;

    // števec ustvarjenih oseb
    private static int stUstvarjenih = 0;

    /* Ustvari osebo s podanim imenom, priimkom, spolom, letom rojstva, očetom
     * in materjo. */
    public Oseba(String ime, String priimek, char spol, int letoRojstva, Oseba oce, Oseba mati) {
        this.ime = ime;
        this.priimek = priimek;
        this.spol = spol;
        this.letoRojstva = letoRojstva;
        this.oce = oce;
        this.mati = mati;
        stUstvarjenih++;
    }

    /* Vrne ime osebe <this>. */
    public String vrniIme() {
        return this.ime;
    }

    /* Vrne predstavitev osebe <this> v obliki niza. */
    public String toString() {
        return String.format("%s %s (%c), %d", 
                this.ime, this.priimek, this.spol, this.letoRojstva);
    }

    /* Vrne starost osebe v podanem letu. */
    public int starost(int leto) {
        return (leto - this.letoRojstva);
    }

    /* Vrne <true> natanko v primeru, če je oseba <this> starejša od osebe
     * <os>. */
    public boolean jeStarejsaOd(Oseba os) {
        if (this.letoRojstva < os.letoRojstva) {
            return true;
        } else {
            return false;
        }
        // krajše: return (this.letoRojstva < os.letoRojstva);
        // ali: return (this.starost(0) > os.starost(0));
    }

    /* Vrne ime očeta osebe <this> oziroma <null>, če oče ni znan. */
    public String imeOceta() {
        if (this.oce == null) {
            return null;
        }
        return this.oce.ime;
    }

    /* Vrne <true> natanko v primeru, če je oseba <this> brat ali sestra osebe
     * <os>. */
    public boolean jeBratAliSestraOd(Oseba os) {
        return (this != os && this.oce != null && this.mati != null &&
                this.oce == os.oce && this.mati == os.mati);
    }

    /* Vrne <true> natanko v primeru, če je oseba <this> sestra osebe <os>. */
    public boolean jeSestraOd(Oseba os) {
        return (this.jeBratAliSestraOd(os) && this.spol == 'Z');
    }

    /* Vrne <true> natanko v primeru, če je oseba <this> teta osebe <os>. */
    public boolean jeTetaOd(Oseba os) {
        return (os.oce != null && this.jeSestraOd(os.oce) || 
                os.mati != null && this.jeSestraOd(os.mati));
    }

    /* Vrne <true> natanko v primeru, če je oseba <this> očetovski prednik osebe <os>. */
    public boolean jeOcetovskiPrednikOd(Oseba os) {
        Oseba p = os.oce;
        while (p != null && p != this) {
            p = p.oce;
        }
        return (p == this);
    }

    /* Vrne število doslej ustvarjenih oseb. */
    public static int steviloUstvarjenih() {
        return stUstvarjenih;
    }

    public int ocetovskaGeneracijskaRazlika(Oseba os) {
		int stevec = 0;
		if(jeOcetovskiPrednikOd(os)){
			Oseba p = os.oce;
			stevec = 1;
			while(p != null && p != this){
				p = p.oce;
				stevec++;
			}
			if(p != this) throw new IllegalArgumentException();
		}
		else{
			Oseba p = this.oce;
			if(this == os) stevec = 0;
			else{
				stevec = -1;
				while(p != null && p != os){
					p = p.oce;
					stevec--;
				}
			if(p != os) throw new IllegalArgumentException();
			}
		}
        return stevec;
    }

    public boolean jePrednikOd(Oseba os) {
		
		if(this == os) return true;
		else{
			os = os.oce;
			return (os.oce == this || os.mati == this);
			os = os.mati;
			return (os.oce == this || os.mati == this);
		}
		
		
		/*if(os == this) return true;
		Oseba p = os.oce;
		Oseba s = os.mati;
		while(p != this || s != this || p != null || s != null){
			p = p.oce;
			s = s.mati;
		}*/
		//if(p != null||s != null) 
			//return(this == p || this == s);
	}

   /* public void nastejPrednike() {
		Oseba os = this;
		if(os.oce == null && os.mati == null){
			return;
		}
		else{
			System.out.println(os.toString());
			this = this.oce;
			this.nastejPrednike();
			os = os.mati;
			if(os != null) os.nastejPrednike();
		}
    }
*/
    public boolean jeSorodnikOd(Oseba os) {
        // popravite / dopolnite ...
        return false;
    }
}
