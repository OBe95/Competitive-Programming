import java.util.*;
import java.io.*;

class Main {

    public static void main (String[] args) {

        Locale.setDefault(new Locale("en", "US"));
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(System.out);

            while(in.ready()){

                String nextLine = in.readLine();

                if(nextLine.isEmpty())
                    continue;
                else if(nextLine.equals("#"))
                    break;

                int length = nextLine.length();
                int indexJ = -1;
                int indexI = -1;

                L: for(int i = length-1; i > 0; i--){

                    char c = nextLine.charAt(i);

                    for(int j = i-1; j >= 0; j--){

                        if(c > nextLine.charAt(j) && j > indexJ){
                            indexJ = j;
                            indexI = i;
                        }

                    }

                }

                if(indexI == -1)
                    out.println("No Successor");
                else{

                    nextLine = nextLine.substring(0, indexJ) + nextLine.charAt(indexI) + nextLine.substring(indexJ+1, indexI) + nextLine.charAt(indexJ) + nextLine.substring(indexI+1);
                    String part1 = nextLine.substring(0, indexJ+1);
                    String part2 = nextLine.substring(indexJ+1);

                    char[] chars = part2.toCharArray();
                    Arrays.sort(chars);
                    String part2Sorted = new String(chars);

                    out.println(part1 + part2Sorted);

                }

                

            }
                

            in.close();
            out.close();
        
        }
        catch(Exception e){}

    }

}