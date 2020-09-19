import java.util.*;
public class Vrazverni{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		Random rand = new Random(s);
		int n = sc.nextInt();
		int nedela = 0;
		for(int i=0; i<n; i++){
			char c = 'D';
			nedela ++;
			int stevec_na_lih = 0, stevec_na_pik = 0;
			if(nedela == 7){
				c = 'N';
				nedela = 0;
			}
			if(c == 'D'){
				System.out.printf("%4d (D):", (i+1));
				while(stevec_na_lih < 3){
					int stPik = rand.nextInt(6) + 1;
					if(stPik % 2!= 0) stevec_na_lih++;
					stevec_na_pik++;
					System.out.printf(" %d", stPik);
				}
				System.out.printf(" [" + stevec_na_pik + "]");
				System.out.println();
			}
			else{
				System.out.printf("%4d (N):", (i+1));
				while(stevec_na_lih < 5){
					int stPik = rand.nextInt(6) + 1;
					if(stPik % 2!= 0) stevec_na_lih++;
					stevec_na_pik++;
					System.out.printf(" %d", stPik);
				}
				System.out.printf(" [" + stevec_na_pik + "]");
				System.out.println();
			}
		}
	}
}