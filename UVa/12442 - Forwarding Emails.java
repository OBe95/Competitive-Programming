import java.util.*;
import java.io.*;

class Main {

    public static boolean[] visited;
    public static int[] adjList, len;

    public static void main(String[] args) throws Exception{
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int tt = Integer.parseInt(in.readLine().trim());

        for(int i = 1; i <= tt; i++){

            int n = Integer.parseInt(in.readLine().trim());

            visited = new boolean[n+1];
            adjList = new int[n+1];
            len = new int[n+1];

            for(int j = 0; j < n; j++){
                String[] input = in.readLine().split("\\s+");
                adjList[Integer.parseInt(input[0])] = Integer.parseInt(input[1]);
            }

            int max = 0;
            int index = -1;
            for(int j = 1; j <= n; j++){
                if(len[j] == 0)
                    traverse(j);
                if(len[j] > max){
                    max = len[j];
                    index = j;
                }
            }

            out.println("Case " + i + ": " + index);

        }

        in.close();
        out.close();
    
    }

    public static int traverse(int node){

        int ans = 0;
        visited[node] = true;
        if(adjList[node] != 0 && !visited[adjList[node]])
            ans += 1 + traverse(adjList[node]);
        visited[node] = false;
        len[node] = ans;
        return ans;

    }

}