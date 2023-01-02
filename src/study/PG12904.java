package study;

public class PG12904 {

    public static void main(String[] args) {
        System.out.println(solution("abcde"));
    }

    public static int solution(String s) {
        int answer = 1;

        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = 1; j < 3; j++) {
                int left = i;
                int right = j + i;

                boolean flag = false;
                while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                    flag = true;
                    if (left == 0 || right == s.length() - 1) {
                        break;
                    }

                    if (s.charAt(left - 1) == s.charAt(right + 1)) {
                        left--;
                        right++;
                    } else {
                        break;
                    }
                }

                if (flag) {
                    int size = right - left + 1;
                    answer = Math.max(answer, size);
                }
            }
        }

        return answer;
    }
}
