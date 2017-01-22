import java.util.*;
import java.io.*;

class kattis {

    public static char[] input;

    public static void main(String[] args) throws Exception{
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        HashMap<String, String> dic = new HashMap<String, String>();

        while(in.ready()){

            String line = in.readLine();
            if(line.isEmpty()){
                while(in.ready()){
                    String word = in.readLine();
                    if(dic.containsKey(word))
                        out.println(dic.get(word));
                    else
                        out.println("eh");
                }
            }
            else{
                String[] lSplit = line.split("\\s+");
                dic.put(lSplit[1],lSplit[0]);
            }

        }

        in.close();
        out.close();
    
    }
}