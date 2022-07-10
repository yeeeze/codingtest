package 그리디.기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 곱하기혹은더하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        String s = br.readLine();

        int result = s.charAt(0) - '0';

        for (int i = 1; i < s.length(); i++) {
            int x = s.charAt(i) - '0';

            if (x <= 1 || result <= 1) {
                result += x;
            } else {
                result *= x;
            }
        }

        System.out.println(result);
    }
}
