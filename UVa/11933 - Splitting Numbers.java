import java.util.*;
import java.io.*;


class Main {

    public static void main(String[] args) throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        while (in.ready()) {

            int n = Integer.parseInt(in.readLine());

            if(n == 0)
                break;

            int length = Integer.toBinaryString(n).length();

            int a = n;
            int b = n;

            int i = 0;

            L: while(i < length){

                //out.println("a = " + Integer.toBinaryString(a) + " b = " + Integer.toBinaryString(b));

                while(i < length && (n & (1 << i)) == 0)
                    i++;

                if(i == length)
                    break L;

                b ^= (1 << i);

                i++;
                while(i < length && (n & (1 << i)) == 0)
                    i++;

                if(i == length)
                    break L;
                
                a ^= (1 << i);

                i++;

            }

            out.println(a + " " + b);



        }

        in.close();
        out.close();
    }

}