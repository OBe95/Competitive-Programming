import java.util.*;

public class kattis {

    public static HashMap<String, Integer> vars;

    public static void main (String[] args) {
        
        Scanner in =new Scanner(System.in);
        vars = new HashMap<String, Integer>();
        while (in.hasNext()) {
            
            String line = in.nextLine();
            String[] tokens = line.split(" ");

            //definition put to Map
            if(tokens[0].equals("def")){
                vars.put(tokens[1], Integer.parseInt(tokens[2]));
            }
            //clear Map
            else if(tokens[0].equals("clear")){
                vars.clear();
            }
            //calculation
            else{
                boolean broken = false;
                //non existence of first param in Map ==> UNKNOWN
                if(!vars.containsKey(tokens[1])){
                    System.out.println(line.substring(5) + " unknown");
                }
                //existence of first param in Map ==> test existence of 3rd, 5th,... params
                else{
                    int res = vars.get(tokens[1]); //for result calculation
                    //test existence of 3rd, 5th,... params & res calculation if test success, break if not
                    for(int i = 3; i < tokens.length; i += 2){
                        if(!vars.containsKey(tokens[i])){
                            System.out.println(line.substring(5) + " unknown");
                            broken = true;
                            break;
                        }
                        else{
                            if(tokens[i-1].equals("+"))
                                res += vars.get(tokens[i]);
                            else
                                res -= vars.get(tokens[i]);
                        }
                    }

                    //if !broken test if Map contains res & output the key, UNKNOWN if not
                    if(!broken){
                        String result = getKey(res);
                        if(result.equals(""))
                            System.out.println(line.substring(5) + " unknown");
                        else
                            System.out.println(line.substring(5) + " " + result);
                    }
                }
            }

        }
    }

    public static String getKey(int value){
        for (Map.Entry<String, Integer> e : vars.entrySet()) {
            if(e.getValue() == value)
                return e.getKey();
        }
        return "";
    }
}