package 구현.기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * StirngTokenizer는 띄어쓰기를 기준으로 분리함
 * 합계 비교할 때에 1개의 변수로 +하고 - 후 결과가 0인지 체크
 */
public class 럭키스트레이트 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
//        int[] arr = new int[s.length()];
        int sum = 0;
//        int b = 0;

//        // 입력
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = s.charAt(i) - '0';
//        }

        // 계산
        for (int i = 0; i < s.length() / 2; i++) {
            sum += s.charAt(i) - '0';
        }

        for (int i = s.length() / 2; i < s.length(); i++) {
            sum -= s.charAt(i) - '0';
        }

        if (sum == 0) {
            System.out.println("LUCKY");
        } else {
            System.out.println("READY");
        }
    }
}
