import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int count = 1, start = 1, end = 1, sum = 1;
        while(end != N){
            if (sum == N){
                count++; end++;
                sum += end;
            } else if (sum > N){
                sum -= start;
                start++;
            } else {
                end++;
                sum += end;
            }
        }
        System.out.println(count);
    }
}