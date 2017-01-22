import java.util.*;

class Main {


    public static void main (String[] args) {

        Scanner in =new Scanner(System.in);
        
        while(in.hasNext()){

            int A = in.nextInt();
            int B = in.nextInt();
            int C = in.nextInt();
            int X = in.nextInt();
            int Y = in.nextInt();

            if(A == 0 && B == 0 && C == 0 && X == 0 && Y == 0)
                break;

            ArrayList<Integer> princess = new ArrayList<Integer>();
            princess.add(A); princess.add(B); princess.add(C);
            Collections.sort(princess);

            ArrayList<Integer> prince = new ArrayList<Integer>();
            prince.add(X); prince.add(Y);
            Collections.sort(prince);

            int princessWins = 0;

            int i = 0;
            int j = 0;

            for(i = 0; i < princess.size(); i++){

                for(j = 0; j < prince.size(); j++){
                    if(princess.get(i) > prince.get(j)){
                        princessWins++;
                        princess.remove(i);
                        prince.remove(j);
                        i--;
                        break;
                    }
                }

            }


            if(princessWins == 2)
                System.out.println("-1");
            else{

                HashSet<Integer> vals = new HashSet<Integer>();
                vals.add(A); vals.add(B); vals.add(C); vals.add(X); vals.add(Y);

                int Z = 0;
                if(princessWins == 1)
                    Z = princess.get(princess.size()-1);

                while(vals.size() < 6){
                    Z++;
                    vals.add(Z);
                }

                Z = (Z > 52) ? -1:Z;

                System.out.println(Z);
            }

        }

    }

}