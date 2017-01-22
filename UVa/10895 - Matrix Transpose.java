import java.util.*;
import java.io.*;

class pair {

	public int index;
	public int value;

	public pair(int i, int v){
		index = i;
		value = v;
	}

}

class Main {

    public static void main(String[] args) throws Exception{
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        while(in.ready()){
        
        	String[] dim = in.readLine().trim().split("\\s+");
        	int m = Integer.parseInt(dim[0]);
        	int n = Integer.parseInt(dim[1]);

        	Vector<Vector<pair>> adjList = new Vector<Vector<pair>>(m);

        	for(int i = 0; i < m; i++){

        		String[] line1 = in.readLine().trim().split("\\s+");
        		String[] line2 = in.readLine().trim().split("\\s+");
        		
        		int r = Integer.parseInt(line1[0]);
        		Vector<pair> vp = new Vector<pair>(r);

        		for(int j = 0; j < r; j++)
        			vp.add(new pair(Integer.parseInt(line1[j+1]), Integer.parseInt(line2[j])));

        		adjList.add(vp);

        	}

        	String ans = n + " " + m + "\n";

        	for(int i = 0; i < n; i++){

        		String line1Tmp = "";
        		String line2Tmp = "";
        		int line1R = 0;

        		for(int j = 0; j < m; j++){

        			Vector<pair> vp = adjList.get(j);
        			if(vp.size() > 0 && vp.get(0).index == i+1){
        				line1Tmp += (j+1) + " ";
        				line2Tmp += vp.get(0).value + " ";
        				line1R++;
        				vp.remove(0);
        			}

        		}
        		ans += (line1Tmp.length() > 0) ? line1R + " " + line1Tmp.substring(0, line1Tmp.length() - 1) + "\n" : line1R + "\n";
        		ans += (line2Tmp.length() > 0) ? line2Tmp.substring(0, line2Tmp.length() - 1) + "\n" : line2Tmp + "\n";

        	}

        	out.print(ans);


        }

        in.close();
        out.close();
    
    }

}