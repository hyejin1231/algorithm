package level1;

import java.util.Arrays;

public class Marathon {
    public static void main(String[] args) {
        Solution7 solution7 = new Solution7();
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        System.out.println(solution7.solution(participant, completion));
    }
}

class Solution7 {
    public String solution(String[] participant, String[] completion) {
        int i;
        Arrays.sort(participant);
        Arrays.sort(completion);

        for (i = 0; i < completion.length; i++) {
            if (!participant[i].equals(completion[i])) break;
        }

        String answer = participant[i];
        return answer;
    }
}

