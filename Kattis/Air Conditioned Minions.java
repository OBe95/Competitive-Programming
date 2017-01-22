import java.util.*;
import java.io.*;

class temp implements Comparable<temp> {

    public int start;
    public int end;

    public temp(int s, int e){
        start = s;
        end = e;
    }

    @Override
    public int compareTo(temp t){
        return Integer.compare(end, t.end);
    }

}

class kattis {

    public static void main(String[] args) throws Exception{
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        while(in.ready()){

            int n = Integer.parseInt(in.readLine());

            PriorityQueue<temp> temps = new PriorityQueue<temp>();

            for(int i = 0; i < n; i++){
                String[] input = in.readLine().split("\\s+");
                temps.add(new temp(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
            }

            int rooms = 0;

            while(temps.size() > 0){
             
                temp t = temps.poll();
                rooms++;
                while(temps.size() > 0 && temps.peek().start <= t.end){
                    temps.poll();
                }

            }

            out.println(rooms);

        }

        in.close();
        out.close();
    
    }
}