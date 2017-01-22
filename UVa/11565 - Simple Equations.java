import java.util.*;
import java.io.*;
import java.lang.Math;

class Main {

    public static void main(String[] args) throws Exception{
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int tt = Integer.parseInt(in.readLine().trim());

        while(tt-- != 0){
        
            String[] input = in.readLine().trim().split("\\s+");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);
            int x = -1, y = -1, z = -1;

            L: for(int i = -100; i < 100; i++){
                if(i * i > c)
                    continue;
                for(int j = -100; j < 100; j++){
                    if(i == j || i*i + j*j > c || i*j > b)
                        continue;
                    for(int k = -100; k < 100; k++){
                        if(k != i && k != j && i+j+k == a && i*j*k == b && i*i + j*j + k*k == c){
                            x = i;
                            y = j;
                            z = k;
                            break L;
                        }
                    }
                }
            }

            if(x == -1)
                out.println("No solution.");
            else
                out.println(x + " " + y + " " + z);
            
        }

        in.close();
        out.close();
    
    }

}