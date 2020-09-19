import java.util.*;
public class NajblizjiEle{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int n = sc.nextInt();
		int[] tab = new int[n];
		int minEl = 99999999;
		int minIx = 0;
		for(int i=0; i<n; i++){
			tab[i] = sc.nextInt();
			int raz = Math.abs(Math.abs(tab[i]) - Math.abs(k));
			if(raz < minEl){
				minEl = raz;
				minIx = i;
			}
		}
		System.out.println(minIx);
	}
}