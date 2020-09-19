import java.util.*;
public abstract class Datoteka{
	protected String ime;
	public Datoteka(String ime){
		this.ime=ime;
	}
	public String vrniIme(){
		return this.ime;
	}
	public abstract int velikost();
	public String toString(){
		return String.format("%s [%s]", this.vrniIme(), this.opis());
	}
	public abstract String opis();
	
	public class BesedilnaDatoteka extends Datoteka{
		private int stZnakov;
		
		public BesedilnaDatoteka(String ime, int stZnakov){
			super(ime);
			this.stZnakov=stZnakov;
		}
		@Override
		public int velikost(){
			return this.stZnakov;
		}
		public String opis(){
			return String.format("b %d", this.stZnakov);
		}
	}
	
	public class SlikovnaDatoteka extends Datoteka{
		
		private int sirina;
		private int visina;
		public SlikovnaDatoteka(String ime, int sirina, int visina){
			super(ime);
			this.sirina=sirina;
			this.visina=visina;
		}
		public int velikost(){
			return (3*this.sirina*this.visina+54);
		}
		public String opis(){
			return String.format("s %d x %d", this.sirina, this.visina);
		}
		public boolean jevelikaVsaj(int prag){
			if(this.sirina >= prag && this.visina >= prag)
				return true;
			return false;
		}
	}
	
	public class Imenik extends Datoteka{
		private Datoteka[] datoteke;
		public Imenik(String ime, Datoteka[] datoteke){
			super(ime);
			this.datoteke=datoteke;
		}
		public int velikost(){
			int sum=256;
			for(int i=0;i<this.datoteke.length;i++){
				sum+=this.datoteke[i].velikost();
			}
			return sum;
		}
		public String opis(){
			return String.format("i %d", this.datoteke.length);
		}
		public int steviloVecjihSlik(int prag){
			int stevec=0;
			for(Datoteka datoteka:this.datoteke){
				if(datoteka instanceof SlikovnaDatoteka){
					SlikovnaDatoteka slikovna=(SlikovnaDatoteka) datoteka;
					if(slikovna.jevelikaVsaj(prag)){
						stevec++;
					}
				}
			}
			return stevec;
		}
			public String poisci(String ime) {
		return this.poisci(".", ime);
	}
	
	// pot: relativna pot od imenika, nad katerim se je poklicala metoda
	// poisci(ime), do imenika this
	public String poisci(String pot, String ime) {
		// išči neposredno v imeniku <this>
		for (Datoteka datoteka: this.datoteke) {
			if (datoteka.vrniIme().equals(ime)) {
				// datoteko smo našli!
				return (pot + "/" + ime);
			}
		}
		
		// datoteke nismo našli neposredno v imeniku,
		// zato rekurzivno preiščemo podimenike
		for (Datoteka datoteka: this.datoteke) {
			if (datoteka instanceof Imenik) {
				Imenik imenik = (Imenik) datoteka;
				String rezultat = imenik.poisci(pot + "/" + imenik.vrniIme(), ime);
				if (rezultat != null) {
					// datoteko smo našli!
					return rezultat;
				}
			}
		}
		
		// datoteke nismo našli niti neposredno v imeniku niti v podimenikih,
		// zato vemo, da je ni
		return null;
	}
}
		
	}
}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	