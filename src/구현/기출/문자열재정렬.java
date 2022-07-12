package 구현.기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 문자를 정렬하는 방법
 * string ->(n번) char[] -> Arrays.sort(char[]) -> 숫자 / 문자 확인 (n번)
 *
 * 해설 : String을 char[]에 넣는게 아니라, 확인하면서 문자일 경우 별도의 리스트 삽입
 * Character.isLetter() -> 문자열인지 판단하는 함수 (T/F)
 */
public class 문자열재정렬 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        char[] c = new char[s.length()];

        for (int i = 0; i < c.length; i++) {
            c[i] = s.charAt(i);
        }

        Arrays.sort(c);

        int sum = 0;
        for (char h : c) {
            if (h <= '9') {
                sum += h - '0';
            } else {
                System.out.print(h);
            }
        }

        System.out.print(sum);
    }
}
