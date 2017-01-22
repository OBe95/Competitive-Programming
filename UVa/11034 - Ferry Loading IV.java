import java.util.*;
import java.io.*;

class Main {

    public static boolean ferryAtLeft;
    public static int crossTimes, ferryLength, lastId;

    public static void main(String[] args) throws Exception{
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        
        int tt = Integer.parseInt(in.readLine());
        
        while(tt-- != 0){
        
            String[] line1 = in.readLine().split("\\s+");
            ferryLength = Integer.parseInt(line1[0]) * 100;
            int m = Integer.parseInt(line1[1]);
            
            Queue<Integer> queueLeft = new ArrayDeque<Integer>();
            Queue<Integer> queueRight = new ArrayDeque<Integer>();
            
            for(int i = 0; i < m; i++){
            
                String[] line = in.readLine().split("\\s+");
                if(line[1].equals("left"))
                    queueLeft.add(Integer.parseInt(line[0]));
                else
                    queueRight.add(Integer.parseInt(line[0]));
            
            }
            
            crossTimes = 0;
            ferryAtLeft = true;

            
            while(!queueLeft.isEmpty() || !queueRight.isEmpty()){

                if(ferryAtLeft)
                    unloadSide(queueLeft, queueRight);
                else
                    unloadSide(queueRight, queueLeft);

            }

            out.println(crossTimes);
        
        }

        in.close();
        out.close();
    
    }

    public static void unloadSide(Queue<Integer> actSide, Queue<Integer> otherSide){

        boolean transporting = false;
        int ferryFreeLength = ferryLength;
        while(!actSide.isEmpty() && actSide.peek() <= ferryFreeLength){
            transporting = true;
            ferryFreeLength -= actSide.poll();
        }

        crossTimes++;
        ferryAtLeft = !ferryAtLeft;

    }

}