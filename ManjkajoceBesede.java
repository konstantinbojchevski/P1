import java.util.Scanner;
import java.util.Arrays;
public class ManjkajoceBesede{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        String prva = sc.nextLine();
        sc.nextLine();
        String druga = sc.nextLine();
        
        String [] prva1 = prva.split(" ");
        String [] prva2 = druga.split(" ");
        int st = prva1.length - 1;
        for(int i = 0; i < prva1.length; i++)
        {
            for(int j = 0; j < prva2.length; j++)
            {
                if(prva1[i].equals(prva2[j]))
                {
                    prva1[i] = null;
                    st--;
                    break;
                }
            }
        }
        String[]rez = new String[st+1];
        for(String s : prva1)
        {
            if(s != null)
            {
                rez[st--] = s;
            }
        }
        Arrays.sort(rez);
        for(int i = 0; i < rez.length; i++){
            boolean already = false;
            String s = rez[i];
            for(int j = 0; j < i; j++)
            {
                if(s.equals(rez[j]))
                {
                    already = true;
                }
            }
            if(!already)
            {
                System.out.println(s);
            }
        }
    }
}