import java.util.*;

public class VrstaZbor{
	
	private static boolean jePravilno(int i, int[] t){
		return (i==0 || t[i-1] <= t[i]) && (i == t.length - 1 || t[i] <= t[i+1]);
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] tabela = new int[n];
		for(int i=0; i<n; i++){
			tabela[i] = sc.nextInt();
		}
		boolean vsajEn = false;
		for(int i=0; i<n; i++){
			if(jePravilno(i, tabela)){
				System.out.printf("%d%n", i);
				vsajEn = true;
			}
		}
		if(!vsajEn)
			System.out.println("NOBEDEN");
	}
}