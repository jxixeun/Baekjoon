import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(nums);
        int i = 0;
        int j = 0;
        int ans = nums[N-1] - nums[0];
        while (j < N){
            if (nums[j] - nums[i] == M){
                ans = M;
                break;
            } else if (nums[j] - nums[i] > M){
                if (nums[j] - nums[i] < ans)
                    ans = nums[j] - nums[i];
                i++;
            } else {
                j++;
            }
        }
        System.out.println(ans);
    }
}