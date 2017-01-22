import java.util.*;
import java.io.*;

class kattis {

    public static ArrayList<Integer>[] connections;
    public static boolean[] visited;
    public static int numMembers;

    public static void main(String[] args) throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        String line = in.readLine();
        while (line != null) {

            String[] spec = line.split("\\s+");
            int n = Integer.parseInt(spec[0]);
            int r = Integer.parseInt(spec[1]);
            int a = Integer.parseInt(spec[2]);
            int b = Integer.parseInt(spec[3]);
            int c = Integer.parseInt(spec[4]);

            connections = new ArrayList[n];

            L: for(int i = 0; i < n; i++){

                int x = 0;
                int y = 0;

                while(x == y){

                    r = (r * a + b) % c;
                    x = r % n;
                    r = (r * a + b) % c;
                    y = r % n;

                }

                //out.println(x + " " + y);
                if(connections[x] == null)
                    connections[x] = new ArrayList<Integer>();

                if(connections[y] == null)
                    connections[y] = new ArrayList<Integer>();

                connections[x].add(y);
                connections[y].add(x);

            }

            visited = new boolean[n];
            Map<Integer, Integer> groupOcc = new TreeMap<>(Collections.reverseOrder());

            int numGroups = 0;

            for(int i = 0; i < n; i++){

                if(!visited[i]){
                    numGroups++;
                    numMembers = 0;
                    dfs(i);
                    //out.println("\t\t" + i + " " + numMembers);
                    if(groupOcc.containsKey(numMembers)){
                        groupOcc.put(numMembers, groupOcc.get(numMembers)+1);
                    }
                    else{
                        groupOcc.put(numMembers, 1);
                    }
                }

            }

            StringBuilder ans = new StringBuilder("" + numGroups);

            Iterator it = groupOcc.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry keyVal = (Map.Entry)it.next();
                int key = (Integer)keyVal.getKey();
                int value = (Integer)keyVal.getValue();
                ans.append(" " + key);
                if(value != 1){
                    ans.append("x" + value);
                }
            }

            out.println(ans);

            line = in.readLine();

        }

        in.close();
        out.close();
    }

    public static void dfs(int i){

        visited[i] = true;
        numMembers++;
        if(connections[i] != null){
            for(Integer conn : connections[i]){
                if(!visited[conn]){
                    dfs(conn);
                }
            }
        }
    }

}