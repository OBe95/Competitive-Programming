import java.util.*;
import java.io.*;


class kattis {

    public static void main(String[] args) throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int i = 0;

        while (in.ready()) {

            String ans = "Case " + (++i) + ": ";
            String[] input = in.readLine().trim().split("\\s+");
            double x = Double.parseDouble(input[0]);
            double y = Double.parseDouble(input[1]);
            int r = Integer.parseInt(input[2]);

            double modulus = Math.sqrt(x*x + y*y);
            double x1 = x;
            double y1 = y;

            while(r-- != 0){

                if(modulus > 2)
                    break;

                double tmpX = x1;
                x1 = x1*x1 - y1*y1 + x;
                y1 = 2*tmpX*y1 + y;
                modulus = Math.sqrt(x1*x1 + y1*y1);

            }
            
            if(r==-1)
                ans += "IN";
            else
                ans += "OUT";

            out.println(ans);

        }

        in.close();
        out.close();
    }

}