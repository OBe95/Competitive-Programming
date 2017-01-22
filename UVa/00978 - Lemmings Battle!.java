import java.util.*;
import java.io.*;
import java.lang.Math;

class Main {

    public static void main(String[] args) throws Exception{
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int tt = Integer.parseInt(in.readLine());
        
        while(tt-- != 0){
        
            String[] input = in.readLine().split("\\s+");
            int battleFields = Integer.parseInt(input[0]);
            int greenSoldiers = Integer.parseInt(input[1]);
            int blueSoldiers = Integer.parseInt(input[2]);

            PriorityQueue<Integer> greenPowers = new PriorityQueue<Integer>();
            PriorityQueue<Integer> bluePowers = new PriorityQueue<Integer>();

            for(int i = 0; i < greenSoldiers; i++)
                greenPowers.add(-Integer.parseInt(in.readLine()));

            for(int i = 0; i < blueSoldiers; i++)
                bluePowers.add(-Integer.parseInt(in.readLine()));


            L: while(greenPowers.size() > 0 && bluePowers.size() > 0){

                int battles = Math.min(battleFields, (int)Math.min(greenPowers.size(), bluePowers.size()));

                ArrayList<Integer> greenWinners = new ArrayList<Integer>();
                ArrayList<Integer> blueWinners = new ArrayList<Integer>();

                for(int i = 0; i < battles; i++){

                    int greenPower = -greenPowers.poll();
                    int bluePower = -bluePowers.poll();

                    if(greenPower > bluePower){
                        greenWinners.add(bluePower - greenPower);
                    }
                    else if(bluePower > greenPower){
                        blueWinners.add(greenPower - bluePower);
                    }

                }

                for(Integer gWinner : greenWinners)
                    greenPowers.add(gWinner);

                for(Integer bWinner : blueWinners)
                    bluePowers.add(bWinner);

            }

            if(greenPowers.size() > 0){

                out.println("green wins");
                while(greenPowers.size() > 0)
                    out.println(-greenPowers.poll());

            }
            else if(bluePowers.size() > 0){

                out.println("blue wins");
                while(bluePowers.size() > 0)
                    out.println(-bluePowers.poll());

            }
            else{
                out.println("green and blue died");
            }

            if(tt != 0)
                out.println();
        
        }

        in.close();
        out.close();
    
    }

}