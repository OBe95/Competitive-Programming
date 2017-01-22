import java.util.*;

public class kattis {
    public static char[] bits;
    public static void main (String[] args) {
        Scanner in =new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        while (n != 0){

            bits = new char[32];
            Arrays.fill(bits, '?');

            for (int k = 0; k < n; k++) {

                String[] line = in.nextLine().split(" ");
                String command = line[0];

                if(command.equals("CLEAR")){
                    int i = Integer.parseInt(line[1]);
                    bits[31 - i] = '0';
                }
                else if(command.equals("SET")){
                    int i = Integer.parseInt(line[1]);
                    bits[31 - i] = '1';
                }
                else if(command.equals("OR")){
                    int i = Integer.parseInt(line[1]);
                    int j = Integer.parseInt(line[2]);
                    OR(31 - i, 31 - j);
                }
                else if(command.equals("AND")){
                    int i = Integer.parseInt(line[1]);
                    int j = Integer.parseInt(line[2]);
                    AND(31 - i, 31 - j);
                }
                
            }

            for (int k = 0; k < 32; k++){
                System.out.print(bits[k]);
            }
            System.out.println();

            n = Integer.parseInt(in.nextLine());

        }
    }

    public static void OR(int i, int j){

        if(bits[j] == '1' || bits[i] == '1')
            bits[i] = '1';
        else if(bits[j] == '?' || bits[i] == '?')
            bits[i] = '?';
        else
            bits[i] = '0';

    }

    public static void AND(int i, int j){

        if(bits[j] == '0' || bits[i] == '0')
            bits[i] = '0';
        else if(bits[j] == '?' || bits[i] == '?')
            bits[i] = '?';
        else
            bits[i] = '1';
        
    }
}