package 프로그래머스;

import java.util.ArrayList;

public class PG92335 {

    public static void main(String[] args) {
        System.out.println(solution(110011, 10));
    }

    public static int solution(int n, int k) {
        int answer = 0;

        // k진수로 변환
        String change = Integer.toString(n, k);
        String[] split = change.split("0");

        for (int i = 0; i < split.length; i++) {
            if (split[i].length() > 0 && check(Long.parseLong(split[i]))) {
                answer++;
            }
        }

        return answer;
    }

    // 소수 판별
    public static boolean check(Long num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
