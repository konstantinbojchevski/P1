import java.util.*;
public class Ulomek{
	private int stevec;
	private int imenovalec;
	public Ulomek(int a, int b){
		int gcd = gcd(a, b);
		if(gcd(a, b) != 1){
			a /= gcd;
			b /= gcd;
		}
		this.stevec = a;
		this.imenovalec = b;
	}
	public static int gcd(int a, int b){
        if (a == 0) return b;
        return gcd(b % a, a);
    }
	public String toString(){
		return String.format("%d/%d", this.stevec, this.imenovalec);
	}
	public boolean jeEnakKot(Ulomek u){
		return((this.stevec/this.imenovalec) == (u.stevec/u.imenovalec));
	}
	public Ulomek negacija(){
		Ulomek nov = new Ulomek(this.stevec, this.imenovalec);
		if(this.stevec < 0){
			nov.stevec = Math.abs(this.stevec);
			nov.imenovalec = Math.abs(this.imenovalec);
		}
		else if(this.imenovalec < 0){
			nov.stevec = -Math.abs(this.stevec);
			nov.imenovalec = Math.abs(this.imenovalec);
		}
		else{
			nov.stevec = -this.stevec;
			nov.imenovalec = this.imenovalec;
		}
		return nov;
	}
	public Ulomek obrat(){
		if(this.stevec < 0){
			int stevec = -this.imenovalec;
			int imenovalec = -this.imenovalec;
		}
		else if(this.imenovalec < 0 && this.stevec > 0){
			int stevec = this.imenovalec;
			int imenovalec = this.stevec;
		}
		else{
			int stevec = this.imenovalec;
			int imenovalec = this.stevec;
		}
		//System.out.printf("%d, %d%n", stevec, imenovalec);
		Ulomek nov = new Ulomek(imenovalec, stevec);
		return nov;
	}
	public Ulomek vsota(Ulomek u){
		int lcm = lcm(this.imenovalec, u.imenovalec);
		Ulomek nov = new Ulomek((this.stevec*lcm + u.stevec*lcm), lcm);
		return nov;
	}
	public Ulomek razlika(Ulomek u){
		int lcm = lcm(this.imenovalec, u.imenovalec);
		Ulomek nov = new Ulomek((this.stevec*lcm - u.stevec*lcm), lcm);
		return nov;
	}
	public Ulomek zmnozek(Ulomek u){
		Ulomek nov = new Ulomek(this.stevec*u.stevec, this.imenovalec*u.imenovalec);
		return nov;
	}
	public Ulomek kolicnik(Ulomek u){
		Ulomek nov = new Ulomek(this.stevec*u.imenovalec, this.imenovalec*u.stevec);
		return nov;
	}
	public Ulomek potenca(int eksponent){
		if(eksponent < 0){
			int stevec = (int) Math.pow(this.imenovalec, eksponent);
			int imenovalec = (int) Math.pow(this.stevec, eksponent);
		}
		else{
			int stevec = (int) Math.pow(this.stevec, eksponent);
			int imenovalec = (int) Math.pow(this.imenovalec, eksponent);
		}
		return new Ulomek(stevec, imenovalec);
	}
	public boolean jeManjsiOd(Ulomek u){
		return ((this.stevec/this.imenovalec) < (u.stevec/u.imenovalec));
	}
	public static int lcm(int n1, int n2){
	int lcm = (n1 > n2) ? n1 : n2;
        while(true)
        {
            if( lcm % n1 == 0 && lcm % n2 == 0 ) break;
            ++lcm;
        }
	return lcm;
	}
	/*
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		Ulomek prv = new Ulomek(-2, 3);
		System.out.println(prv.obrat());
	}
	*/
}