import java.util.*;
import java.io.*;


class kattis {

    public static void main(String[] args) throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        while (in.ready()) {

            int input = Integer.parseInt(in.readLine());

            int supPow = (int)Math.pow(2, Math.ceil(Math.log(input)/Math.log(2)));

            if(supPow == input){
                out.println(supPow + " 0");
                continue;
            }
            int n = 0;
            int breaks = 0;
            int inpCpy = supPow;

            while(n != input){
                
                //System.out.println(n + " " + infPow + " " + supPow);
                inpCpy /= 2;
                if(inpCpy + n <= input)
                    n += inpCpy;
                breaks++;

            }

            out.println(supPow + " " + breaks);
            
        }

        in.close();
        out.close();
    }

}