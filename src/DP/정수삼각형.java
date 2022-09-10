package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 처음에 문제 잘못이해함
 *
 * 맨 밑층까지 가봐야 알 수 있음 -> 맨 밑층에서 저장된 값들 비교해서 최댓값 판별
 * 각 자리의 기준에서 대각선 왼 or 오? 를 선택하면서 가는거임
 */
public class 정수삼각형 {

    private static int sum, n;
    private static ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();
    private static ArrayList<ArrayList<Integer>> dp = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            triangle.add(new ArrayList<>());
            dp.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                triangle.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        dp.get(0).add(triangle.get(0).get(0));

        // 1층부터 dp 채움
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp.get(i).add(triangle.get(i).get(j) + dp.get(i - 1).get(j));
                } else if (j == i) {
                    dp.get(i).add(triangle.get(i).get(j) + dp.get(i - 1).get(j - 1));
                } else {
                    int left = dp.get(i - 1).get(j);
                    int right = dp.get(i - 1).get(j - 1);
                    dp.get(i).add(triangle.get(i).get(j) + Math.max(left, right));
                }
            }
        }

        sum = 0;
        for (int i = 0; i < n; i++) {
            sum = Math.max(dp.get(n - 1).get(i), sum);
        }

        System.out.println(sum);
    }
}
