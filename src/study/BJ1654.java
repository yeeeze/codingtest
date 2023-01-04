package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1654 {

    private static int[] arr;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[k];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        long start = 0;
        long end = max + 1L;
        while (start + 1 < end) {
            long mid = (start + end) / 2;

            if (check(mid)) {
                start = mid;
            } else {
                end = mid;
            }
        }

        System.out.println(start);
    }

    public static boolean check(long mid) {
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i] / mid;
        }

        if (sum >= n) {
            return true;
        } else {
            return false;
        }
    }
}
