import java.util.*;

public class Metaprogram{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int field_size = 0;
		System.out.println("public class Nizi {");
		field_size += 4;
		for(int i=0; i<field_size; i++){ System.out.printf(" ");}
		System.out.println("public static void main(String[] args) {");
		for(int i=0; i<n; i++){
			field_size += 4;
			for(int j=0; j<field_size; j++){ System.out.printf(" ");}
			String format = "for (char c" + (i+1) + " = \'A\';  c" + (i+1) + " <= \'Z\';  c" + (i+1) + "++) {";
			System.out.println(format);
		}
		field_size +=4;
		for(int i=0; i<field_size; i++){ System.out.printf(" ");}
		StringBuilder sb = new StringBuilder();
		sb.append("System.out.println(");
		for(int i=0; i<n; i++){
			if(i==0) sb.append("\'"\'\'"\'" + c" + (i+1));
			sb.append(" + c" + (i+1));
		}
		sb.append(");");
		String format1 = sb.toString();
		System.out.format(format1);
		System.out.println();
		while(field_size > 0){
			field_size -= 4;
			for(int i=0; i<field_size; i++){ System.out.printf(" ");}
		System.out.printf("}");
		System.out.println();
		}
	}
}