import java.util.*;
import java.lang.*;
public class Predvolilni{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int racun=0;
		while(sc.hasNextInt()){
			int cenaKosilo=sc.nextInt();
			int steviloKosil=sc.nextInt();
			int vino=sc.nextInt();
			boolean booly;
			if(vino==1)
				booly=true;
			else booly=false;
			if(booly){
			int y=(int) Math.ceil((cenaKosilo*steviloKosil)/2);
			
			racun=(cenaKosilo*steviloKosil)+y;
			n-=racun;
			}
			else {
				racun=cenaKosilo*steviloKosil;
				n-=racun;
			}
			if(n>0)
				System.out.printf("%d %d%n", racun, n);
			else if(n<0){
				System.out.printf("%d -%n", racun);
				break;
			}
			else{
				System.out.printf("%d 0%n", racun);
				break;
			}

		}
	}
}