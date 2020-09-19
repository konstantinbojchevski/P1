import java.util.*;
public class Imenik{
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] tab = new String[2*n];
		for(int i=0; i<2*n; i++){
			tab[i] = sc.next();
		}
		int k = sc.nextInt();
		String[] tab12 = new String[k];
		for(int i=0; i<k; i++){
			tab12[i] = sc.next();
		}
		int stevec = 0;
		while(stevec < k){
			boolean znano = false;
			for(int i=(2*n)-2; i>-1; i-=2){
				if((tab12[stevec]).equals(tab[i])){
					System.out.println(tab[i+1]);
					znano = true;
					break;
				}
			}
			if(!znano) System.out.println("NEZNANA");
			stevec++;
		}
	}
}