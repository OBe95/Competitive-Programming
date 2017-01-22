import java.util.*;
import java.io.*;

class Main {

    public static boolean[][] notSafe, visited;
    public static int[][] accessPoints;
    public static int[] moveR, moveC;
    public static int r, c, m, n, maxMoves;

    public static void main(String[] args) throws Exception{
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int tt = Integer.parseInt(in.readLine().trim());
        moveR = new int[8];
        moveC = new int[8];

        for(int i = 1; i <= tt; i++){

            String[] dims = in.readLine().split("\\s+");
            r = Integer.parseInt(dims[0]);
            c = Integer.parseInt(dims[1]);
            m = Integer.parseInt(dims[2]);
            n = Integer.parseInt(dims[3]);

            if(n == 0 || m == 0){
                moveR[0] = m; moveC[0] = n;
                moveR[1] = -1*m; moveC[1] = -1*n;
                moveR[2] = n; moveC[2] = m;
                moveR[3] = -1*n; moveC[3] = -1*m;
                maxMoves = 4;
            }
            else if(n == m){
                moveR[0] = m; moveC[0] = n;
                moveR[1] = m; moveC[1] = -1*n;
                moveR[2] = -1*n; moveC[2] = m;
                moveR[3] = -1*n; moveC[3] = -1*m;
                maxMoves = 4;
            }
            else{
                moveR[0] = m; moveC[0] = n;
                moveR[1] = m; moveC[1] = -1*n;
                moveR[2] = -1*n; moveC[2] = m;
                moveR[3] = -1*n; moveC[3] = -1*m;
                moveR[4] = n; moveC[4] = m;
                moveR[5] = n; moveC[5] = -1*m;
                moveR[6] = -1*m; moveC[6] = n;
                moveR[7] = -1*m; moveC[7] = -1*n;
                maxMoves = 8;
            }

            notSafe = new boolean[r][c];
            visited = new boolean[r][c];
            accessPoints = new int[r][c];

            int w = Integer.parseInt(in.readLine().trim());

            while(w-- != 0){
                String[] indices = in.readLine().split("\\s+");
                notSafe[Integer.parseInt(indices[0])][Integer.parseInt(indices[1])] = true;
            }

            visit(0, 0);

            int numEven = 0;
            int numOdd = 0;

            for(int k = 0; k < r; k++){
                for(int j = 0; j < c; j++){
                    if(visited[k][j]){
                        if(accessPoints[k][j] % 2 == 0)
                            numEven++;
                        else
                            numOdd++;
                    }
                }
            }

            out.println("Case " + i + ": " + numEven + " " + numOdd);

        }

        in.close();
        out.close();
    
    }

    public static void visit(int i, int j){

        //System.out.println(i + " " + j + " " + r + " " + c);
        visited[i][j] = true;
        for(int k = 0; k < maxMoves; k++){

            int tmpI = i + moveR[k];
            int tmpJ = j + moveC[k];
            //System.out.println("\t" + tmpI + " " + tmpJ);
            if(tmpI >= 0 && tmpI < r && tmpJ >= 0 && tmpJ < c && !notSafe[tmpI][tmpJ]){
                //System.out.println("\t\t" + tmpI + " " + tmpJ);
                accessPoints[i][j]++;
                if(!visited[tmpI][tmpJ])
                    visit(tmpI, tmpJ);
            }

        }

    }

}