
import java.util.*;

public class Avtor implements Comparable<Avtor> {

    private String ime;
    private String priimek;

    public Avtor(String ime, String priimek) {
        this.ime = ime;
        this.priimek = priimek;
    }

    @Override
    public String toString() {
        return (this.ime + " " + this.priimek);
    }
	
	@Override
	public int compareTo(Avtor drugi) {
		if (!this.priimek.equals(drugi.priimek)) {
			return this.priimek.compareTo(drugi.priimek);
		}
		return this.ime.compareTo(drugi.ime);
	}
}
