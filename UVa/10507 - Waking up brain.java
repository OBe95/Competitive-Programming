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

        while(in.ready()){
        
        	int sleptCount = Integer.parseInt(in.readLine().trim());
        	int connCount = Integer.parseInt(in.readLine().trim());

        	UnionFind uf = new UnionFind(26);
        	boolean[] occured = new boolean[26];
        	boolean[][] connected = new boolean[26][26];

        	String directSt = in.readLine().trim();
        	char awake1 = directSt.charAt(0);
        	char awake2 = directSt.charAt(1);
        	char awake3 = directSt.charAt(2);

        	uf.union(awake1-'A'+1, awake2-'A'+1);
        	uf.union(awake2-'A'+1, awake3-'A'+1);

        	while(in.ready()){

        		String connection = in.readLine().trim();

        		if(connection.isEmpty())
        			break;

        		char char1 = connection.charAt(0);
        		char char2 = connection.charAt(1);
        		connected[char1-'A'][char2-'A'] = connected[char2-'A'][char1-'A'] = true;
        		occured[char1-'A'] = true;
        		occured[char2-'A'] = true;

        	}

        	if(connCount == 0 && sleptCount == 3){
        		out.println("WAKE UP IN, 0, YEARS");
        		continue;
        	}
        	else if(connCount == 0){
        		out.println("THIS BRAIN NEVER WAKES UP");
        		continue;
        	}

        	occured[awake1-'A'] = false;
        	occured[awake2-'A'] = false;
        	occured[awake3-'A'] = false;

        	boolean newAwake = false;
        	int years = 0;

        	int root = uf.find(awake1-'A'+1);

        	do{

        		newAwake = false;
        		ArrayList<Integer> toAdd = new ArrayList<Integer>();
        		for(int i = 0; i < 26; i++){

        			int count = 0;
        			if(occured[i]){

        				for(int j = 0; j < 26; j++){

        					if(connected[i][j] && uf.find(j+1) == root)
        						count++;

        				}

        			}
        			if(count > 2){
        				newAwake = true;
        				toAdd.add(i+1);
        				occured[i] = false;
        			}

        		}

        		if(toAdd.size() > 0){
        			years++;

	        		for(int i = 0; i < toAdd.size(); i++)
	        			uf.union(toAdd.get(i), root);

	        		root = uf.find(root);
        		}


        	}while(newAwake);


        	boolean possible = true;

        	for(int i = 0; i < 26; i++){
        		if(occured[i]){
        			possible = false;
        			break;
        		}
        	}

        	if(possible && years > 0)
        		out.println("WAKE UP IN, " + years + ", YEARS");
        	else
        		out.println("THIS BRAIN NEVER WAKES UP");


        }

        in.close();
        out.close();
    
    }

}