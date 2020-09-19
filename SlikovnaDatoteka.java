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