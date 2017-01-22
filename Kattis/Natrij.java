import java.util.*;
import java.io.*;
import java.lang.Math;


class kattis {

    public static void main(String[] args) throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int i = 0;

        while (in.ready()) {

            String[] actualTime = in.readLine().trim().split(":");
            String[] explosionTime = in.readLine().trim().split(":");

            int actH = Integer.parseInt(actualTime[0]);
            int expH = Integer.parseInt(explosionTime[0]);
            int actM = Integer.parseInt(actualTime[1]);
            int expM = Integer.parseInt(explosionTime[1]);
            int actS = Integer.parseInt(actualTime[2]);
            int expS = Integer.parseInt(explosionTime[2]);

            if(expS < actS){
                actM++;
                expS += 60;
            }

            int diffS = (expS-actS)%60;

            if(expM < actM){
                actH++;
                expM += 60;
            }

            int diffM = (expM-actM)%60;

            int diffH = -1;
            if(diffS == 0 && diffM == 0 && actH == expH)
                diffH = 24;
            else if(expH < actH){
                expH += 24;
                diffH = (expH-actH)%60;
            }
            else
                diffH = (expH-actH)%60;

            out.println(String.format("%02d", diffH) + ":" + String.format("%02d", diffM) + ":" + String.format("%02d", diffS));

        }

        in.close();
        out.close();
    }

}