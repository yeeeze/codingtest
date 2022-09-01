package BJ;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 아니 왜 이걸 못 풀지
 */
public class BJ14719 {

    private static int H, W, result = 0;
    private static int[] arr;
    private static ArrayList<Integer> left = new ArrayList<>();
    private static ArrayList<Integer> right = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        arr = new int[W];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < W; i++) {
            int l = 0, r = i;
            // max left
            for (int j = 0; j < i; j++) {
                if (arr[l] < arr[j]) {
                    l = j;
                }
            }

            // max right
            for (int j = i + 1; j < W; j++) {
                if (arr[r] < arr[j]) {
                    r = j;
                }
            }

            if (Math.min(arr[l], arr[r]) - arr[i] > 0) {
                result += Math.min(arr[l], arr[r]) - arr[i];
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
