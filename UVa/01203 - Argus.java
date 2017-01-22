import java.util.*;
import java.io.*;

class Instruction {

    public int id;
    public int period;
    public int execTime;

    public Instruction(int i, int p, int e){
        id = i;
        period = p;
        execTime = e;
    }

}

class Main {

    public static Comparator compareInstruction = new Comparator<Instruction>() {

        public int compare(Instruction i1, Instruction i2) {
            if(i1.execTime < i2.execTime)
                return -1;
            else if(i1.execTime > i2.execTime)
                return 1;
            return Integer.compare(i1.id, i2.id);
        }

    };

    public static void main(String[] args) throws Exception{
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        PriorityQueue<Instruction> queue = new PriorityQueue<Instruction>(10, compareInstruction);
        
        while(in.ready()){
        
            String[] input = in.readLine().split("\\s+");

            if(input[0].equals("#"))
                break;

            queue.add(new Instruction(Integer.parseInt(input[1]), Integer.parseInt(input[2]), Integer.parseInt(input[2])));

        }

        int k = Integer.parseInt(in.readLine());

        while(k-- != 0){

            Instruction i = queue.poll();

            queue.add(new Instruction(i.id, i.period, i.execTime+i.period));

            out.println(i.id);

        }

        in.close();
        out.close();
    
    }

}