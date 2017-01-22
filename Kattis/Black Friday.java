import java.util.*;
import java.io.*;


class kattis {

    public static void main(String[] args) throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        while (in.ready()) {

            int n = Integer.parseInt(in.readLine());

            int[] occ = new int [7];
            int[] lastind = new int[7];

            String[] input = in.readLine().split("\\s+");

            for(int i = 0; i < n; i++){
                occ[Integer.parseInt(input[i])]++;
                lastind[Integer.parseInt(input[i])] = i+1;
            }

            int ans = 0;
            for(int i = 6; i > 0; i--){
                if(occ[i] == 1){
                    ans = lastind[i];
                    break;
                }
            }

            if(ans == 0){
                out.println("none");
            }
            else
                out.println(ans);
            
        }

        in.close();
        out.close();
    }

}