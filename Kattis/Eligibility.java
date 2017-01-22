import java.util.*;
import java.io.*;

class kattis {

    public static void main(String[] args) throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        Locale.setDefault(new Locale("en", "US"));

        int tt = Integer.parseInt(in.readLine());

        while (tt-- != 0) {

            String[] input = in.readLine().split("\\s+");

            String[] postSchool = input[1].split("/");
            int yearPostSchool = Integer.parseInt(postSchool[0]);

            String[] birth = input[2].split("/");
            int birthYear = Integer.parseInt(birth[0]);

            int courses = Integer.parseInt(input[3]);

            if(yearPostSchool >= 2010){
                out.println(input[0] + " eligible");
            }
            else if(birthYear >= 1991){
                out.println(input[0] + " eligible");
            }
            else if(courses >= 41){
                out.println(input[0] + " ineligible");
            }
            else{
                out.println(input[0] + " coach petitions");
            }
            

        }

        in.close();
        out.close();
    }


}