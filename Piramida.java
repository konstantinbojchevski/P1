import java.util.*;
public class Piramida{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int fieldSize=n;
		for(int i=0; i<n;i++){
			System.out.printf("%" + fieldSize + "d", (i>=9 ? (i+1)%10 : (i+1)));
			int k;
			if(i>=9) k=(i+1)%10+1;
			else k = i+2;			
			for(int j=0;j<(2*i);j++){
				if(k>9) k=0;
				System.out.print(k);
				k++;
			}
			fieldSize--;
			System.out.println();
		}
	}
}
