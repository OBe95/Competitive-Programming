import java.util.*;
import java.io.*;

class kattis {

    public static void main(String[] args) throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        Locale.setDefault(new Locale("en", "US"));

        while (in.ready()) {

            String[] spec = in.readLine().split("\\s+");
            int x = Integer.parseInt(spec[0]);
            int y = Integer.parseInt(spec[1]);
            int n = Integer.parseInt(spec[2]);

            for(int i = 1; i <= n; i++){

                if(i % x == 0 && i % y == 0){
                    out.println("FizzBuzz");
                }
                else if(i % x == 0){
                    out.println("Fizz");
                }
                else if(i % y == 0){
                    out.println("Buzz");
                }
                else{
                    out.println(i);
                }

            }

        }

        in.close();
        out.close();
    }


}