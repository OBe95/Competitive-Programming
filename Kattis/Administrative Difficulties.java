import java.util.*;
import java.lang.Math;

class Car {
    public int catalogPrice;
    public int pickUpCost;
    public int kmCost;

    public Car(int _catalogPrice, int _pickUpCost, int _kmCost){
        catalogPrice = _catalogPrice;
        pickUpCost = _pickUpCost;
        kmCost = _kmCost;
    }
}

public class kattis {

    public static void main (String[] args) {
        
        Scanner in =new Scanner(System.in);
        int tt = Integer.parseInt(in.nextLine());
        for (int i = 0; i < tt; i++) {
            
            String[] line1 = in.nextLine().split(" ");
            int n = Integer.parseInt(line1[0]);
            int m = Integer.parseInt(line1[1]);

            //cars list
            HashMap<String, Car> cars = new HashMap<String, Car>();
            for(int j = 0; j < n; j++){
                String[] carLine = in.nextLine().split(" ");
                //add car to cars HashMap
                cars.put(carLine[0], new Car(Integer.parseInt(carLine[1]), Integer.parseInt(carLine[2]), Integer.parseInt(carLine[3])));
            }

            //HashMap of pickUps <Spy, CarName> for record, delete pickUp after return
            //HashMap for rent bills
            //ArrayList of Spies names to sort for printing results
            //ArrayList<Spy> for inconsistencies, once an inconsistency found no reason to check events for the concerned spy

            HashMap<String, String> record = new HashMap<String, String>();
            HashMap<String, Integer> bills = new HashMap<String, Integer>();
            ArrayList<String> spies = new ArrayList<String>();
            ArrayList<String> inconsistents = new ArrayList<String>();

            for(int j = 0; j < m; j++){

                String[] eventLine = in.nextLine().split(" ");
                String spy = eventLine[1];
                char event = eventLine[2].charAt(0);

                if(!spies.contains(spy))
                    spies.add(spy);

                if(!inconsistents.contains(spy)){
                    //A spy can use at most one car at a time.
                    //pickUp event : check there is no ongoing rent if so add a new record and add the pickUpCost to the old bill (if it exists), else inconsistency for spy
                    if(event == 'p'){
                        if(record.containsKey(spy))
                            inconsistents.add(spy);
                        else{
                            String car = eventLine[3];
                            record.put(spy, car);
                            //test if the spy already picked and returned a car
                            if(bills.containsKey(spy)){
                                bills.put(spy, bills.get(spy) + cars.get(car).pickUpCost);
                            }
                            else{
                                bills.put(spy, cars.get(car).pickUpCost);
                            }
                            
                        }
                    }
                    //A spy will pick up a car before returning it.
                    //return event : check there is an ongoing rent if so add the kmCost to bills and delete the record, else inconsistency for spy
                    else if(event == 'r'){
                        if(!record.containsKey(spy))
                            inconsistents.add(spy);
                        else{
                            int distance = Integer.parseInt(eventLine[3]);
                            String car = record.get(spy);
                            bills.put(spy, bills.get(spy) + distance * cars.get(car).kmCost);
                            record.remove(spy);
                        }
                    }
                    //Accidents can only happen when a spy is using a car
                    //accident event : check there is an ongoing rent if so add the accidentCost to bills, else inconsistency for the spy
                    else if(event == 'a'){
                        if(!record.containsKey(spy))
                            inconsistents.add(spy);
                        else{
                            String car = record.get(spy);
                            int accidentCost = (int) Math.ceil(Integer.parseInt(eventLine[3]) * cars.get(car).catalogPrice / 100.0);
                            bills.put(spy, bills.get(spy) + accidentCost);
                        }
                    }
                }

            }

            //A spy will always return a car they picked up.
            //every remaining element in record is an inconsistency with the statement above
            for (Map.Entry<String, String> e : record.entrySet()) {
                inconsistents.add(e.getKey());
            }

            //sort spies
            Collections.sort(spies);

            //printing results
            //test if the spy is in the inconsistents ==> INCONSISTENT, else ==> bills.get(spy)
            for(int j = 0; j < spies.size(); j++){
                String spy = spies.get(j);
                if(inconsistents.contains(spy))
                    System.out.println(spy + " INCONSISTENT");
                else
                    System.out.println(spy + " " + bills.get(spy));
            }

        }
    }
}