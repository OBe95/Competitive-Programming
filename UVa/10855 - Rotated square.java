import java.util.*;
import java.io.*;

class Main {

    public static int N, n;
    public static String[] big, small;

    public static void main (String[] args) {

        Locale.setDefault(new Locale("en", "US"));
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(System.out);
            while(in.ready()){

                String nextLine = in.readLine();
                String[] line = nextLine.split("\\s+");

                N = Integer.parseInt(line[0]);
                n = Integer.parseInt(line[1]);

                if(N == 0 && n == 0)
                    break;

                big = new String[N];
                small = new String[n];

                for(int i = 0; i < N; i++)
                    big[i] = in.readLine();

                for(int i = 0; i < n; i++)
                    small[i] = in.readLine();

                String ans = occ(small) + " ";

                String[] rotated90 = rotate90(small);
                ans += occ(rotated90) + " ";

                String[] rotated180 = rotate90(rotated90);
                ans += occ(rotated180) + " ";

                String[] rotated270 = rotate90(rotated180);
                ans += occ(rotated270);

                out.println(ans);
                
            }

            in.close();
            out.close();
        
        }
        catch(Exception e){}

    }

    public static String[] rotate90(String[] orginal){

        String[] res = new String[n];

        int k = 0;

        for(int i = 0; i < n; i++){

            String tmp = "";
            for(int j = n - 1; j >= 0; j--)
                tmp += orginal[j].charAt(i);

            res[k] = tmp;
            k++;

        }

        return res;

    }

    public static int occ(String[] toCount){

        int count = 0;

        for(int i = 0; i <= N - n; i++){

            int lastIndex = 0;

            while(lastIndex != -1){

                lastIndex = big[i].indexOf(toCount[0],lastIndex);

                if(lastIndex != -1){

                    int j = 1;

                    while(j < n && big[i+j].indexOf(toCount[j],lastIndex) == lastIndex)
                        j++;

                    if(j == n)
                        count++;

                    lastIndex += 1;

                }
            }

        }

        return count;

    }

}