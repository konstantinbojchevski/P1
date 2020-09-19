import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
public class ObratSlovarja{
    public static <K,V> Map <V,Set<K>> obrni(Map<K, V> slovar){
        HashMap<V, Set<K>> ret = new HashMap<>();
        for(K key : slovar.keySet())
        {   
            V val = slovar.get(key);
            if(!ret.containsKey(val))
            {
                ret.put(val, new HashSet());
            }
            ret.get(val).add(key);
        }
        return ret;
    }
}