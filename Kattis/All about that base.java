import java.util.*;
import java.io.*;

class kattis {

    public static void main(String[] args) throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        char[] bases = {'-', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0'};
        
        int tt= Integer.parseInt(in.readLine());

        while (tt-- != 0) {

            String[] input = in.readLine().split("\\s+");
            char op = input[1].charAt(0);

            String ans = "";

            boolean base1 = true;
            for(int i = 0; i < input[0].length() && base1; i++){
                if(input[0].charAt(i) != '1')
                    base1 = false;
            }
            for(int i = 0; i < input[2].length() && base1; i++){
                if(input[2].charAt(i) != '1')
                    base1 = false;
            }
            for(int i = 0; i < input[4].length() && base1; i++){
                if(input[4].charAt(i) != '1')
                    base1 = false;
            }

            if(base1){
                if(op == '+' && (input[0].length()+input[2].length() == input[4].length()))
                    ans += '1';
                else if(op == '-' && (input[0].length()-input[2].length() == input[4].length()))
                    ans += '1';
                else if(op == '/' && ((double)input[0].length()/input[2].length() == (double)input[4].length()))
                    ans += '1';
                else if(op == '*' && (input[0].length()*input[2].length() == input[4].length()))
                    ans += '1';
            }

            for(int i = 2; i <= 36; i++){

                int a = -1;
                int b = -1;
                int c = -1;
                try{
                    a = Integer.parseInt(input[0], i);
                    b = Integer.parseInt(input[2], i);
                    c = Integer.parseInt(input[4], i);
                }
                catch (NumberFormatException nfe){}
                //out.println(i + " : " + a + " " + b + " " + c);
                if(a != -1 && b != -1 && c != -1){
                    if(op == '+' && a+b == c)
                        ans += bases[i];
                    else if(op == '-' && a-b == c)
                        ans += bases[i];
                    else if(op == '/' && (double)a/b == (double)c)
                        ans += bases[i];
                    else if(op == '*' && a*b == c)
                        ans += bases[i];
                }

            }

            if(ans.isEmpty())
                out.println("invalid");
            else
                out.println(ans);
            
            
        }

        in.close();
        out.close();
    }

}