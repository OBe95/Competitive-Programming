import java.util.*;
import java.lang.Math;
public class kattis {

    public static int[][] grid;
    public static void main (String[] args) {
        Scanner in =new Scanner(System.in);
        while(in.hasNext()){
            
            grid = new int[4][4];
            for(int i = 0; i < 4; i++)
                for(int j = 0; j < 4; j++)
                    grid[i][j] = in.nextInt();

            int mvt = in.nextInt();
            switch(mvt){
                case 0:
                    moveLeft();
                    break;
                case 1:
                    moveUp();
                    break;
                case 2:
                    moveRight();
                    break;
                case 3:
                    moveDown();
                    break;
            }

            for(int i = 0; i < 4; i++){

                for(int j = 0; j < 3; j++)
                    System.out.print(grid[i][j] + " ");

                System.out.println(grid[i][3]);

            }

        }
    }

    public static void moveLeft(){
        for(int j = 0; j < 3; j++){
            for(int i = 0; i < 4; i++){

                if(grid[i][j] == 0){
                    int k = j + 1;
                    while(k < 4 && grid[i][k] == 0)
                        k++;
                    if(k < 4){
                        grid[i][j] = grid[i][k];
                        grid[i][k] = 0;
                    }
                }

                if(grid[i][j+1] == 0){
                    int k = j + 2;
                    while(k < 4 && grid[i][k] == 0)
                        k++;
                    if(k < 4){
                        grid[i][j+1] = grid[i][k];
                        grid[i][k] = 0;
                    }
                }

                if(grid[i][j] == grid[i][j+1]){
                    grid[i][j] *= 2;
                    grid[i][j+1] = 0;
                }

            }
        }
    }

    public static void moveUp(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 4; j++){

                if(grid[i][j] == 0){
                    int k = i + 1;
                    while(k < 4 && grid[k][j] == 0)
                        k++;
                    if(k < 4){
                        grid[i][j] = grid[k][j];
                        grid[k][j] = 0;
                    }
                }

                if(grid[i+1][j] == 0){
                    int k = i + 2;
                    while(k < 4 && grid[k][j] == 0)
                        k++;
                    if(k < 4){
                        grid[i+1][j] = grid[k][j];
                        grid[k][j] = 0;
                    }
                }

                if(grid[i][j] == grid[i+1][j]){
                    grid[i][j] *= 2;
                    grid[i+1][j] = 0;
                }

            }
        }
    }

    public static void moveRight(){
        for(int j = 3; j > 0; j--){
            for(int i = 0; i < 4; i++){

                if(grid[i][j] == 0){
                    int k = j - 1;
                    while(k >= 0 && grid[i][k] == 0)
                        k--;
                    if(k >= 0){
                        grid[i][j] = grid[i][k];
                        grid[i][k] = 0;
                    }
                }

                if(grid[i][j-1] == 0){
                    int k = j - 2;
                    while(k >= 0 && grid[i][k] == 0)
                        k--;
                    if(k >= 0){
                        grid[i][j-1] = grid[i][k];
                        grid[i][k] = 0;
                    }
                }

                if(grid[i][j] == grid[i][j-1]){
                    grid[i][j] *= 2;
                    grid[i][j-1] = 0;
                }

            }
        }
    }

    public static void moveDown(){
        for(int i = 3; i > 0; i--){
            for(int j = 0; j < 4; j++){

                if(grid[i][j] == 0){
                    int k = i - 1;
                    while(k >= 0 && grid[k][j] == 0)
                        k--;
                    if(k >= 0){
                        grid[i][j] = grid[k][j];
                        grid[k][j] = 0;
                    }
                }

                if(grid[i-1][j] == 0){
                    int k = i - 2;
                    while(k >= 0 && grid[k][j] == 0)
                        k--;
                    if(k >= 0){
                        grid[i-1][j] = grid[k][j];
                        grid[k][j] = 0;
                    }
                }

                if(grid[i][j] == grid[i-1][j]){
                    grid[i][j] *= 2;
                    grid[i-1][j] = 0;
                }
                
            }
        }
    }

}