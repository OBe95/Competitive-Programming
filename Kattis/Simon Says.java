import java.util.*;
import java.io.*;

class kattis {

    public static char[] input;

    public static void main(String[] args) throws Exception{
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        while(in.ready()){

            int n = Integer.parseInt(in.readLine());

            while(n-- != 0){

                String input = in.readLine();
                if(input.length() < 10)
                    continue;

                if(input.substring(0, 10).equals("Simon says"))
                    out.println(input.substring(10));

            }

        }

        in.close();
        out.close();
    
    }

}