import java.util.*;
import java.io.*;
import java.lang.Math;

class SegmentTree {

	public int[] st, array, occ;
	public int n;

	public int left(int p){
		return (p << 1);
	}

	public int right(int p){
		return (p << 1) + 1;
	}

	public void build(int p, int l, int r){

		if(l == r)
			st[p] = occ[array[l]];
		else{

			build(left(p), l, (l+r)/2);
			build(right(p), (l+r)/2 + 1, r);
			st[p] = (st[left(p)] >= st[right(p)]) ? st[left(p)] : st[right(p)];

		}

	}	

	public int rmq(int p, int l, int r, int i, int j){

		if(i > r || j < l)
			return -1;
		if(i <= l && j >= r)
			return st[p];

		int p1 = rmq(left(p), l, (l+r)/2, i, j);
		int p2 = rmq(right(p), (l+r)/2+1, r, i, j);

		if(p1 == -1)
			return p2;
		if(p2 == -1)
			return p1;

		return (p1 >= p2) ? p1 : p2;

	}

	public SegmentTree(int[] _array, int[] _occ){
		occ = _occ;
		array = _array;
		n = array.length;
		st = new int[4*n];
		build(1, 0, n-1);
	}

	public int rmq(int i, int j){
		return rmq(1, 0, n-1, i, j);
	}

}

class Main {

    public static void main(String[] args) throws Exception{
    
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        while(in.ready()){
        
        	String[] input = in.readLine().trim().split("\\s+");
        	int n = Integer.parseInt(input[0]);

        	if(n == 0)
        		break;

        	int q = Integer.parseInt(input[1]);

        	String[] ints = in.readLine().trim().split("\\s+");

        	int[] nums = new int[n];
        	int[] occ = new int[200009];
        	int[] start = new int[200009];
        	
        	for(int i = 0; i < n; i++){

        		nums[i] = Integer.parseInt(ints[i]) + 100000;
        		occ[nums[i]]++;
        		if(occ[nums[i]] == 1)
        			start[nums[i]] = i;

        	}

        	SegmentTree st = new SegmentTree(nums, occ);

        	while(q-- != 0){

        		String[] query = in.readLine().trim().split("\\s+");
        		int i = Integer.parseInt(query[0]) - 1;
        		int j = Integer.parseInt(query[1]) - 1;

        		if(nums[i] == nums[j])
        			out.println(j-i+1);
        		else{

        			int intsIocc = occ[nums[i]] + start[nums[i]] - i;
        			int intsJocc = j - start[nums[j]] + 1;
        			int intsNonINonJocc = 0;
        			if(intsIocc + intsJocc < j - i +1){
        				int tmpL = start[nums[i]] + occ[nums[i]];
        				int tmpR = start[nums[j]] - 1;
        				intsNonINonJocc = st.rmq(tmpL, tmpR);
        			}

        			out.println((int)Math.max(intsIocc, Math.max(intsJocc, intsNonINonJocc)));

        		}

        	}

        }

        in.close();
        out.close();
    
    }

}