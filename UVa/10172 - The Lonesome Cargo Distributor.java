import java.util.*;
import java.io.*;
import java.lang.Math;


class Main {

    public static ArrayList<Queue<Integer>> queues;
    public static Stack<Integer> stack;
    public static int n;

    public static void main(String[] args) throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int tt = Integer.parseInt(in.readLine());

        while (tt-- != 0) {

            queues = new ArrayList<Queue<Integer>>();
            stack = new Stack<Integer>();

            String[] line1 = in.readLine().split("\\s+");
            n = Integer.parseInt(line1[0]);
            int s = Integer.parseInt(line1[1]);
            int q = Integer.parseInt(line1[2]);

            for(int i = 0; i < n; i++){

                String[] line = in.readLine().split("\\s+");
                int qLenth = Integer.parseInt(line[0]);
                Queue<Integer> queueI = new ArrayDeque<Integer>();

                for(int j = 1; j <= qLenth; j++)
                    queueI.add(Integer.parseInt(line[j]));

                queues.add(queueI);

            }

            long neededTime = 0;
            int lastStop = 0;

            L: while(true){

                for(int i = 0; i < n; i++){

                    boolean stationStop = false;//no unload in station i

                    while(!stack.empty() && (stack.peek() == i+1 || queues.get(i).size() < q)){
                        
                        stationStop = true;
                        int tmpInt = stack.pop();

                        if(tmpInt != i+1)
                            queues.get(i).add(tmpInt);

                        neededTime++;

                    }

                    while(!queues.get(i).isEmpty() && stack.size() < s){

                        stationStop = true;
                        stack.add(queues.get(i).poll());
                        neededTime++;
                        
                    }

                    boolean endProcess = stack.empty();
                    for(int j = 0; j < n && endProcess; j++)
                        endProcess &= queues.get(j).isEmpty();

                    if(endProcess)
                        break L;

                    neededTime += 2;

                }

            }

            out.println(neededTime);

            
        }

        in.close();
        out.close();
    }

}