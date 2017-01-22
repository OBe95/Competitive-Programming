import java.util.*;
import java.io.*;
import java.lang.Math;

class kattis {

    public static void main(String[] args) throws Exception{
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        while(in.ready()){

            String[] dim = in.readLine().split("\\s+");
            int n = Integer.parseInt(dim[0]);
            int p = Integer.parseInt(dim[1]);

            String[] input = in.readLine().split("\\s+");
            int max_so_far = Integer.parseInt(input[0]) - p;
            int curr_max = max_so_far;

            for(int i = 1; i < n; i++){
                int tmp = Integer.parseInt(input[i]) - p;
                curr_max = (int)Math.max(tmp, curr_max+tmp);
                max_so_far = (int)Math.max(curr_max, max_so_far);
            }

            out.println(max_so_far);

        }

        in.close();
        out.close();
    
    }

}