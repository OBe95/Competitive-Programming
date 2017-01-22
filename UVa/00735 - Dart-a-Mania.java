import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws Exception{
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int[] nums = new int[62];
        Arrays.fill(nums, -3000);
        nums[0] = 0;
        for(int i = 1; i <= 20; i++){
            nums[i] = i;
            nums[2*i] = 2*i;
            nums[3*i] = 3*i;
        }
        nums[61] = 50;

        while(in.ready()){
        
            int n = Integer.parseInt(in.readLine().trim());

            if(n <= 0){
                out.println("END OF OUTPUT");
                break;
            }
            int numPerm = 0;
            int numComb = 0;
            for(int i = 0; i <= 61; i++){
                for(int j = 0; j <= 61; j++){
                    for(int k = 0; k <= 61; k++){
                        if(nums[i]+nums[j]+nums[k] == n){
                            numPerm++;
                            if(i <= j && j <= k)
                                numComb++;
                        }
                    }
                }
            }

            if(numPerm == 0){
                out.println("THE SCORE OF " + n + " CANNOT BE MADE WITH THREE DARTS.");
            }
            else{
                out.println("NUMBER OF COMBINATIONS THAT SCORES " + n + " IS " + numComb + ".");
                out.println("NUMBER OF PERMUTATIONS THAT SCORES " + n + " IS " + numPerm + ".");
            }
            out.println("**********************************************************************");
            
        }

        in.close();
        out.close();
    
    }

}