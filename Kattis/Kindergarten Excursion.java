import java.util.*;
import java.io.*;

class kattis {

    public static char[] input;

    public static void main(String[] args) throws Exception{
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        while(in.ready()){

            input = in.readLine().toCharArray();

            out.println(MS(0, input.length-1));

        }

        in.close();
        out.close();
    
    }

    public static long MS(int left,int right)
    {
        if(left >= right)
            return 0;

        int mid = (right+left)/2;
        long l = MS(left, mid);
        long r = MS(mid+1, right);
        return l + r + Merge(left, mid+1, right);

    }
 
    public static long Merge(int left,int mid,int right)
    {

        char[] tmp = new char[right - left + 1];
        long cnt = 0;
        int k = 0;

        int i = left;
        int j = mid;

        while(i <= mid-1 && j <= right){

            if(input[i] <= input[j])
                tmp[k++] = input[i++];
            else{
                tmp[k++] = input[j++];
                cnt += mid-i;
            }
        }

        while (i <= mid-1)
            tmp[k++] = input[i++];

        while(j <= right)
            tmp[k++] = input[j++];

        for(i = left; i <= right; i++)
            input[i] = tmp[i-left];

        return cnt;
    }

}