import java.util.*;
import java.io.*;
import java.lang.Math;

class Main {

    public static int p, q, r, s, t, u;
    public static double eps = 1e-9;

    public static void main(String[] args) throws Exception{

        Locale.setDefault(new Locale("en", "US"));
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        while(in.ready()){

            String[] input = in.readLine().trim().split("\\s+");
            p = Integer.parseInt(input[0]);
            q = Integer.parseInt(input[1]);
            r = Integer.parseInt(input[2]);
            s = Integer.parseInt(input[3]);
            t = Integer.parseInt(input[4]);
            u = Integer.parseInt(input[5]);

            double low = 0, high = 1, mid = 0, ans = -1;
            while(high != low){
                mid = (high+low)/2;
                double tmp = f(mid);
                if(Math.abs(tmp) < eps){
                    ans = mid;
                    break;
                }
                if(tmp > 0)
                    low = mid;
                else
                    high = mid;
            }

            if(ans == -1)
                out.println("No solution");
            else
                out.printf("%.4f\n", ans);

        }

        in.close();
        out.close();
    
    }
//p*exp(-x) + q * sin(x) + r * cos(x) + s * tan(x) + t*(x^2) + u
    public static double f(double x){

        return (p * Math.exp(-1*x)) + (q * Math.sin(x)) + (r * Math.cos(x)) + (s * Math.tan(x)) + (t * Math.pow(x, 2)) + u;

    }

}