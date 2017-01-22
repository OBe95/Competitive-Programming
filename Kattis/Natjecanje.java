import java.util.*;
import java.io.*;


class kattis {

    public static void main(String[] args) throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        while (in.ready()) {

            String[] dims = in.readLine().split("\\s+");
            int n = Integer.parseInt(dims[0]);
            int s = Integer.parseInt(dims[1]);
            int r = Integer.parseInt(dims[2]);

            boolean[] isDamaged = new boolean[n+1];
            boolean[] hasReseve = new boolean[n+1];

            String[] dam = in.readLine().split("\\s+");
            for(int i = 0; i < s; i++)
                isDamaged[Integer.parseInt(dam[i])] = true;

            String[] res = in.readLine().split("\\s+");
            for(int i = 0; i < r; i++){
                hasReseve[Integer.parseInt(res[i])] = true;
            }

            int ans = 0;
            for(int i = 1; i <= n; i++){
                if(isDamaged[i]){
                    if(hasReseve[i]){
                        hasReseve[i] = false;
                    }
                    else if(i > 1 && hasReseve[i-1]){
                        hasReseve[i-1] = false;
                    }
                    else if(i < n && hasReseve[i+1]){
                        hasReseve[i+1] = false;
                    }
                    else{
                        ans++;
                    }
                }
            }

            out.println(ans);
            
        }

        in.close();
        out.close();
    }

}