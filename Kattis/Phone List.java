import java.util.*;
import java.io.*;

class kattis {

    public static void main(String[] args) throws Exception{
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int tt = Integer.parseInt(in.readLine().trim());

        while(tt-- != 0){

            int n = Integer.parseInt(in.readLine().trim());
            boolean isConsistent = true;
            HashSet<String> prefixes = new HashSet<String>();
            HashSet<Integer> lengths = new HashSet<Integer>();

            for(int i = 0; i < n; i++){

                String num = in.readLine();
                if(prefixes.contains(num))
                    isConsistent = false;
                prefixes.add(num);
                lengths.add(num.length());

            }

            L:for(String num : prefixes){
                int len = num.length();
                if(isConsistent){
                    for(int l : lengths){
                        if(l < len && prefixes.contains(num.substring(0,l))){
                            isConsistent = false;
                            break L;
                        }
                    }
                }
            }
                

            if(isConsistent)
                out.println("YES"); 
            else
                out.println("NO"); 

        }

        in.close();
        out.close();
    
    }

}