
import java.util.*;
import java.util.function.*;

public class Deljivost {

    public static void main(String[] args) {
        // po potrebi dopolnite ...
    }

    public static <T> List<T> filtriraj(Collection<T> zbirka, Predicate<T> pogoj) {
        List <T> seznam = new ArrayList<>();
		for(T cla: zbirka){
			if(pogoj.test(cla))
				seznam.add(cla);
		}
        return seznam;
    }

    public static <T, R> List<R> pretvori(Collection<T> zbirka, Function<T, R> pretvornik) {
			List <R> seznam = new ArrayList<>();
			for(T element: zbirka){
				R rezultat = pretvornik.apply(element);
				seznam.add(rezultat);
			}
			return seznam;
		}

    public static List<Integer> zaporedje(int a, int b) {
		List<Integer> seznam = new ArrayList<>();
		for(int i=a; i<=b; i++){
			seznam.add(i);
		}
        return seznam;
    }

    public static List<Integer> delitelji(int n) {
        List <Integer> seznam = new ArrayList<>();
		for(int i=1; i<=n; i++){
			if(n%i ==0)
				seznam.add(i);
		}
        return seznam;
    }

    public static NavigableSet<Integer> skupniDelitelji(int a, int b) {
		NavigableSet<Integer> prv = new TreeSet<Integer>(delitelji(a));
		NavigableSet<Integer> vto = new TreeSet<>(delitelji(b));
		prv.retainAll(vto);
		return prv;
    }

    public static Map<Integer, List<Integer>> stevilo2delitelji(int a, int b) {
		Map<Integer, List<Integer>> slovar = new HashMap<>();
		
		for(int i=a; i<=b; i++){
			slovar.put(i, delitelji(i));
		}
        return slovar;
    }
	
    public static List<Integer> prastevila(int a, int b) {
        return filtriraj(zaporedje(a, b), sht -> delitelji(sht).size() == 2);
    }

    public static List<Boolean> prastevilskost(int a, int b) {
        return pretvori(zaporedje(a, b), sht -> delitelji(sht).size() == 2);
    }

    public static List<List<Integer>> seznamiDeliteljev(int a, int b) {
        return pretvori(zaporedje(a, b), element -> delitelji(element));
    }

    public static NavigableSet<Integer> stevilaPoDeljivosti(int a, int b) {
        Map<Integer, List<Integer>> sl1 = stevilo2delitelji(a, b);
		NavigableSet<Integer> mnozestvo = new TreeSet<>(
			(p,q) -> {
				int stDela = sl1.get(p).size();
				int stDelb = sl1.get(q).size();
				if(stDela != stDelb)
					return stDelb - stDela;
				return (p - q);
			});
			mnozestvo.addAll(sl1.keySet());
        return mnozestvo;
    }
}