import java.util.*;
import java.io.*;

class Connection implements Comparable<Connection> {

    int b;
    int t;
    public Connection(int _b, int _t) {
        b = _b;
        t = _t;
    }

    @Override
    public int compareTo(Connection c){
        return Integer.compare(t, c.t);
    }

}

class Main {

    public static void main(String[] args) throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int tt = Integer.parseInt(in.readLine().trim());

        while (tt-- != 0) {

            in.readLine();
            int n = Integer.parseInt(in.readLine().trim())+1;
            int e = Integer.parseInt(in.readLine().trim());
            int maxT = Integer.parseInt(in.readLine().trim());
            int m = Integer.parseInt(in.readLine().trim());

            ArrayList<Connection> conn[] = new ArrayList[n];
            for(int i = 0; i < n; i++)
                conn[i] = new ArrayList<Connection>();

            for(int i = 0; i < m; i++){
                String[] input = in.readLine().split("\\s+");
                conn[Integer.parseInt(input[1])].add(new Connection(Integer.parseInt(input[0]), Integer.parseInt(input[2])));
            }

            int[] dist = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[e] = 0;

            PriorityQueue<Connection> queue = new PriorityQueue<Connection>();
            queue.add(new Connection(e, 0));

            while(queue.size() > 0){

                Connection c = queue.poll();
                int num = c.b;
                int t = c.t;
                if(t > dist[num])
                    continue;

                for(Connection cc : conn[num]){
                    if(t+cc.t <= maxT && t+cc.t < dist[cc.b]){
                        dist[cc.b] = t+cc.t;
                        queue.add(new Connection(cc.b, t+cc.t));
                    }
                }

            }

            int ans = 0;
            for(int i = 0; i < n; i++){
                if(dist[i] < Integer.MAX_VALUE)
                    ans++;
            }

            out.println(ans);
            if(tt != 0)
                out.println();

        }

        in.close();
        out.close();
    }

}