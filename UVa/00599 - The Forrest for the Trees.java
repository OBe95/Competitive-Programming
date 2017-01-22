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

        while(tt-- != 0){
        
        	UnionFind uf = new UnionFind(26);
        	boolean[] occured = new boolean[26];

        	while(true){

            	String input = in.readLine();

            	if(input.charAt(0) == '*')
            		break;

            	char u = input.charAt(1);
            	char v = input.charAt(3);

            	occured[u-'A'] = true;
            	occured[v-'A'] = true;

            	uf.union(u-'A'+1, v-'A'+1);

        	}

        	int acornsCount = 0;
        	int treesCount = 0;

        	String[] input = in.readLine().trim().split(",");

        	for(int i = 0; i < input.length; i++){
        		if(!occured[input[i].charAt(0) - 'A'])
        			acornsCount++;
        		else if(uf.parent[input[i].charAt(0) - 'A' + 1] == 0)
        			treesCount++;
        	}

        	out.println("There are " + treesCount + " tree(s) and " + acornsCount + " acorn(s).");

        }

        in.close();
        out.close();
    
    }

}