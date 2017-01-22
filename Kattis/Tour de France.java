import java.util.*;
import java.io.*;


class kattis {

    public static void main(String[] args) throws Exception{

        Locale.setDefault(new Locale("en", "US"));
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        while (in.ready()) {

            String line = in.readLine();
            if(line.equals("0"))
                break;

            String[] dim = line.split("\\s+");
            int f = Integer.parseInt(dim[0]);
            int r = Integer.parseInt(dim[1]);

            String[] front = in.readLine().split("\\s+");
            int[] frontI = new int[f];
            for(int i = 0; i < f; i++)
                frontI[i] = Integer.parseInt(front[i]);

            String[] rear = in.readLine().split("\\s+");
            int[] rearI = new int[r];
            for(int i = 0; i < r; i++)
                rearI[i] = Integer.parseInt(rear[i]);

            double[] ratios = new double[r*f];

            int count = 0;
            for(int i = 0; i < f; i++){
                for(int j = 0; j < r; j++){
                    ratios[count++] = 1.0*rearI[j]/frontI[i];
                }
            }

            Arrays.sort(ratios);

            double max = 0;
            for(int i = 1; i < r*f; i++){
                if(ratios[i]/ratios[i-1] > max)
                    max = ratios[i]/ratios[i-1];
            }

            out.printf("%.2f\n", max);
            
        }

        in.close();
        out.close();
    }

}