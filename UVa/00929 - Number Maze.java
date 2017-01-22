import java.util.*;
import java.io.*;

class Cell implements Comparable<Cell> {

    int x;
    int y;
    int d;
    public Cell(int _x, int _y, int _d) {
        x = _x;
        y = _y;
        d = _d;
    }

    @Override
    public int compareTo(Cell c){
        return Integer.compare(d, c.d);
    }

}

class Main {

    public static void main(String[] args) throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int[] rMove = {-1, 1, 0, 0};
        int[] cMove = {0, 0, -1, 1};

        int tt = Integer.parseInt(in.readLine().trim());

        while (tt-- != 0) {

            int n = Integer.parseInt(in.readLine().trim());
            int m = Integer.parseInt(in.readLine().trim());

            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] input = in.readLine().split("\\s+");
                for(int j = 0; j < m; j++)
                    grid[i][j] = Integer.parseInt(input[j]);
            }

            int[][] dist = new int[n][m];
            for(int i = 0; i < n; i++)
                Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[0][0] = grid[0][0];

            PriorityQueue<Cell> queue = new PriorityQueue<Cell>();
            queue.add(new Cell(0, 0, dist[0][0]));

            while(queue.size() > 0){

                Cell c = queue.poll();
                int x = c.x;
                int y = c.y;
                int d = c.d;
                if(d > dist[x][y])
                    continue;

                for(int i = 0; i < 4; i++){
                    if(x+rMove[i] >= 0 && x+rMove[i] < n && y+cMove[i] >= 0 && y+cMove[i] < m && dist[x][y]+grid[x+rMove[i]][y+cMove[i]] < dist[x+rMove[i]][y+cMove[i]]){
                        dist[x+rMove[i]][y+cMove[i]] = dist[x][y]+grid[x+rMove[i]][y+cMove[i]];
                        queue.add(new Cell(x+rMove[i], y+cMove[i], dist[x+rMove[i]][y+cMove[i]]));
                    }
                }

            }

            out.println(dist[n-1][m-1]);

        }

        in.close();
        out.close();
    }

}