import java.util.*;
import java.io.*;

class kattis {

    public static void main(String[] args) throws Exception{
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        

        while(in.ready()){

            int n = Integer.parseInt(in.readLine());
            String[] input = in.readLine().split("\\s+");

            ArrayList<Integer> height = new ArrayList<Integer>();

            for(int i = 0; i < n; i++){
                height.add(Integer.parseInt(input[i]));
            }

            Collections.sort(height);
            int niveau = 0;
            int count = 0;

            while(height.size() > 0){
                int floor = -1;
                do{
                    floor = height.get(0);
                    if(floor <= niveau){
                        height.remove(0);
                    }
                }while(height.size() > 0 && floor <= niveau);
                if(height.size() > 0){
                    int max = height.get(height.size()-1)-niveau;
                    if(max > height.size()){
                        count++;
                        height.remove(height.size()-1);
                    }
                    else{
                        count++;
                        niveau++;
                    }
                }
                
            }

            out.println(count);

        }

        in.close();
        out.close();
    
    }
}