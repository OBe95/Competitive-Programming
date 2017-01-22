import java.util.*;
import java.io.*;

class Main {

    public static int[] price;

    public static void main(String[] args) throws Exception{
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        while(in.ready()){

            int n = Integer.parseInt(in.readLine().trim());
            price = new int[n];

            String[] prices = in.readLine().trim().split("\\s+");
            for(int i = 0; i < n; i++)
                price[i] = Integer.parseInt(prices[i]);
            Arrays.sort(price);

            int m = Integer.parseInt(in.readLine().trim());
            int min = 0;
            int max = 1000009;
            for(int i = 0; i < n-1; i++){
                int indComplement = bst(i, m-price[i], i+1, n-1);
                if(indComplement != -1 && max-min > price[indComplement]-price[i]){
                    min = price[i];
                    max = price[indComplement];
                }
            }

            out.println("Peter should buy books whose prices are " + min + " and " + max + ".\n");
            in.readLine();

        }

        in.close();
        out.close();
    
    }

    public static int bst(int index, int val, int l, int r){

        if(l == r){
            if(val == price[l])
                return l;
            return -1;
        }
        else{
            if(val <= price[(l+r)/2])
                return bst(index, val, l, (l+r)/2);
            else
                return bst(index, val, (l+r)/2+1, r);
        }

    }

}