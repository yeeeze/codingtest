package BJ;

import java.io.*;
import java.util.Arrays;

/**
 * 그리디
 */
public class BJ2217 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long result = 0;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            result = Math.max(result, (long) arr[i] * (n - i));
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
