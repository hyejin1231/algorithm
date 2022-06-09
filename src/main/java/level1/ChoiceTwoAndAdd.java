package level1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 프로그래머스 레벨 1
 * 두 개 뽑아서 더하기
 */
public class ChoiceTwoAndAdd {
    public static void main(String[] args) {
        Solution10 solution10 = new Solution10();
        int[] numbers = {2, 1, 3, 4, 1};
        int[] solution = solution10.solution(numbers);
        for (int i : solution) {
            System.out.print( i + " ");
        }
    }
}

// MergeSort 사용하는 방법 알아보기
class Solution10 {
    public int[] solution(int[] numbers) {
        int[] answer = {};

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        answer = new int[set.size()];

        int i = 0;
        for (Integer integer : set) {
            answer[i] = integer;
            i++;
        }

        Arrays.sort(answer);

        return answer;
    }

    public static void mergeSort(int start, int end, int[] arr) {
        int[] tmpArr = new int[arr.length];

        if (start < end) {
            int mid = (start + end) /2;
            mergeSort(start, mid,arr);
            mergeSort(mid + 1, end, arr);

            int p = start;
            int q = mid + 1;
            int idx = p;

            while (p <= mid || q <= end) {
                if (q > end || (p <= mid && arr[p] < arr[q])) {
                    tmpArr[idx++] = arr[p++];
                }else {
                    tmpArr[idx++] = arr[q++];
                }
            }

            for (int i = start; i <= end; i++) {
                arr[i] = tmpArr[i];
            }

        }
    }
}









