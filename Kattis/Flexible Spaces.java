import java.util.*;
import java.io.*;

class kattis {

    public static void main(String[] args) throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        while(in.ready()){

            String[] line1 = in.readLine().trim().split("\\s+");
            int w = Integer.parseInt(line1[0]);
            int p = Integer.parseInt(line1[1]);

            String[] line2 = in.readLine().trim().split("\\s+");

            int[] interm = new int[p+2];
            interm[p+1] = w;

            for(int i = 1; i <= p; i++){
                interm[i] = Integer.parseInt(line2[i-1]);
            }

            TreeSet<Integer> diff = new TreeSet<Integer>();

            for(int i = p+1; i > 0; i--){
                for(int j = i-1; j >= 0; j--){
                    diff.add(interm[i]-interm[j]);
                }
            }

            while(diff.size() > 1){
                out.print(diff.pollFirst() + " ");
            }

            out.println(diff.pollFirst());
            
        }

        in.close();
        out.close();
    }

}