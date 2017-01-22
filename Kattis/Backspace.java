import java.util.*;
import java.io.*;

class kattis {

    public static void main(String[] args) throws Exception{
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        while(in.ready()){

            char[] input = in.readLine().trim().toCharArray();
            StringBuilder ans = new StringBuilder();

            for(int i = 0; i < input.length; i++){

                if(input[i] == '<')
                    ans.deleteCharAt(ans.length()-1);
                else
                    ans.append(input[i]);

            }

            out.println(ans);

        }

        in.close();
        out.close();
    
    }

}