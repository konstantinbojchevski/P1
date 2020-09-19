import java.util.*;

public class IgorjeviBloki{

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int najvecji = Math.max(Math.max(a, b), c);
		int i=0, j=0, k=0;
		int stevec = 0;
		while(stevec < najvecji){
			if(i<a){
				for(int prv = 0; prv<a; prv++) System.out.printf("%d", a);
			}else{
				for(int prv = 0; prv<a; prv++) System.out.printf(" ");
			}
			System.out.printf(" ");
			if(j<b){
				for(int vtor = 0; vtor<b; vtor++) System.out.printf("%d", b);
			}else{
				for(int vtor = 0; vtor<b; vtor++) System.out.printf(" ");
			}
			System.out.printf(" ");
			if(k<c){
				for(int tret = 0; tret<c; tret++) System.out.printf("%d", c);
			}else{
				for(int tret = 0; tret<c; tret++) System.out.printf(" ");
			}
			i++;
			j++; 
			k++; 
			stevec++;
			System.out.println();
		}
	}
}