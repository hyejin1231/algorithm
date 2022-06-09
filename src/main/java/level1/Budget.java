package level1;

import java.util.Arrays;

/**
 * 프로그래머스 레벨 1
 * 예산
 */
public class Budget {
    public static void main(String[] args) {
        Solution9 solution9 = new Solution9();
         int[] d = {1, 3, 2, 5, 4};
        System.out.println(solution9.solution(d, 9));
    }
}

class Solution9 {
    public int solution(int[] d, int budget) {
        int result = 0;
        int sum = 0;

        mergeSort(0, d.length - 1, d);

        for (int i : d) {
            if (sum + i > budget) {
                break;
            }
            sum += i;
            result++;
        }

        return result;
    }

    public int solution2(int[] d, int budget) {
        int sum = 0;
        int count = 0;

        Arrays.sort(d);

        for (int i = 0; i < d.length; i++) {
            if (sum + d[i] > budget) {
                break;
            }

            sum += d[i];
            count++;
        }

        return count;
    }

    /**
     * @param start 배열의 시작 인덱스
     * @param end 마지막으로 포함될 배열의 인덱스
     */
    public static void mergeSort(int start, int end, int[] arr) {
        int[] tmpArr = new int[arr.length];
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(start, mid, arr);
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
