import java.util.*;

public class NajblizjiVeckratnik{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		long broj = sc.nextInt();
		long doNego = sc.nextInt();
		long min = doNego - broj;
		long trenutniMin = 0;
		long veckratnik = 0;
		long vrati = 0;
		do{
			veckratnik += broj;
			trenutniMin = Math.abs(doNego - veckratnik);
			if(trenutniMin < min){
				min = trenutniMin;
				vrati = veckratnik;
			}
		}
		while(veckratnik < doNego);
		if(broj == doNego) System.out.println(broj);
		else System.out.println(vrati);
	}
}