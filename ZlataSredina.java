import java.util.*;
public class ZlataSredina{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] tab = new int[2*n+1];
		for(int i=0; i<2*n+1; i++){
			tab[i] = sc.nextInt();
		}
		for(int i=0; i<2*n+1; i++){
			int manje=0, vecji=0;
			
			for(int j=0; j<2*n+1; j++){
				if(i != j){
					if(tab[j] < tab[i]){
						manje++;
					}
					if(tab[j] > tab[i]){
						vecji++;
						}
					if(vecji>=n && manje>=n) break;
				}
			}
			if(manje>=n && vecji>=n){ System.out.println(tab[i]); break; }
		}
	}
}