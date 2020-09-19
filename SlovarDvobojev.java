import java.util.TreeMap;
import java.util.NavigableMap;
import java.util.Set;
import java.util.List;
public class SlovarDvobojev{
    public static NavigableMap<String, NavigableMap<String, Integer>>
    partije2slovar(List<Partija> partije){
        TreeMap<String, NavigableMap<String, Integer>> ret = new TreeMap<>();
        for(Partija p : partije)
        {
            String beli = p.beli;
            String crni = p.crni;
            if(!ret.containsKey(beli))
            {
                ret.put(beli, new TreeMap<String,Integer>());
            }
            if(!ret.containsKey(crni))
            {
                ret.put(crni, new TreeMap<String,Integer>());
            }
            Set <String> hs = ret.keySet();
            for(String s : hs)
            {
                for(String b : hs)
                {
                    NavigableMap <String, Integer> tm = ret.get(s);
                    if(!s.equals(b) && !tm.containsKey(b))
                {
                    tm.put(b,0);
                }
                }
            }
            NavigableMap <String, Integer> tmBeli = ret.get(beli);
            NavigableMap <String, Integer> tmCrni = ret.get(crni);
            Integer izid = p.izid;
            tmBeli.put(crni, tmBeli.remove(crni) + izid);
            tmCrni.put(beli, tmCrni.remove(beli) + (2-izid) );
        }
        return ret;
    }
}