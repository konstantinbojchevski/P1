import java.util.*;
public class DN04{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int w = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int s = sc.nextInt();
		Random random = new Random(s);
		int[][] tab = new int[h][w];
		for(int i=0; i<h; i++){
			for(int j=0; j<w; j++){
				tab[i][j] = random.nextInt(1000) + 1;
			}
		}
		/*for(int i=0; i<h; i++){
			for(int j=0; j<w; j++){
				System.out.printf("%3d ", tab[i][j]);
			}
			System.out.println();
		}*/
		 int i=0, j=0, maksSuma = 99999999, rezultat= 0;
		while(h - i >= a){
			j=0;
			rezultat = 0;
			while(b <= w - j){
				rezultat = 0;
				for(int k=i; k<i+a; k++){
					for(int l=j;l<(j+b); l++){
						rezultat += tab[k][l];
					}
				}
				if(maksSuma > rezultat) maksSuma = rezultat;
				j++;
			}
			i++;
		}
		rezultat = 0; i=0;
		int o = a; int y = b;
		while(h - i >= y){
			j=0;
			rezultat = 0;
			while(o <= w - j){
				rezultat = 0;
				for(int k=i; k<i+y; k++){
					for(int l=j;l<(j+o); l++){
						rezultat += tab[k][l];
						
					}
				}
				if(maksSuma > rezultat) maksSuma = rezultat;
				j++;
			}
			i++;
		}
		
		
		System.out.println(maksSuma);
	}
}