import java.util.*;
import java.io.*;

class kattis {

    public static void main(String[] args) throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int tt = 0;

        while (in.ready()) {

            int n = Integer.parseInt(in.readLine());

            if(n == 0)
                break;

            if(tt != 0)
                out.println();

            tt = 1;

            String[] line = new String[n];
            int max = 0;
            for(int i = 0; i < n; i++){
                line[i] = in.readLine();
                if(max < line[i].length())
                    max = line[i].length();
            }

            char[][] chars = new char[n][max];

            for(int i = 0; i < n; i++){
                int l = line[i].length();
                while(l < max){
                    line[i] += " ";
                    l++;
                }
                //System.out.println(line[i]);
                chars[i] = line[i].toCharArray();
            }

            line = new String[max];
            for(int i = 0; i < max; i++){
                line[i] = "";
                for(int j = n-1; j >= 0; j--){
                    if(chars[j][i] == '|')
                        line[i] += '-';
                    else if(chars[j][i] == '-')
                        line[i] += '|';
                    else
                        line[i] += chars[j][i];
                }

                while(line[i].charAt(line[i].length()-1) == ' '){
                    line[i] = line[i].substring(0, line[i].length()-1);
                }
            }

            for(int i = 0; i < max; i++)
                out.println(line[i]);
            
        }

        in.close();
        out.close();
    }

}