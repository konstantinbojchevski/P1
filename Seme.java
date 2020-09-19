import java.util.Random;
import java.util.Scanner;
public class Seme{
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int n=sc.nextInt();
		int a=sc.nextInt();
		int b=sc.nextInt();
		Random rand = new Random(n);
		int najvecjo=0;
		for (int i = a; i <= b; i++) {
			int p=rand.nextInt(i);
			if(p>najvecjo){
				najvecjo=p;
			}
			System.out.println(najvecjo);
		}
			
}
}