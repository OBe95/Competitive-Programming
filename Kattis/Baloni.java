import java.util.*;

public class kattis {

    public static void main (String[] args) {
        
        Scanner in =new Scanner(System.in);
        while(in.hasNext()) {
            
            ArrayList<Integer> heights = new ArrayList<Integer>();
            int numShots = 0;

            int n = in.nextInt();
            for(int i = 0; i < n; i++){
                int height = in.nextInt();
                int upperHeightIndex = heights.indexOf(height + 1);
                if(upperHeightIndex == -1){
                    numShots++;
                }
                else{
                    heights.remove(upperHeightIndex);
                }
                heights.add(height);
            }

            System.out.println(numShots);

        }
    }
}