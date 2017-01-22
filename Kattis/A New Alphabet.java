import java.util.*;
import java.io.*;

class kattis {

    public static void main(String[] args) throws Exception{
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        String[] dic = {"@","8","(","|)","3","#","6","[-]","|","_|","|<","1","[]\\/[]","[]\\[]","0","|D","(,)","|Z","$","']['","|_|","\\/","\\/\\/","}{","`/","2"};

        while(in.ready()){

            String input = in.readLine().toLowerCase();
            StringBuilder ans = new StringBuilder();

            for(int i = 0; i < input.length(); i++){

                char c = input.charAt(i);
                if(c >= 'a' && c <= 'z'){
                    ans.append(dic[c-'a']);
                }
                else{
                    ans.append(c);
                }

            }

            out.println(ans); 

        }

        in.close();
        out.close();
    
    }

}