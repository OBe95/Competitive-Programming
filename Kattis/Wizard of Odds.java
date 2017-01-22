import java.util.*;
import java.io.*;
import java.math.BigInteger;

class kattis {

    public static void main(String[] args) throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        Locale.setDefault(new Locale("en", "US"));

        while (in.ready()) {

            String[] spec = in.readLine().split("\\s+");
            
            double n = Double.parseDouble(spec[0]);
            double k = Double.parseDouble(spec[1]);

            double pow = Math.log(n)/Math.log(2);
            //out.println(pow);

            if(k >= pow){
                out.println("Your wish is granted!");
            }
            else{
                out.println("You will become a flying monkey!");
            }

        }

        in.close();
        out.close();
    }


}