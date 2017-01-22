import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws Exception{
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        
        while(in.ready()){
        
            int promoDays = Integer.parseInt(in.readLine());

            if(promoDays == 0)
                break;

            TreeSet<Integer> bills = new TreeSet<Integer>();
            int[] billOcc = new int[1000009];

            long total = 0;

            while(promoDays-- != 0){

                String[] input = in.readLine().split("\\s+");

                for(int i = 1; i < input.length; i++){
                    int bill = Integer.parseInt(input[i]);
                    bills.add(bill);
                    billOcc[bill]++;
                }

                int maxDayBill = bills.last();
                int minDayBill = bills.first();

                billOcc[maxDayBill]--;
                billOcc[minDayBill]--;

                if(billOcc[maxDayBill] == 0)
                    bills.remove(maxDayBill);

                if(billOcc[minDayBill] == 0)
                    bills.remove(minDayBill);

                total += maxDayBill - minDayBill;

            }

            out.println(total);
        
        }

        in.close();
        out.close();
    
    }

}