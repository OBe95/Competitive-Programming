import java.util.*;
import java.io.*;

class kattis {

    public static void main(String[] args) throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        while(in.ready()){

            String[] info = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(info[0]);

            if(n == 0)
                break;

            int[] perm = new int[n];

            for(int i = 0; i < n; i++)
                perm[i] = Integer.parseInt(info[i+1])-1;

            String msg = in.readLine().trim();
            int l = msg.length();

            if(l%n != 0){
                for(int i = 0; i < n - (l%n); i++)
                    msg += ' ';
            }

            l = msg.length() / n;

            StringBuilder ans = new StringBuilder();

            int j = 0;

            while(j < l){
                for(int i = 0; i < n; i++){
                    ans.append(msg.charAt(perm[i]));
                    perm[i] += n;
                }
                j++;
            }
            

            out.println("'" + ans + "'");
            
        }

        in.close();
        out.close();
    }

}