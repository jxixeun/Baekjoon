class Solution {
    public int solution(int n) {
        int mod = 1;
        int minus = 0;
        int count = 0;
        while (n > minus) {
            if ((n - minus) % mod == 0){
                count++;
            }
            minus += mod;
            mod++;
        }
        return count;
    }
}