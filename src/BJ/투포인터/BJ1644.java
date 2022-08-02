package BJ.투포인터;

import java.io.*;

public class BJ1644 {

    private static int n, cnt = 0;
    private static int[] sumArr;
    private static boolean[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new boolean[n + 1];
        sumArr = new int[n + 1];

        // 소수 구하기
        decimal();

        // 누적합 구하기
        bw.write(String.valueOf(sumCount()));
        bw.flush();
        bw.close();
    }

    public static void decimal() {
        // 소수 = F, 소수가 아니면 true
        arr[0] = true;
        arr[1] = true;

        for (int i = 2; i * i <= n; i++) {
            if (!arr[i]) {
                for (int j = i * i; j <= n; j += i) {
                    if (!arr[j]) {
                        arr[j] = true;
                    }
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (!arr[i]) {
                sumArr[cnt] = i;
                cnt++;
            }
        }
    }

    public static int sumCount() {
        int answer = 0;

        int start = 0, end = 0;
        int sum = 0;
        while (start <= end && end < cnt) {
            if (start == end) {
                sum = sumArr[start];
            }

            if (sum <= n) {
                if (sum == n) {
                    answer++;
                }
                end++;
                sum += sumArr[end];
            } else {
                sum -= sumArr[start];
                start++;
            }
        }
        return answer;
    }
}
