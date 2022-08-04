package BJ.투포인터;

import java.util.HashMap;
import java.util.HashSet;

public class PG67258 {

    public static void main(String[] args) {
        String[] arr = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
        int[] solution = solution(arr);
        System.out.println(solution[0] + ", " + solution[1]);
    }

    public static int[] solution(String[] gems) {
        HashMap<String, Integer> data = new HashMap<>();
        HashSet<String> set = new HashSet<>();

        for (String s : gems) {
            set.add(s);
        }

        int[] answer = new int[2];

        int distance = Integer.MAX_VALUE;
        int left = 0, right = 0;
        // 정답
        int start = 0, end = 0;

        // 정확성 테스트에서 2개가 틀림 -> right 커서가 맨 마지막 보다 하나 뒤에 있고, map에 마지막 원소가 추가된 상태일 때 체크가 안됨
        while (left <= right && right < gems.length) {
            if (data.size() == set.size()) {
                data.put(gems[left], data.get(gems[left]) - 1);

                if (data.get(gems[left]) == 0) {
                    data.remove(gems[left]);
                }
                left++;
            } else {
                data.put(gems[right], data.getOrDefault(gems[right], 0) + 1);
                right++;
            }

            if (data.size() == set.size()) {
                if (distance > right - left) {
                    distance = right - left;
                    start = left + 1;
                    end = right;
                }
            }
        }

        // 통과
        while (true) {
            if (data.size() == set.size()) {
                data.put(gems[left], data.get(gems[left]) - 1);

                if (data.get(gems[left]) == 0) {
                    data.remove(gems[left]);
                }
                left++;
            } else if (right == gems.length) {
                break;
            } else {
                data.put(gems[right], data.getOrDefault(gems[right], 0) + 1);
                right++;
            }

            if (data.size() == set.size()) {
                if (distance > right - left) {
                    distance = right - left;
                    start = left + 1;
                    end = right;
                }
            }
        }
        answer[0] = start;
        answer[1] = end;

        return answer;
    }
}
