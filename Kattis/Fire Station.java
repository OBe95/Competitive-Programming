import java.util.*;
import java.io.*;

class neighbour implements Comparable<neighbour> {

    public int index;
    public int dist;

    public neighbour(int i, int d){
        index = i;
        dist = d;
    }

    @Override
    public int compareTo(neighbour n){
        return Integer.compare(dist, n.dist);
    }
}

class kattis {

    public static void main(String[] args) throws Exception{
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int tt = Integer.parseInt(in.readLine());
        in.readLine();

        L: while(tt-- != 0){

            String[] dims = in.readLine().split("\\s+");
            int f = Integer.parseInt(dims[0]);
            int r = Integer.parseInt(dims[1]);

            if(r == f){
                out.println(1);
                if(tt != 0)
                    out.println();
                while(in.ready()){
                    String line = in.readLine();
                    if(line.isEmpty())
                        continue L;
                }
            }

            HashSet<Integer> fireStation = new HashSet<Integer>();
            boolean[] containFS = new boolean[r+1];
            for(int i = 0; i < f; i++){
                int tmp = Integer.parseInt(in.readLine());
                containFS[tmp] = true;
                fireStation.add(tmp);
            }

            ArrayList<neighbour> roads[] = new ArrayList[r+1];
            for(int i = 0; i <= r; i++)
                roads[i] = new ArrayList<neighbour>();

            while(in.ready()){
                String line = in.readLine();
                if(line.isEmpty())
                    break;
                String[] input = line.split("\\s+");
                int a = Integer.parseInt(input[0]);
                int b = Integer.parseInt(input[1]);
                int w = Integer.parseInt(input[2]);
                roads[a].add(new neighbour(b,w));
                roads[b].add(new neighbour(a,w));
            }

            int[] distance = new int[r+1];
            Arrays.fill(distance, Integer.MAX_VALUE);

            PriorityQueue<neighbour> queue = new PriorityQueue<neighbour>();

            for(int fs : fireStation){
                distance[fs] = 0;
                queue.add(new neighbour(fs, 0));
            }

            while(queue.size() > 0){

                neighbour n = queue.poll();
                int ind = n.index;
                int dist = n.dist;
                if(dist > distance[ind])
                    continue;

                for(neighbour nn : roads[ind]){
                    if(dist+nn.dist < distance[nn.index]){
                        distance[nn.index] = dist+nn.dist;
                        queue.add(new neighbour(nn.index, dist+nn.dist));
                    }
                }

            }

            int minmax = Integer.MAX_VALUE;
            int ans = 0;

            for(int j = 1; j <= r; j++){

                if(!containFS[j]){

                    int[] distTmp = distance.clone();
                    distTmp[j] = 0;
                    queue.add(new neighbour(j, 0));

                    while(queue.size() > 0){

                        neighbour n = queue.poll();
                        int ind = n.index;
                        int dist = n.dist;
                        if(dist > distTmp[ind])
                            continue;

                        for(neighbour nn : roads[ind]){
                            if(dist+nn.dist < distTmp[nn.index]){
                                distTmp[nn.index] = dist+nn.dist;
                                queue.add(new neighbour(nn.index, dist+nn.dist));
                            }
                        }

                    }

                    int max = 0;
                    for(int i = 1; i <= r; i++){
                        //out.print(distTmp[i] + " ");
                        if(distTmp[i] > max){
                            max = distTmp[i];
                        }
                    }

                    //out.println(j + " " + max + " " + minmax);

                    if(max < minmax){
                        minmax = max;
                        ans = j;
                    }

                }

            }
            
            out.println(ans);
            if(tt != 0)
                out.println();

        }

        in.close();
        out.close();
    
    }
}