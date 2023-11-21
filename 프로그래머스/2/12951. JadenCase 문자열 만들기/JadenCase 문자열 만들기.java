import java.util.*;
import java.lang.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        char prev = ' ';
        for (int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if (prev == ' ') {
                if (ch >= 'a'){
                    ch -= ('a'-'A');
                }
            } else {
                if (ch >= 'A' && ch <= 'Z'){
                    ch += ('a'-'A');
                }
            }
            sb.append(ch);
            prev = ch;
            
        }
        return sb.toString();
    }
    
}