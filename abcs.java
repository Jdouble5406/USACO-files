import java.io.*;
import java.util.*;
public class abcs{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> inp = new ArrayList<Integer>();
		int max = 0;
		for(int i = 0; i < 7; i++){
			inp.add(in.nextInt());
			if(inp.get(i) > max){
				max = inp.get(i);
			}
		}
		int min1 = max;
		int min2 = max;
		int min1Index;
		int min2Index;
		int x = 0;
		for(int i = 0; i < 7; i++){
			if(inp.get(i) < min1){
				min1 = inp.get(i);
			}
		}
		System.out.print(min1 + " ");
		for(int i = 0; i < 7; i++){
			if(inp.get(i) == min1){
				inp.remove(i);
				break;
			}
		}
		for(int i = 0; i < 6; i++){
			if(inp.get(i) < min2){
				min2 = inp.get(i);
			}
		}
		System.out.print(min2 + " ");
		System.out.print(max - min1 - min2);
		in.close();

	}
}