package 프로그래머스;

import java.util.HashSet;

public class 스킬체크_레벨2_1 {

    public static void main(String[] args) {
        String[] w = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        int[] solution = solution(3, w);
        for (int s : solution) {
            System.out.println(s);
        }

    }

    public static int[] solution(int n, String[] words) {
        HashSet<String> word = new HashSet<>();

        int cnt = 0;
        char end = words[0].charAt(0);
        for (int i = 0; i < words.length; i++) {
            if (word.contains(words[i]) || words[i].length() == 1 || end != words[i].charAt(0) ) {
                cnt = i;
                break;
            }
            word.add(words[i]);
            end = words[i].charAt(words[i].length() - 1);
        }

        int[] answer = new int[2];
        cnt++;
        if (cnt == 1) {
            answer = new int[]{0, 0};
        } else {
            if (cnt % n == 0) {
                answer[0] = n;
                answer[1] = cnt / n;
            } else {
                answer[0] = cnt % n;
                answer[1] = cnt / n + 1;
            }
        }

        return answer;
    }
}
