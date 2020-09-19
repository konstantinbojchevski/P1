import java.util.*;

public class Zgoscenke2{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int capacity = sc.nextInt();
		int[] tabela = new int[n];
		int maxCapacity = 0;
		int maxIndex = 0;
		
		while(sc.hasNextInt()){
			int vnos = sc.nextInt();
			maxCapacity = capacity - tabela[0];
			maxIndex = 0;
			for(int i=0; i<n; i++){
				if((capacity-tabela[i]) > maxCapacity){
					maxCapacity = capacity-tabela[i];
					maxIndex = i;
				}
			}
			if(vnos <= (capacity - tabela[maxIndex])){
				tabela[maxIndex] += vnos;
				System.out.printf("%d EP -> zgoscenka %d", vnos, (maxIndex+1));
				System.out.printf(Arrays.toString(tabela));
				System.out.println();
			}
			else{
				break;
			}
		}	
	}
}