import java.util.TreeMap;
import java.util.Scanner;
import java.util.Arrays;
public class PogostostBesed{
    public static void main(String[]args){
        TreeMap <String, Integer> rez = new TreeMap<>();
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext())
        {
            String s = sc.next();
            if(rez.containsKey(s))
            {
                rez.put(s, rez.remove(s) + 1);
            }else
            {
                rez.put(s, 1);
            }
        }
        Object[] temp =  (rez.keySet().toArray());
        String temp2[]=new String[temp.length];
        for(int i = 0;i<temp.length;i++){
            temp2[i]=(String)temp[i];
        }
        Arrays.sort(temp2, (s1, s2) -> rez.get(s2) - rez.get(s1));
        for(String s : temp2)
        {
            System.out.printf("%s (%d)%n", s, rez.get(s));
        }
    }
}