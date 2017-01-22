import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws Exception{
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int caseNum = 0;

        while(in.ready()){
        
            int n = Integer.parseInt(in.readLine().trim());

            if(n == 0)
                break;

            caseNum++;

            int[] a = new int[n];

            for(int i = 0; i < n; i++)
                a[i] = Integer.parseInt(in.readLine().trim());

            int affect = n*(n-1)/2;
            int[] pairs = new int[affect];
            int index = 0;

            for(int i = 0; i < n-1; i++){
                for(int j = i+1; j < n; j++){
                    pairs[index++] = a[i]+a[j];
                }
            }

            Arrays.sort(pairs);

            int q = Integer.parseInt(in.readLine().trim());

            out.println("Case " + caseNum + ":");
            while(q-- != 0){

                int num = Integer.parseInt(in.readLine().trim());
                int i = 0;
                for(i = 0; i < affect; i++){
                    if(pairs[i] >= num)
                        break;
                }
                int ans = -1;
                if(i == affect)
                    ans = pairs[affect-1];
                else if(i == 0)
                    ans = pairs[0];
                else
                    ans = (pairs[i] - num < num - pairs[i-1]) ? pairs[i] : pairs[i-1];

                out.println("Closest sum to " + num + " is " + ans + ".");
            }

        }

        in.close();
        out.close();
    
    }

}