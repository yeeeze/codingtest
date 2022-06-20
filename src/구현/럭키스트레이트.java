package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * int result 값을 1개 선언하고,
 * 앞부분 더한뒤 뒷부분을 그대로 빼고 0인지 아닌지를 확인하는 방법
 */
public class 럭키스트레이트 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();

        int result = 0;

        // 앞 부분 합
        for (int i = 0; i < n.length() / 2; i++) {
            result += n.charAt(i) - '0';
        }

        // 뒤 부분 합
        for (int j = n.length() / 2; j < n.length(); j++) {
            result -= n.charAt(j) - '0';
        }

        if (result == 0) {
            System.out.println("LUCKY");
        } else {
            System.out.println("READY");
        }
    }
}
