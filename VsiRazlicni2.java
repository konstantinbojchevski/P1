import java.util.*;
public class VsiRazlicni2{
	
	private static final int MAKS_ST = 10000000;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		int n = sc.nextInt();
		Random random = new Random(s);
		int[] tab = new int[n];
		for(int i=0; i<n; i++){
			int clen = random.nextInt(2 * MAKS_ST + 1) - MAKS_ST;
			tab[i] = clen;
		}
		int[] tabela = new int[2 * MAKS_ST + 1];
		for(int i=0; i<n; i++){
			if(tab[i] < 0){
				tabela[tab[i]+MAKS_ST]++;
			}
			else if(tab[i] > 0){
				tabela[tab[i]+(MAKS_ST)]++;
			}
			else{
				tabela[MAKS_ST]++;
			}
		}
		int najveckrat = 0;
		int st = 0;
		for(int i=0; i<tabela.length; i++){
			if(tabela[i] > najveckrat){
				najveckrat = tabela[i];
				if(i<MAKS_ST){
					st = i-MAKS_ST;
				}
				else if(i>MAKS_ST){
					st = i-MAKS_ST;
				}
				else{
					st = 0;
				}
			}
		}
		if(najveckrat <= 1) System.out.println("RAZLICNI");
		else System.out.println(st);
	}
}