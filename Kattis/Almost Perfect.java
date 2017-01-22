import java.util.*;
import java.io.*;

class kattis {

    public static void main(String[] args) throws Exception{
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        String input = in.readLine();
        while(input != null){
        
            int n = Integer.parseInt(input.trim());
            int sum = 1;
            for(int i = 2; i*i <= n; i++)
            {
                if(n % i == 0)
                {
                   sum += i;
                   int d = n/i;
                   if(d != i)
                      sum += d;
                }
            }

            if(sum == n)
                out.println(n + " perfect");
            else if(Math.abs(sum - n) <= 2)
                out.println(n + " almost perfect");
            else
                out.println(n + " not perfect");

            input = in.readLine();

        }

        in.close();
        out.close();
    
    }

}