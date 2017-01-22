import java.util.*;
import java.lang.Math;

class Main {

    public static int n, m;

    public static void main (String[] args) {

        Scanner in =new Scanner(System.in);
        
        while(in.hasNext()){

            m = in.nextInt();
            n = in.nextInt();

            if(m==0 && n==0)
                break;

            System.out.println(knights() + " knights may be placed on a " + m + " row " + n + " column board.");

        }

    }
    public static int knights(){
        if(m == 1)
            return n;
        if(m == 2)
            return (int)(2 * (Math.ceil(0.25*n) + Math.ceil(0.25 * (n-1))));
        if(n == 1)
            return m;
        if(n == 2){
            if(m % 2 != 0)
                return m + 1;
            else if(m % 4 == 0)
                return m;
            return m + 2;
        }
        return (int)(Math.ceil(0.5*n*m));
    }

}