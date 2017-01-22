import java.util.*;
import java.io.*;
import java.math.BigInteger;

class kattis {

    public static void main(String[] args) throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        Locale.setDefault(new Locale("en", "US"));

        while (in.ready()) {

            String input = in.readLine();

            if(input.charAt(0) == '0'){
                break;
            }

            BigInteger n = new BigInteger(input);
            n = n.subtract(BigInteger.ONE);

            char[] bins = n.toString(2).toCharArray();

            int l = bins.length - 1;
            BigInteger three = new BigInteger("3");
            String ans = "{";

            for(int i = 0; i <= l; i++){
                if(bins[l-i] == '1'){
                    ans += " " + three.pow(i) + ",";
                }
            }

            if(ans.length() > 1){
                ans = ans.substring(0, ans.length()-1);
            }
            ans += " }";

            out.println(ans);

        }

        in.close();
        out.close();
    }

}