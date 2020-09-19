import java.util.Set;
import java.util.Collection;
import java.util.HashSet;
public class PresekMnozic{
    public static <T> Set<T> presek(Collection<Set<T>> mnozice){
        if(mnozice.size() <= 0)
        {
            return null;
        }
        Set <T> ret = new HashSet<T>(mnozice.iterator().next());
        for(Set<T> t : mnozice)
        {
            ret.retainAll(t);
        }
        return ret;
    }
}