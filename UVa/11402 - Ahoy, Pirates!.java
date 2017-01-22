import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws Exception{
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int tt = Integer.parseInt(in.readLine().trim());
        int caseNum = 0;

        while(tt-- != 0){

        	caseNum++;
        
        	StringBuilder pirates = new StringBuilder();

        	int m = Integer.parseInt(in.readLine().trim());

        	while(m-- != 0){

				int t = Integer.parseInt(in.readLine().trim());
        		String s = in.readLine().trim();

        		while(t-- != 0){
        			pirates.append(s);
        		}

        	}

        	BitSet piratesLand = createFromString(pirates.toString());
        	int q = Integer.parseInt(in.readLine().trim());
        	int qNum = 1;

        	out.println("Case " + caseNum + ":");

        	while(q-- != 0){

        		String[] query = in.readLine().trim().split("\\s+");
        		char qType = query[0].charAt(0);
        		int i = Integer.parseInt(query[1]);
        		int j = Integer.parseInt(query[2]);

        		switch(qType){
        			case 'F':
        				piratesLand.set(i, j+1);
        				break;
        			case 'E':
        				piratesLand.clear(i, j+1);
        				break;
        			case 'I':
        				piratesLand.flip(i, j+1);
        				break;
        			case 'S':
        				out.println("Q" + qNum + ": " + piratesLand.get(i, j+1).cardinality());
        				qNum++;
        				break;
        		}

        	}

        }

        in.close();
        out.close();
    
    }

    public static BitSet createFromString(String s) {
	    BitSet t = new BitSet(s.length());

	    for (int i = 0; i < s.length(); i++) {
	        if ( s.charAt(i) == '1'){
	            t.set(i);                            
	        }               
	    }

	    return t;
	}

}