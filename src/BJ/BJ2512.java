package BJ;

import java.io.*;
import java.util.StringTokenizer;

public class BJ2512 {

    private static int n, sum;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int sumArr = 0, max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sumArr += arr[i];
            max = Math.max(max, arr[i]);
        }

        sum = Integer.parseInt(br.readLine());

        // 2. 모든 요청이 배정될 수 없는 경우 : 특정한 정수 상한액 계산
        int start = 0, end = max;
        long result = 0;
        while (start <= end) {
            int mid = (start + end) / 2;

            // mid를 기준으로 배정 예산합 계산
            long s = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] > mid) {
                    s += mid;
                } else {
                    s += arr[i];
                }
            }

            // 모든 요청을 만족하는지?
            if (sum > s) {
                start = mid + 1;
                result = Math.max(result, mid);
            } else if (sum == s) {
                result = Math.max(result, mid);
                break;
            } else {
                end = mid - 1;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
