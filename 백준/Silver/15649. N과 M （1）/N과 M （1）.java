import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	/* N개 중 중복없이 M개를 순서있게 나열한다 */

	static int N, M;
	static int [] selected;
	static boolean [] visited;

	static StringBuilder sb = new StringBuilder();

	static void recursion(int k) {
		if (k == M + 1){
			// selected[1..M] 배열이 새롭게 탐색된 결과
			for (int i = 1; i<= M; i++){
				sb.append(selected[i]).append(' ');
			}
			sb.append('\n');
		} else {
			// 1 ~ N까지를 K번째 원소로 한 번씩 정하고
			for (int i = 1; i <= N; i++){
				// k번째에 i가 올 수 있으면
				if (!visited[i]){
					selected[k] = i;
					visited[i] = true;
					// 매번 K+1 번부터 M번 원소로 재귀호출 해주기
					recursion(k + 1);
					selected[k] = 0;
					visited[i] = false;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		input();
		recursion(1);
		printAnswer();
	}

	private static void printAnswer() {
		System.out.println(sb.toString());
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		selected = new int[N + 1];
		visited = new boolean[N + 1];
	}
}