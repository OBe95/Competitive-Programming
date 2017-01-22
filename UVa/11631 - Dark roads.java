import java.util.*;
import java.io.*;

class Edge implements Comparable<Edge> {

    int x;
    int y;
    int w;
    public Edge(int _x, int _y, int _w){
        x = _x;
        y = _y;
        w = _w;
    }

    @Override
    public int compareTo(Edge e){
        return Integer.compare(w, e.w);
    }

}

class unionFind {

    public int[] parent, rank;

    public unionFind(int m){
        parent = new int[m];
        rank = new int[m];
    }

    public int find(int node){

        int tmpNode = node;
        while(parent[tmpNode] != 0){
            tmpNode = parent[tmpNode];
        }

        //path compression
        int root = tmpNode;
        while(parent[node] != 0){
            tmpNode = parent[node];
            parent[node] = root;
            node = tmpNode;
        }

        return root;

    }

    public void union(int node1, int node2){

        int root1 = find(node1);
        int root2 = find(node2);

        if(root1 == root2)
            return;

        if(rank[root1] > rank[root2])
            parent[root2] = root1;
        else{
            parent[root1] = root2;
            if(rank[root1] == rank[root2])
                rank[root2]++;
        }

    }

}

class Main {

    public static void main(String[] args) throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        while (in.ready()) {

            String[] dims = in.readLine().split("\\s+");
            int m = Integer.parseInt(dims[0]);
            int n = Integer.parseInt(dims[1]);

            ArrayList<Edge> edges = new ArrayList<Edge>();

            if(n == 0 && m == 0)
                break;

            unionFind uf = new unionFind(m+1);

            int total = 0;

            while(n-- != 0){
                String[] input = in.readLine().split("\\s+");
                total += Integer.parseInt(input[2]);
                edges.add(new Edge(Integer.parseInt(input[0])+1, Integer.parseInt(input[1])+1, Integer.parseInt(input[2])));
            }

            Collections.sort(edges);

            int cost = 0;

            for(Edge e : edges){

                if(uf.find(e.x) != uf.find(e.y)){

                    cost += e.w;
                    uf.union(e.x, e.y);

                }

            }

            out.println(total-cost);

        }

        in.close();
        out.close();
    }

}