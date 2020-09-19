
import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * Objekt tega razreda predstavlja vektor z elementi tipa Object.  Vektor je
 * vsebovalnik, ki se obna"sa kot ">raztegljiva"< tabela.
 */
public class Vektor implements Iterable {

    private static class IteratorCezVektor implements Iterator {
        private Vektor vektor;
        private int indeks;

        public IteratorCezVektor(Vektor vektor) {
            this.vektor = vektor;
            this.indeks = 0;
        }

        @Override
        public boolean hasNext() {
            return (this.indeks < this.vektor.steviloElementov());
        }

        @Override
        public Object next() {
            if (this.indeks >= this.vektor.steviloElementov()) {
                throw new NoSuchElementException();
            }
            return this.vektor.vrni(this.indeks++);
        }
    }

    // privzeta za"cetna kapaciteta vektorja
    private static final int ZACETNA_KAPACITETA = 10;

    // tabela elementov
    private Object[] elementi;

    // dejansko "stevilo elementov (<= elementi.length)
    private int stElementov;

    /*
     * Ustvari objekt, ki predstavlja vektor s privzeto za"cetno kapaciteto.
     */
    public Vektor() {
        this(ZACETNA_KAPACITETA);
    }

    /*
     * Ustvari objekt, ki predstavlja vektor s podano za"cetno kapaciteto.
     */
    public Vektor(int kapaciteta) {
        this.elementi = new Object[kapaciteta];
        this.stElementov = 0;
    }

    /*
     * Vrne "stevilo elementov vektorja <this>.
     */
    public int steviloElementov() {
        return this.stElementov;
    }

    /*
     * Vrne element na podanem indeksu.
     */
    public Object vrni(int indeks) {
        return this.elementi[indeks];
    }

    /*
     * Element na podanem indeksu nastavi na podano vrednost.
     */
    public void nastavi(int indeks, Object vrednost) {
        this.elementi[indeks] = vrednost;
    }

    /*
     * Doda element s podano vrednostjo na konec vektorja (na indeks
     * this.stElementov).
     */
    public void dodaj(Object vrednost) {
        this.poPotrebiPovecaj();
        this.elementi[this.stElementov] = vrednost;
        this.stElementov++;
    }

    /*
     * Element s podano vrednostjo vstavi na podani indeks.
     */
    public void vstavi(int indeks, Object vrednost) {
        this.poPotrebiPovecaj();
        for (int i = this.stElementov - 1;  i >= indeks;  i--) {
            this.elementi[i + 1] = this.elementi[i];
        }
        this.elementi[indeks] = vrednost;
        this.stElementov++;
    }

    /*
     * Odstrani element na podanem indeksu.
     */
    public void odstrani(int indeks) {
        for (int i = indeks;  i < this.stElementov - 1;  i++) {
            this.elementi[i] = this.elementi[i + 1];
        }
        this.stElementov--;
    }

    /*
     * "Ce je vektor <this> poln, pove"ca njegovo kapaciteto za faktor 2.
     */
    private void poPotrebiPovecaj() {
        if (this.stElementov >= this.elementi.length) {
            // ustvari novo, ve"cjo tabelo in vanjo skopiraj elemente iz stare
            // tabele
            Object[] stariElementi = this.elementi;
            this.elementi = new Object[2 * stariElementi.length];
            for (int i = 0;  i < this.stElementov;  i++) {
                this.elementi[i] = stariElementi[i];
            }
        }
    }

    /*
     * Vrne vsebino vektorja v obliki niza [e_0, e_1, ..., e_{n-1}].
     * Uporablja lepljenje nizov.
     */
    public String toString0() {
        String str = "[";
        for (int i = 0;  i < this.stElementov;  i++) {
            if (i > 0) {
                str += ", ";
            }
            str += this.elementi[i];
        }
        str += "]";
        return str;
    }

    /*
     * Vrne vsebino vektorja v obliki niza [e_0, e_1, ..., e_{n-1}].
     * Uporablja razred StringBuilder.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0;  i < this.stElementov;  i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(this.elementi[i]);
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public Iterator iterator() {
        return new IteratorCezVektor(this);
    }
}
