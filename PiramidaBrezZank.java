import java.util.*;

public class PiramidaBrezZank {
	
	public static void zaporedje(char znak, int dolzina) {
		if(dolzina>0) {
			System.out.printf("%c", znak);
			zaporedje(znak, dolzina-1);
			// return;
		}
	}
	public static void vrstica(int vr, int visina){
			zaporedje(' ', visina-vr-1);
			zaporedje('*', 2*vr+1);
			System.out.println();
	}
	public static void piramida(int vr, int visina){
			if(vr>visina){
				return;
			}
				vrstica(vr-1, visina);
				piramida(vr+1, visina);
		}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();		
		piramida(1, n);
	}

}