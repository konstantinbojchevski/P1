import java.util.*;
public class Romanje{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n = sc.nextInt();
		int v = sc.nextInt();
		int p=sc.nextInt();
		int stDneva = 1;
		
		while (n > 0&&v>0) {
			if (n <  v) {
				v = n;
			}
			System.out.printf("%d. dan: %d -> %d (prehodil %d)%n", 
						stDneva, n, (n - v), v);
			n -= v;
			stDneva++;	
			v-=p;
		}
	}
}