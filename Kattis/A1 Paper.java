import java.util.*;
import java.io.*;
import java.lang.Math;

class kattis {

    public static char[] input;

    public static void main(String[] args) throws Exception{

        Locale.setDefault(new Locale("en", "US"));
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        double p2 = 2.0*(Math.pow(2.0,-5.0/4.0) + Math.pow(2.0,-3.0/4.0));
        double p1 = Math.sqrt(2) * p2;

        while(in.ready()){

            int n = Integer.parseInt(in.readLine());

            String[] input = in.readLine().split("\\s+");

            double p2cpy = p2;
            double p = 0.0;
            int needed = 1;

            for(int i = 2; i <= n && needed > 0; i++){
                int tmp = Integer.parseInt(input[i-2]);
                needed *= 2;
                if(tmp >= needed){
                    p += needed*p2cpy;
                    needed = 0;
                }
                else{
                    needed -= tmp;
                    p += tmp*p2cpy;
                }
                

                p2cpy /= Math.sqrt(2);
            }

            if(needed == 0.0)
                out.printf("%.11f\n", (p - p1)/2.0);
            else
                out.println("impossible");
                

        }

        in.close();
        out.close();
    
    }

}