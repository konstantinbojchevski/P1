import java.util.*;
public class LeksikografskoUrejanje{
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] tab = new int[n];
		for(int i=0; i<n; i++){
			int[] nova = new int[3];
			for(int j=0; j<3; j++){
				nova[j] = sc.nextInt();
			}
			tab[i] = nova;
		}
		for(int i=0; i<n; i++){
			System.out.println(Arrays.toString(tab));
		}
	}
}