import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<Integer>();

        while (in.hasNextInt()) {
            numbers.add(in.nextInt());
            Collections.sort(numbers);
            int n = numbers.size();
            int mid = n / 2;
            int med = 0;

            if (n % 2 == 1)
                med = numbers.get(mid);
            else
                med = (numbers.get(mid - 1) + numbers.get(mid)) / 2;
            System.out.println(med);
        }
    }
}