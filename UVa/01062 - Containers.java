import java.util.*;
import java.io.*;


class Main {


    public static void main(String[] args) throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int numCase = 0;

        while (in.ready()) {

            String ships = in.readLine();

            if(ships.isEmpty())
                continue;

            if(ships.equals("end"))
                break;

            numCase++;

            ArrayList<Stack<Character>> stacks = new ArrayList<Stack<Character>>();
            stacks.add(new Stack<Character>());
            stacks.get(0).push(ships.charAt(0));
            int numStacks = 1;

            for(int i = 1; i < ships.length(); i++){
                char c = ships.charAt(i);
                int j = 0;
                for(j = 0; j < numStacks; j++){
                    if(stacks.get(j).peek() >= c){
                        stacks.get(j).push(c);
                        break;
                    }
                }
                if(j == numStacks){
                    stacks.add(new Stack<Character>());
                    stacks.get(numStacks).push(c);
                    numStacks++;
                }
            }

            out.println("Case " + numCase + ": " + numStacks);
            
        }

        in.close();
        out.close();
    }

}