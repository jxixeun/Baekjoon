import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] words = new String[N];
		for (int i = 0; i < N; i++) {
			words[i] = br.readLine();
		}
		String ans1 = "";
		String ans2 = "";
		int maxCnt = -1;
		for (int i = 0; i < N-1; i++) {
			for (int j = i+1; j < N; j++) {
				int cnt = 0;
				if (words[i].compareTo(words[j])== 0)
					continue;
				int length = Math.min(words[i].length(), words[j].length());
				for (int k = 0; k < length; k++) {
					if (words[i].charAt(k) != words[j].charAt(k)){
						break;
					}
					cnt++;
				}
				if (maxCnt < cnt){
					maxCnt = cnt;
					ans1 = words[i];
					ans2 = words[j];
				}
			}
		}
		System.out.println(ans1);
		System.out.println(ans2);
	}
}