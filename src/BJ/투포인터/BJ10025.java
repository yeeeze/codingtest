package BJ.투포인터;

import java.io.*;
import java.util.StringTokenizer;

public class BJ10025 {

    private static int n, k, result;
    private static int[] arr, subSum;

    // 누적합 O(N) + 최댓값 O(N)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        arr = new int[1000001];
        subSum = new int[1000001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int ice = Integer.parseInt(st.nextToken());
            int index = Integer.parseInt(st.nextToken());
            arr[index] = ice;
        }

        // 누적합 구하기
        int sum = arr[0];
        subSum[0] = sum;
        for (int i = 1; i < 1000001; i++) {
            subSum[i] = sum + arr[i];
            sum = subSum[i];
        }

        // 범위가 정해져있는 부분합의 최댓값 구하기
        int window = 1 + (2 * k);   // 고정된 범위를 구한다
        window = Math.min(window, 1000000);
        int max = subSum[window - 1];
        for (int i = window; i < 1000001; i++) {
            int now = subSum[i] - subSum[i - window];
            max = Math.max(max, now);
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }

    // 슬라이딩윈도우로 누적합 갱신하면서 탐색, 최댓값 갱신 O(N)
    public void solution() {
        int window = 1 + (2 * k);   // 범위 갯수
        int sum = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i >= window) {
                sum -= arr[i - window];
            }
            sum += arr[i];
            max = Math.max(max, sum);
        }
    }
}
