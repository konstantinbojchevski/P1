public class Prastevila{
	private int trenutno;
	public Prastevila(){
		this.trenutno=2;
	}
	public void nastaviTrenutno(int prastevilo){
		this.trenutno = prastevilo;
	}
	public int vrniTrenutno(){
		return this.trenutno;
	}
	public int naslednje(){
		int n = this.vrniTrenutno();
		int i=n+1;
		int stevilo=0;
		boolean najden = false;
		while(!najden){
			if(i%2!=0){
			int stDeljiteljev=2;
			for(int j=2;j<i;j++){
				if((i%j)==0){
					stDeljiteljev++;
				}
			}
			if(stDeljiteljev==2){
				stevilo=i;
				najden = true;
			}
			}
			i++;
		}
		nastaviTrenutno(stevilo);
		return stevilo;
	}
	public int prejsnje(){
		int n=this.trenutno;
		int i=n-1;
		int stevilo=0;
		while(i>0){
			if(i==2) return 2;
			if(i%2!=0){
			int stDeljiteljev=1;
			for(int j=1;j<i;j++){
				if((i%j)==0){
					stDeljiteljev++;
				}
			}
			if(stDeljiteljev==2){
				stevilo=i;
				break;
			}
			}
			if(stevilo!=0)
				break;
			i--;
		}
		nastaviTrenutno(stevilo);
		return stevilo;
	}
	/*public static void main(String[] args) {
        Prastevila prastevila = new Prastevila();
        prastevila.nastaviTrenutno(31);
        for (int i = 0;  i < 10;  i++) {
            System.out.println(prastevila.naslednje());
        }
    }*/
}
	
