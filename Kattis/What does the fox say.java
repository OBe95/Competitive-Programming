import java.util.*;
import java.io.*;

class kattis {

    public static void main(String[] args) throws Exception{
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int tt = Integer.parseInt(in.readLine());

        while(tt-- != 0){

            String[] input = in.readLine().split("\\s+");

            HashSet<String> known = new HashSet<String>();
            String s = in.readLine();
            while(!s.equals("what does the fox say?")){
                String[] sSplit = s.split("\\s+");
                known.add(sSplit[2]);
                s = in.readLine();
            }

            StringBuilder ans = new StringBuilder();

            for(int i = 0; i < input.length; i++){
                if(!known.contains(input[i]))
                    ans.append(input[i] + " ");
            }

            out.println(ans.substring(0, ans.length()-1));

        }

        in.close();
        out.close();
    
    }
}