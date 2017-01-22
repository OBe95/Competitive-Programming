import java.util.*;
import java.io.*;

class Node {

    public int id;
    public HashMap<Node, Integer> adjacentNodes = new HashMap<Node, Integer>();
    public int pathCost = 0;
 
    public Node(int i){
        id = i;
    }
 
    public void addAdjacentNodes(Node n, int dist){
        adjacentNodes.put(n, dist);
    } 
 
}

class kattis {

    public static HashMap<String, Node> indices;
    public static int[] distance, parent;
    public static ArrayList<String> names;
    public static int max;
    public static boolean[] visited;

    public static void main(String[] args) throws Exception{
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        while(in.ready()){

            String[] line1 = in.readLine().trim().split("\\s+");
            String s = line1[0];
            String d = line1[1];
        
            int n = Integer.parseInt(in.readLine().trim());

            if(s.equals(d)){
                for(int i = 0; i < n; i++)
                    in.readLine();
            }
            else{
                names = new ArrayList<String>();
                indices = new HashMap<String, Node>();
                indices.put(s, new Node(0));
                indices.put(d, new Node(1));
                names.add(s);
                names.add(d);
                int index = 2;

                for(int j = 0; j < n; j++){

                    String[] input = in.readLine().trim().split("\\s+");
                    int k = input.length;
                    Node[] actNodes = new Node[k];
                    for(int i = 0; i < k; i++){
                        if(indices.containsKey(input[i]))
                            actNodes[i] = indices.get(input[i]);
                        else{
                            actNodes[i] = new Node(index);
                            indices.put(input[i], actNodes[i]);
                            names.add(input[i]);
                            index++;
                        }
                    }
                    for(int i = 0; i < k-1; i++){
                        for(int l = i+1; l < k; l++){
                            if(actNodes[i].adjacentNodes.containsKey(actNodes[l])){
                                int dist = actNodes[i].adjacentNodes.get(actNodes[l]);
                                if(dist > k-1){
                                    actNodes[i].adjacentNodes.put(actNodes[l], k-1);
                                    actNodes[l].adjacentNodes.put(actNodes[i], k-1);
                                }
                                //System.out.println("\tAdjacentNode for " + names.get(actNodes[i].id) + " : " + names.get(actNodes[l].id) + " : " + actNodes[i].adjacentNodes.get(actNodes[l]));
                            }
                            else{
                                actNodes[i].adjacentNodes.put(actNodes[l], k-1);
                                actNodes[l].adjacentNodes.put(actNodes[i], k-1);
                                //System.out.println("\tNew adjacentNode : " + names.get(actNodes[i].id) + " : " + names.get(actNodes[l].id) + " : " + actNodes[i].adjacentNodes.get(actNodes[l]));
                            }
                        }
                    }

                }

                max = index;

                distance = new int[max];
                visited = new boolean[max];
                parent = new int[max];

                distance[0] = 0;
                dij(indices.get(s));

                if(distance[1] == 0)
                    out.println("impossible");
                else{
                    String ans = " " + d;
                    int tmp = 1;
                    while(parent[tmp] != 0){
                        tmp = parent[tmp];
                        ans = " " + names.get(tmp) + ans;
                    }
                    ans = distance[1]-1 + " " + s + ans;
                    out.println(ans);
                }
                
            }
            

        }

        in.close();
        out.close();
    
    }

    public static void dij(Node s){

        //System.out.println(s.id + " " + names.get(s.id) + " : " + distance[s.id]);
        visited[s.id] = true;

        Iterator it = s.adjacentNodes.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            Node tmpNode = (Node)pair.getKey();
            int tmpCost = (int)pair.getValue();
            if(!visited[tmpNode.id]){
                if(distance[tmpNode.id] == 0 || distance[s.id] + tmpCost <= distance[tmpNode.id]){
                    distance[tmpNode.id] = distance[s.id] + tmpCost;
                    parent[tmpNode.id] = s.id;
                }

            }
            //System.out.println("\t" + names.get(tmpNode.id) + " : " + distance[tmpNode.id]);
            it.remove();
        }

        int nextNode = 0;
        int nextNodeWeight = 0;

        for(int i = 0; i < max; i++){
            if(!visited[i] && distance[i] > 0 && (distance[i] <= nextNodeWeight || nextNodeWeight == 0)){
                nextNodeWeight = distance[i];
                nextNode = i;
            }
        }

        if(nextNode != 0)
            dij(indices.get(names.get(nextNode)));

    }

}