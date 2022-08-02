package BJ.투포인터;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ3273 {

    private static int n, x;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        x = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int l = 0, r = n - 1, result = 0;
        while (l < r) {
            int sum = arr[l] + arr[r];

            if (sum == x) {
                l++;
                r--;
                result++;
            } else if (sum < x) {
                l++;
            } else if (sum > x) {
                r--;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
