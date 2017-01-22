import java.util.*;
import java.io.*;
import java.lang.Math;

class index implements Comparable<index> {

    public int i;
    public int j;
    public int k;
    public int w;

    public index(int _i, int _j, int _k, int _w){
        i = _i;
        j = _j;
        k = _k;
        w = _w;
    }

    @Override
    public int compareTo(index ind){
        return Integer.compare(w, ind.w);
    }

}

class kattis {

    public static StringBuilder ans;

    public static void main(String[] args) throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int[] mvL = {1, -1, 0, 0, 0, 0};
        int[] mvR = {0, 0, 1, -1, 0, 0};
        int[] mvC = {0, 0, 0, 0, 1, -1};

        while (in.ready()) {

            String[] dims = in.readLine().split("\\s+");
            int l = Integer.parseInt(dims[0]);
            int r = Integer.parseInt(dims[1]);
            int c = Integer.parseInt(dims[2]);

            if(l == 0 && r == 0 && c == 0)
                break;

            char[][][] grid = new char[l][r][c];

            int lS = -1;
            int rS = -1;
            int cS = -1;
            
            int lE = -1;
            int rE = -1;
            int cE = -1;

            for(int i = 0; i < l; i++){

                for(int j = 0; j < r; j++){
                    grid[i][j] = in.readLine().toCharArray();
                    for(int k = 0; k < c; k++){
                        if(grid[i][j][k] == 'S'){
                            lS = i;
                            rS = j;
                            cS = k;
                        }
                        else if(grid[i][j][k] == 'E'){
                            lE = i;
                            rE = j;
                            cE = k;
                        }
                    }
                }
                in.readLine();

            }

            int[][][] dist = new int[l][r][c];
            for(int i = 0; i < l; i++){
                for(int j = 0; j < r; j++){
                    Arrays.fill(dist[i][j], Integer.MAX_VALUE);
                }
            }
            dist[lS][rS][cS] = 0;

            PriorityQueue<index> queue = new PriorityQueue<index>();
            queue.add(new index(lS, rS, cS, 0));

            while(queue.size() > 0){

                index curr = queue.poll();
                int x = curr.i;
                int y = curr.j;
                int z = curr.k;

                if(curr.w > dist[x][y][z])
                    continue;

                for(int i = 0; i < 6; i++){
                    int tmpX = x + mvL[i];
                    int tmpY = y + mvR[i];
                    int tmpZ = z + mvC[i];

                    if(tmpX < l && tmpX >= 0 && tmpY < r && tmpY >= 0 && tmpZ < c && tmpZ >= 0 && (grid[tmpX][tmpY][tmpZ] == '.' || grid[tmpX][tmpY][tmpZ] == 'E') && curr.w+1 < dist[tmpX][tmpY][tmpZ]){
                        dist[tmpX][tmpY][tmpZ] = curr.w+1;
                        queue.add(new index(tmpX, tmpY, tmpZ, curr.w+1));
                    }
                }

            }

            if(dist[lE][rE][cE] == Integer.MAX_VALUE){
                out.println("Trapped!");
            }
            else{
                out.println("Escaped in " + dist[lE][rE][cE] + " minute(s).");
            }
            
        }

        in.close();
        out.close();
    }

}