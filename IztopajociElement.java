import java.util.*;
public class IztopajociElement{
    public static int gcd(int a, int b){
        if (a == 0) return b;
        return gcd(b % a, a);
    }
    public static int findGCD(int arr[], int n){
        int result = 0;
        for (int element: arr){
            result = gcd(result, element);
            if(result == 1) return 1;
        }
        return result;
    }
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] tab = new int[n];
		for(int i=0; i<n; i++){
			tab[i] = sc.nextInt();
		}

		boolean ima = false;
		for(int i=0; i<n; i++){
			int[] tmp = new int[n-1];
			for(int j=0; j<i; j++){
				tmp[j] = tab[j];
			}
			for(int j=i+1; j<tmp.length; j++){
				tmp[j] = tab[j];
			}
			if(tab[i] % (findGCD(tmp, n-1)) != 0){
				System.out.println(tab[i]);
				ima = true;
			}
		}
		if(!ima) System.out.println("NIC");
	}
}