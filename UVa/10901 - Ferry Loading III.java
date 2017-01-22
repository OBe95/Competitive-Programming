import java.util.*;
import java.io.*;

class Car {

    public int id;
    public int arrivalTime;

    public Car(int i, int a){
        id = i;
        arrivalTime = a;
    }

}

class Main {

    public static long ferryTime, t;
    public static boolean ferryAtLeft;
    public static int n;
    public static long[] arrivals;

    public static void main(String[] args) throws Exception{
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        int tt = Integer.parseInt(in.readLine());
        
        while(tt-- != 0){
        
            String[] line1 = in.readLine().split("\\s+");
            n = Integer.parseInt(line1[0]);
            t = Long.parseLong(line1[1]);
            int m = Integer.parseInt(line1[2]);
            
            Queue<Car> queueLeft = new ArrayDeque<Car>();
            Queue<Car> queueRight = new ArrayDeque<Car>();

            arrivals = new long[m];
            
            for(int i = 0; i < m; i++){
            
                String[] line = in.readLine().split("\\s+");
                Car tmpCar = new Car(i, Integer.parseInt(line[0]));
                if(line[1].equals("left"))
                    queueLeft.add(tmpCar);
                else
                    queueRight.add(tmpCar);
            
            }
            
            ferryTime = 0;
            ferryAtLeft = true;

            
            while(!queueLeft.isEmpty() || !queueRight.isEmpty()){

                if(ferryAtLeft)
                    unloadSide(queueLeft, queueRight);
                else
                    unloadSide(queueRight, queueLeft);

            }

            for(int i = 0; i < m; i++)
                System.out.println(arrivals[i]);
            if(tt != 0)
                System.out.println();
        
        }

        in.close();
    
    }

    public static void unloadSide(Queue<Car> actSide, Queue<Car> otherSide){

        int transporting = 0;
        while(!actSide.isEmpty() && actSide.peek().arrivalTime <= ferryTime && transporting < n){
            arrivals[actSide.poll().id] = ferryTime + t;
            transporting++;
        }

        if(transporting > 0){
            ferryTime += t;
            ferryAtLeft = !ferryAtLeft;
        }
        else{
            if(!actSide.isEmpty() && !otherSide.isEmpty()){
                if(actSide.peek().arrivalTime <= otherSide.peek().arrivalTime){
                    ferryTime = actSide.peek().arrivalTime;
                }
                else{
                    if(ferryTime >= otherSide.peek().arrivalTime)
                        ferryTime += t;
                    else
                        ferryTime = otherSide.peek().arrivalTime + t;
                    ferryAtLeft = !ferryAtLeft;
                }
            }
            else if(!actSide.isEmpty()){
                ferryTime = actSide.peek().arrivalTime;
            }
            else if(!otherSide.isEmpty()){
                if(ferryTime >= otherSide.peek().arrivalTime)
                    ferryTime += t;
                else
                    ferryTime = otherSide.peek().arrivalTime + t;
                ferryAtLeft = !ferryAtLeft;
            }
        }

    }

}