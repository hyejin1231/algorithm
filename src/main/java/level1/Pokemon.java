package level1;

import java.util.Arrays;

public class Pokemon {
    public static void main(String[] args) {
        Solution6 solution6 = new Solution6();
        int[] nums = {3, 1, 2, 3};
        System.out.println(solution6.solution(nums));
    }
}

class Solution6 {
    public int solution(int[] nums) {
        int answer = 0;

        int[] ints = Arrays.stream(nums).distinct().toArray();
        int choice = nums.length / 2;


        if (ints.length > choice) {
            answer = choice;
        } else {
            answer = ints.length;
        }


        return answer;
    }
}
