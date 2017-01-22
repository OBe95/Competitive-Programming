import java.util.*;
import java.lang.Math;

class Main {

    public static void main (String[] args) {

        Scanner in =new Scanner(System.in);
        
        while(in.hasNext()){

            String nextLine = in.nextLine();
            if(nextLine.isEmpty())
                continue;

            String[] line = nextLine.split("\\s+");

            int n = Integer.parseInt(line[0]);

            if(n == 1){
                System.out.println("Jolly");
            }
            else{

                boolean broken = false;
                HashSet<Integer> diffs = new HashSet<Integer>();

                for(int i = 1; i < n; i++){

                    int diff = Math.abs(Integer.parseInt(line[i]) - Integer.parseInt(line[i+1]));
                    if(diff == 0 || diff >= n){
                        broken = true;
                        break;
                    }
                    if(!diffs.add(diff)){
                        broken = true;
                        break;
                    }

                }

                //System.out.print("SIZE : " + diffs.size() + " ");

                if(broken)
                    System.out.println("Not jolly");
                else
                    System.out.println("Jolly");

            }
            

            //Collections.sort(diffs);
                

        }

    }
}