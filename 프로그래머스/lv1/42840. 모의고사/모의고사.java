import java.util.*;

class Solution {
    private static final int [][] rules = {
        {1,2,3,4,5}, {2,1,2,3,2,4,2,5}, {3,3,1,1,2,2,4,4,5,5}
    };
    
    public int[] solution(int[] answers) {
        int[] count = new int[3];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < rules.length; i++) {
            for (int j = 0; j < answers.length; j++) {
                int index = j % rules[i].length;
                if (rules[i][index] == answers[j]){
                    if (++count[i] > max){
                        max = count[i];
                    }
                }
            }
        }
        List<Integer> persons = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (max == count[i]){
                persons.add(i+1);
            }
        }
        return persons.stream().mapToInt(i -> i).toArray();
    }
}