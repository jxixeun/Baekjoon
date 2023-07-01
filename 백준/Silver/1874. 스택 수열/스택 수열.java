import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        Stack<Integer> stack = new Stack<>();
        int num = 1;
        for (int i = 0; i < N; i++) {
            if (nums[i] >= num){
                while (nums[i] >= num){
                    stack.push(num++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else {
                int now = stack.pop();
                if (now > nums[i]){
                    System.out.println("NO");
                    flag = false;
                    break;
                } else {
                    sb.append("-\n");
                }
            }
        }
        if (flag)
            System.out.print(sb);

    }

}