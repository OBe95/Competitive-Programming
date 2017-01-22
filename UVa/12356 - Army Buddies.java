import java.util.*;
import java.io.*;

class Main {

    public static void main (String[] args) {

        Locale.setDefault(new Locale("en", "US"));
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(System.out);
            while(in.ready()){

                String nextLine = in.readLine();
                String[] line = nextLine.split("\\s+");

                int s = Integer.parseInt(line[0]);
                int b = Integer.parseInt(line[1]);

                if(s == 0 && b == 0)
                    break;

                int[] leftBuddy = new int[s+1];
                int[] rightBuddy = new int[s+1];

                for(int i = 1; i <= s; i++){
                    leftBuddy[i] = i - 1;
                    rightBuddy[i] = i + 1;
                }
                rightBuddy[s] = 0;

                while(b-- != 0){

                    nextLine = in.readLine();

                    String[] report = nextLine.split("\\s+");

                    int l = Integer.parseInt(report[0]);
                    int r = Integer.parseInt(report[1]);

                    if(leftBuddy[l] == 0)
                        out.print("* ");
                    else
                        out.print(leftBuddy[l] + " ");

                    if(rightBuddy[r] == 0)
                        out.println("*");
                    else
                        out.println(rightBuddy[r]);

                    leftBuddy[rightBuddy[r]] = leftBuddy[l];
                    rightBuddy[leftBuddy[l]] = rightBuddy[r];

                }

                out.println("-");
            }

            in.close();
            out.close();
        
        }
        catch(Exception e){}

    }
}