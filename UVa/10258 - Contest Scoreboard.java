import java.util.*;

class Contestant {

    public boolean[] solved;
    public int[] penality;

    public int id;
    public int problems;
    public int time;

    public Contestant(int _id){
        solved = new boolean[10];
        penality = new int[10];
        id = _id;
        time = 0;
        problems = 0;
    }

}

class Main {

    public static Comparator compareContestants = new Comparator<Contestant>() {

            public int compare(Contestant c1, Contestant c2) {
                if(c1.problems > c2.problems)
                    return -1;
                else if(c1.problems < c2.problems)
                    return 1;
                if(c1.time < c2.time)
                    return -1;
                else if(c1.time > c2.time)
                    return 1;
                if(c1.id < c2.id)
                    return -1;
                return 1;
            }

    };

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int tt = Integer.parseInt(in.nextLine());
        in.nextLine();

        while (tt-- != 0) {

            Contestant[] contestant = new Contestant[101];
            HashSet<Integer> indexes = new HashSet<Integer>();
            while(in.hasNext()){

                String nextLine = in.nextLine();
                if(nextLine.isEmpty())
                    break;

                String[] line = nextLine.split("\\s+");
                int c = Integer.parseInt(line[0]);
                int p = Integer.parseInt(line[1]);
                int t = Integer.parseInt(line[2]);
                char l = line[3].charAt(0);

                indexes.add(c);

                if(contestant[c] == null)
                    contestant[c] = new Contestant(c);

                if(l == 'I' && !contestant[c].solved[p])
                    contestant[c].penality[p] += 20;
                else if(l == 'C' && !contestant[c].solved[p]){
                    contestant[c].solved[p] = true;
                    contestant[c].time += t + contestant[c].penality[p];
                    contestant[c].problems++;
                }

            }

            ArrayList<Contestant> results = new ArrayList<Contestant>();

            for (int i : indexes) {
                results.add(contestant[i]);
            }

            Collections.sort(results, compareContestants);

            for(int i = 0; i < results.size(); i++)
                System.out.println(results.get(i).id + " " + results.get(i).problems + " " + results.get(i).time);

            if(tt != 0)
                System.out.println();
        }
    }
}