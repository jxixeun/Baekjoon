class Solution {
    public int solution(int n) {
        int count = Integer.bitCount(n);
        int answer = 0;
        for (int i = n+1; i < n * 2; i++){
            if (Integer.bitCount(i) == count){
                answer = i;
                break;
            }
        }
        return answer;
    }
}