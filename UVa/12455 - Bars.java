import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws Exception{
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int tt = Integer.parseInt(in.readLine().trim());

        while(tt-- != 0){
        
            int n = Integer.parseInt(in.readLine().trim());
            int p = Integer.parseInt(in.readLine().trim());

            String[] input = in.readLine().trim().split("\\s+");
            int[] nums = new int[p];

            for(int i = 0; i < p; i++)
                nums[i] = Integer.parseInt(input[i]);

            boolean possible = false;

            for(int i = 0; i < (1 << p); i++){
                int total = 0;
                for(int j = 0; j < p; j++){
                    if((i & (1 << j)) != 0)
                        total += nums[j];
                }
                if(total == n){
                    possible = true;
                    break;
                }
            }

            if(possible)
                out.println("YES");
            else
                out.println("NO");
            
        }

        in.close();
        out.close();
    
    }

}