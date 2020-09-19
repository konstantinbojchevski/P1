import java.util.*;
public class Datum{
	private int dan;
	private int mesec;
	private int leto;
	
	public static Datum ustvari(int dan, int mesec, int leto){
		
		boolean mozhe = false;
		if(1583 <= leto && leto <= 2999 && 1 <= mesec && mesec <= 12){
			if((leto % 4 == 0 && leto % 100 != 0) || leto % 400 == 0){
				switch(mesec){
					case 2: 
					{
						if(1 <= dan || dan <= 29)
							mozhe = true;
					}
					case 1, 3, 5, 7, 8, 10, 12:
					{
						if(1 <= dan || dan <= 31)
							mozhe = true;
					}
					case 4, 6, 9, 11:
					{
						if(1 <= dan || dan <= 30)
							mozhe = true;
					}
				}
			}
			else{
				switch(mesec){
					case 2: 
					{
						if(1 <= dan && dan <= 28)
							mozhe = true;
					}
					case 1, 3, 5, 7, 8, 10, 12:
					{
						if(1 <= dan && dan <= 31)
							mozhe = true;
					}
					case 4, 6, 9, 11:
					{					
						if(1 <= dan && dan <= 30)
							mozhe = true;
					}
				}
			}
		}
		if(mozhe)
			return new Datum(dan, mesec, leto);
		else 
			return null;
	}

	private Datum(int dan, int mesec, int leto){
		this.dan = dan;
		this.mesec = mesec;
		this.leto = leto;
	}
	
	public String toString(){
		return String.format("%" + ((1 <= this.dan && this.dan <= 9) ? "02" : "") + "d.%" + ((1 <= this.mesec && this.mesec <= 9) ? "02" : "") + "d.%d", this.dan, this.mesec, this.leto);  
	}
	
	public boolean jeEnakKot(Datum datum){
		return (this.dan == datum.dan && this.mesec == datum.mesec && this.leto == datum.leto);
	}
	
	public boolean jePred(Datum datum){
		boolean je = false;
		if(this.leto < datum.leto) je = true;
		else if(this.leto == datum.leto){
			if(this.mesec < datum.mesec) je = true;
			else if(this.mesec == datum.mesec){
				if(this.dan < datum.dan) je = true;
			}
		}
		else{
			je = false;
		}
		return je;
	}
	
	public Datum cez(int stDni){
		int dan = 0, mesec = 0, leto = 0;
		switch(this.mesec){
			case 1, 3, 5, 7, 8, 10:
			{
				int razlika = 31 - this.dan;
				if(razlika < stDni){
					mesec = stevec - (12  - this.mesec);
					leto = this.leto;
					dan = (stDni - razlika)%31;
				}
				else{
					mesec = this.mesec;
					leto = this.leto;
					dan = this.dan + stDni;
				}
			}
			break;
			case 12:
			{
				int razlika = 31 - this.dan;
				if(razlika < stDni){
					mesec = 1;
					
					leto = this.leto + 1;
					dan = (stDni - razlika)%31;
					if(leto > 2999) return null;
				}
				else{
					mesec = this.mesec;
					leto = this.leto;
					dan = this.dan + stDni;
					if(leto > 2999) return null;
				}
			}
			break;
			case 2, 4, 6, 9, 11:
			{
				int razlika = 30 - this.dan;
				if(razlika < stDni){
					mesec = this.mesec + 1;
					leto = this.leto;
					dan = (stDni - razlika)%31;
					if(leto > 2999) return null;
				}
				else{
					mesec = this.mesec;
					leto = this.leto;
					dan = this.dan + stDni;
					if(leto > 2999) return null;
				}
			}
		}
		return new Datum(dan, mesec, leto);
	}
	
	public static void main(String[] args){
			Datum prv = Datum.ustvari(29, 3, 2016);
			Datum vto = Datum.ustvari(2, 11, 2019);
			System.out.println(prv.cez(365));
	}
}