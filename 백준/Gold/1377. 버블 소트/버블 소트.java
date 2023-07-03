import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[N];
        for (int i = 0; i < N; i++) {
            nodes[i] = new Node(i, Integer.parseInt(br.readLine()));
        }
        Arrays.sort(nodes);
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            if (ans < (nodes[i].index - i)){
                ans = nodes[i].index - i;
            }
        }
        System.out.println(ans + 1);
    }

    static class Node implements Comparable<Node> {
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }

}