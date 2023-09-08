import java.util.*;

class Solution {
    
    private void hanoi(int n, int from, int to, List<int[]> process) {
        if (n == 1) {
            process.add(new int[] {from, to});
            return;
        }

        int mid = 6 - from - to;
        hanoi(n-1, from, mid, process);
        hanoi(1, from, to, process);
        hanoi(n - 1, mid, to, process);

    }
    
    public int[][] solution(int n) {
        List<int[]> process = new ArrayList<>();
        hanoi(n, 1, 3, process);
        return process.toArray(new int[0][]);
    }
}