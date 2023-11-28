import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int [] operators;
	static int [] nums;

	static int maxValue = Integer.MIN_VALUE;
	static int minValue = Integer.MAX_VALUE;

	static void recursion(int k, int value) {
		if (k == N){
			maxValue = Math.max(maxValue, value);
			minValue = Math.min(minValue, value);
		} else {
			for (int i = 0; i < 4; i++){
				if (operators[i] > 0) {
					operators[i]--;
					recursion(k+1, caculate(i, value, k));
					operators[i]++;
				}
			}
		}
	}

	static int caculate(int operatorIndex, int value, int numIndex){
		if (operatorIndex == 0) {
			return value + nums[numIndex];
		} else if (operatorIndex == 1) {
			return value - nums[numIndex];
		} else if (operatorIndex == 2) {
			return value * nums[numIndex];
		} else {
			return value / nums[numIndex];
		}
	}

	public static void main(String[] args) throws IOException {
		input();
		recursion(1, nums[0]);
		printAnswer();
	}

	private static void printAnswer() {
		System.out.println(maxValue);
		System.out.println(minValue);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new int[N + 1];
		operators = new int[4];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++){
			nums[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++){
			operators[i] = Integer.parseInt(st.nextToken());
		}
	}
}