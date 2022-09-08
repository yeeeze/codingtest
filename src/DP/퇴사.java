package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 퇴사 {

    private static int N;
    private static ArrayList<Day> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Day(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int[] dp = new int[N + 1];  // 뒤에서부터 그 시점에 최댓값 기록

        // dp 테이블을 1개 더 생성해놓으면 불필요한 계산 코드가 줄어든다

        for (int i = N - 1; i >= 0; i--) {
            // 시간 내에 해당 상담이 끝나는 경우
            if (i + list.get(i).time <= N) {
                dp[i] = Math.max(dp[i + 1], list.get(i).money + (i + list.get(i).time < N ? dp[i + list.get(i).time] : 0));
            } else {
                dp[i] = dp[i + 1];
            }
        }

        System.out.println(dp[0]);
    }
}

class Day {
    int time, money;

    public Day(int time, int money) {
        this.time = time;
        this.money = money;
    }
}