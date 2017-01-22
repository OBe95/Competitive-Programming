import java.util.*;
import java.io.*;


class Main {

    public static void main(String[] args) throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        while (in.ready()) {

            String text = in.readLine();

            LinkedList<StringBuilder> ll = new LinkedList<StringBuilder>();
            StringBuilder s = new StringBuilder();

            int length = text.length();

            boolean homeClicked = false;
            char[] chars = text.toCharArray();

            for(int i = 0; i < length; i++){

                if(chars[i] == '['){
                    if(homeClicked)
                        ll.addFirst(s);
                    else
                        ll.addLast(s);

                    homeClicked = true;
                    s = new StringBuilder();
                }
                else if(chars[i] == ']'){
                    if(homeClicked)
                        ll.addFirst(s);
                    else
                        ll.addLast(s);

                    homeClicked = false;
                    s = new StringBuilder();
                }
                else
                    s.append(chars[i]);

            }

            if(homeClicked)
                ll.addFirst(s);
            else
                ll.addLast(s);

            s = new StringBuilder();

            for(StringBuilder tmp : ll)
                s.append(tmp);

            out.println(s);



        }

        in.close();
        out.close();
    }

}