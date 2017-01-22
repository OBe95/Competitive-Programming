import java.util.*;
import java.io.*;

class Node {

	public int id;
	public Node parent;
	public int rank;

	public Node(int i, Node p, int r){
		id = i;
		parent = p;
		rank = r;
	}

}

class UnionFind {

	public ArrayList<Node> nodes;

	public UnionFind(){
		nodes = new ArrayList<Node>();
	}

	public Node find(Node n){

		Node node = n;
		while(node.parent != null)
			node = node.parent;

		//path compression
		Node root = node;
		node = n;

		while(node.parent != null){
			Node tmpNode = node.parent;
			node.parent = root;
			node = tmpNode;
		}

		return root;

	}

	public void union(Node u, Node v){

		Node uRoot = find(u);
		Node vRoot = find(v);

		if(uRoot.id == vRoot.id)
			return;

		if(vRoot.rank < uRoot.rank){
			vRoot.parent = uRoot;
			uRoot.rank += vRoot.rank;
		}
		else{
			uRoot.parent = vRoot;
			vRoot.rank += uRoot.rank;
		}

	}

}

class Main {

    public static void main(String[] args) throws Exception{
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        
        int tt = Integer.parseInt(in.readLine().trim());

        while(tt-- != 0){
        
        	int f = Integer.parseInt(in.readLine().trim());
        	HashMap<String, Integer> names = new HashMap<String, Integer>();
        	UnionFind uf = new UnionFind();
        	int added = 0;

        	while(f-- != 0){

        		String[] input = in.readLine().trim().split("\\s+");
        		Node u, v;

        		if(names.containsKey(input[0])){
        			u = uf.nodes.get(names.get(input[0]));
        		}
        		else{
        			u = new Node(added, null, 1);
        			uf.nodes.add(u);
        			names.put(input[0], added);
        			added++;
        		}

        		if(names.containsKey(input[1])){
        			v = uf.nodes.get(names.get(input[1]));
        		}
        		else{
        			v = new Node(added, null, 1);
        			uf.nodes.add(v);
        			names.put(input[1], added);
        			added++;
        		}

        		uf.union(u, v);

        		Node root = uf.find(u);
        		out.println(root.rank);

        	}

        }

        in.close();
        out.close();
    
    }

}