import java.util.*;
import java.util.Random;
public class NajboljsheSeme{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int n = sc.nextInt();
		long max = 0, seme = 0;
		for(int i=a; i<=b; i++){
			long stevilo = 0;
			Random rand = new Random(i);
			for(int j=0; j<n; j++){
				stevilo += 10*stevilo + rand.nextInt(10);	
				if(stevilo > max){
					max = stevilo; seme = i;
				}
			}
		}
		System.out.println(seme);
	}
}