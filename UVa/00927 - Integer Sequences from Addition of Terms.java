import java.util.*;
import java.io.*;
import java.lang.Math;

class Main {

    public static void main(String[] args) throws Exception{
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int tt = Integer.parseInt(in.readLine().trim());

        while(tt-- != 0){
        
            String aN = in.readLine().trim();

            int d = Integer.parseInt(in.readLine().trim());
            int k = Integer.parseInt(in.readLine().trim());

            int n = 0;
            int i = 0;
            for(n = 1; n <= k; n++){
                i += n*d;
                if(i >= k)
                    break;
            }

            out.println(calc(aN, n));

        }

        in.close();
        out.close();
    
    }

    public static long calc(String aN, int n){

        long ans = 0;
        String[] coeff = aN.split("\\s+");

        for(int i = 1; i < coeff.length; i++)
            ans += (long)Math.pow(n, i-1)*Integer.parseInt(coeff[i]);

        return ans;

    }

}