import java.util.*;

public class DN03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		
		int h=sc.nextInt();
		int w=sc.nextInt();
		int a1=sc.nextInt();
		int b1=sc.nextInt();
		int c1=sc.nextInt();
		int a2=sc.nextInt();
		int b2=sc.nextInt();
		int c2=sc.nextInt();
		int t=sc.nextInt();
		int s=0;
		int s1=0, s2=0, s3=0;
		int nadolu=0, nadesno=0;
		int n = 1;
		//int n=(w-1)+(h-1);
		
		while(n <= (w-1)+(h-1)){
//		nadesno != (w-1) && nadolu != (h-1)){
			s1=we(n, a1, b1, c1);
			s2=ns(n, a2, b2, c2);
			if(s1<s2 || s1==s2)
			{
				if(n==1){
					s+=a1+t;
					nadesno++;
				}
				else{
					if((s1-c1) >= s){
						s += t;
						nadesno++;
					}
					else{
						s+=(s1-s)+t;
						nadesno++;
					}
				}
			}
			else{
				if(n==1){
					s+=a2+t;
					nadolu++;
				}
				else{
					if((s2 - c2) >= s){
						s += t;
						nadolu++;
					}
					else{
						s += (s2-s)+t;
						nadolu++;
					}
				}
			}
		}
		System.out.println(s);
	}
		public static int we(int n, int a, int b, int c){
		if(n==1)
			return a;
		else if(n==2)
			return a+b+c;
		else
			return a+((n-1)*(b+c));
	}
	public static int ns(int n, int a, int b, int c){
		if(n==1)
			return a;
		else if(n==2)
			return a+b+c;
		else
			return a+((n-1)*(b+c));
	}
}