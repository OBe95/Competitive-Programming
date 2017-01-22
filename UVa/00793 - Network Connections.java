import java.util.*;
import java.io.*;
import java.lang.Math;

class UnionFind {

	public int[] parent;
	public int[] rank;

	public UnionFind(int n){
		parent = new int[n+1];
		rank = new int[n+1];
	}

	public int find(int x){

		int tmpX = x;
		while(parent[tmpX] != 0)
			tmpX = parent[tmpX];

		//path compression
		int root = tmpX;
		tmpX = x;

		while(parent[tmpX] != 0){
			int tmp = parent[tmpX];
			parent[tmpX] = root;
			tmpX = tmp;
		}

		return root;

	}

	public void union(int u, int v){

		int uRoot = find(u);
		int vRoot = find(v);

		if(uRoot == vRoot)
			return;

		else if(rank[uRoot] < rank[vRoot])
			parent[uRoot] = vRoot;
		else if(rank[vRoot] < rank[uRoot])
			parent[vRoot] = uRoot;
		else{
			parent[uRoot] = vRoot;
			rank[vRoot]++;
		}

	}

}

class Main {

    public static void main(String[] args) throws Exception{
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        
        int tt = Integer.parseInt(in.readLine().trim());
        in.readLine();

        L: while(tt-- != 0){

        	int numOfComputers = Integer.parseInt(in.readLine().trim());
        	UnionFind uf = new UnionFind(numOfComputers);
        	int successful = 0;
        	int unsuccessful = 0;
        
        	while(in.ready()){

        		String input = in.readLine().trim();

        		if(input.isEmpty())
        			break;

        		String[] line = input.split("\\s+");
        		if(line[0].equals("c")){
        			uf.union(Integer.parseInt(line[1]), Integer.parseInt(line[2]));
        		}
        		else{
        			if(uf.find(Integer.parseInt(line[1])) == uf.find(Integer.parseInt(line[2])))
        				successful++;
        			else
        				unsuccessful++;
        		}

        	}

        	out.println(successful + "," + unsuccessful);
        	if(tt != 0)
        		out.println();

        }

        in.close();
        out.close();
    
    }

}