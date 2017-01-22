import java.util.*;
import java.io.*;
import java.lang.Math;

class Index {

    public int x;
    public int y;

    public Index(int _x, int _y){
        x = _x;
        y = _y;
    }

}


class kattis {

    public static void main(String[] args) throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int minX = 0;
        int minY = 0;
        int maxX = 0;
        int maxY = 0;

        int actX = 0;
        int actY = 0;

        ArrayList<Index> indexes = new ArrayList<Index>();
        indexes.add(new Index(actX, actY));

        while (in.ready()) {

            String move = in.readLine().trim();

            switch(move.charAt(0)){
                case 'r':
                    actY++;
                    break;
                case 'l':
                    actY--;
                    break;
                case 'd':
                    actX++;
                    break;
                case 'u':
                    actX--;
                    break;
            }

            minX = Math.min(minX, actX);
            minY = Math.min(minY, actY);
            maxX = Math.max(maxX, actX);
            maxY = Math.max(maxY, actY);

            indexes.add(new Index(actX, actY));

        }

        minX = -minX;
        minY = -minY;

        char[][] map = new char[maxX + minX + 1][maxY + minY + 1];
        for(int i = 0; i <= maxX + minX; i++)
            Arrays.fill(map[i], ' ');

        for(int i = 1; i < indexes.size() - 1; i++)
            map[indexes.get(i).x + minX][indexes.get(i).y + minY] = '*';

        map[indexes.get(0).x + minX][indexes.get(0).y + minY] = 'S';
        map[indexes.get(indexes.size()-1).x + minX][indexes.get(indexes.size()-1).y + minY] = 'E';

        String delim = "##";
        for(int i = 0; i <= maxY + minY; i++)
            delim += "#";

        out.println(delim);
        for(int i = 0; i <= maxX + minX; i++){
            out.print("#");
            for(int j = 0; j <= maxY + minY; j++)
                out.print(map[i][j]);
            out.println("#");
        }
        out.println(delim);

        in.close();
        out.close();
    }

}