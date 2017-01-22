import java.util.*;
import java.io.*;


class kattis {

    public static void main(String[] args) throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        String line = in.readLine();
        while (line != null) {

            String[] spec = line.split("\\s+");
            int a = Integer.parseInt(spec[0]);
            int b = Integer.parseInt(spec[1]);

            if(a == 0 && b == 0)
                break;

            out.println((int)(a/b) + " " + (a%b) + " / " + b);


            line = in.readLine();

        }

        in.close();
        out.close();
    }

}