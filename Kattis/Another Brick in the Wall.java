import java.util.*;
import java.io.*;

class kattis {

    public static void main(String[] args) throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        while (in.ready()) {

            String[] input = in.readLine().split("\\s+");
            int h = Integer.parseInt(input[0]);
            int w = Integer.parseInt(input[1]);
            int n = Integer.parseInt(input[2]);

            String[] bricks = in.readLine().split("\\s+");
            boolean possible = true;

            int actW = 0;
            int actH = 0;
            for(int i = 0; i < n; i++){
                actW += Integer.parseInt(bricks[i]);
                if(actW > w){
                    possible = false;
                    break;
                }
                if(actW == w){
                    actW = 0;
                    actH++;
                    if(actH == h)
                        break;
                }
            }

            if(possible)
                out.println("YES");
            else
                out.println("NO");
            
        }

        in.close();
        out.close();
    }

}