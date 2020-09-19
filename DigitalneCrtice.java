import java.util.*;
public class DigitalneCrtice{
	public static int SteviloCrtic(int n){
		int rez = 0;
		while(n > 0){
			int stevka = n % 10;
			switch(stevka){
				case 0:
					rez += 6;
					break;
				case 1:
					rez += 2;
					break;
				case 2:
					rez += 5;
					break;
				case 3:
					rez += 5;
					break;
				case 4:
					rez += 4;
					break;
				case 5:
					rez += 5;
					break;
				case 6:
					rez += 6;
					break;
				case 7:
					rez += 3;
					break;
				case 8:
					rez += 7;
					break;
				case 9:
					rez += 6;
					break;
			}
			n /= 10;
		}
		return rez;
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] tab = new int[n];
		int st = 0;
		int br = -1;
		for(int i=0; i<n; i++){
			tab[i] = sc.nextInt();
			int ova = SteviloCrtic(tab[i]);
			if(ova > st){ 
				st = ova;
				br = tab[i];
			}
		}
		System.out.println(br);
	}
	
	
	
}