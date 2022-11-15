package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ20207 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[366];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            for (int j = start; j <= end; j++) {
                arr[j] = arr[j] + 1;
            }
        }

        int maxCnt = 0;
        int start = 0;
        int end = 0;
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                result += maxCnt * (end - start);
                maxCnt = 0;
                start = i;
            } else {
                maxCnt = Math.max(maxCnt, arr[i]);
                end = i;
            }
        }
        result += maxCnt * (end - start);

        System.out.println(result);
    }
}
