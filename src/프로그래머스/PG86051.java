package 프로그래머스;

import java.util.HashMap;

/**
 * 다른 사람 풀이 보고 반성함...
 */

class PG86051 {

    /**
     * 1차원 배열 생성해서 계수정렬처럼 풀이해도 됨. 굳이 HashMap 안 만들어도....
     */
    public int solution(int[] numbers) {
        HashMap<Integer, Boolean> nums = new HashMap<>();
        int answer = -1;

        for(int i = 0; i < 10; i++) {
            nums.put(i, false);
        }

        for(int n: numbers) {
            nums.put(n, true);
        }

        int cnt = 0;
        for(int key: nums.keySet()) {
            if(!nums.get(key)) {
                answer += key;
                cnt++;
            }
        }

        if(cnt != 0) {
            answer += 1;
        }

        return answer;
    }

    /**
     * 0 ~ 9까지의 합 = 45
     * 45 전체 값에서 없는 값의 합을 구하는 것이니까 45에서 1개씩 빼주면 나머지가 답
     */

    public int 다른풀이(int[] numbers) {
        int sum = 45;
        for (int i : numbers) {
            sum -= i;
        }
        return sum;
    }
}