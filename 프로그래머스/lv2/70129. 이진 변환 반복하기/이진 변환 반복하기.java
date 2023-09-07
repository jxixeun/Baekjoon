class Solution {
    private int countZero(String s){
        int count = 0;
        for (char c:s.toCharArray()){
            if (c == '0')
                count++;
        }
        return count;
    }
    
    public int[] solution(String s) {
        int loop = 0;
        int removed = 0;
        while(!s.equals("1")){
            int zeros = countZero(s);
            removed += zeros;
            loop++;
            s = Integer.toString(s.length() - zeros, 2);
        }
        return new int[]{loop, removed};
    }
}