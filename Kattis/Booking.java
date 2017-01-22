import java.util.*;
import java.io.*;

class Booking implements Comparable<Booking>{
    public GregorianCalendar time;
    public boolean arrival;

    public Booking(GregorianCalendar t, boolean a){
        time = t;
        arrival = a;
    }

    @Override
    public int compareTo(Booking b2){
        if(time.compareTo(b2.time) == 0){
            if(arrival)
                return 1;
            return -1;
        }
        return time.compareTo(b2.time);
    }
}

class kattis {

    public static void main(String[] args) throws Exception{
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int tt = Integer.parseInt(in.readLine().trim());

        while(tt-- != 0){
        
            String[] input = in.readLine().trim().split("\\s+");
            int b = Integer.parseInt(input[0]);
            int c = Integer.parseInt(input[1]);

            Booking[] info = new Booking[2*b];

            int i = 0;
            int tmpB = b;

            while(tmpB-- != 0){
                
                String[] Booking = in.readLine().trim().split("\\s+");

                String[] arrDate = Booking[1].split("-");
                String[] arrTime = Booking[2].split(":");
                GregorianCalendar arr = new GregorianCalendar(Integer.parseInt(arrDate[0]), Integer.parseInt(arrDate[1])-1, Integer.parseInt(arrDate[2]), Integer.parseInt(arrTime[0]), Integer.parseInt(arrTime[1]));

                String[] depDate = Booking[3].split("-");
                String[] depTime = Booking[4].split(":");
                GregorianCalendar dep = new GregorianCalendar(Integer.parseInt(depDate[0]), Integer.parseInt(depDate[1])-1, Integer.parseInt(depDate[2]), Integer.parseInt(depTime[0]), Integer.parseInt(depTime[1]));
                dep.add(GregorianCalendar.MINUTE, c);

                info[i] = new Booking(arr, true);
                info[i+1] = new Booking(dep, false);
                i += 2;

            }

            Arrays.sort(info);

            int currentTotal = 0;
            int rooms = 0;
            i = 0;
            while(i < 2*b){


                if(info[i].arrival){
                    //out.println("Arrival " + info[i].time.getTime());
                    currentTotal++;
                }

                else {
                    //out.println("Departure " + info[i].time.getTime());
                    currentTotal--;
                }

                i++;
                rooms = Math.max(rooms, currentTotal);

            }

            out.println(rooms);

        }

        in.close();
        out.close();
    
    }

}