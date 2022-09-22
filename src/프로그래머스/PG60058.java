package 프로그래머스;

import java.util.Stack;

/**
 * 문자열 자르기 substring()
 */

public class PG60058 {

    public static void main(String[] args) {
        System.out.println(solution(")("));
    }

    public static int balancedIndex(String p) {
        // u (개수 맞춰서 더이상 분리 못함), v 분리 (빈 문자 가능)
        int cnt = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                cnt++;
            } else {
                cnt--;
            }

            if (cnt == 0) {
                return i;
            }
        }

        return -1;
    }

    public static String solution(String p) {
        // 올바른 문자열인지 확인 바로 리턴
        if (check(p) || p.equals("")) {
            return p;
        }

        int lastIndex = balancedIndex(p);

        // u
        String u = p.substring(0, lastIndex + 1);
        // v
        String v = p.substring(lastIndex + 1);

        String answer = "";
        if (check(u)) {
            answer = u + solution(v);
        } else {
            answer = "(" + solution(v) + ")";

            String replace = "";
            u = u.substring(1, u.length() - 1);
            for (int i = 0; i < u.length(); i++) {
                if (u.charAt(i) == '(') {
                    replace += ")";
                } else {
                    replace += "(";
                }
            }
            answer += replace;
        }

        return answer;
    }

    // 올바른 괄호문자열인가?
    // 1. stack 사용
    public static boolean c(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        return true;
    }

    // 2. 왼쪽 괄호의 개수 활용
    public static boolean check(String s) {
        int cnt = 0;    // 왼쪽 괄호의 개수
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                cnt++;
            } else {
                if (cnt == 0) {
                    return false;
                }
                cnt--;
            }
        }
        return true;
    }
}
