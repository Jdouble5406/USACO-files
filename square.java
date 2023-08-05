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
public class square{
	public static void main(String[] args) throws IOException{
		Kattio in = new Kattio("square");
		coordinates[] inp = new coordinates[4];
		for(int i = 0; i < 4; i++){
			inp[i] = new coordinates(in.nextInt(), in.nextInt());
		}
		int maxX = inp[0].x;
		int minX = inp[0].x;
		int minY = inp[0].y;
		int maxY = inp[0].y;
		for(int i = 0; i < 4; i++){
			if(inp[i].x > maxX){
				maxX = inp[i].x;
			}
			if(inp[i].x < minX){
				minX = inp[i].x;
			}
			if(inp[i].y > maxY){
				maxY = inp[i].y;
			}
			if(inp[i].y < minY){
				minY = inp[i].y;
			}
		}
		int diffX = maxX - minX;
		int diffY = maxY - minY;
		if(diffX > diffY){
			in.print(diffX*diffX);
		}
		else{
			in.print(diffY*diffY);
		}
		in.close();
	}
}
class coordinates{
	public int x;
	public int y;
	public coordinates(int x, int y){
		this.x = x;
		this.y = y;
	}
}