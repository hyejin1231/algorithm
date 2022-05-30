package level1;

import java.util.ArrayList;
import java.util.Arrays;

// K번째 수
public class Knumbers {
    public static void main(String[] args) {
        Solution8 solution8 = new Solution8();
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {
                {2, 5, 3},
                {4, 4, 1},
                {1, 7, 3}
        };

        System.out.println(Arrays.toString(solution8.solution2(array, commands))); // [5, 6, 3]
    }
}

class Solution8 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        ArrayList<int[]> list = new ArrayList<>();

        for (int i = 0; i < commands.length; i++) {
            list.add(Arrays.stream(array).skip(commands[i][0] - 1).limit(commands[i][1] - commands[i][0] + 1).toArray());
        }

        answer = new int[list.size()];

        for (int i = 0; i < commands.length; i++) {
            int[] ints1 = Arrays.stream(list.get(i)).sorted().toArray();
            if (commands[i][2] == 1) {
                answer[i] = ints1[0];
            } else {
                answer[i] = ints1[commands[i][2] - 1];
            }

        }

        return answer;
    }

    public int[] solution2(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        ArrayList<int[]> list = new ArrayList<>();

        for (int i = 0; i < commands.length; i++) {
            list.add(Arrays.stream(Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1])).sorted().toArray());

            answer[i] = commands[i][2] == 1 ? list.get(i)[0] : list.get(i)[commands[i][2] - 1];
        }

        return answer;
    }


}
