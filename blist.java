import java.io.*;
import java.util.*;

class Kattio extends PrintWriter {
	private BufferedReader r;
	private StringTokenizer st;
	// standard input
	public Kattio() { this(System.in, System.out); }
	public Kattio(InputStream i, OutputStream o) {
		super(o);
		r = new BufferedReader(new InputStreamReader(i));
	}
	// USACO-style file input
	public Kattio(String problemName) throws IOException {
		super(problemName + ".out");
		r = new BufferedReader(new FileReader(problemName + ".in"));
	}
	// returns null if no more input
	public String next() {
		try {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(r.readLine());
			return st.nextToken();
		} catch (Exception e) {}
		return null;
	}
	public int nextInt() { return Integer.parseInt(next()); }
	public double nextDouble() { return Double.parseDouble(next()); }
	public long nextLong() { return Long.parseLong(next()); }
}

public class blist{
	public static void main(String args[]) throws IOException{
		Kattio in = new Kattio("blist");
		final int cowNumber = in.nextInt();
		ArrayList<cows> cowList = new ArrayList<cows>();


		int finalEndTime = 0;
		for(int i = 0; i < cowNumber; i++){
			int a = in.nextInt();
			int b = in.nextInt();
			int c = in.nextInt();
			cowList.add(new cows(a,b,c));
			if(b > finalEndTime){
				finalEndTime = b;
			}
		}
		int maxBuckets = 0;
		for(int i = 0; i < finalEndTime; i++){
			int currentBuckets = 0;
			for(int j = 0; j < cowNumber; j++){
				if(cowList.get(j).startTime <= i && cowList.get(j).endTime >= i){
					currentBuckets += cowList.get(j).numOfBuckets;
				}
			}
			if(maxBuckets < currentBuckets){
				maxBuckets = currentBuckets;
			}
		}
		in.print(maxBuckets);
		in.close();
	}
}

class cows{
	int startTime;
	int endTime;
	int numOfBuckets;

	public cows(int start, int end, int buckets){
		startTime = start;
		endTime = end;
		numOfBuckets = buckets;
	}

	void startChange(int start){
		startTime = start;
		return;
	}
	void endChange(int end){
		endTime = end;
		return;
	}
	void bucketsChange(int buckets){
		numOfBuckets = buckets;
		return;
	}
}