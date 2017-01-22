import java.util.*;
import java.io.*;


class Main {

    public static String wordS, wordT;
    public static ArrayList<String> combinations;
    public static int length;

    public static void main(String[] args) throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        while (in.ready()) {

            wordS = in.readLine();
            wordT = in.readLine();

            length = wordT.length();
            if(wordS.length() != length){
                out.println("[\n]");
                continue;
            }

            Stack<Character> chars = new Stack<Character>();
            combinations = new ArrayList<String>();

            build(0, 0, "", chars);

            Collections.sort(combinations);

            out.println("[");
            for(String s : combinations)
                out.println(s);
            out.println("]");
            
        }

        in.close();
        out.close();
    }

    public static void build(int posS, int posT, String comb, Stack<Character> stack){

        if(posT >= length){
            combinations.add(comb.substring(0,comb.length()-1));
        }
        else if(stack.empty() && posS < length){
            stack.push(wordS.charAt(posS));
            build(posS+1, posT, comb+"i ", stack);
        }
        else{
            if(posS < length){
                Stack<Character> stackCopy = (Stack<Character>)stack.clone();
                stackCopy.push(wordS.charAt(posS));
                build(posS+1, posT, comb+"i ", stackCopy);
            }

            if(stack.pop() == wordT.charAt(posT)){
                build(posS, posT+1, comb+"o ", stack);
            }
        }

    }

}