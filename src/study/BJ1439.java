package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 15분
public class BJ1439 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();

        // 1, 0 뭉탱이 몇개인지 세고 더 작은 숫자를 뒤집음

        int zero = 0;
        int one = 0;
        char c = num.charAt(0);
        if (c == '0') {
            zero++;
        } else {
            one++;
        }

        for (int i = 1; i < num.length(); i++) {
            if (c != num.charAt(i)) {
                if (num.charAt(i) == '0') {
                    zero++;
                } else {
                    one++;
                }
                c = num.charAt(i);
            }
        }

        int anwser = Math.min(zero, one);
        System.out.println(anwser);
    }
}
