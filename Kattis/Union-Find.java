import java.util.*;
import java.io.*;

class kattis {

    public static int[] parent, height;

    public static void main(String[] args) throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        while(in.ready()) {

            String[] input = in.readLine().split("\\s+");
            int n = Integer.parseInt(input[0]);
            int q = Integer.parseInt(input[1]);

            parent = new int[n+2];
            height = new int[n+2];

            for(int i = 0; i < q; i++){

                String[] line = in.readLine().split("\\s+");
                char query = line[0].charAt(0);
                int num1 = Integer.parseInt(line[1])+1;
                int num2 = Integer.parseInt(line[2])+1;

                if(query == '?'){
                    if(find(num1) == find(num2))
                        out.println("yes");
                    else
                        out.println("no");
                }
                else
                    union(num1, num2);

            }

        }

        in.close();
        out.close();
    }

    public static int find(int n){

        int tmpNum = n;
        while(parent[tmpNum] != 0)
            tmpNum = parent[tmpNum];

        //path compression
        int root = tmpNum;
        tmpNum = n;

        while(parent[tmpNum] != 0){
            int tmpParent = parent[tmpNum];
            parent[tmpNum] = root;
            tmpNum = tmpParent;
        }
        //System.out.println("Root " + n + " : " + root);
        return root;

    }

    public static void union(int n1, int n2){

        int n1root = find(n1);
        int n2root = find(n2);

        if(n1root == n2root)//same set
            return;

        if(height[n1root] < height[n2root])
            parent[n1root] = n2root;
        else if(height[n1root] > height[n2root])
            parent[n2root] = n1root;
        else{
            parent[n2root] = n1root;
            height[n1root]++;
        }

    }

}