import java.util.*;
import java.io.*;
import java.lang.Math;

class Main {

    public static void main(String[] args) throws Exception{

        Locale.setDefault(new Locale("en", "US"));
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int tt = Integer.parseInt(in.readLine());
        
        while(tt-- != 0){
        
            int numSnowFlakes = Integer.parseInt(in.readLine());
            HashMap<Integer, Integer> snowFalke = new HashMap<Integer, Integer>();

            int max = 0;
            int counter = 0;
            for(int i = 0; i < numSnowFlakes; i++){

                int id = Integer.parseInt(in.readLine().trim());

                if(snowFalke.containsKey(id)){
                    max = Math.max(max, counter);
                    counter = Math.min(counter, i - snowFalke.get(id) - 1);
                    snowFalke.remove(id);
                }

                snowFalke.put(id, i);
                counter++;

            }

            max = Math.max(max, counter);

            out.println(max);
        
        }

        in.close();
        out.close();
    
    }

}