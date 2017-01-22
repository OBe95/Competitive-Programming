import java.util.*;
import java.io.*;

class room implements Comparable<room> {

    public int students;
    public int index;

    public room(int s, int i){
        students = s;
        index = i;
    }

    @Override
    public int compareTo(room r){
        return -1*Integer.compare(students, r.students);
    }

}

class kattis {

    public static void main(String[] args) throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());
        String[] line = in.readLine().split("\\s+");

        PriorityQueue<room> queue = new PriorityQueue<room>();
        for(int i = 1; i <= n; i++){
            queue.add(new room(Integer.parseInt(line[i-1]), i));
        }

        StringBuilder ans = new StringBuilder();
        boolean possible = true;
        room actRoom = queue.poll();
        int actCopies = actRoom.students;
        int startCopies = actCopies;
        ans.append(actRoom.index + " ");

        while(queue.size() > 0){

            actRoom = queue.poll();
            if(actCopies < actRoom.students){
                possible = false;
                break;
            }
            startCopies -= actRoom.students;
            ans.append(actRoom.index + " ");

        }

        if(!possible || startCopies > 0){
            out.println("impossible");
        }
        else{
            out.println(ans.toString().trim());
        }

        in.close();
        out.close();
    }

}