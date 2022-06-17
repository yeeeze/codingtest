package 이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 떡볶이떡만들기 {

    private static int n, m, h;
    private static int[] arr;

    public static void main(String[] args) throws IOException {

        // 떡길이 - 절단기 높이 = 나머지 길이
        // 나머지 길이 + 다 더하면 M
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = (int) 1e9;

        int result = 0;
        while (start <= end) {
            long total = 0;
            int mid = (start + end) / 2;
            for (int i = 0; i < n; i++) {
                if (arr[i] > mid) {
                    total += arr[i] - mid;
                }
            }

            if (total < m) {
                end = mid - 1;
            } else {
                result = mid;
                start = mid + 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(result);
        System.out.println(sb);
    }
}
