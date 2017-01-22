import java.util.*;
import java.io.*;

class FenwickTree {
    public int[] ft;

    public int LSOne(int S) { 
        return (S & (-S));
    }

    public FenwickTree(int n) { 
        ft = new int[n+1];
        Arrays.fill(ft, 0);
    }

    public int rsq(int b) {
        int sum = 0;
        for (; b > 0; b -= LSOne(b))
            sum += ft[b];
        return sum;
    }

    public int rsq(int a, int b) {
        return rsq(b) - (a == 1 ? 0 : rsq(a - 1));
    }

    void adjust(int k, int v) {
        for (; k < ft.length; k += LSOne(k))
            ft[k] += v;
    }
}

class Main {

    public static void main(String[] args) throws Exception{
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        while(in.ready()){
        
            StringBuilder ans = new StringBuilder();

            String[] dims = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(dims[0]);
            int k = Integer.parseInt(dims[1]);

            String[] input = in.readLine().trim().split("\\s+");

            FenwickTree ftNeg = new FenwickTree(n);
            FenwickTree ftZero = new FenwickTree(n);
            int[] nums = new int[n+1];

            for(int i = 1; i <= n; i++){
                nums[i] = Integer.parseInt(input[i-1]);
                int v = 0;
                if(nums[i] == 0)
                    ftZero.adjust(i, 1);
                else if(nums[i] < 0)
                    ftNeg.adjust(i, 1);
            }

            while(k-- != 0){

                String[] query = in.readLine().trim().split("\\s+");
                char qType = query[0].charAt(0);
                int i = Integer.parseInt(query[1]);
                int j = Integer.parseInt(query[2]);

                if(qType == 'C'){
                    if(nums[i] == 0){
                        if(j < 0){
                            ftZero.adjust(i, -1);
                            ftNeg.adjust(i, 1);
                        }
                        else if(j > 0)
                            ftZero.adjust(i, -1);
                    }
                    else if(nums[i] < 0){
                        if(j == 0){
                            ftNeg.adjust(i, -1);
                            ftZero.adjust(i, 1);
                        }
                        else if(j > 0)
                            ftNeg.adjust(i, -1);
                    }
                    else{
                        if(j == 0)
                            ftZero.adjust(i, 1);
                        else if(j < 0)
                            ftNeg.adjust(i, 1);
                    }
                    nums[i] = j;
                }
                else{
                    if(ftZero.rsq(i, j) > 0)
                        ans.append('0');
                    else if(ftNeg.rsq(i, j) % 2 == 1)
                        ans.append('-');
                    else
                        ans.append('+');
                }

            }

            out.println(ans);

        }

        in.close();
        out.close();
    
    }

}