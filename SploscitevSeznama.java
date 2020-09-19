import java.util.List;
import java.util.ArrayList;
public class SploscitevSeznama{
    public static <T> List<T> splosci(List<List<T>> seznami){
        ArrayList <T> ret = new ArrayList<T>();
        for(List<T> l : seznami)
        {
            ret.addAll(l);
        }
        return ret;
    }
}