import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws Exception{
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        String s = in.readLine();

        int q = Integer.parseInt(in.readLine().trim());

        while(q-- != 0){

            String ss = in.readLine();
            boolean solvable = true;
            int l = ss.length();
            int start = -1;
            int end = -1;
            int nextInd = 0;
            for(int i = 0; i < l; i++){
                int ind = s.indexOf(ss.charAt(i), nextInd);
                if(ind == -1){
                    solvable = false;
                    break;
                }
                if(i == 0)
                    start = ind;
                if(i == l-1)
                    end = ind;
                nextInd = ind + 1;
            }

            if(solvable){
                out.println("Matched " + start + " " + end);
            }
            else{
                out.println("Not matched");
            }

        }

        in.close();
        out.close();
    
    }

}