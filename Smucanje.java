import java.util.*;
public class Smucanje{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int v1, v2;
		int n=sc.nextInt();
		int najCas=99999999;
		int najTekmovalec=0;
		int Cas;
		for(int i=0;i<n;i++){
			v1=sc.nextInt();
			if(v1==0) continue;
			v2=sc.nextInt();
			if(v2==0) continue;
			Cas=v1+v2;
			if(Cas<najCas){
				najCas=Cas;
				najTekmovalec=i+1;
			}
		}
		if(najTekmovalec==0)
			System.out.println("NIHCE");
		else{
		System.out.println(najTekmovalec);
		System.out.println(najCas);
		}
}
}