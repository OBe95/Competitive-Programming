import java.util.*;
public class kattis {

    public static void main (String[] args) {
        Scanner in =new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 1; i <= n; i++){
            
            int x = in.nextInt();
            if(x % 2 == 0)
                System.out.println(x + " is even");
            else
                System.out.println(x + " is odd");

        }
    }
}