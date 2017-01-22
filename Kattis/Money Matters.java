import java.util.*;
import java.io.*;

class kattis {

    public static boolean[] visited;
    public static int[] balance;
    public static ArrayList<Integer> adjList[];

    public static void main(String[] args) throws Exception{
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        while(in.ready()){

            String[] dim = in.readLine().split("\\s+");
            int n = Integer.parseInt(dim[0]);
            int m = Integer.parseInt(dim[1]);

            balance = new int[n];
            adjList = new ArrayList[n];

            for(int i = 0; i < n; i++){
                balance[i] = Integer.parseInt(in.readLine());
                adjList[i] = new ArrayList<Integer>();
            }

            for(int i = 0; i < m; i++){
                String[] friends = in.readLine().split("\\s+");
                adjList[Integer.parseInt(friends[0])].add(Integer.parseInt(friends[1]));
                adjList[Integer.parseInt(friends[1])].add(Integer.parseInt(friends[0]));
            }

            visited = new boolean[n];
            boolean isPossible = true;

            L: for(int i = 0; i < n && isPossible; i++){
                if(!visited[i]){
                    int sum = dfs(i);
                    if(sum != 0){
                        isPossible = false;
                        break L;
                    }
                }
            }

            if(isPossible)
                out.println("POSSIBLE");
            else
                out.println("IMPOSSIBLE");

        }

        in.close();
        out.close();
    
    }

    public static int dfs(int i){

        visited[i] = true;
        int sum = balance[i];
        for(int adj : adjList[i]){
            if(!visited[adj])
                sum += dfs(adj);
        }
        return sum;

    }

}