import java.util.*;
import java.io.*;

class word implements Comparable<word> {

    public String w;
    public long occ;

    public word(String _w, long _occ){
        w = _w;
        occ = _occ;
    }

    @Override
    public int compareTo(word ww){
        if(occ > ww.occ)
            return -1;
        if(occ < ww.occ)
            return 1;
        return w.compareTo(ww.w);
    }

}

class pair {

    public int used;
    public long occ;

    public pair(int u, long o){
        used = u;
        occ = o;
    }

}

class kattis {


    public static void main(String[] args) throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        Locale.setDefault(new Locale("en", "US"));

        while (in.ready()) {

            int m = Integer.parseInt(in.readLine());
            HashMap<String, pair> words = new HashMap<String, pair>();

            ArrayList<HashSet<String>> usedWords = new ArrayList<HashSet<String>>();
            HashMap<String, Integer> users = new HashMap<String, Integer>();
            int userId = 0;

            long one = 1;

            for(int i = 0; i < m; i++){
                String[] line = in.readLine().split("\\s+");

                String user = line[0];
                int id = userId;
                if(users.containsKey(user)){
                    id = users.get(user);
                }
                else{
                    users.put(user, userId++);
                    usedWords.add(new HashSet<String>());
                }

                HashSet<String> tmpHS = usedWords.get(id);
                //out.println(i + " : " + id);

                for(int j = 1; j < line.length; j++){
                    String actWord = line[j];
                    boolean newForUser = false;

                    if(!tmpHS.contains(actWord)){
                        tmpHS.add(actWord);
                        newForUser = true;
                    }

                    if(words.containsKey(actWord)){
                        pair tmp = words.get(actWord);
                        int timeUse = tmp.used;
                        if(newForUser)
                            timeUse++;
                        
                        words.put(actWord, new pair(timeUse, tmp.occ+1));
                        //out.println("\t" + actWord + ", used by " + timeUse + " users, and for " + (tmp.occ+1) + " times.");
                    }
                    else{
                        words.put(actWord, new pair(1, one));
                        //out.println("\t" + actWord + ", used by 1 users, and for 1 times.");
                    }
                }
            }

            PriorityQueue<word> queue = new PriorityQueue<word>();

            Iterator it = words.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry keyVal = (Map.Entry)it.next();
                pair tmp = (pair)keyVal.getValue();
                String s = (String) keyVal.getKey();
                if(tmp.used == userId){
                    queue.add(new word(s, tmp.occ));
                }
            }

            if(queue.size() == 0){
                out.println("ALL CLEAR");
                continue;
            }

            while(queue.size() > 0){
                out.println(queue.poll().w);
            }

        }

        in.close();
        out.close();
    }


}