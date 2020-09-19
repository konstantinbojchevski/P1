
import java.util.*;

public class Clanek {

    private List<Avtor> avtorji;
    private String naslov;
    private int leto;

    public Clanek(List<Avtor> avtorji, String naslov, int leto) {
        this.avtorji = avtorji;
        this.naslov = naslov;
        this.leto = leto;
    }

    @Override
    public String toString() {
        String strAvtorji = this.avtorji.toString();
        return String.format("%s: %s (%d)",
                strAvtorji.substring(1, strAvtorji.length() - 1), this.naslov, this.leto);
    }
	
	public static class primerjalnik implements Comparator<Clanek> {
		@Override
		public int compare(Clanek prvi, Clanek drugi){
			if(prvi.leto == drugi.leto)
					return (prvi.naslov.compareTo(drugi.naslov));
			return (drugi.leto - prvi.leto);
		}
	}
	
	public List<Avtor> vrniAvtorje(){
		return this.avtorji;
	}
}
