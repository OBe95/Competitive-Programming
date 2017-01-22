import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws Exception{
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        
        while(in.ready()){
        
            int n = Integer.parseInt(in.readLine());

            if(n == 0)
                break;

            PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

            String[] input = in.readLine().split("\\s+");

            for(int i = 0; i < n; i++)
                queue.add(Integer.parseInt(input[i]));

            long cost = 0;

            while(queue.size() > 1){

                int newCost = queue.poll() + queue.poll();
                cost += newCost;

                queue.add(newCost);

            }

            out.println(cost);

        }

        in.close();
        out.close();
    
    }

}