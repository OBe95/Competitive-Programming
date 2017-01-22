import java.util.*;
import java.io.*;

class Main {

    public static char direction;
    public static char[][] map;
    public static int r, c, currI, currJ, collected;

    public static void main(String[] args) throws Exception{
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        while(in.ready()){

            String[] dims = in.readLine().split("\\s+");
            r = Integer.parseInt(dims[0]);
            c = Integer.parseInt(dims[1]);
            int s = Integer.parseInt(dims[2]);

            if(r == 0 && c == 0 && s == 0)
                break;

            map = new char[r][c];

            for(int i = 0; i < r; i++){

                String input = in.readLine();
                for(int j = 0; j < c; j++){
                    char currC = input.charAt(j);
                    map[i][j] = currC;
                    if(currC != '.' && currC != '*' && currC != '#'){
                        direction = currC;
                        currI = i;
                        currJ = j;
                        map[i][j] = '.';
                    }
                }

            }

            String instructions = in.readLine();
            collected = 0;
            for(int i = 0; i < s; i++){
                //out.println(direction + " " + currI + " " + currJ);
                nextIndex(instructions.charAt(i));
            }
            out.println(collected);

        }

        in.close();
        out.close();
    
    }

    public static void nextIndex(char inst){

        if(inst == 'D'){
            if(direction == 'N'){
                direction = 'L';
            }
            else if(direction == 'L'){
                direction = 'S';
            }
            else if(direction == 'S'){
                direction = 'O';
            }
            else if(direction == 'O'){
                direction = 'N';
            }
        }
        else if(inst == 'E'){
            if(direction == 'N'){
                direction = 'O';
            }
            else if(direction == 'O'){
                direction = 'S';
            }
            else if(direction == 'S'){
                direction = 'L';
            }
            else if(direction == 'L'){
                direction = 'N';
            }
        }
        else {
            move();
        }

    }

    public static void move(){

        if(direction == 'S' && currI < r-1 && map[currI+1][currJ] != '#'){
            currI++;
        }
        else if(direction == 'L' && currJ < c-1 && map[currI][currJ+1] != '#'){
            currJ++;
        }
        else if(direction == 'N' && currI > 0 && map[currI-1][currJ] != '#'){
            currI--;
        }
        else if(direction == 'O' && currJ > 0 && map[currI][currJ-1] != '#'){
            currJ--;
        }

        if(map[currI][currJ] == '*'){
            collected++;
            map[currI][currJ] = '.';
        }

    }

}