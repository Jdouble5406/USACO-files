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
public class teleportation{
	public static void main(String[] args)throws IOException{
		Kattio in = new Kattio("teleport");
		int start = in.nextInt();
		int end = in.nextInt();
		int teleporter1 = in.nextInt();
		int teleporter2 = in.nextInt();
		int firstPossibility = Math.abs(end - start);
		int secondPossibility;
		if(Math.abs(teleporter1 - start) < Math.abs(teleporter2 - start)){
			secondPossibility = Math.abs(teleporter1 - start) + Math.abs(teleporter2 - end);
		}
		else{
			secondPossibility = Math.abs(teleporter2 - start) + Math.abs(teleporter1 - end);
		}
		if(firstPossibility > secondPossibility){
			in.print(secondPossibility);
		}
		else{
			in.print(firstPossibility);
		}
		in.close();
	}
}