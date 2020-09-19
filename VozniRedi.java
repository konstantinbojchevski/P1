import java.util.*;
public class VozniRedi{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int hz=sc.nextInt();
		int mz=sc.nextInt();
		int hk=sc.nextInt();
		int mk=sc.nextInt();
		int interval=sc.nextInt();
		int trenutnaUra=(hz*60)+mz;
		int koncnaUra=(hk*60)+mk;
		while(trenutnaUra<koncnaUra){
			int h=trenutnaUra/60;
			int m=trenutnaUra-(h*60);
			System.out.println(h+":"+m);
			trenutnaUra+=interval;
			if((trenutnaUra)>koncnaUra)
				break;
		}
	}
}