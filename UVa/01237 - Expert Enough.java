import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws Exception{
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int tt = Integer.parseInt(in.readLine().trim());

        while(tt-- != 0){
        
            int d = Integer.parseInt(in.readLine().trim());
            String[] names = new String[d];
            int[] low = new int[d];
            int[] high = new int[d];

            for(int i = 0; i < d; i++){
                String[] input = in.readLine().trim().split("\\s+");
                names[i] = input[0];
                low[i] = Integer.parseInt(input[1]);
                high[i] = Integer.parseInt(input[2]);
            }

            int q = Integer.parseInt(in.readLine().trim());

            while(q-- != 0){

                int price = Integer.parseInt(in.readLine().trim());
                int count = 0;
                int index = -1;

                for(int i = 0; i < d && count < 2; i++){
                    if(low[i] <= price && price <= high[i]){
                        index = i;
                        count++;
                    }
                }

                if(count == 1){
                    out.println(names[index]);
                }
                else{
                    out.println("UNDETERMINED");
                }

            }

            if(tt != 0)
                out.println();

        }

        in.close();
        out.close();
    
    }

}