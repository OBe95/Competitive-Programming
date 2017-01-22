import java.util.*;
import java.io.*;

class kattis {

    public static void main(String[] args) throws Exception{
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        while(in.ready()){

            String[] dims = in.readLine().split("\\s+");
            int n = Integer.parseInt(dims[0]);
            int t = Integer.parseInt(dims[1]);

            String[] params = in.readLine().split("\\s+");
            int a = Integer.parseInt(params[0]);
            int b = Integer.parseInt(params[1]);
            int c = Integer.parseInt(params[2]);

            int currT = Integer.parseInt(params[3]);


            PriorityQueue<Integer> time = new PriorityQueue<Integer>();

            for(int i = 0; i < n; i++){
                time.add(currT);
                currT = (int)((((long)a * currT + b)%c) + 1);
            }

            int penality = 0;
            int solved = 0;
            long elapsedT = 0;

            while(time.size() > 0){
                elapsedT += time.poll();
                if(elapsedT > t)
                    break;
                penality = (int)((penality + elapsedT)%1000000007);
                solved++;
            }

            out.println(solved + " " + penality);

        }

        in.close();
        out.close();
    
    }
}