package 그리디.기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 첫번째 숫자는 미리 센다.
 * 다음 숫자의 경우를 +1해준다.
 *
 * 배열에서 현재 인덱스와 다음 인덱스를 비교하는거니까 반복문에서 마지막 인덱스는 가면 안됨
 * 다음 인덱스의 갯수를 세줘야함
 */
public class 문자열뒤집기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        String s = br.readLine();

        int a = 0;
        int b = 0;

        if (s.charAt(0) == '0') {
            a += 1;
        } else {
            b += 1;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                if (s.charAt(i + 1) == '0') {
                    a += 1;
                } else {
                    b += 1;
                }
            }
        }

        System.out.println(Math.min(a, b));
    }
}
