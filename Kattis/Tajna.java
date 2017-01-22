import java.util.*;
import java.io.*;

class kattis {

    public static void main(String[] args) throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        while (in.ready()) {

            String s = in.readLine();

            int l = s.length();

            int r = -1;

            for(r = (int)Math.sqrt(l); r > 0; r--){
                if(l % r == 0)
                    break;
            }

            int c = l/r;
           // out.println(r + " " + c);
            String ans = "";

            for(int i = 0; i < r; i++){

                int tmp = i;
                while(tmp < l){
                    ans += s.charAt(tmp);
                    tmp += r;
                }

            }
            
            out.println(ans);

        }

        in.close();
        out.close();
    }

}