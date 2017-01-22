import java.util.*;
import java.io.*;

class kattis {

    public static void main(String[] args) throws Exception{
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        while(in.ready()){

            String[] dim = in.readLine().split("\\s+");
            long n = Long.parseLong(dim[0]);
            long k = Long.parseLong(dim[1]);

            if(k >= n){
                out.println(n-1);
                continue;
            }

            long tmp = (n-1)/k;
            long lastMult = tmp * k;
            //out.println(k + " " +lastMult);

            long ans = (lastMult == k) ? k + (n-1-lastMult) : k + 1 + (n-1-lastMult);

            out.println(ans);

        }

        in.close();
        out.close();
    
    }

}