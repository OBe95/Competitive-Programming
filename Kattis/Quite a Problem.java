import java.util.*;
import java.io.*;


class kattis {

    public static void main(String[] args) throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        while (in.ready()) {

            String input = in.readLine().toLowerCase();

            if(input.contains("problem")){
                out.println("yes");
            }
            else
                out.println("no");
            
        }

        in.close();
        out.close();
    }

}