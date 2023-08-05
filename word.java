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
public class word{
	public static void main(String[] args) throws IOException{
		Kattio in = new Kattio("word");
		int numOfWords = in.nextInt();
		int charsPerLine = in.nextInt();
		String[] words = new String[numOfWords];
		int currentAt = 0;
		boolean first = true;
		for(int i = 0; i < numOfWords; i++){
			words[i] = in.next();
			if(currentAt + words[i].length() <= charsPerLine){
				if(first == false){
				in.print(" ");
				}
				else{
					first = false;
				}
				in.print(words[i]);
				currentAt += words[i].length();
			}
			else{
				in.print("\n" + words[i]);
				currentAt = words[i].length();

			}
		}
		in.close();
	}
}