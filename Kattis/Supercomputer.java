import java.util.*;
import java.io.*;

class kattis {

    public static void main(String[] args) throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        while(in.ready()) {

            String[] input = in.readLine().split("\\s+");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);

            BitSet bits = new BitSet(n);

            for(int i = 0; i < k; i++){

                String[] line = in.readLine().split("\\s+");
                char query = line[0].charAt(0);

                if(query == 'F'){
                    bits.flip(Integer.parseInt(line[1])-1);
                }
                else{
                    out.println(bits.get(Integer.parseInt(line[1])-1, Integer.parseInt(line[2])).cardinality());
                }

            }

        }

        in.close();
        out.close();
    }

}