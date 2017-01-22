import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws Exception{
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        while(in.ready()){
        
        	String[] input = in.readLine().trim().split("\\s+");
        	int n = Integer.parseInt(input[0]);
        	int q = Integer.parseInt(input[1]);

        	HashMap<Integer,Vector<Integer>> map = new HashMap<Integer,Vector<Integer>>();

        	String[] list = in.readLine().trim().split("\\s+");

        	for(int i = 0; i < n; i++){
        		int num = Integer.parseInt(list[i]);
        		if(map.containsKey(num))
        			map.get(num).add(i+1);
        		else{
        			Vector<Integer> tmp = new Vector<Integer>();
        			tmp.add(i+1);
        			map.put(num, tmp);
        		}
        	}

        	for(int i = 0; i < q; i++){

        		String[] query = in.readLine().trim().split("\\s+");
        		int k = Integer.parseInt(query[0]);
        		int v = Integer.parseInt(query[1]);

        		if(map.get(v).size() < k)
        			out.println(0);
        		else
        			out.println(map.get(v).get(k-1));

        	}

        }

        in.close();
        out.close();
    
    }

}