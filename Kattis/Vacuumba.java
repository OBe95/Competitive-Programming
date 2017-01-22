import java.util.*;
import java.io.*;

class kattis {

    public static void main(String[] args) throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        Locale.setDefault(new Locale("en", "US"));

        int tt = Integer.parseInt(in.readLine());

        while (tt-- != 0) {

            int m = Integer.parseInt(in.readLine());

            double x = 0;
            double y = 0;
            double ang = 0;

            while(m-- != 0){

                String[] input = in.readLine().split("\\s+");
                double alpha = Double.parseDouble(input[0]);
                double d = Double.parseDouble(input[1]);

                ang += alpha;
                x += d * Math.sin(-1*ang*Math.PI/180.0);
                y += d * Math.cos(-1*ang*Math.PI/180.0);

            }
            
            out.printf("%.6f %.6f\n", x, y);

        }

        in.close();
        out.close();
    }

}