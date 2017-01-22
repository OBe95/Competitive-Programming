import java.util.*;
import java.io.*;
import java.lang.Math;

class pair {

    public int i;
    public int j;
    public pair(int _i, int _j){
        i = _i;
        j = _j;
    }

}

class Main {

    public static void main(String[] args) throws Exception{
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        while(in.ready()){
        
            int m = Integer.parseInt(in.readLine().trim());
            pair[] ones = new pair[m*m];
            pair[] threes = new pair[m*m];

            int countOnes = 0;
            int countThrees = 0;

            for(int k = 0; k < m; k++){
                String input = in.readLine().trim();
                for(int l = 0; l < m; l++){
                    if(input.charAt(l) == '1'){
                        ones[countOnes] = new pair(k, l);
                        countOnes++;
                    }
                    else if(input.charAt(l) == '3'){
                        threes[countThrees] = new pair(k, l);
                        countThrees++;
                    }
                }
            }

            int ans = 0;
            for(int k = 0; k < countOnes; k++){
                int oneI = ones[k].i;
                int oneJ = ones[k].j;
                int min = Integer.MAX_VALUE;
                for(int l = 0; l < countThrees; l++){
                    int dist = (int)(Math.abs(oneI-threes[l].i) + Math.abs(oneJ-threes[l].j));
                    min = (dist < min) ? dist : min; 
                }
                ans = (ans < min) ? min : ans;
            }

            out.println(ans);
            
        }

        in.close();
        out.close();
    
    }

}