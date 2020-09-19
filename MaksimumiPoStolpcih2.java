import java.util.*;
public class MaksimumiPoStolpcih2{
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] tab = new int[n][100]; int najdaljsaVrstica = 0;
		for(int i=0; i<tab.length; i++){			
			int d = sc.nextInt();
			if(d > najdaljsaVrstica) najdaljsaVrstica = d;
			int[] novaa = new int[d];
			for(int j=0; j<d; j++){
				novaa[j] = sc.nextInt();
			}
			tab[i] = novaa;
		}
		boolean imad = false;
		int[] rez = new int[najdaljsaVrstica];
		for(int j=0; j<najdaljsaVrstica; j++){
			int najvecji = -99999999;
			for(int i=0; i<tab.length; i++){
				if(tab[i].length-1 < j) continue;
				if(tab[i][j] > najvecji){
					najvecji = tab[i][j];
				}
			}
			rez[j] = najvecji;			
		}
		System.out.println(Arrays.toString(rez));
	}
}