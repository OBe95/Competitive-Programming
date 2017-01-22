import java.util.*;
import java.io.*;

class kattis {

    public static void main(String[] args) throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        while (in.ready()) {

            int n = Integer.parseInt(in.readLine());

            if(n <= 1){
                out.println(n);
                continue;
            }
            
            out.println((2*(n-1)));

        }

        in.close();
        out.close();
    }

}