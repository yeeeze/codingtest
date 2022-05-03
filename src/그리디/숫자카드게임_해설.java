package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Math의 min, max 활용
 * 이중 for문으로 순서대로 돌면서 비교하면 됨
 * 별도의 배열 불필요
 */
public class 숫자카드게임_해설 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N, M을 공백을 기준으로 구분하여 입력 받기
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int result = 0;

        // 한 줄씩 입력 받아 확인하기
        for(int i = 0; i < n; i++) {
            // 현재 줄에서 '가장 작은 수' 찾기
            String s1 = br.readLine();
            StringTokenizer st1 = new StringTokenizer(s1);
            int min_value = 10001;
            for(int j = 0; j < m; j++) {
                int x = Integer.parseInt(st1.nextToken());
                min_value = Math.min(min_value, x);
            }
            // '가장 작은 수'들 중에서 가장 큰 수 찾기
            result = Math.max(result, min_value);
        }

        System.out.println(result);
    }
}
