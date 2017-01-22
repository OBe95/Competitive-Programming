import java.util.*;
import java.io.*;

class kattis {

    public static void main(String[] args) throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());

        while (n-- != 0) {

            
            String[] input = in.readLine().split("\\s+");
            String k = input[0];
            String[] vals = input[1].split("/");
            int left = Integer.parseInt(vals[0]);
            int right = Integer.parseInt(vals[1]);

            if(right == 1){
                out.println(k + " 1/" + (left+1));
                continue;
            }

            if(left < right){
                out.println(k + " " + right + "/" + (right-left));
                continue;
            }

            int count = left/right;

            left -= count * right;

            int tmp = left;
            left = right;
            right = right-tmp;

            right += count * left;
            

            out.println(k + " " + left + "/" + right);
            
        }

        in.close();
        out.close();
    }

}