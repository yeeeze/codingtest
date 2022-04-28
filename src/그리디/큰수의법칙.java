package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 가장 큰 수와 두번째로 큰 수만 활용하여 더함
 * 반복되는 수열 파악하기 (6 + 6 + 5 + 6 + 6 + 5) -> 665가 2번 반복
 * 전체 M번 중에 K + 1의 횟수 만큼 반복
 * K + 1로 나누어떨어지지 않을 때 가장 큰 수가 더해지는 횟수 고려!
 */

public class 큰수의법칙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);

        // n, m, k 공백 기준으로 구분하여 입력 받음
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // n개의 수를 공백 기준으로 구분하여 입력 받아서 배열 생성
        int[] ar = new int[n];
        String arr = br.readLine();
        StringTokenizer st1 = new StringTokenizer(arr);
        int ss=0;
        while (st1.hasMoreTokens()) {
            ar[ss] = Integer.parseInt(st1.nextToken());
            ss++;
        }

        // 배열 정렬
        Arrays.sort(ar);
        int first = ar[n-1];    // 가장 큰 수
        int second = ar[n-2];   // 두 번째로 큰 수

        // 가장 큰 수가 더해지는 횟수 계산
        int cnt = (m / (k + 1)) * k;
        cnt += m % (k + 1);

        int result = 0;
        result += cnt * first;  // 가장 큰 수 더하기
        result += (m - cnt) * second;

        System.out.println("결과 : " + result);
    }
}
