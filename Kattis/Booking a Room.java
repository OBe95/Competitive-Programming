import java.util.*;
import java.io.*;

class kattis {

    public static void main(String[] args) throws Exception{
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

            String[] dims = in.readLine().split("\\s+");
            int r = Integer.parseInt(dims[0]);
            int n = Integer.parseInt(dims[1]);

            if(n == r)
                out.println("too late");

            boolean[] taken = new boolean[r+1];

            while(n-- != 0){
                taken[Integer.parseInt(in.readLine())] = true;
            }
            
            for(int i = 1; i <= r; i++){
                if(!taken[i]){
                    out.println(i);
                    break;
                }
            }

        
        in.close();
        out.close();
    
    }

}