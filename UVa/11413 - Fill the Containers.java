import java.util.*;
import java.io.*;

class Main {

    public static int n, m;
    public static int[] capacity;

    public static void main(String[] args) throws Exception{
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        while(in.ready()){

            String[] input = in.readLine().trim().split("\\s+");
            n = Integer.parseInt(input[0]);
            m = Integer.parseInt(input[1]);

            capacity = new int[n];
            String[] capacities = in.readLine().trim().split("\\s+");

            for(int i = 0; i < n; i++)
                capacity[i] = Integer.parseInt(capacities[i]);

            int high = Integer.MAX_VALUE;
            int low = 0;
            while(high > low){

                if(canFill(high)){
                    //out.println("can fill " + high);
                    high = low + (high-low)/2;
                }
                else{
                    //out.println("can't fill " + high);
                    low = high;
                    high += high/2;
                }

            }

            out.println(high+1);

        }

        in.close();
        out.close();
    
    }

    public static boolean canFill(int c){

        int filled = 0, currentCap = 0;
        for(int i = 0; i < n; i++){

            if(capacity[i] > c)
                return false;

            if(currentCap + capacity[i] > c)
                currentCap = 0;

            if(currentCap == 0)
                filled++;

            if(filled > m)
                return false;

            currentCap += capacity[i];

        }

        return true;

    }

}