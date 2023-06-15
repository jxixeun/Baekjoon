import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] score = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }
        long maxScore = Integer.MIN_VALUE;
        long totalScore = 0;
        for (int i = 0; i < N; i++) {
            if (maxScore < score[i])
                maxScore = score[i];
            totalScore += score[i];
        }
        System.out.println(totalScore * 100.0 / maxScore / N);
    }
}