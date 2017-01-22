import java.util.*;
import java.io.*;

class Floor implements Comparable<Floor> {

    int num;
    int time;
    int elev;
    public Floor(int n, int t, int e) {
        num = n;
        time = t;
        elev = e;
    }

    @Override
    public int compareTo(Floor f){
        return Integer.compare(time, f.time);
    }

}

class Main {

    public static void main(String[] args) throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        while(in.ready()){

            String[] spec = in.readLine().split("\\s+");
            int n = Integer.parseInt(spec[0]);
            int k = Integer.parseInt(spec[1]);

            int[] elevTime = new int[n];
            String[] times = in.readLine().split("\\s+");
            for(int i = 0; i < n; i++)
                elevTime[i] = Integer.parseInt(times[i]);

            ArrayList<Integer> elevFloors[] = new ArrayList[n];
            for(int i = 0; i < n; i++)
                elevFloors[i] = new ArrayList<Integer>();

            ArrayList<Integer> conn[] = new ArrayList[100];
            for(int i = 0; i < 100; i++)
                conn[i] = new ArrayList<Integer>();

            for(int i = 0; i < n; i++){
                String[] input = in.readLine().split("\\s+");
                for(int j = 0; j < input.length; j++){
                    elevFloors[i].add(Integer.parseInt(input[j]));
                    conn[Integer.parseInt(input[j])].add(i);
                }
            }

            if(k == 0){
                out.println(0);
                continue;
            }

            int[][] dist = new int[n][100];
            for(int i = 0; i < n; i++)
                Arrays.fill(dist[i], Integer.MAX_VALUE);
            for(int i = 0; i < n; i++)
                dist[i][0] = 0;

            PriorityQueue<Floor> queue = new PriorityQueue<Floor>();
            queue.add(new Floor(0, -60, -1));
            //out.println("\t (0, -60, -1)");

            while(queue.size() > 0){

                Floor actF = queue.poll();
                int num = actF.num;
                int t = actF.time;
                int e = actF.elev;

                if(e != -1 && t > dist[e][num] || e == k)
                    continue;

                for(int elev : conn[num]){
                    int floorIndex = elevFloors[elev].indexOf(num);
                    int nextTime = (elev != e) ? t+60 : t;
                    if(floorIndex-1 >= 0){
                        int nextFloorDown = elevFloors[elev].get(floorIndex-1);
                        int nextTimeDown = nextTime + (num - nextFloorDown)*elevTime[elev];
                        if(nextTimeDown < dist[elev][nextFloorDown]){
                            dist[elev][nextFloorDown] = nextTimeDown;
                            queue.add(new Floor(nextFloorDown, nextTimeDown, elev));
                            //out.print("\t (" + nextFloorDown + ", " + nextTimeDown + ", " + elev + ") ");
                        }
                    }
                    if(floorIndex+1 < elevFloors[elev].size()){
                        int nextFloorUp = elevFloors[elev].get(floorIndex+1);
                        int nextTimeUp = nextTime + (nextFloorUp - num)*elevTime[elev];
                        if(nextTimeUp < dist[elev][nextFloorUp]){
                            dist[elev][nextFloorUp] = nextTimeUp;
                            queue.add(new Floor(nextFloorUp, nextTimeUp, elev));
                            //out.print("\t (" + nextFloorUp + ", " + nextTimeUp + ", " + elev + ") ");
                        }
                    }
                }
                //out.println();

            }

            int min = Integer.MAX_VALUE;

            for(int i = 0; i < n; i++)
                if(dist[i][k] < min)
                    min = dist[i][k];

            if(min == Integer.MAX_VALUE)
                out.println("IMPOSSIBLE");
            else
                out.println(min);

        }

        in.close();
        out.close();
    }

}