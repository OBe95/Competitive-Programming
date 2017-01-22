import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws Exception{
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        while(in.ready()){

            String[] input = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);

            if(dividesFact(n, m))
                out.println(m + " divides " + n + "!");
            else
                out.println(m + " does not divide " + n + "!");

        }

        in.close();
        out.close();
    
    }

    public static boolean dividesFact(int n, int m) {
        
        if (m == 0) return true;
        if (n == 0 && m == 1) return true;
        for (int i = 2; m > n && i*i <= m; i++) {
            //power of i in m
            int powOfiM = 0;
            while(m % i == 0){
                powOfiM++;
                m /= i;
            }
            //power of i in n
            int powOfiN = 0;
            for(int j = i; j <= n && powOfiN < powOfiM; j *= i){
                powOfiN += n / j;
            }
            if (powOfiM > powOfiN) return false;
        }
        return m <= n;

    }
}