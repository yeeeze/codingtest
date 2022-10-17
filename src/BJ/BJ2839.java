package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * dp[n] = min(dp[n-3] + 1, dp[n-5] + 1)
 * 3과 5가 기본이니까 5까지는 테이블 기본 세팅해줌
 */
public class BJ2839 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[5001];
        dp[0] = -1;
        dp[1] = -1;
        dp[2] = -1;
        dp[3] = 1;
        dp[4] = -1;
        dp[5] = 1;

        for (int i = 6; i <= n; i++) {
            int a = dp[i - 3];
            int b = dp[i - 5];

            if (a != -1 && b != -1) {
                dp[i] = Math.min(a, b) + 1;
            } else if (b != -1) {
                dp[i] = b + 1;
            } else if (a != -1) {
                dp[i] = a + 1;
            } else {
                dp[i] = -1;
            }
        }

        System.out.println(dp[n]);
    }
}
