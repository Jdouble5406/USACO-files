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
public class paint{
	public static void main(String[] args)throws IOException{
		Kattio in = new Kattio("paint");
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		int d = in.nextInt();
		int totalPaint = 0;
		
		for(int i = 1; i <= 100; i++){
			boolean hasPaint = false;
			if(a < i && i <= b){
				hasPaint = true;
			}
			else if (c < i &&i <= d){
				hasPaint = true;
			}
			if(hasPaint){
				totalPaint++;
			}
		}
		in.print(totalPaint);
		in.close();
	}
}