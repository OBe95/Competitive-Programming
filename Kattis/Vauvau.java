import java.util.*;
import java.io.*;

class kattis {

    public static void main(String[] args) throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        Locale.setDefault(new Locale("en", "US"));

        while (in.ready()) {

            String[] spec = in.readLine().split("\\s+");
            int a = Integer.parseInt(spec[0]);
            int b = Integer.parseInt(spec[1]);
            int c = Integer.parseInt(spec[2]);
            int d = Integer.parseInt(spec[3]);

            int d1 = a + b;
            int d2 = c + d;

            String[] input = in.readLine().split("\\s+");
            int p = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            int g = Integer.parseInt(input[2]);

            int p1 = p%d1;
            if(p1 == 0)
                p1 = d1;
            int p2 = p%d2;
            if(p2 == 0)
                p2 = d2;

            if(p1 <= a && p2 <= c){
                out.println("both");
            }
            else if(p1 <= a || p2 <= c){
                out.println("one");
            }
            else{
                out.println("none");
            }

            p1 = m%d1;
            if(p1 == 0)
                p1 = d1;
            p2 = m%d2;
            if(p2 == 0)
                p2 = d2;

            if(p1 <= a && p2 <= c){
                out.println("both");
            }
            else if(p1 <= a || p2 <= c){
                out.println("one");
            }
            else{
                out.println("none");
            }

            p1 = g%d1;
            if(p1 == 0)
                p1 = d1;
            p2 = g%d2;
            if(p2 == 0)
                p2 = d2;

            if(p1 <= a && p2 <= c){
                out.println("both");
            }
            else if(p1 <= a || p2 <= c){
                out.println("one");
            }
            else{
                out.println("none");
            }

        }

        in.close();
        out.close();
    }


}