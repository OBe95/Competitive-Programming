import java.util.*;
import java.io.*;

class pack implements Comparable<pack> {

    public String name;
    public int level;

    public pack(String n, int l){
        name = n;
        level = l;
    }

    @Override
    public int compareTo(pack p){
        if(level < p.level)
            return -1;
        if(level > p.level)
            return 1;
        return name.compareTo(p.name);
    }

}

class kattis {

    public static void main(String[] args) throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        boolean firstCase = true;
        String line = in.readLine();
        while (line != null) {

            int n = Integer.parseInt(line);
            if(n == 0)
                break;

            if(!firstCase){
                out.println();
            }
            firstCase = false;

            HashSet<String> nonInstalled = new HashSet<String>();
            //HashSet<String> installed = new HashSet<String>();
            HashMap<String, HashSet<String>> dependencies = new HashMap<String, HashSet<String>>();
            PriorityQueue<String> canInstall = new PriorityQueue<String>();

            for(int i = 0; i < n; i++){
                String[] spec = in.readLine().split("\\s+");
                String pack = spec[0];
                int specLength = spec.length;
                if(specLength == 1){
                    canInstall.add(pack);
                    continue;
                }
                HashSet<String> packDependencies = new HashSet<String>();
                for(int j = 1; j < specLength; j++){
                    packDependencies.add(spec[j]);
                }
                nonInstalled.add(pack);
                dependencies.put(pack, packDependencies);
            }

            //PriorityQueue<pack> packagesOrder = new PriorityQueue<pack>();
            StringBuilder ans = new StringBuilder();
            int installed = 0;

            while(canInstall.size() > 0){
                String actPackage = canInstall.poll();
                ans.append(actPackage + "\n");
                HashSet<String> toRemove = new HashSet<String>();
                for(String notInstalled : nonInstalled){
                    HashSet<String> tmp = dependencies.get(notInstalled);
                    tmp.remove(actPackage);
                    if(tmp.size() == 0)
                        toRemove.add(notInstalled);
                }
                for(String toR : toRemove){
                    canInstall.add(toR);
                    nonInstalled.remove(toR);
                }
            }

            if(nonInstalled.size() > 0){
                out.println("cannot be ordered");
            }
            else{
                out.println(ans.toString().trim());
            }

            line = in.readLine();

        }

        in.close();
        out.close();
    }

}