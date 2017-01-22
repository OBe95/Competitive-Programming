import java.util.*;

/*
Store input in ArrayList<String> 0 - 51
Method valueOfCard returns the value of the card 2 - 10
Set Y to the value of 51-25= 26th card
Remove elements from 26th index to 26-(10-Y) index
print Case num : element at Y - 1
*/



class Main {


    public static void main (String[] args) {

        Scanner in =new Scanner(System.in);
        int tt = Integer.parseInt(in.nextLine());

        for(int i = 1; i <= tt; i++){

            String[] line = in.nextLine().split("\\s+");
            ArrayList<String> cards = new ArrayList<String>(Arrays.asList(line));

            int y = 0;

            for(int k = 0; k < 3; k++){

                int newIndex = cards.size() - 26;
                int x = valueOfCard(cards.get(newIndex).charAt(0));
                y += x;

                for(int j = newIndex; j >= newIndex - (10 - x); j--)
                    cards.remove(j);

            }

            System.out.println("Case " + i + ": " + cards.get(y-1));

        }

    }

    public static int valueOfCard(char rank){

        if(rank >= '2' && rank <='9')
            return Character.getNumericValue(rank);
        return 10;

    }

}