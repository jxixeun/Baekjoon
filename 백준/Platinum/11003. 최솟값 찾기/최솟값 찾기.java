import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Deque<Node> deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());
            while (!deque.isEmpty() && deque.getLast().value > now){
                deque.removeLast();
            }
            deque.addLast(new Node(now, i));
            if (deque.getFirst().index  <= i-L){
                deque.removeFirst();
            }
            sb.append(deque.getFirst().value).append(" ");
        }
        System.out.println(sb);
    }

    private static class Node {
        int value;
        int index;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}