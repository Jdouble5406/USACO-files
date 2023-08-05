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
public class herding{
	public static void main(String[] args) throws IOException{
		Kattio in = new Kattio("herding");
		int[] cowPos = new int[3];
		cowPos[0] = in.nextInt();
		cowPos[1] = in.nextInt();
		cowPos[2] = in.nextInt();
		while(cowPos[0] > cowPos[1] || cowPos[1] > cowPos[2] || cowPos[0] > cowPos[2]){
			if(cowPos[0] > cowPos[1]){
				int bruh = cowPos[0];
				cowPos[0] = cowPos[1];
				cowPos[1] = bruh;
			}
			if(cowPos[1] > cowPos[2]){
				int bruh = cowPos[1];
				cowPos[1] = cowPos[2];
				cowPos[2] = bruh;
			}
		}
		if(cowPos[0] + 1 == cowPos[1] && cowPos[1] + 1 == cowPos[2]){
			in.print(0 + "\n");
			in.print(0);
			in.close();
			return;
		}
		else if(cowPos[0] +2 == cowPos[1] || cowPos[1] + 2 == cowPos[2]){
			in.print(1);
		}
		else{
			in.print(2);
		}
		if(cowPos[1] - cowPos[0] > cowPos[2] - cowPos[1]){
			in.print("\n");
			in.print(cowPos[1] - cowPos[0] - 1);
		}
		else{
			in.print("\n");
			in.print(cowPos[2]-cowPos[1]-1);
		}
		in.close();
	}
}