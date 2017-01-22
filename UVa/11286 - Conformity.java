import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws Exception{

        Locale.setDefault(new Locale("en", "US"));
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        
        while(in.ready()){
        
            int tt = Integer.parseInt(in.readLine());
            if(tt == 0)
                break;

            TreeMap<String, Integer> combOcc = new TreeMap<String, Integer>();

            while(tt-- != 0){

                String[] input = in.readLine().split("\\s+");
                Arrays.sort(input);
                String combination = input[0]+input[1]+input[2]+input[3]+input[4];

                if(combOcc.containsKey(combination))
                    combOcc.put(combination, combOcc.get(combination)+1);
                else
                    combOcc.put(combination, 1);

            }

            ArrayList<Integer> combOccs = new ArrayList<Integer>(combOcc.values());
            Collections.sort(combOccs);

            int i = combOccs.size()-1;
            int max = combOccs.get(i);
            int ans = max;
            i--;

            while(i >= 0 && combOccs.get(i) == max){
                ans += max;
                i--;
            }

            out.println(ans);
        
        }

        in.close();
        out.close();
    
    }

}