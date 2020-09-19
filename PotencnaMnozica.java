import java.util.Set;
import java.util.HashSet;
import java.util.List;
public class PotencnaMnozica{
    public static <T> Set<Set<T>> potencna(Set<T> mnozica){
        Set<Set<T>> ret = new HashSet<Set<T>>();
        T [] tab = (T[]) new Object[mnozica.size()+1];
        T [] temp = (T[]) mnozica.toArray();
        for(int i = 1; i <= temp.length; i++)
        {
            tab[i] = temp[i-1];
        }
        for(int i = 0; i < tab.length; i++)
        {
            rekur(ret, tab, i, new HashSet());
        }
        return ret;
    }
    public static<T> void rekur(Set<Set<T>> ret, T[] tab, int indeks, Set<T> mn){
        if(indeks >= tab.length || tab[indeks] == null)
        {
            ret.add(mn);
            return;
        }
        mn.add(tab[indeks++]);
        for(int i = indeks; i < tab.length; i++)
        {
            rekur(ret, tab, i, new HashSet(mn));
        }
        ret.add(mn);
    }
}