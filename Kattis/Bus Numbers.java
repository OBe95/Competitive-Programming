import java.util.*;
import java.io.*;
import java.lang.Math;


class kattis {

    public static void main(String[] args) throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        while (in.ready()) {

            int n = Integer.parseInt(in.readLine().trim());
            PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

            String[] input = in.readLine().trim().split("\\s+");
            for(int i = 0; i < n; i++)
                queue.add(Integer.parseInt(input[i]));

            String ans = "";

            while(queue.size() > 0){

                int firstNum = queue.poll();
                int num = firstNum + 1;
                int nextNum = -1;
                int length = 1;

                while(queue.size() > 0 && (nextNum = queue.peek()) == num){
                    queue.poll();
                    length++;
                    num++;
                }

                if(length == 1)
                    ans += firstNum;
                else if(length == 2)
                    ans += firstNum + " " + (num-1);
                else
                    ans += firstNum + "-" + (num-1);

                ans += " ";

            }

            out.println(ans.substring(0, ans.length()-1));

        }

        in.close();
        out.close();
    }

}