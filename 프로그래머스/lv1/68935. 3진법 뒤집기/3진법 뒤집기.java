class Solution {
    public int solution(int n) {
        StringBuilder threeReverse = new StringBuilder(Integer.toString(n, 3)).reverse();
        return Integer.parseInt(threeReverse.toString(), 3);
    }
}