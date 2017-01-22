import java.util.*;


class kattis {

    public static void main(String[] args) throws Exception{
        
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {

            int n = in.nextInt();
            int ans = 0;

            while(n-- != 0){
                if(in.nextInt() < 0)
                    ans++;
            }

            System.out.println(ans);

        }
    }

}