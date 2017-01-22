import java.util.*;
import java.io.*;

class kattis {

    public static void main(String[] args) throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        Locale.setDefault(new Locale("en", "US"));

        

        while (in.ready()) {

            long n = Long.parseLong(in.readLine());

            int maxBase = 2;
            int maxZeros = 0;

            for(int i = 2; i <= n; i++){

                int numZeros = 0;
                while(n % i == 0){
                    numZeros++;
                    n /= i;
                }
                if(numZeros > maxZeros){
                    maxZeros = numZeros;
                    maxBase = i;
                }

            }
            
            out.println(maxBase);
            

        }

        in.close();
        out.close();
    }


}