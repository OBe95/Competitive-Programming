import java.util.*;
import java.io.*;

class kattis {

    public static void main(String[] args) throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        while(in.ready()){

            String[] input = in.readLine().trim().split("\\s+");
            long a = Long.parseLong(input[0]);
            long b = Long.parseLong(input[1]);

            if(a == 0 && b == 0)
                break;

            long A = a;
            long B = b;

            int aSteps = 0;
            int bSteps = 0;

            HashMap<Long, Integer> stepsA = new HashMap<Long, Integer>();
            HashMap<Long, Integer> stepsB = new HashMap<Long, Integer>();

            if(a == b){
                out.println(A + " needs 0 steps, " + B + " needs 0 steps, they meet at " + a);
                continue;
            }
            else if(a == 1){
                out.println(A + " needs 0 steps, " + B + " needs " + setpsToOne(b) + " steps, they meet at 1");
                continue;
            }
            else if(b == 1){
                out.println(A + " needs " + setpsToOne(a) + " steps, " + B + " needs 0 steps, they meet at 1");
                continue;
            }

            stepsA.put(a, aSteps);
            stepsB.put(b, bSteps);

            while(true){

                a = (a % 2 == 0) ? a/2 : 3*a+1;
                aSteps++;
                if(a == 1){
                    while(b != 1 && !stepsA.containsKey(b)){
                        b = (b % 2 == 0) ? b/2 : 3*b+1;
                        bSteps++;
                    }
                    if(b != 1){
                        aSteps = stepsA.get(b);
                        a = b;
                    }
                    break;
                }
                if(stepsB.containsKey(a)){
                    bSteps = stepsB.get(a);
                    b = a;
                    break;
                }
                stepsA.put(a, aSteps);

                b = (b % 2 == 0) ? b/2 : 3*b+1;
                bSteps++;
                if(b == 1){
                    while(a != 1 && !stepsB.containsKey(a)){
                        a = (a % 2 == 0) ? a/2 : 3*a+1;
                        aSteps++;
                    }
                    if(a != 1){
                        bSteps = stepsB.get(a);
                        b = a;
                    }
                    break;
                }
                if(stepsA.containsKey(b)){
                    aSteps = stepsA.get(b);
                    a = b;
                    break;
                }
                stepsB.put(b, bSteps);

            }

            out.println(A + " needs " + aSteps + " steps, " + B + " needs " + bSteps + " steps, they meet at " + a);
            
        }

        in.close();
        out.close();
    }

    public static int setpsToOne(long a){
        
        int steps = 0;

        while(a != 1){
            a = (a % 2 == 0) ? a/2 : 3*a+1;
            steps++;
        }

        return steps;

    }

}