import java.util.*;
public class DN01{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int stevilo = sc.nextInt();
		switch(stevilo){
			case 1:
			{
				int a=sc.nextInt();
				int v=a*a*a;
				System.out.print(v);
				break;
			}
			case 2:
			{
				int a=sc.nextInt();
				int b=sc.nextInt();
				int c=sc.nextInt();
				int v=a*b*c;
				System.out.print(v);
				break;
			}
			case 3:
			{
				int a=sc.nextInt();
				int v=0;
				while(a!=0)
				{
					v+=a*a;
					a--;
				}
				System.out.print(v);
				break;
			}
			case 4:
			{
				int a=sc.nextInt();
				int b=sc.nextInt();
				int v=0;
				do{
					v+=a*b;
					a--;
				}
				while(a>=1);
				System.out.print(v);
				break;
			}
			case 5:
			{
				int a=sc.nextInt();
				int v=1;
				do{
					v+=4*a-4;
					a--;
				}
				while(a>=1);
				System.out.print(v);
				break;
			}
			case 6:
			{
				int a=sc.nextInt();
				int b=sc.nextInt();
				int v=b;
				do{
					v+=2*a+2*b-4;
					a--;
				}
				while(a>1);
				System.out.print(v);
				break;
			}
		}
	}
	
}