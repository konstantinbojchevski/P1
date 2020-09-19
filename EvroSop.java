import java.util.*;
public class EvroSop{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		
		int kasa=0, i1=0, i2=0;
		while(sc.hasNextInt()){
			int kovanecc=sc.nextInt();
			kasa+=kovanecc;
			if(kovanecc==2){
				kasa=kasa-1;
				i2++;
			}
			else{
				i1++;
			}
		}
		int r=kasa-(i2*2);
			if(r<0){
				System.out.println("BANKROT");
			}
			else{
				System.out.println(r);
				System.out.println(i2);
			}		
	}
}