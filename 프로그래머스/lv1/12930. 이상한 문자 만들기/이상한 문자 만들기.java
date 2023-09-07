class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean isUpperCase = true;
        for (char c : s.toCharArray()) {
            if (Character.isSpaceChar(c)){
                sb.append(c);
                isUpperCase = true;
            } else {
                if (isUpperCase){
                    sb.append(Character.toUpperCase(c));
                } else {
                    sb.append(Character.toLowerCase(c));
                }
                isUpperCase = !isUpperCase;
            }
        }
        return sb.toString();
    }
}