import java.util.*;
import java.io.*;

class kattis {

    public static void main(String[] args) throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        while(in.ready()){

            String[] line1 = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(line1[0]);
            int t = Integer.parseInt(line1[1]);

            int excecTime = 0;

            String[] line2 = in.readLine().trim().split("\\s+");

            int i = 0;
            for(i = 0; i < n; i++){
                if(excecTime + Integer.parseInt(line2[i]) > t)
                    break;
                excecTime += Integer.parseInt(line2[i]);
            }

            out.println(i);
            
        }

        in.close();
        out.close();
    }

}