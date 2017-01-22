import java.util.*;
import java.io.*;

class pair {
    public int x;
    public int y;

    public pair(int _x, int _y){
        x = _x;
        y = _y;
    }
}

class Main {

    public static void main(String[] args) throws Exception{
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        while(in.ready()){
        
            int k = Integer.parseInt(in.readLine().trim());

            ArrayList<pair> sols = new ArrayList<pair>();

            for(int y = k+1; y <= 2*k; y++){
                if((y*k)%(y-k) == 0)
                    sols.add(new pair((y*k)/(y-k), y));
            }

            out.println(sols.size());
            for(pair p : sols){
                out.println("1/" + k + " = 1/" + p.x + " + 1/" + p.y);
            }

        }

        in.close();
        out.close();
    
    }

}