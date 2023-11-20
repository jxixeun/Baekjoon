import java.util.*;

class Solution {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s);
        List<Integer> nums = new ArrayList<>();
        while(st.hasMoreTokens()){
            nums.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(nums);
        StringBuilder sb = new StringBuilder();
        sb.append(nums.get(0)).append(" ");
        sb.append(nums.get(nums.size()-1));
        String answer = sb.toString();
        return answer;
    }
}