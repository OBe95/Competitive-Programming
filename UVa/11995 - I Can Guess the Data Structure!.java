import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws Exception{
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        
        while(in.ready()){
        
            int n = Integer.parseInt(in.readLine());

            Stack<Integer> stack = new Stack<Integer>();
            Queue<Integer> queue = new ArrayDeque<Integer>();
            PriorityQueue<Integer> pqueue = new PriorityQueue<Integer>();

            boolean isStack = true;
            boolean isQueue = true;
            boolean isPQueue = true;

            while(n-- != 0){

                String[] input = in.readLine().trim().split("\\s+");
                int query = Integer.parseInt(input[0]);
                int x = Integer.parseInt(input[1]);

                if(query == 1){

                    if(isStack)
                        stack.add(x);

                    if(isQueue)
                        queue.add(x);

                    if(isPQueue)
                        pqueue.add(-x);

                }

                else{

                    if(isStack && (stack.empty() || stack.pop() != x))
                        isStack = false;

                    if(isQueue && (queue.size() == 0 || queue.poll() != x))
                        isQueue = false;

                    if(isPQueue && (pqueue.size() == 0 || pqueue.poll() != -x))
                        isPQueue = false;

                }

            }

            if((isStack && isQueue) || (isStack && isPQueue) || (isQueue && isPQueue))
                out.println("not sure");
            else if(isStack)
                out.println("stack");
            else if(isQueue)
                out.println("queue");
            else if(isPQueue)
                out.println("priority queue");
            else
                out.println("impossible");

        }

        in.close();
        out.close();
    
    }

}