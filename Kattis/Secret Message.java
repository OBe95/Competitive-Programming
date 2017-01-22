import java.util.*;
import java.io.*;
import java.lang.Math;

class kattis {

    public static void main(String[] args) throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int tt = Integer.parseInt(in.readLine().trim());

        while(tt-- != 0){

            String input = in.readLine().trim();
            int l = input.length();
            int m = (int)Math.sqrt(l);
            m = ((double)m == Math.sqrt(l)) ? m : m+1;

            StringBuilder ans = new StringBuilder();

            for(int i = m-1; i >= 0; i--){
                int j = i;
                while(j < l){
                    ans.append(input.charAt(j));
                    j += m;
                }
            }

            out.println(ans.reverse().toString());
            
        }

        in.close();
        out.close();
    }

}