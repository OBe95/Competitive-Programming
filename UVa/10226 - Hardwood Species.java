import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws Exception{

        Locale.setDefault(new Locale("en", "US"));
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        
        int tt = Integer.parseInt(in.readLine());
        in.readLine();
        
        while(tt-- != 0){
        
            int numOfTrees = 0;
            TreeMap<String, Integer> treeOcc = new TreeMap<String, Integer>();

            while(in.ready()){

                String tree = in.readLine();
                if(tree.isEmpty())
                    break;

                numOfTrees++;
                if(treeOcc.containsKey(tree))
                    treeOcc.put(tree, treeOcc.get(tree)+1);
                else
                    treeOcc.put(tree, 1);

            }

            Iterator it = treeOcc.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                int num = (int)pair.getValue();
                out.printf("%s %.4f\n",pair.getKey(), 100.0*num/numOfTrees);
                it.remove(); // avoids a ConcurrentModificationException
            }

            if(tt != 0)
                out.println();
        
        }

        in.close();
        out.close();
    
    }

}