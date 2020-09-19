import java.util.*;
public class Pascal{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] tab = new int[n+1][n+2];
		for(int i=0; i<n+1; i++){
			for(int j=0; j<=i; j++){
				if(j==0){
					tab[i][j] = 1;
					System.out.print(tab[i][j]);
				}
				else if(j == i){
					tab[i][j] = 1;
					System.out.printf("%2d", tab[i][j]);
				}
				else{
					tab[i][j] = tab[i-1][j-1] + tab[i-1][j];
					System.out.printf(" %d", tab[i][j]);
				}
			}
			System.out.println();
		}
	}
}