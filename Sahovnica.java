import java.util.*;

public class Sahovnica{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int s = sc.nextInt();
		int d = sc.nextInt();
		boolean prazno = true;
		int stevec_na_prazni = 0;
		int stevec_na_polnii = 0;
		int linii = 0;
		for(int i=0; i<=(v*d)+1; i++){
			if(i==0 || i==(v*d)+1){
				for(int j=0; j<=(s*d)+1; j++){
					if(j==0 || j==(s*d)+1){
						System.out.printf("+ ");
					}
					else{
						System.out.printf("- ");
					}
				}
			}
			else{
				if(linii == d){
					if(prazno) prazno = false;
					else prazno = true;
					linii = 0;
					stevec_na_polnii = 0;
					stevec_na_prazni = 0;
				}
				linii++;
				for(int j=0; j<=(d*s)+1; j++){
					if(j==0 || j==(s*d)+1){
						System.out.printf("| ");
					}
					else{
						if(prazno){
							System.out.printf("  ");
							stevec_na_prazni++;
						}
						else{
							System.out.printf("* ");
							stevec_na_polnii++;
						}
					}
					if(stevec_na_prazni == d){
						prazno = false;
						stevec_na_prazni = 0;
					}
					if(stevec_na_polnii == d){
						prazno = true;
						stevec_na_polnii = 0;
					}
				}
			}
			System.out.println();
		}
	}
}