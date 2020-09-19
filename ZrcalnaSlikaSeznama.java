import java.util.List;
import java.util.ArrayList;
public class ZrcalnaSlikaSeznama{
    public static <T> List <T> zrcalnaSlika(List<T> seznam){
        ArrayList <T> nov = new ArrayList<T>(seznam.size());
        for(int i = seznam.size() - 1; i >= 0; i--)
        {
            nov.add(seznam.get(i));
        }
        return nov;
    }
}