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

public class pails{
	public static void main(String[] args) throws IOException{
		Kattio in = new Kattio("pails");
		final int bucket1 = in.nextInt();
		final int bucket2 = in.nextInt();
		final int bigBoyBucket = in.nextInt();
		int searchTo = bigBoyBucket/bucket1;
		int maxCapacity = 0;
		for(int i = 1; i <= searchTo; i++){
			int currentCapacity = bucket1 * i;
			while(currentCapacity + bucket2 <= bigBoyBucket){
				currentCapacity += bucket2;
			}
			if(currentCapacity > maxCapacity){
				maxCapacity = currentCapacity;
			}
		}
		in.print(maxCapacity);
		in.close();
	}
}