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
public class buckets{
	public static void main(String[] args)throws IOException{
		Kattio in = new Kattio("buckets");
		String[] map = new String[10];
		int bx = 0;
		int by = 0;
		int rx = 0;
		int ry = 0;
		int lx = 0;
		int ly = 0;
		for(int i = 0; i < 10; i++){
			map[i] = in.next();
			if(map[i].indexOf("B") > 0){
				by = i;
				bx = map[i].indexOf("B");
			}
			if(map[i].indexOf("R") > 0){
				ry = i;
				rx = map[i].indexOf("R");
			}
			if(map[i].indexOf("L") > 0){
				ly = i;
				lx = map[i].indexOf("L");
			}
		}
		if(bx == rx && bx == lx && ((by <= ry && ry <= ly) || (by >= ry && ry >= ly))){
			in.print(Math.abs(ly-by) + 1);
		}
		else if(by == ry && by == ly && ((bx <= rx && rx <= lx) || (bx >= rx && rx >= lx))){
			in.print(Math.abs(lx-bx) + 1);
		}
		else{
			int diffX = Math.abs(lx - bx);
			int diffY = Math.abs(ly - by);
			in.print(diffX + diffY - 1);
		}
		in.close();
	}
}