import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws Exception{
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int tt = Integer.parseInt(in.readLine().trim());

        while(tt-- != 0){
        
            int n = Integer.parseInt(in.readLine().trim());
            String[] input = in.readLine().trim().split("\\s+");

            int[] a = new int[n];
            a[0] = Integer.parseInt(input[0]);

            int ans = 0;

            for(int i = 1; i < n; i++){
                a[i] = Integer.parseInt(input[i]);
                for(int j = 0; j < i; j++){
                    if(a[j] <= a[i])
                        ans++;
                }
            }

            out.println(ans);

        }

        in.close();
        out.close();
    
    }

}