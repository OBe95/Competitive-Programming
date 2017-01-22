import java.util.*;
import java.io.*;

class kattis {

    public static void main(String[] args) throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        Locale.setDefault(new Locale("en", "US"));

        while (in.ready()) {

            String[] input = in.readLine().split("\\s+");

            double x1 = Double.parseDouble(input[0]);

            if(x1 == 0){
                break;
            }

            double y1 = Double.parseDouble(input[1]);
            double x2 = Double.parseDouble(input[2]);
            double y2 = Double.parseDouble(input[3]);
            double p = Double.parseDouble(input[4]);

            double ans = Math.pow(Math.pow(Math.abs(x1-x2),p)+Math.pow(Math.abs(y1-y2),p), 1.0/p);

            out.printf("%.10f\n", ans);

        }

        in.close();
        out.close();
    }

}