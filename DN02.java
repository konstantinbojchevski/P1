import java.util.*;
public class DN02{
	public static void main(String[] args){
		int ukaz;
		long a, b, k;
		Scanner sc = new Scanner(System.in);
		ukaz = sc.nextInt();
		a = sc.nextLong();
		b = sc.nextLong();
		k = sc.nextLong();
		switch(ukaz){
			case 1:
			{
				int stevec = 0;
				for(long i=a; i<=b; i++){
					if(i % k == 0) stevec++;
				}
				System.out.println(stevec);
				break;
			}	
			case 2:
			{
				int stevec = 0;
				for(long i=a; i<=b; i++){
					boolean Ena = false;
					while(i > 0 && !Ena){
						if(i % 10 == k){
							Ena = true;
							stevec++;
						}
						i /= 10;
					}
				}
				System.out.println(stevec);
				break;
			}	
			case 3:
			{
				int stevec = 0;
				for(long i=a; i<=b; i++){
					boolean ne_vse = false;
					while(i > 0 && !ne_vse){
						if((i % 10) % k != 0){
							ne_vse = true;
							break;
						}
						i /= 10;
					}
					if(!ne_vse) stevec++;
				}
				System.out.println(stevec);
				break;
			}	
			case 4:
			{
				int stevec = 0;
				for(long i=a; i<=b; i++){
					int stevki = 0;
					long prejsna = 0;
					while(i > 0){
						long trenutna = i%10;
						if(prejsna == trenutna){
							stevki++;
							if(stevki == k){
								stevec++;
								break;
							}
						}
						prejsna = trenutna;
						i /= 10;
					}
				}
				System.out.println(stevec);
				break;
			}	
			/*case 5:
				int stevec = 0;
				for(long i=a; i<=b; i++){
					int stevki = 0;
					int prejsna = 0;
					boolean pomalo = false, pogolemo = false;
					while(i > 0){
						int trenutna = i%10;
						if(prejsna - trenutna == -1) pogolemo = true;
						else if(prejsna - trenutna == 1) pomalo = true;
						else{ pomalo = false; pogolemo = false; stevki = 0;}
						if(pogolemo){
							stevki++;
							if(stevki == k){
								stevec++;
								break;
							}
						}
						else if(pomalo){
							
						}
						prejsna = trenutna;
						i /= 10;
					}
				}
				System.out.println(stevec);
				break;*/
		}
	}
}