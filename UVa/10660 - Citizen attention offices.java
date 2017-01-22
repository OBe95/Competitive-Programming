import java.util.*;
import java.io.*;
import java.lang.Math;

class Main {

    public static void main(String[] args) throws Exception{
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int tt = Integer.parseInt(in.readLine().trim());

        while(tt-- != 0){
        
            int[][] population = new int[5][5];
            int n = Integer.parseInt(in.readLine().trim());
            
            while(n-- != 0){
                String[] input = in.readLine().trim().split("\\s+");
                population[Integer.parseInt(input[0])][Integer.parseInt(input[1])] = Integer.parseInt(input[2]);
            }

            int[] solution = new int[5];
            int minDist = Integer.MAX_VALUE;

            for(int a = 0; a < 21; a++)
                for(int b = a+1; b < 22; b++)
                    for(int c = b+1; c < 23; c++)
                        for(int d = c+1; d < 24; d++)
                            for(int e = d+1; e < 25; e++){
                                int dist = 0;
                                for(int i = 0; i < 5; i++){
                                    for(int j = 0; j < 5; j++){
                                        int actMin = Integer.MAX_VALUE;
                                        actMin = Math.min(actMin, (int) (Math.abs(i - a/5) + Math.abs(j - a%5)));
                                        actMin = Math.min(actMin, (int) (Math.abs(i - b/5) + Math.abs(j - b%5)));
                                        actMin = Math.min(actMin, (int) (Math.abs(i - c/5) + Math.abs(j - c%5)));
                                        actMin = Math.min(actMin, (int) (Math.abs(i - d/5) + Math.abs(j - d%5)));
                                        actMin = Math.min(actMin, (int) (Math.abs(i - e/5) + Math.abs(j - e%5)));
                                        dist += actMin * population[i][j];
                                    }
                                }
                                if(dist < minDist){
                                    minDist = dist;
                                    solution[0] = a;
                                    solution[1] = b;
                                    solution[2] = c;
                                    solution[3] = d;
                                    solution[4] = e;
                                }
                            }

            for(int i = 0; i < 4; i++)
                out.print(solution[i] + " ");
            out.println(solution[4]);
            
        }

        in.close();
        out.close();
    
    }

}