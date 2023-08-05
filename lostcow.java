import java.io.*;
import java.util.*;

public class lostcow{
    public static void main(String[] args) throws IOException{
        Kattio in = new Kattio("lostcow");
        int x = in.nextInt();
        int y = in.nextInt();
		final int trueX = x;
        boolean positive = true;
        int move = 1;
		int counter = 0;
        while(x != y){
            if(positive){
                x++;
				if(x == trueX + move){
					positive = false;
					move*=2;
				}
			}
			else if (!positive){
				x--;
				if(x == trueX - move){
					positive = true;
					move*=2;
				}
			}
			counter++;
        }
		in.print(counter);
		in.close();
    }
}
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
			} catch (Exception e) { }
			return null;
		}
		public int nextInt() { return Integer.parseInt(next()); }
		public double nextDouble() { return Double.parseDouble(next()); }
		public long nextLong() { return Long.parseLong(next()); }
	}