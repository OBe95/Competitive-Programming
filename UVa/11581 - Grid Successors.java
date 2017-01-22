import java.util.*;
import java.io.*;

class Main {

    public static Integer[][] lines;
    public static long count;

    public static void main (String[] args) {

        Locale.setDefault(new Locale("en", "US"));
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(System.out);

            String nextLine = in.readLine();
            int tt = Integer.parseInt(nextLine);
            while(tt-- != 0){

                lines = new Integer[3][3];

                nextLine = in.readLine();
                if(nextLine.isEmpty()){
                    tt++;
                    continue;
                }
                lines[0][0] = Character.getNumericValue(nextLine.charAt(0));
                lines[0][1] = Character.getNumericValue(nextLine.charAt(1));
                lines[0][2] = Character.getNumericValue(nextLine.charAt(2));

                nextLine = in.readLine();
                lines[1][0] = Character.getNumericValue(nextLine.charAt(0));
                lines[1][1] = Character.getNumericValue(nextLine.charAt(1));
                lines[1][2] = Character.getNumericValue(nextLine.charAt(2));

                nextLine = in.readLine();
                lines[2][0] = Character.getNumericValue(nextLine.charAt(0));
                lines[2][1] = Character.getNumericValue(nextLine.charAt(1));
                lines[2][2] = Character.getNumericValue(nextLine.charAt(2));

                fLines();

                out.println(count);

                

            }
                

            in.close();
            out.close();
        
        }
        catch(Exception e){}

    }

    public static void fLines(){

        int num1 = lines[0][0] * 100 + lines[0][1] * 10 + lines[0][2];
        int num2 = lines[1][0] * 100 + lines[1][1] * 10 + lines[1][2];
        int num3 = lines[2][0] * 100 + lines[2][1] * 10 + lines[2][2];

        count = -1;

        while((num1 != 0 || num2 != 0 || num3 != 0)){

            Integer[][] tmp = new Integer[3][3];

            tmp[0][0] = (lines[0][1] + lines[1][0]) % 2;
            tmp[0][1] = (lines[0][0] + lines[0][2] + lines[1][1]) % 2;
            tmp[0][2] = (lines[0][1] + lines[1][2]) % 2;

            tmp[1][0] = (lines[0][0] + lines[1][1] + lines[2][0]) % 2;
            tmp[1][1] = (lines[0][1] + lines[1][0] + lines[1][2] + lines[2][1]) % 2;
            tmp[1][2] = (lines[0][2] + lines[1][1] + lines[2][2]) % 2;

            tmp[2][0] = (lines[2][1] + lines[1][0]) % 2;
            tmp[2][1] = (lines[2][0] + lines[2][2] + lines[1][1]) % 2;
            tmp[2][2] = (lines[2][1] + lines[1][2]) % 2;

            lines = tmp;

            num1 = lines[0][0] * 100 + lines[0][1] * 10 + lines[0][2];
            num2 = lines[1][0] * 100 + lines[1][1] * 10 + lines[1][2];
            num3 = lines[2][0] * 100 + lines[2][1] * 10 + lines[2][2];

            count++;
        }
        

    }

}