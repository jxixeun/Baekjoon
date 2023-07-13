import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int answer = 0;
	public static void recursion(String T, String S){
		if (S.equals(T)){
			answer = 1;
			return;
		}
		if (T.length()==0){
			return;
		}
		if (T.charAt(T.length()-1)=='A' && T.length()>1){
			recursion(T.substring(0, T.length()-1), S);
		}
		if (T.charAt(0)=='B'&& T.length()>1){
			StringBuffer sb = new StringBuffer(T.substring(1,T.length()));
			recursion(sb.reverse().toString(), S);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String T = br.readLine();
		recursion(T, S);
		System.out.println(answer);
	}
}