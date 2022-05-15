package level1;

/**
 * 프로그래머스 레벨1
 * 로또의 최고 순위와 최저 순위
 */
public class Lotto {
    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        int[] lottos = {44, 1, 0, 0, 31, 25}; // 구매한 로또 번호
        int[] win_nums = {31, 10, 45, 1, 6, 19}; // 당첨 번호

        System.out.println(solution.solution(lottos, win_nums)[1]); // result [3,5]
    }
}

class Solution3 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int unknown = 0;
        int matched = 0;

        for (int lotto : lottos) {
            if (lotto == 0) unknown++;
            else {
                for (int win_num : win_nums) {
                    if (lotto == win_num) {
                        matched++;
                        break;
                    }
                }
            }
        }
        int max = unknown + matched;
        int min = matched;

        return new int[]{Math.min(7 - max, 6), Math.min(7 - min,6)};
    }
}
