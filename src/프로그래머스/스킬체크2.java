package 프로그래머스;

import java.util.Arrays;

public class 스킬체크2 {
    public static void main(String[] args) {

    }

    public String[] solution(String[] strings, int n) {
        word[] s = new word[strings.length];

        for (int i = 0; i < strings.length; i++) {
            s[i] = new word(strings[i].substring(n, n + 1), strings[i]);
        }

        Arrays.sort(s);

        String[] answer = new String[s.length];
        for (int i = 0; i < s.length; i++) {
            answer[i] = s[i].word;
        }
        return answer;
    }

}

class word implements Comparable<word>{
    String n, word;

    public word(String n, String word) {
        this.n = n;
        this.word = word;
    }

    @Override
    public int compareTo(프로그래머스.word o) {
        if (this.n.charAt(0) < o.n.charAt(0)) {
            return -1;
        } else if (this.n.charAt(0) == o.n.charAt(0)) {
            return this.word.compareTo(o.word);
        }

        return 1;
    }
}
