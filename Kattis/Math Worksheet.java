import java.util.*;
import java.io.*;

class kattis {

    public static void main(String[] args) throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        Locale.setDefault(new Locale("en", "US"));
        int tt = 0;

        while (in.ready()) {

            int n = Integer.parseInt(in.readLine());

            if(n == 0){
                break;
            }

            if(tt != 0){
                out.println();
            }

            tt = 1;

            String[] ans = new String[n];
            int maxL = 0;

            for(int i = 0; i < n; i++){
                String[] input = in.readLine().split("\\s+");
                int x = Integer.parseInt(input[0]);
                int y = Integer.parseInt(input[2]);
                char op = input[1].charAt(0);

                if(op == '+'){
                    ans[i] = "" + (x+y);
                }
                else if(op == '-'){
                    ans[i] = "" + (x-y);                    
                }
                else {
                    ans[i] = "" + (x*y);                    
                }

                maxL = (ans[i].length() > maxL) ? ans[i].length() : maxL;
            }

            int stringPerLine = 50 / (maxL+1);
            
            for(int i = 0; i < n-1; i++){

                int l = ans[i].length();
                for(int j = 0; j < maxL - l; j++){
                    out.print(" ");
                }
                out.print(ans[i]);

                if((i+1) % stringPerLine == 0){
                    out.println();
                }
                else{
                    out.print(" ");
                }

            }
            int l = ans[n-1].length();
            for(int j = 0; j < maxL - l; j++){
                out.print(" ");
            }
            out.println(ans[n-1]);

        }

        in.close();
        out.close();
    }

}