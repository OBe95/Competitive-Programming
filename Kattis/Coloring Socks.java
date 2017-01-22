import java.util.*;
import java.io.*;
import java.lang.Math;

class kattis {

    public static void main(String[] args) throws Exception{
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        while(in.ready()){

            String[] dim = in.readLine().split("\\s+");
            int s = Integer.parseInt(dim[0]);
            int c = Integer.parseInt(dim[1]);
            int k = Integer.parseInt(dim[2]);

            String[] input = in.readLine().split("\\s+");
            PriorityQueue<Integer> color = new PriorityQueue<Integer>();

            for(int i = 0; i < s; i++)
                color.add(Integer.parseInt(input[i]));

            int numMachines = 1;
            int prevColor = color.poll();
            int actSocks = 1;

            while(color.size() > 0){
                //out.println(numMachines + " : " + actSocks);
                int actColor = color.poll();
                if((int)Math.abs(actColor - prevColor) > k || actSocks >= c){
                    actSocks = 1;
                    numMachines++;
                }
                else{
                    actSocks++;
                }
                prevColor = actColor;
            }

            out.println(numMachines);

        }

        in.close();
        out.close();
    
    }

}