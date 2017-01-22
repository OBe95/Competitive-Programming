import java.util.*;
import java.io.*;
import java.lang.Math;

class kattis {

    public static StringBuilder ans;

    public static void main(String[] args) throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        while (in.ready()) {

            int n = Integer.parseInt(in.readLine());        

            ans = new StringBuilder();

            if(n < 0){
                n = -1 * n;
                ans.append("-1 ");
            }       

            primeFactors(n);

            out.println(ans.substring(0,ans.length()-1));
            
        }

        in.close();
        out.close();
    }

    public static void primeFactors(long n) {
        

        int powOfI = 0;
        while (n % 2 == 0 && n > 0) {
            n /= 2;
            powOfI++;
        }
        if(powOfI > 1){
            ans.append("2^" + powOfI + " ");
        }
        else if(powOfI > 0){
            ans.append("2 ");
        }

        for (long i = 3; i * i <= n; i+=2) {
            powOfI = 0;
            while (n % i == 0) {
                powOfI++;
                n /= i;
            }
            if(powOfI > 1){
                ans.append(i + "^" + powOfI + " ");
            }
            else if(powOfI > 0){
                ans.append(i + " ");
            }
        }
        if (n > 1){
            ans.append(n + " ");
        }

    }

}