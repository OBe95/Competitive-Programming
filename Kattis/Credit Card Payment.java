import java.util.*;
import java.io.*;

class kattis {

    public static void main(String[] args) throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        Locale.setDefault(new Locale("en", "US"));

        double eps = 1e-8;

        int tt = Integer.parseInt(in.readLine());

        while (tt-- != 0) {

            String[] spec = in.readLine().split("\\s+");
            
            double r = Double.parseDouble(spec[0])/100.0;
            double b = Double.parseDouble(spec[1]);
            double m = Double.parseDouble(spec[2]);

            int ans = 0;

            while(b > 0 && ans <= 1200){

                //double monthlyR = ((long)((b*r*100) + 0.5)) / 100.0;
                //out.println("\t" + (b*r) + " " + monthlyR);
                b = Math.round((b + b*r)*100 + eps)/100.0 - m;
                //b = ((int)((b + b*r) * 100 + 0.5 + eps)) / 100.0 - m;
                //out.println(b);
                ans++;

            }

            if(ans > 1200){
                out.println("impossible");
            }
            else{
                out.println(ans);
            }


        }

        in.close();
        out.close();
    }


}