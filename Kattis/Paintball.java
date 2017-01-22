import java.util.*;
import java.io.*;

class kattis {

    public static int[] parent;
    public static boolean[] visited;
    public static ArrayList<Integer> connections[];

    public static void main(String[] args) throws Exception{
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        while(in.ready()){

            String[] dims = in.readLine().split("\\s+");
            int n = Integer.parseInt(dims[0]);
            int m = Integer.parseInt(dims[1]);

            connections = new ArrayList[n+1];
            for(int i = 0; i <=n; i++)
                connections[i] = new ArrayList<Integer>();

            while(m-- != 0){
                String[] input = in.readLine().split("\\s+");
                connections[Integer.parseInt(input[0])].add(Integer.parseInt(input[1]));
                connections[Integer.parseInt(input[1])].add(Integer.parseInt(input[0]));
            }

            parent = new int[n+1];
            visited = new boolean[n+1];

            int maxFlow = 0;

            for(int i = 1; i <= n; i++){
                Arrays.fill(visited, false);
                maxFlow += augmentFlow(i);
            }

            if(maxFlow < n)
                out.println("Impossible");
            else{
                for(int i = 1; i <= n; i++){
                    out.println(parent[i]);
                }
            }

        }

        in.close();
        out.close();
    
    }

    public static int augmentFlow(int i){

        if(visited[i])
            return 0;

        visited[i] = true;

        for(int j : connections[i]){

            if(parent[j] == 0 || augmentFlow(parent[j]) == 1){
                parent[j] = i;
                return 1;
            }

        }

        return 0;

    }
}