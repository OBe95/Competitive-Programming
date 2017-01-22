import java.util.*;
import java.io.*;
import java.lang.Math;

class Main {

    public static void main(String[] args) throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        while(in.ready()) {

            int n = Integer.parseInt(in.readLine());
            int powN = (int)Math.pow(2, n);

            int[] weights = new int[powN];
            int[] potencies = new int[powN];

            for(int i = 0; i < powN; i++)
                weights[i] = Integer.parseInt(in.readLine());


            for(int i = 0; i < powN; i++)
                for(int j = 0; j < n; j++)
                    potencies[i] += weights[i ^ (1 << j)];

            int max = 0;

            for(int i = 0; i < powN; i++)
                for(int j = 0; j < n; j++)
                    max = Math.max(max, potencies[i] + potencies[i ^ (1 << j)]);

            out.println(max);

        }

        in.close();
        out.close();
    }

}