import java.util.*;

class Main {

    public static boolean[] s, h, d, c;
    public static int sCards, hCards, dCards, cCards;
    public static boolean sStopped, hStopped, dStopped, cStopped;

    public static void main (String[] args) {

        Scanner in =new Scanner(System.in);
        while(in.hasNext()){

            s = new boolean[13];
            h = new boolean[13];
            d = new boolean[13];
            c = new boolean[13];

            sCards = 0;
            hCards = 0;
            dCards = 0;
            cCards = 0;

            sStopped = false;
            hStopped = false;
            dStopped = false;
            cStopped = false;

            String[] line = in.nextLine().split("\\s+");

            for(int i = 0; i < line.length; i++){
                fillR(line[i].charAt(0), line[i].charAt(1));
            }

            int points = 0;

            points += rule1();
            points -= rules234();

            if(points >= 16){
                isStopped();
            }

            if(sStopped && hStopped && dStopped && cStopped){
                System.out.println("BID NO-TRUMP");
            }
            else{

                points += rules567();

                if(points < 14){
                    System.out.println("PASS");
                }
                else{

                    int max = findMax(sCards, hCards, dCards, cCards);
                    if(sCards == max)
                        System.out.println("BID S");
                    else if(hCards == max)
                        System.out.println("BID H");
                    else if(dCards == max)
                        System.out.println("BID D");
                    else
                        System.out.println("BID C");

                }

            }

        }

    }

    public static void fillR(char rank, char suit){
        //System.out.println("fillR : rank " + rank + " suit " + suit);
        if(rank == 'A'){
            fillS(suit, 0);
        }

        else if(rank == 'T'){
            fillS(suit, 9);
        }

        else if(rank == 'J'){
            fillS(suit, 10);
        }

        else if(rank == 'Q'){
            fillS(suit, 11);
        }

        else if(rank == 'K'){
            fillS(suit, 12);
        }

        else{
            fillS(suit, Character.getNumericValue(rank) - 1);
        }

    }

    public static void fillS(char suit, int pos){
        //System.out.println("fillS : suit " + suit + " pos " + pos);
        if(suit == 'S'){
            s[pos] = true;
            sCards++;
        }

        else if(suit == 'H'){
            h[pos] = true;
            hCards++;
        }

        else if(suit == 'D'){
            d[pos] = true;
            dCards++;
        }

        else if(suit == 'C'){
            c[pos] = true;
            cCards++;
        }

    }

    public static int rule1(){

        int sum = 0;

        sum += rule1sec(0, 4);
        sum += rule1sec(12, 3);
        sum += rule1sec(11, 2);
        sum += rule1sec(10, 1);

        return sum;

    }

    public static int rule1sec(int pos, int points){

        int sum = 0;

        if(s[pos])
            sum += points;

        if(h[pos])
            sum += points;

        if(d[pos])
            sum += points;

        if(c[pos])
            sum += points;

        return sum;

    }

    public static int rules234(){

        int sum = 0;

        sum += rules234sec(12, 1);
        sum += rules234sec(11, 2);
        sum += rules234sec(10, 3);

        return sum;

    }

    public static int rules234sec(int pos, int maxCards){

        int sum = 0;

        if(s[pos] && sCards <= maxCards)
            sum++;

        if(h[pos] && hCards <= maxCards)
            sum++;

        if(d[pos] && dCards <= maxCards)
            sum++;

        if(c[pos] && cCards <= maxCards)
            sum++;
        
        return sum;

    }

    public static int rules567(){

        int sum = 0;

        if(sCards == 2)
            sum++;
        else if(sCards == 1 || sCards == 0)
            sum += 2;

        if(hCards == 2)
            sum++;
        else if(hCards == 1 || hCards == 0)
            sum += 2;

        if(dCards == 2)
            sum++;
        else if(dCards == 1 || dCards == 0)
            sum += 2;

        if(cCards == 2)
            sum++;
        else if(cCards == 1 || cCards == 0)
            sum += 2;

        return sum;

    }

    public static void isStopped(){

        if(s[0] || (s[12] && sCards > 1) || (s[11] && sCards > 2))
            sStopped = true;

        if(h[0] || (h[12] && hCards > 1) || (h[11] && hCards > 2))
            hStopped = true;

        if(d[0] || (d[12] && dCards > 1) || (d[11] && dCards > 2))
            dStopped = true;

        if(c[0] || (c[12] && cCards > 1) || (c[11] && cCards > 2))
            cStopped = true;

    }

    public static int findMax(int... vals) {

        int max = 0;

        for (int val : vals) {
            if (val > max) max = val;
        }

        return max;

    }

}