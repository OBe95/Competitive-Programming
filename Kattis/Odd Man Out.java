import java.util.*;
import java.io.*;

class kattis {

    public static void main(String[] args) throws Exception{
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int tt = Integer.parseInt(in.readLine());

        for(int i = 1; i <= tt; i++){

            int g = Integer.parseInt(in.readLine());

            PriorityQueue<Integer> couples = new PriorityQueue<Integer>();
            String[] input = in.readLine().split("\\s+");

            for(int j = 0; j < g; j++)
                couples.add(Integer.parseInt(input[j]));

            int first = couples.poll();
            while(couples.size() > 0){
                if(couples.poll() == first){
                    first = couples.poll();
                }
                else{
                    break;
                }
            }

            out.println("Case #" + i + ": " + first);

        }

        in.close();
        out.close();
    
    }

}