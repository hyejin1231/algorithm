package level1;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 프로그래머스 레벨1
 * 숫자 문자열과 영단어
 */
public class ConvertGame {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.solution("one4seveneight")); // result 1478
        System.out.println(solution2.solution("23four5six7")); // result 234567
        System.out.println(solution2.solution("2three45sixseven")); // result 234567
        System.out.println(solution2.solution("123")); // result 123
    }
}

class Solution2 {
    public int solution(String s) {
        String[] word = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for (int i = 0; i < word.length; i++) {
            s = s.replace(word[i], i + "");
        }

        return Integer.parseInt(s);

    }

}










