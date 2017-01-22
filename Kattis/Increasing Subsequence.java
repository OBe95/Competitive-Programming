import java.util.*;
import java.io.*;


class kattis {

    public static void main(String[] args) throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        String line = in.readLine();
        while (line != null) {

            String[] spec = line.split("\\s+");
            int n = Integer.parseInt(spec[0]);

            if(n == 0)
                break;

            int[] list = new int[n];
            int[] solution = new int[n];
            int lis[] = new int[n];

            for(int i = 0; i < n; i++){
                lis[i] = 1;
                list[i] = Integer.parseInt(spec[i+1]);
                solution[i] = i;
            }

            /* Compute optimized LIS values in bottom up manner */
            for(int i = 1; i < n; i++){
                for(int j = 0; j < i; j++){
                    if(list[i] > list[j]){
                        if(lis[i] < lis[j] + 1){
                            lis[i] = lis[j] + 1;
                            solution[i] = j;
                        }
                        else if(lis[i] == lis[j]+1 && list[solution[i]] > list[j]){
                            solution[i] = j;
                        }
                    }
                }
            }
 
            int max = 0;
            int maxIndex = -1;
            /* Pick maximum of all LIS values */
            for(int i = 0; i < n; i++){
                if(max < lis[i]){
                    max = lis[i];
                    maxIndex = i;
                }
                else if(max == lis[i]){
                    if(list[i] <= list[maxIndex]){
                        max = lis[i];
                        maxIndex = i;
                    }
                }
            }

            StringBuilder ans = new StringBuilder();
            int t = maxIndex;
            int newT = maxIndex;
            do{
                t = newT;
                ans.insert(0, list[t] + " ");
                newT = solution[t];
            }while(t != newT);

            out.println(max + " " + ans.toString().trim());

            line = in.readLine();

        }

        in.close();
        out.close();
    }

}