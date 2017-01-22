import java.util.*;
import java.io.*;
import java.lang.Math;

class Main {

    public static void main(String[] args) throws Exception{

        Locale.setDefault(new Locale("en", "US"));
    
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        for(int i = 1; i < 2000; i++){
            for(int j = i; i+j < 2000; j++){
                for(int k = j; i+j+k < 2000; k++){
                    
                    if(i*j*k <= 1000000)
                        continue;
                    if(((i+j+k)*1000000) % (i*j*k - 1000000) != 0)
                        continue;
                    int l = ((i+j+k)*1000000) / (i*j*k - 1000000);

                    if(l >= k && (i+j+k+l) <= 2000){
                        out.printf("%.2f %.2f %.2f %.2f\n", i/100.0, j/100.0, k/100.0, l/100.0);
                    }

                }
            }
        }
        
        out.close();
    
    }

}