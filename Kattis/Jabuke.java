import java.util.*;
import java.io.*;

class point {

    public int x;
    public int y;

    public point(int _x, int _y){
        x = _x;
        y = _y;
    }

}


class kattis {

    public static point v1, v2, v3;

    public static void main(String[] args) throws Exception{

        Locale.setDefault(new Locale("en", "US"));
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        while (in.ready()) {

            String[] pt = in.readLine().split("\\s+");
            v1 = new point(Integer.parseInt(pt[0]), Integer.parseInt(pt[1]));

            pt = in.readLine().split("\\s+");
            v2 = new point(Integer.parseInt(pt[0]), Integer.parseInt(pt[1]));

            pt = in.readLine().split("\\s+");
            v3 = new point(Integer.parseInt(pt[0]), Integer.parseInt(pt[1]));

            double area = Math.abs(v1.x*(v2.y-v3.y) + v2.x*(v3.y-v1.y) + v3.x*(v1.y-v2.y))/2.0;

            int tt = Integer.parseInt(in.readLine());

            int ans = 0;

            while(tt-- != 0){

                pt = in.readLine().split("\\s+");
                point tmpPt = new point(Integer.parseInt(pt[0]), Integer.parseInt(pt[1]));

                double area1 = Math.abs(tmpPt.x*(v2.y-v3.y) + v2.x*(v3.y-tmpPt.y) + v3.x*(tmpPt.y-v2.y))/2.0;
                double area2 = Math.abs(v1.x*(tmpPt.y-v3.y) + tmpPt.x*(v3.y-v1.y) + v3.x*(v1.y-tmpPt.y))/2.0;
                double area3 = Math.abs(v1.x*(v2.y-tmpPt.y) + v2.x*(tmpPt.y-v1.y) + tmpPt.x*(v1.y-v2.y))/2.0;

                if(area1+area2+area3 == area)
                    ans++;

            }

            out.printf("%.1f\n", area);
            out.println(ans);
            
        }

        in.close();
        out.close();
    }

}