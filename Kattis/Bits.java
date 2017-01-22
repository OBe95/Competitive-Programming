import java.util.*;
import java.io.*;

class kattis {

    public static void main(String[] args) throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int tt = Integer.parseInt(in.readLine());

        while (tt-- != 0) {

            String num = in.readLine();

            int max = 0;

            for(int i = 1; i <= num.length(); i++){
                int n = Integer.parseInt(num.substring(0,i));
                String tmpBin = Integer.toBinaryString(n);
                BitSet bits = BitSet.valueOf(new long[] { Long.parseLong(tmpBin, 2) });
                //out.println("\t" + bits.toString() + " " + bits.cardinality());
                if(bits.cardinality() > max)
                    max = bits.cardinality();
            }

            out.println(max);
            
        }

        in.close();
        out.close();
    }

}