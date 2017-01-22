import java.util.*;
import java.lang.Math;
public class kattis {

    public static void main (String[] args) {
        Scanner in =new Scanner(System.in);
        while(in.hasNext()){
            
            long a = in.nextLong();
            long b = in.nextLong();
            
            System.out.println(Math.abs(a - b));

        }
    }
}