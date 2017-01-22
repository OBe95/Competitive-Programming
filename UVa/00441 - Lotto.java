import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws Exception{
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        String ans = "";
        int testCase = 0;

        while(in.ready()){
        
            String[] input = in.readLine().trim().split("\\s+");
            int k = Integer.parseInt(input[0]);

            if(k == 0)
                break;

            testCase++;
            if(testCase > 1)
                out.println(ans);
            ans = "";

            for(int a = 1; a <= k-5; a++)
                for(int b = a+1; b <= k-4; b++)
                    for(int c = b+1; c <= k-3; c++)
                        for(int d = c+1; d <= k-2; d++)
                            for(int e = d+1; e <= k-1; e++)
                                for(int f = e+1; f <= k; f++)
                                    ans += input[a] + " " + input[b] + " " + input[c] + " " + input[d] + " " + input[e] + " " + input[f] + "\n";

        }

        out.print(ans);

        in.close();
        out.close();
    
    }

}