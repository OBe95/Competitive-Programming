import java.util.*;
import java.io.*;

class Main {

    public static int[][] height;
    public static int n, m, l, u, maxSquareDim;

    public static void main(String[] args) throws Exception{
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        while(in.ready()){

            String[] dims = in.readLine().trim().split("\\s+");
            n = Integer.parseInt(dims[0]);
            m = Integer.parseInt(dims[1]);
            if(n == 0 && m == 0)
                break;

            height = new int[n][m];

            for(int i = 0; i < n; i++){
                String[] heightsI = in.readLine().trim().split("\\s+");
                for(int j = 0; j < m; j++)
                    height[i][j] = Integer.parseInt(heightsI[j]);
            }

            int q = Integer.parseInt(in.readLine().trim());

            while(q-- != 0){

                String[] bounds = in.readLine().trim().split("\\s+");
                l = Integer.parseInt(bounds[0]);
                u = Integer.parseInt(bounds[1]);
                maxSquareDim = 0;

                for(int i = 0; i < n; i++){

                    squareDim(i);

                }

                out.println(maxSquareDim);

            }

            out.println("-");
            

        }

        in.close();
        out.close();
    
    }

    public static void squareDim(int i){

        int j = -1;
        for(int k = 0; k < m; k++){
            if(height[i][k] >= l){
                j = k;
                break;
            }
        }

        if(j == -1)
            return;

        i+=maxSquareDim; j+=maxSquareDim;
        while(i < n && j < m){
            if(height[i][j] <= u)
                maxSquareDim++;
            else
                break;
            i++; j++;
        }

    }

}