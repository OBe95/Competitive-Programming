import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws Exception{
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        
        while(in.ready()){
        
            String[] input = in.readLine().split("\\s+");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);

            if(n == 0 && m == 0)
                break;

            HashSet<Integer> nCDs = new HashSet<Integer>();

            while(n-- != 0)
                nCDs.add(Integer.parseInt(in.readLine()));

            int total = 0;

            while(m-- != 0){
                int cdId = Integer.parseInt(in.readLine());
                if(nCDs.contains(cdId))
                    total++;
            }

            out.println(total);
        
        }

        in.close();
        out.close();
    
    }

}