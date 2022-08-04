package BJ;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1920 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int start = 0, end = arr.length - 1;
            int target = Integer.parseInt(st.nextToken());
            while (true) {
                if (start > end) {
                    System.out.println(0);
                    break;
                }
                int mid = (start + end) / 2;

                if (target < arr[mid]) {
                    end = mid - 1;
                } else if (target > arr[mid]) {
                    start = mid + 1;
                } else {
                    System.out.println(1);
                    break;
                }
            }
        }
    }
}
