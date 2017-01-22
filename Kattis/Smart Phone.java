import java.util.*;
import java.io.*;

class kattis {

    public static String word;

    public static void main(String[] args) throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        Locale.setDefault(new Locale("en", "US"));

        int tt = Integer.parseInt(in.readLine());

        while (tt-- != 0) {

            word = in.readLine();
            String typed = in.readLine();

            int ans = calcDiff(typed);

            for(int i = 0; i < 3; i++){
                typed = in.readLine();
                int tmp = calcDiff(typed) + 1;
                if(tmp < ans)
                    ans = tmp;
            }
            
            out.println(ans);

        }

        in.close();
        out.close();
    }

    public static int calcDiff(String s){

        int min = 0;
        int i = 0;
        int l = word.length();
        int l2 = s.length();

        while(i < l && i < l2 && word.charAt(i) == s.charAt(i)){
            i++;
        }

        return (l2-i)+(l-i);

    }


}