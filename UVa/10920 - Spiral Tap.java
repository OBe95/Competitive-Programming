import java.util.*;
import java.io.*;
import java.lang.Math;

class Main {

    public static void main (String[] args) {

        Locale.setDefault(new Locale("en", "US"));
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(System.out);
            while(in.ready()){

                String nextLine = in.readLine();
                String[] line = nextLine.split("\\s+");

                int sz = Integer.parseInt(line[0]);
                long p = Long.parseLong(line[1]);

                if(sz == 0 && p == 0)
                    break;

                int sqrt = (int)Math.ceil(Math.sqrt(p));
                int preFullGridSize = (sqrt % 2 == 0) ? sqrt - 1 : sqrt - 2;//size of the precedent full grid
                if(sqrt == 1){
                    out.println("Line = " + (sz/2+1) + ", column = " + (sz/2+1) + ".");
                }
                else if(sqrt % 2 == 1 && sqrt == (int)Math.sqrt(p)){
                    out.println("Line = " + ((sz - preFullGridSize) / 2+preFullGridSize+1) + ", column = " + ((sz - preFullGridSize) / 2+preFullGridSize+1) + ".");
                }
                else{

                    int i = (sz - preFullGridSize) / 2 - 1;
                    int j = preFullGridSize + i;//last column index
                    long actPos = (long)Math.pow(preFullGridSize, 2) + 1;//actuel position where the precedent grid has been completly full + 1 mouvement UP
                    int lastMove = 1;//lastMove 1 UP, 2 LEFT, 3 DOWN, 4 RIGHT; to fill a grid the last mouvement is UP
                    int horizontalMoves = preFullGridSize - 1;//num of horizontal moves to make (left or right); equals to size - 1 when full; +1 for the UP mouvement
                    int verticalMoves = preFullGridSize;//num of vertical moves to make (up or down); equals to size when full

                    

                    L: while(actPos != p){

                        if(lastMove == 4){//RIGHT ==> MOVE UP verticalMoves times

                            verticalMoves++;
                            lastMove = 1;
                            for(int k = 0; k < verticalMoves; k++){
                                i--;
                                if(++actPos == p)
                                    break L;
                            }

                        }

                        else if(lastMove == 1){//UP ==> MOVE LEFT horizontalMoves times

                            horizontalMoves++;
                            lastMove = 2;
                            for(int k = 0; k < horizontalMoves; k++){
                                j--;
                                if(++actPos == p)
                                    break L;
                            }

                        }

                        else if(lastMove == 2){//LEFT ==> MOVE DOWN verticalMoves times

                            verticalMoves++;
                            lastMove = 3;
                            for(int k = 0; k < verticalMoves; k++){
                                i++;
                                if(++actPos == p)
                                    break L;
                            }

                        }

                        else if(lastMove == 3){//DOWN ==> MOVE RIGHT horizontalMoves times

                            horizontalMoves++;
                            lastMove = 4;
                            for(int k = 0; k < horizontalMoves; k++){
                                j++;
                                if(++actPos == p)
                                    break L;
                            }

                        }

                    }

                    out.println("Line = " + (sz-i) + ", column = " + (j+1) + ".");
                    
                }

                }
                

            in.close();
            out.close();
        
        }
        catch(Exception e){}

    }

}