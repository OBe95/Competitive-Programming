import java.util.*;
import java.lang.Math;

class Main {

    public static int n, m;

    public static void main (String[] args) {

        Scanner in =new Scanner(System.in);
        int tt = Integer.parseInt(in.nextLine());
        
        while(tt-- != 0){

            String nextLine = in.nextLine();
            if(nextLine.isEmpty()){
                tt++;
                continue;
            }
            String[] line = nextLine.split("\\s+");
            char chesspiece = line[0].charAt(0);
            n = Integer.parseInt(line[1]);
            m = Integer.parseInt(line[2]);

            switch(chesspiece){
                case 'r':
                    System.out.println(rooks());
                    break;
                case 'Q':
                    System.out.println(queens());
                    break;
                case 'k':
                    System.out.println(knights());
                    break;
                case 'K':
                    System.out.println(kings());
                    break;
            }

        }

    }

    public static int rooks(){
        return Math.min(m,n);
    }

    public static int queens(){
        int min = Math.min(m,n);

        if(min <= 2)
            return 1;
        if(min == 3)
            return 2;
        return min;
    }

    public static int kings(){
        return (int) (Math.floor(0.5*(n+1)) * Math.floor(0.5*(m+1)));
    }

    public static int knights(){
        if(m == 1)
            return n;
        if(m == 2)
            return (int)(2 * (Math.ceil(0.25*n) + Math.ceil(0.25 * (n-1))));
        return (int)(Math.ceil(0.5*n*m));
    }

}