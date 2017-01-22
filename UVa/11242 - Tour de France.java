import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws Exception{

        Locale.setDefault(new Locale("en", "US"));
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int caseNum = 0;

        while(in.ready()){
        
            String[] input = in.readLine().trim().split("\\s+");
            int fN = Integer.parseInt(input[0]);

            if(fN == 0)
                break;

            int rN = Integer.parseInt(input[1]);

            int[] f = new int[fN];
            int[] r = new int[rN];

            String[] front = in.readLine().trim().split("\\s+");
            String[] rear = in.readLine().trim().split("\\s+");

            for(int i = 0; i < fN; i++)
                f[i] = Integer.parseInt(front[i]);

            for(int i = 0; i < rN; i++)
                r[i] = Integer.parseInt(rear[i]);

            double[] pairs = new double[fN*rN];
            int count = 0;

            for(int i = 0; i < fN; i++){
                for (int j = 0; j < rN; j++){
                    pairs[count] = (double)r[j] / f[i]; 
                    count++;     
                }
            }

            Arrays.sort(pairs);

            double max = 0;

            for(int i = 0; i < fN*rN-1; i++)
                max = (pairs[i+1]/pairs[i] > max) ? pairs[i+1]/pairs[i] : max;

            out.printf("%.2f\n", max);

        }

        in.close();
        out.close();
    
    }

}