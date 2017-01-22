import java.util.*;
import java.io.*;

class kattis {


    public static void main(String[] args) throws Exception{

        Locale.setDefault(new Locale("en", "US"));
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        char[] parent = new char[256];
        
        parent['='] = '-'; parent['-'] = '0'; parent['0'] = '9'; parent['9'] = '8'; parent['8'] = '7'; parent['7'] = '6'; parent['6'] = '5'; parent['5'] = '4'; parent['4'] = '3'; parent['3'] = '2'; parent['2'] = '1'; parent['1'] = '\u2018';
         
        parent['\\'] = ']'; parent[']'] = '['; parent['['] = 'P'; parent['P'] = 'O'; parent['O'] = 'I'; parent['I'] = 'U'; parent['U'] = 'Y'; parent['Y'] = 'T'; parent['T'] = 'R'; parent['R'] = 'E'; parent['E'] = 'W'; parent['W'] = 'Q';
        parent['\''] = ';'; parent[';'] = 'L'; parent['L'] = 'K'; parent['K'] = 'J'; parent['J'] = 'H'; parent['H'] = 'G'; parent['G'] = 'F'; parent['F'] = 'D'; parent['D'] = 'S'; parent['S'] = 'A';
        parent['/'] = '.'; parent['.'] = ','; parent[','] = 'M'; parent['M'] = 'N'; parent['N'] = 'B'; parent['B'] = 'V'; parent['V'] = 'C'; parent['C'] = 'X'; parent['X'] = 'Z';

        while(in.ready()){

            String input = in.readLine();
            StringBuilder ans = new StringBuilder();
            for(int i = 0; i < input.length(); i++){
                char tmp = input.charAt(i);
                if(parent[tmp] == '\u0000')
                    ans.append(tmp);
                else
                    ans.append(parent[tmp]);
            }

            out.println(ans);

        }

        in.close();
        out.close();
    
    }

}