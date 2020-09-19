import java.util.*;
public class VsiRazlicniI{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();boolean vtora = false;
		int[] tab = new int [n];
		for(int i=0; i<tab.length; i++){
			tab[i] = sc.nextInt();
		}
		int najmanjse = 99999999;
		boolean ima = false;
		for(int i=1; i<n; i++){
			for(int j=i-1; j>=0; j--){
				if(tab[i] == tab[j] && tab[j] <= najmanjse){
					najmanjse = tab[j];
					ima = true;
				}
			}
		}
		if(!ima) System.out.println("RAZLICNI");
		else
			System.out.println(najmanjse);
	}
}