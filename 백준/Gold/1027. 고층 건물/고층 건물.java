import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] buildings = new long[N];
		long[] counts = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			buildings[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i <N; i++) {
			for (int j = 0; j < N; j++) {
				if (i==j)
					continue;
				boolean flag = true;
				int start = Math.min(i, j);
				int end = Math.max(i, j);
				for (int k = start+1; k < end; k++) {
					double point = (double) (buildings[j]-buildings[i])*(k - i)/(j-i)+ buildings[i];
					if (point <= buildings[k]){
						flag = false;
						break;
					}
				}
				if (flag){
					counts[i]++;
					// System.out.println(i +"에서 " + j + "는 보인다!");
				}

			}
		}
		long ans = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			if (ans < counts[i]){
				ans = counts[i];
			}
		}
		System.out.println(ans);
	}
}