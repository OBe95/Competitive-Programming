import java.util.*;
import java.io.*;


class kattis {

    public static void main(String[] args) throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("**** ** ** ****",0);
        map.put("  *  *  *  *  *",1);
        map.put("***  *****  ***",2);
        map.put("***  ****  ****",3);
        map.put("* ** ****  *  *",4);
        map.put("****  ***  ****",5);
        map.put("****  **** ****",6);
        map.put("***  *  *  *  *",7);
        map.put("**** ***** ****",8);
        map.put("**** ****  ****",9);


        String line = in.readLine();
        int l = line.length()/4;
        String[] codes = new String[l+1];
        Arrays.fill(codes, "");

        for(int i = 0; i < 5; i++) {

            int k = 0;
            for(int j = 0; j <= l; j++){
                codes[k] += line.substring(k*3 + k, (k+1)*3 + k);
                k++;
            }
            line = in.readLine();
            //out.println(k);
        }

        /*for(int i = 0; i <= l; i++){
            out.println("map.put(\"" + codes[i] + "\"," + i + ");");
        }*/

        int x = 0;
        boolean safe = true;
        L: for(int i = 0; i <= l; i++){
           if(!map.containsKey(codes[i])){
                safe = false;
                break L;
           }
           else{
                x = x*10 + map.get(codes[i]);
           }
        }

        //out.println(x);

        if(safe && x%6 == 0){
            out.println("BEER!!");
        }
        else{
            out.println("BOOM!!");
        }

        in.close();
        out.close();
    }

}