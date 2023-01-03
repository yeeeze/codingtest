package 이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P367 {

    static int x, n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int a = upperBound();
        int b = lowerBound();
        int cnt = a - b;
        if (cnt == 0) {
            System.out.println(-1);
        } else {
            System.out.println(cnt);
        }
    }

    public static int lowerBound() {
        int start = 0;
        int end = n - 1;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (arr[mid] < x) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return end;
    }

    public static int upperBound() {
        int start = 0;
        int end = n - 1;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (arr[mid] <= x) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return end;
    }
}
