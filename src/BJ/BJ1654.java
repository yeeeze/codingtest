package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 이분탐색 변수들 long으로 선언하자...
 */
public class BJ1654 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[k];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        long start = 1;
        long end = max;
        long result = 0;
        while (start <= end) {
            long cnt = 0;
            long mid = (start + end) / 2;

            for (int i = 0; i < k; i++) {
                cnt += arr[i] / mid;
            }

            if (cnt < n) {
                end = mid - 1;
            } else {
                start = mid + 1;
                result = mid;
            }
        }

        System.out.println(result);
    }
}
