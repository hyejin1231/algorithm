package level1;

/**
 * 프로그래머스 레벨1
 * 신규 아이디 추천
 */
public class NewId {
    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        System.out.println(solution4.solution("...!@BaT#*..y.abcdefghijklm")); // result bat.y.abcdefghi
        System.out.println(solution4.solution("z-+.^.")); // result z--
        System.out.println(solution4.solution("=.=")); // result aaa
        System.out.println(solution4.solution("123_.def")); // result 123_.def
        System.out.println(solution4.solution("abcdefghijklmn.p")); // result abcdefghijklmn
    }
}

class Solution4 {
    public String solution(String new_id) {
        String answer = "";
        answer = new_id.toLowerCase(); // 1단계 : 대문자 -> 소문자

        // 2단계 : 소문자, 숫자, 빼기, 밑줄, 마침표를 제외한 모든 문자 제거
        StringBuffer id = new StringBuffer();
        for (int i = 0; i < new_id.length(); i++) {
            char c = answer.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || (c == '.' || c == '-' || c == '_')) {
                id.append(c);
            }
        }
        answer = id.toString();

        // 3단계 : .. -> .
        answer.replace("..", ".");
        while (answer.contains("..")) {
            answer = answer.replace("..", ".");
        }

        // 4단계: . 처음, 마지막 제거
        if (answer.startsWith(".")) {
            answer = answer.substring(1);
        } else if (answer.endsWith(".")) {
            answer = answer.substring(0, answer.length() - 1);
        }

        // 5단계: 빈 문자열이라면 new_id에 a 대입
        if (answer.isBlank()) answer += "a";

        // 6단계: 16자 이상이면 15자리까지
        if (answer.length() >= 16) answer = answer.substring(0, 15);

        if (answer.endsWith(".")) {
            answer = answer.substring(0, answer.length() - 1);
        }

        // 7단계
        String substring = answer.substring(answer.length() - 1);
        if (answer.length() == 2) {
            answer += substring;
        } else if (answer.length() == 1) {
            answer += substring + substring;
        }

        return answer;
    }
}
