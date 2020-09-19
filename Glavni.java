
import java.util.*;

public class Glavni {

    public static void urediPoLetuInNaslovu(List<Clanek> clanki) {
		Comparator <Clanek>primerjalnik = new Clanek.primerjalnik();
		clanki.sort(primerjalnik);
    }

    public static Set<Avtor> vsiAvtorji(Collection<Clanek> clanki) {
		Set<Avtor> vrathi = new HashSet<>();
		for(Clanek clanek: clanki){
			vrathi.addAll(clanek.vrniAvtorje());
		}
        return vrathi;
    }

    public static Map<Avtor, List<Clanek>> clankiPoAvtorjih(Collection<Clanek> clanki) {
        Map<Avtor, List<Clanek>> vrakam = new HashMap<>();
		for(Clanek clanek: clanki){
			for(Avtor avtor: clanek.vrniAvtorje()){
				List<Clanek> nov = vrakam.get(avtor);
				if(nov == null){
					nov = new ArrayList<Clanek>();
					vrakam.put(avtor, nov);
				}
				nov.add(clanek);
			}
		}
		for(Avtor avtor: vrakam.keySet()){
			urediPoLetuInNaslovu(vrakam.get(avtor));
		}
        return vrakam;
    }

    public static Avtor najplodnejsiAvtor(Collection<Clanek> clanki) {
        return Collections.max(vsiAvtorji(clanki), new primerjalnikPoclankov(clankiPoAvtorjih(clanki)));
    }
	
	private static class primerjalnikPoclankov implements Comparator<Avtor> {
		private Map<Avtor, List<Clanek>> nova;
		
		public primerjalnikPoclankov(Map<Avtor, List<Clanek>> nov){
			this.nova = nov;
		}
		
		@Override
		public int compare(Avtor prvi, Avtor drugi){
			int stClankovPrvi = this.nova.get(prvi).size();
			int stclankovDrugi = this.nova.get(drugi).size();
			if(stClankovPrvi != stclankovDrugi){
				return (stClankovPrvi - stclankovDrugi);
			}
			return drugi.compareTo(prvi);
		}
	}
}
