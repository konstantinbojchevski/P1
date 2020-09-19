import java.util.*;
public class NajSkupniDelitelj {
	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int g=sc.nextInt();
		
		for(int i =1;i<=n;i++){
			for(int j =1; j<=n; j++){
			 if (gcd(i, j) == g) {
				 if(i<=j)
				 System.out.println("("+ i +", " + j +")");
			 }
			
			}
			
		}
	}
		public static int gcd(int a, int b){
			while(b>0){
				int t=a;
				a=b;
				b=t%b;
			}
			return a;
		}
}