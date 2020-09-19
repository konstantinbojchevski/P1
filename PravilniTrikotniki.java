import java.util.*;
public class PravilniTrikotniki{
	
	public static double najgolema(double x1, double y1, double x2, double y2, double x3, double y3){
		double s1 = (double) Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
		double s2 = (double) Math.sqrt(Math.pow(x3-x1, 2) + Math.pow(y3-y1, 2));
		double s3 = (double) Math.sqrt(Math.pow(x3-x2, 2) + Math.pow(y3-y2, 2));
		return Math.max(Math.max(s1, s2), s3);
	}
	
	public static double najmala(double x1, double y1, double x2, double y2, double x3, double y3){
		double s1 = (double) Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
		double s2 = (double) Math.sqrt(Math.pow(x3-x1, 2) + Math.pow(y3-y1, 2));
		double s3 = (double) Math.sqrt(Math.pow(x3-x2, 2) + Math.pow(y3-y2, 2));
		return Math.min(Math.min(s1, s2), s3);
	}
	
	public static boolean fun(double x1, double y1, double x2, double y2, double x3, double y3, double d){
		boolean mozhe = false;
		double a = najgolema(x1, y1, x2, y2, x3, y3);
		double b = najmala(x1, y1, x2, y2, x3, y3);
		if((a-b) < (Math.pow(10, -d)*b)) mozhe = true;
		return mozhe;
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int d = sc.nextInt();
		int n = sc.nextInt();
		double[] tab = new double[2*n];
		for(int i=0; i<2*n; i++){
			tab[i] = sc.nextDouble();
		}
		boolean ima = false;
		for(int i=0; i<2*n; i+=2){
			for(int j=i+2; j<2*n; j+=2){
				for(int k=j+2; k<2*n; k+=2){
					boolean ova = fun(tab[i], tab[i+1], tab[j], tab[j+1], tab[k], tab[k+1], d);
					if(ova) {
						System.out.printf("%d %d %d%n", i/2, j/2, k/2);
						ima = true;
					}
				}
			}
		}
		if(!ima) System.out.println("BREZ");
	}
}