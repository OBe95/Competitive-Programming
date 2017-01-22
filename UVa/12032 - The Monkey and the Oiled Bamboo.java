import java.util.*;
import java.io.*;

class Main {

    public static int n;
    public static int[] height;

    public static void main(String[] args) throws Exception{
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int tt = Integer.parseInt(in.readLine().trim());

        for(int i = 1; i <= tt; i++){

            n = Integer.parseInt(in.readLine().trim());
            height = new int[n];
            String[] input = in.readLine().trim().split("\\s+");

            for(int j = 0; j < n; j++)
                height[j] = Integer.parseInt(input[j]);

            int h = Integer.MAX_VALUE;
            int l = 0;
            int ans = 0;

            while(h > l){

                int mid = (h+l) / 2;
                if(canReach(mid)){
                    ans = mid;
                    h = mid;
                }
                else{
                    l = mid+1;
                }

            }

            out.println("Case " + i + ": " + ans);

        }

        in.close();
        out.close();
    
    }

    public static boolean canReach(int k){

        int actHeight = 0;
        for(int i = 0; i < n; i++){

            if(height[i] - actHeight > k)
                return false;
            if(height[i] - actHeight == k)
                k--;
            actHeight = height[i];
            if(k < 0)
                return false;

        }

        return true;

    }

}