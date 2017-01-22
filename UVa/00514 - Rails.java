import java.util.*;
import java.io.*;


class Main {

    public static void main(String[] args) throws Exception{
        
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {

            int n = in.nextInt();

            if(n == 0)
                break;

            while(in.hasNext()){

                int[] order = new int[n];

                if((order[0] = in.nextInt()) == 0){
                    System.out.println();
                    break;
                }

                for(int i = 1; i < n; i++)
                    order[i] = in.nextInt();

                Stack<Integer> stack = new Stack<Integer>();
                int nonAdded = 1;
                boolean possible = true;

                for(int i = 0; i < n && possible; i++){

                    if(stack.empty() || nonAdded <= order[i]){
                        while(nonAdded < order[i])
                            stack.push(nonAdded++);
                        nonAdded++;
                    }
                    else if(stack.peek() != order[i]){
                        possible = false;
                        break;
                    }
                    else
                        stack.pop();

                }

                if(possible)
                    System.out.println("Yes");
                else
                    System.out.println("No");

            }
            
        }
    }

}