import java.util.*;
import java.io.*;
import java.math.BigInteger;


class kattis {

    public static void main(String[] args) throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        while (in.ready()) {

            String[] input = in.readLine().split("\\s+");

            BigInteger res = BigInteger.valueOf(Integer.parseInt(input[0]));
            for(int i = 1; i < input.length; i++)
                res = lcm(res, BigInteger.valueOf(Integer.parseInt(input[i])));

            out.println(res);

        }

        in.close();
        out.close();
    }

    public static BigInteger gcd(BigInteger a, BigInteger b)
    {
        while (b.compareTo(BigInteger.ZERO) > 0)
        {
            BigInteger temp = b;
            b = a.mod(b);
            a = temp;
        }
        return a;
    }

    private static BigInteger lcm(BigInteger a, BigInteger b)
    {
        return a.multiply(b.divide(gcd(a,b)));
    }

}