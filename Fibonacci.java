import java.util.*;
public class Fibonacci{
	private int prvi;
	private int drugi;
	
	public Fibonacci(int p, int d){
		this.prvi=p;
		this.drugi=d;
	}
	public int naslednji(){
		int trenutni=this.prvi+this.drugi;
		this.prvi=this.drugi;
		this.drugi=trenutni;
		return trenutni;
	}
}