import java.util.*;
import java.io.*;

class kattis {


    public static void main(String[] args) throws Exception{
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        while(in.ready()){

            String[] input = in.readLine().trim().split("\\s+");
            int s = Integer.parseInt(input[0]);
            int v1 = Integer.parseInt(input[1]);
            int v2 = Integer.parseInt(input[2]);

            int small = 0;

            while(s % v1 != 0 && s > 0){
                s -= v2;
                small++;
            }

            if(s == 0 || s%v1 == 0)
                out.println((s/v1) + " " + small);
            else
                out.println("Impossible");

        }

        in.close();
        out.close();
    
    }
    
}