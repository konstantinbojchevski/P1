
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Slovar implements Iterable {

    private static class Vozlisce {
        Object kljuc;
        Object vrednost;
        Vozlisce naslednje;

        Vozlisce(Object kljuc, Object vrednost, Vozlisce naslednje) {
            this.kljuc = kljuc;
            this.vrednost = vrednost;
            this.naslednje = naslednje;
        }
    }

    private static class IteratorPoKljucih implements Iterator {
        private Slovar slovar;
        private int indeks;
        private int stevec;
        private Vozlisce vozlisce;

        public IteratorPoKljucih(Slovar slovar) {
            this.slovar = slovar;
            this.indeks = 0;
            this.stevec = 0;
            this.vozlisce = this.slovar.podatki[this.indeks];
        }

        @Override
        public boolean hasNext() {
            return (this.stevec < this.slovar.stParov);
        }

        @Override
        public Object next() {
            if (this.vozlisce == null) {
                // smo na koncu verige, zato poi"s"cemo naslednji element
                // tabele z neprazno verigo
                do {
                    this.indeks++;
                } while (this.indeks < this.slovar.podatki.length &&
                        this.slovar.podatki[this.indeks] == null);

                if (this.indeks >= this.slovar.podatki.length) {
                    throw new NoSuchElementException();
                }
                this.vozlisce = this.slovar.podatki[this.indeks];
            }

            Object kljuc = this.vozlisce.kljuc;
            this.vozlisce = this.vozlisce.naslednje;
            this.stevec++;
            return kljuc;
        }
    }

    private static final int VELIKOST_TABELE = 97;

    private Vozlisce[] podatki;
    private int stParov;

    public Slovar() {
        this(VELIKOST_TABELE);
    }

    public Slovar(int velikostTabele) {
        this.podatki = new Vozlisce[velikostTabele];
        this.stParov = 0;
    }

    public void shrani(Object kljuc, Object vrednost) {
        Vozlisce vozlisce = this.poisci(kljuc);
        if (vozlisce != null) {
            vozlisce.vrednost = vrednost;
        } else {
            int indeks = this.indeks(kljuc);
            vozlisce = new Vozlisce(kljuc, vrednost, this.podatki[indeks]);
            this.podatki[indeks] = vozlisce;
            this.stParov++;
        }
    }

    public Object vrni(Object kljuc) {
        Vozlisce vozlisce = this.poisci(kljuc);
        if (vozlisce == null) {
            return null;
        }
        return vozlisce.vrednost;
    }

    private int indeks(Object kljuc) {
        int n = this.podatki.length;
        return ((kljuc.hashCode() % n) + n) % n;
    }

    private Vozlisce poisci(Object kljuc) {
        int indeks = this.indeks(kljuc);
        Vozlisce vozlisce = this.podatki[indeks];
        while (vozlisce != null && !vozlisce.kljuc.equals(kljuc)) {
            vozlisce = vozlisce.naslednje;
        }
        return vozlisce;
    }

    @Override
    public Iterator iterator() {
        return new IteratorPoKljucih(this);
    }
}
