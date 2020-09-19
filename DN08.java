import java.util.Scanner;
public class DN08{
    public static void main(String []arg){
        Scanner sc = new Scanner(System.in);
        Tip.wordLength = sc.nextInt();
        Tip [] objekti = new Tip [sc.nextInt() + 1];
        for(int i = 1; i < objekti.length; i++)
        {
            objekti[i] = parseTip(sc);
        }
        
        int max = sc.nextInt();
        for(int i = 0; i < max; i++)
        {
            switch(sc.nextInt())
            {
                case 1: 
                    System.out.println(objekti[sc.nextInt()]);
                    break;
                case 2: 
                    System.out.println(objekti[sc.nextInt()].retVel());
                    break;
                case 3: 
                    System.out.println(objekti[sc.nextInt()].pomnPor());
                    break;    
                }
        }
    }

    public static Tip parseTip(Scanner sc){
        Tip ret = null;
        Tip[] temp;
        String s = sc.next();
        if(s.equals("prim"))
        {
                ret = new Prim(sc.nextInt());
        } else if(s.equals("arr"))
        {
                ret = new Arr(sc.nextInt(), parseTip(sc));
        }else
        {
                temp = new Tip[sc.nextInt()];
                for(int x = 0; x < temp.length; x++)
                {
                    temp[x] = parseTip(sc);
                }
                if(s.equals("ostruct"))
                {
                    ret = new Ostruct(temp);
                } else
                {
                    ret = new Pstruct(temp);
                }
        }
        return ret;
    }
    public static abstract class Tip{
        public static int wordLength;
        private int velikost;
        public Tip(int velikost){
            this.velikost = velikost;
        }

        public abstract String toString();

        public int pomnPor(){
            if(this.velikost % this.wordLength == 0)
            {
                return this.velikost;
            } else
            {
                return (this.velikost/this.wordLength + 1) * this.wordLength;
            }    
        }

        public int retVel(){
            return this.velikost;
        }

        public void setVel(int x){
            this.velikost = x;
        }
    }
    public static class Prim extends Tip{
        public Prim(int velikost){
            super(velikost);
        }

        @Override
        public String toString(){
            return "prim"+super.retVel();
        }
    }
    public static class Arr extends Tip{
        private int st;
        private Tip element;
        public Arr(int st, Tip element){
            super(st * element.retVel());
            this.st = st;
            this.element = element;
        }

        @Override
        public String toString(){
            return String.format("%s[%d]", this.element, this.st);
        }
    }
    public static class Ostruct extends Tip{
        private Tip [] tab;
        public Ostruct(Tip [] tab){
            super(0);
            this.tab = tab;
            super.setVel(velikost());
        }

        public int velikost(){
            int rez = 0;
            for(int i = 0; i < this.tab.length; i++){
                rez += this.tab[i].pomnPor();
            }
            return rez;
        }

        @Override
        public String toString(){
            String rez = "ostruct{";
            for(int i = 0; i < this.tab.length; i++){
                rez += this.tab[i];
                if(i < this.tab.length - 1)
                {
                    rez += ", ";
                }
            }    
            rez = rez + "}";
            return rez;
        }
    }
    public static class Pstruct extends Tip{
        private Tip [] tab;
        public Pstruct(Tip [] tab){
            super(0);
            this.tab = tab;
            super.setVel(velikost());
        }

        public int velikost(){
            int rez = 0;
            for(int i = 0; i < this.tab.length; i++){
                rez += this.tab[i].retVel();
            }
            return rez;
        }

        @Override
        public String toString(){
            String rez = "pstruct{";
            for(int i = 0; i < this.tab.length; i++){
                rez += this.tab[i];
                if(i < this.tab.length - 1)
                {
                    rez += ", ";
                }
            }    
            rez = rez + "}";
            return rez;
        }
    }
}