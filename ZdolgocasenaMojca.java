import java.util.*;
public class ZdolgocasenaMojca{
	public static boolean jePrastevilo(int n){
		int vsota = 1;
		for(int i=1; i<=(n/2); i++){
			if(n % i == 0)
				vsota++;
		}
		if(vsota == 2) return true;
		else return false;
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		int k = sc.nextInt();
		int dne = sc.nextInt();
		Random rand = new Random(s);
		for(int i=0; i<dne; i++){
			boolean jeP = false;
			int brojac = 1;
			System.out.println((i+1) +". dan:");
			while(!jeP){
				int vsota = 0;
				System.out.printf("%5d. met:", brojac);
				int stevec = 0;
					while(stevec < k){					
						int stPik = rand.nextInt(6) + 1;
							vsota += stPik;
						System.out.printf(" %d", stPik);
						stevec++;
					}
						if(jePrastevilo(vsota)) jeP = true;
				System.out.printf(" | vsota = %d%n", vsota);
				brojac++;
			}
		}
		System.out.println(jePrastevilo(14));
	}
}