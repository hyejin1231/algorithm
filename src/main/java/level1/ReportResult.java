package level1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 프로그래머스 레벨 1
 * 신고 결과 받기
 */
public class ReportResult {
    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};

        System.out.println(solution5.solution(id_list, report, 2)); // result [2,1,1,0]
    }
}

class Solution5 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Set<String>> list = new HashMap<>();
        Map<String, Integer> mail = new HashMap<>();

        // 초기화
        for (String id : id_list) {
            Set<String> ids = new HashSet<>();
            list.put(id, ids);
            mail.put(id, 0);
        }

        for (String ids : report) {
            String[] id = ids.split(" ");
            Set<String> set = list.get(id[1]);
            set.add(id[0]);
            list.put(id[1], set);
        }

        for (String s : list.keySet()) {
            Set<String> strings = list.get(s);
            if (strings.size() >= k) {
                for (String string : strings) {
                    int count = mail.get(string) + 1;
                    mail.put(string, count);
                }
            }
        }

        for (int i = 0; i < id_list.length; i++) {
            answer[i] = mail.get(id_list[i]);
        }


        return answer;
    }
}
