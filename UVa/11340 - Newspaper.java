import java.util.*;
import java.io.*;

class Main {

    public static void main (String[] args) {

        Locale.setDefault(new Locale("en", "US"));
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
            int tt = Integer.parseInt(in.readLine());
            
            while(tt-- != 0){

                int numChars = Integer.parseInt(in.readLine());

                int[] charVals = new int[300];
                int[] charOcc = new int[300];

                while(numChars-- != 0){

                    String nextLine = in.readLine();
                    if(nextLine.isEmpty()){
                        numChars++;
                        continue;
                    }

                    String[] line = nextLine.split("\\s+");
                    charVals[line[0].charAt(0)] = Integer.parseInt(line[1]);

                }

                int numLines = Integer.parseInt(in.readLine());

                while(numLines-- != 0){

                    String nextLine = in.readLine();
                    if(nextLine.isEmpty())
                        continue;

                    for(int i = 0; i < nextLine.length(); i++)
                        charOcc[nextLine.charAt(i)]++;

                }

                int cents = 0;
                for(int i = 0; i < 300; i++)
                    cents += charOcc[i] * charVals[i];

                System.out.printf("%.2f$\n", (double) cents/100.0);
            }
        
        }
        catch(Exception e){}

    }
}