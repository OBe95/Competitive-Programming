import java.util.*;
import java.io.*;

class Connection implements Comparable<Connection> {

    int n;
    int w;
    public Connection(int _n, int _w) {
        n = _n;
        w = _w;
    }

    @Override
    public int compareTo(Connection c){
        return Integer.compare(w, c.w);
    }

}

class Main {

    public static void main(String[] args) throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int tt = Integer.parseInt(in.readLine().trim());

        for(int k = 1; k <= tt; k++) {
            String[] spec = in.readLine().split("\\s+");
            int n = Integer.parseInt(spec[0]);
            int m = Integer.parseInt(spec[1]);
            int s = Integer.parseInt(spec[2]);
            int d = Integer.parseInt(spec[3]);

            ArrayList<Connection> conn[] = new ArrayList[n];
            for(int i = 0; i < n; i++)
                conn[i] = new ArrayList<Connection>();

            for(int i = 0; i < m; i++){
                String[] input = in.readLine().split("\\s+");
                conn[Integer.parseInt(input[0])].add(new Connection(Integer.parseInt(input[1]), Integer.parseInt(input[2])));
                conn[Integer.parseInt(input[1])].add(new Connection(Integer.parseInt(input[0]), Integer.parseInt(input[2])));
            }

            int[] dist = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[s] = 0;

            PriorityQueue<Connection> queue = new PriorityQueue<Connection>();
            queue.add(new Connection(s, 0));

            while(queue.size() > 0){

                Connection c = queue.poll();
                int num = c.n;
                int w = c.w;
                if(w > dist[num])
                    continue;

                for(Connection cc : conn[num]){
                    if(w+cc.w < dist[cc.n]){
                        dist[cc.n] = w+cc.w;
                        queue.add(new Connection(cc.n, w+cc.w));
                    }
                }

            }

            if(dist[d] == Integer.MAX_VALUE)
                out.println("Case #" + k + ": unreachable");
            else
                out.println("Case #" + k + ": " + dist[d]);

        }

        in.close();
        out.close();
    }

}