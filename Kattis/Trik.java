import java.util.*;
import java.io.*;

class kattis {

    public static void main(String[] args) throws Exception{
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        while(in.ready()){

            String input = in.readLine();
            int pos = 1;

            for(int i = 0; i < input.length(); i++){
                if(input.charAt(i) == 'A'){
                    if(pos == 1)
                        pos = 2;
                    else if(pos == 2)
                        pos = 1;
                }
                else if(input.charAt(i) == 'B'){
                    if(pos == 2)
                        pos = 3;
                    else if(pos == 3)
                        pos = 2;
                }
                else{
                    if(pos == 1)
                        pos = 3;
                    else if(pos == 3)
                        pos = 1;
                }
            }

            out.println(pos);

        }

        in.close();
        out.close();
    
    }

}