import java.util.*;
import java.io.*;


class Main {

    public static long necessaryCost;
    public static int v;
    public static int[][] edge;
    public static int[] parent;


    public static void main(String[] args) throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        while (in.ready()) {

            String[] line = in.readLine().split("\\s+");
            int n = Integer.parseInt(line[0]);
            int m = Integer.parseInt(line[1]);

            if(n == 0 && m == 0)
                break;

            BitSet bits = new BitSet(1000000);

            boolean stop = false;

            for(int i = 0; i < n; i++){

                String[] nextLine = in.readLine().split("\\s+");

                if(!stop){
                    int start = Integer.parseInt(nextLine[0]);
                    int end = Integer.parseInt(nextLine[1]);

                    if(!bits.get(start, end).isEmpty())
                        stop = true;
                    else
                        bits.flip(start, end);
                }
            }

            for(int i = 0; i < m; i++){

                String[] nextLine = in.readLine().split("\\s+");

                if(!stop){
                    int start = Integer.parseInt(nextLine[0]);
                    int end = Integer.parseInt(nextLine[1]);
                    int interval = Integer.parseInt(nextLine[2]);

                    if(!bits.get(start, end).isEmpty())
                        stop = true;
                    else{
                        bits.flip(start, end);
                        while(start + interval < 1000000){

                            start += interval;
                            end = (end + interval >= 1000000) ? 1000000 : end+interval;

                            if(!bits.get(start, end).isEmpty()){
                                stop = true;
                                break;
                            }
                            else
                                bits.flip(start, end);

                        }
                    }
                }
            }

            if(stop)
                out.println("CONFLICT");
            else
                out.println("NO CONFLICT");

        }

        in.close();
        out.close();
    }

}