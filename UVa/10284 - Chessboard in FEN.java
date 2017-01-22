import java.util.*;
import java.lang.Math;

class Main {

    public static boolean[][] attacked;
    public static char[][] pieces;

    public static void main (String[] args) {

        Scanner in =new Scanner(System.in);
        
        while(in.hasNext()){

            String nextLine = in.nextLine();
            if(nextLine.isEmpty())
                continue;

            String[] line = nextLine.split("/");

            attacked = new boolean[8][8];
            pieces = new char[8][8];

            for(int i = 0; i < 8; i++){

                int j = 0;
                for(int k = 0; k < line[i].length(); k++){

                    char c = line[i].charAt(k);
                    if(c >= '1' && c <= '8'){
                        j += Character.getNumericValue(c);
                    }
                    else{
                        pieces[i][j] = c;
                        j++;
                    }

                }
            }

            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 8; j++){

                    char c = pieces[i][j];

                    if(c == 'p'){
                        wPawn(i, j);
                    }
                    else if(c == 'P'){
                        bPawn(i, j);
                    }
                    else if(c == 'N' || c == 'n'){
                        knight(i, j);
                    }
                    else if(c == 'B' || c == 'b'){
                        bishop(i, j);
                    }
                    else if(c == 'R' || c == 'r'){
                        rook(i, j);
                    }
                    else if(c == 'Q' || c == 'q'){
                        bishop(i, j);
                        rook(i, j);
                    }
                    else if(c == 'K' || c == 'k'){
                        king(i, j);
                    }

                }

            }

            int ans = 0;
            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 8; j++){
                    if(!attacked[i][j])
                        ans++;
                }
            }

            System.out.println(ans);

        }

    }

    public static void wPawn(int i, int j){

        attacked[i][j] = true;

        if(i+1 < 8){
            if(j+1 < 8)
                attacked[i+1][j+1] = true;
            if(j-1 >= 0)
                attacked[i+1][j-1] = true;
        }

    }

    public static void bPawn(int i, int j){

        attacked[i][j] = true;

        if(i-1 >= 0){
            if(j+1 < 8)
                attacked[i-1][j+1] = true;
            if(j-1 >= 0)
                attacked[i-1][j-1] = true;
        }

    }

    public static void knight(int i, int j){

        attacked[i][j] = true;

        //donw right
        if(i+2 < 8 && j+1 < 8)
            attacked[i+2][j+1] = true;

        if(i+1 < 8 && j+2 < 8)
            attacked[i+1][j+2] = true;

        //donw left
        if(i+2 < 8 && j-1 >= 0)
            attacked[i+2][j-1] = true;

        if(i+1 < 8 && j-2 >=0)
            attacked[i+1][j-2] = true;

        //top right
        if(i-2 >= 0 && j+1 < 8)
            attacked[i-2][j+1] = true;

        if(i-1 >= 0 && j+2 < 8)
            attacked[i-1][j+2] = true;

        //top left
        if(i-2 >= 0 && j-1 >= 0)
            attacked[i-2][j-1] = true;

        if(i-1 >= 0 && j-2 >=0)
            attacked[i-1][j-2] = true;

    }

    public static void bishop(int i, int j){

        attacked[i][j] = true;

        int i2 = i-1;
        int j2 = j-1;

        while(i2 >= 0 && j2 >= 0 && pieces[i2][j2] == '\u0000'){
            attacked[i2][j2] = true;
            i2--;
            j2--;
        }

        i2 = i-1;
        j2 = j+1;

        while(i2 >= 0 && j2 < 8 && pieces[i2][j2] == '\u0000'){
            attacked[i2][j2] = true;
            i2--;
            j2++;
        }

        i2 = i+1;
        j2 = j-1;

        while(i2 < 8 && j2 >= 0 && pieces[i2][j2] == '\u0000'){
            attacked[i2][j2] = true;
            i2++;
            j2--;
        }

        i2 = i+1;
        j2 = j+1;

        while(i2 < 8 && j2 < 8 && pieces[i2][j2] == '\u0000'){
            attacked[i2][j2] = true;
            i2++;
            j2++;
        }

    }

    public static void rook(int i, int j){

        attacked[i][j] = true;

        int i2 = i-1;

        while(i2 >= 0 && pieces[i2][j] == '\u0000'){
            attacked[i2][j] = true;
            i2--;
        }

        i2 = i+1;

        while(i2 < 8 && pieces[i2][j] == '\u0000'){
            attacked[i2][j] = true;
            i2++;
        }

        int j2 = j-1;

        while(j2 >= 0 && pieces[i][j2] == '\u0000'){
            attacked[i][j2] = true;
            j2--;
        }

        j2 = j+1;

        while(j2 < 8 && pieces[i][j2] == '\u0000'){
            attacked[i][j2] = true;
            j2++;
        }

    }

    public static void king(int i, int j){

        attacked[i][j] = true;

        if(i-1 >= 0){
            attacked[i-1][j] = true;
            if(j+1 < 8)
                attacked[i-1][j+1] = true;
            if(j-1 >= 0)
                attacked[i-1][j-1] = true;
        }

        if(i+1 < 8){
            attacked[i+1][j] = true;
            if(j+1 < 8)
                attacked[i+1][j+1] = true;
            if(j-1 >= 0)
                attacked[i+1][j-1] = true;
        }

        if(j-1 >= 0)
            attacked[i][j-1] = true;

        if(j+1 < 8)
            attacked[i][j+1] = true;

    }

}