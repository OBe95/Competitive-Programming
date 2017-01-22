import java.util.*;
import java.io.*;
import java.math.BigInteger;

class kattis {

    public static void main(String[] args) throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        while (in.ready()) {

            
            BigInteger a = new BigInteger(in.readLine());
            BigInteger b = new BigInteger(in.readLine());
            out.println(a.add(b));
            
        }

        in.close();
        out.close();
    }

}