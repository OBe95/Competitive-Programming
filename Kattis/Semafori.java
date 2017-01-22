import java.util.*;
import java.io.*;
import java.math.BigInteger;

class kattis {

    public static void main(String[] args) throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        while (in.ready()) {

            String[] input = in.readLine().split("\\s+");
            int n = Integer.parseInt(input[0]);
            int l = Integer.parseInt(input[1]);

            int distance = 0;
            int wait = 0;

            while(n-- != 0){
                String[] spec = in.readLine().split("\\s+");
                int d = Integer.parseInt(spec[0]);
                int r = Integer.parseInt(spec[1]);
                int g = Integer.parseInt(spec[2]);

                int tmpD = d + wait;

                if(tmpD%(r+g) < r)
                    wait += r - tmpD%(r+g);

            }

            out.println(l + wait);
            
        }

        in.close();
        out.close();
    }

}