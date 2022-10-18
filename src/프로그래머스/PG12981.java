package 프로그래머스;

import java.util.HashSet;

public class PG12981 {

    public int[] solution(int n, String[] words) {
        HashSet<String> set = new HashSet<>();
        int cnt = 0;
        char end = words[0].charAt(0);
        boolean flag = false;
        for (int i = 0; i < words.length; i++) {
            cnt = i + 1;
            if (set.contains(words[i]) || words[i].length() == 1 || end != words[i].charAt(0)) {
                flag = true;
                break;
            } else {
                set.add(words[i]);
                end = words[i].charAt(words[i].length() - 1);
            }
        }

        int[] answer = new int[2];
        if (!flag) {
            return answer;
        } else {
            int a = cnt / n + 1;
            int b = cnt % n;

            if (b == 0) {
                b = n;
            }
            answer[0] = b;
            answer[1] = a;
        }

        return answer;
    }

    public int[] refactor(int n, String[] words) {
        HashSet<String> set = new HashSet<>();
        char end = words[0].charAt(0);
        int[] answer = new int[2];

        for (int i = 0; i < words.length; i++) {
            if (set.contains(words[i]) || words[i].length() == 1 || end != words[i].charAt(0)) {
                answer[0] = (i % n) +1;
                answer[1] = (i / n) +1;
            }
            set.add(words[i]);
            end = words[i].charAt(words[i].length() - 1);
        }

        return answer;
    }
}
