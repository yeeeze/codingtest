package DP;

public class 피보_Bottomup {

    private static long[] dp = new long[100];

    public static void main(String[] args) {
        dp[1] = 1;
        dp[2] = 1;
        int n = 50;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(dp[n]);
    }

}
