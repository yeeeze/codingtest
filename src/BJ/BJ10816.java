package BJ;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 이진탐색
 * 타켓 숫자를 찾아서 배열의 인덱스 반환!! 어디있는지 찾는...
 */
public class BJ10816 {

    private static int N, M;
    private static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int key = Integer.parseInt(st.nextToken());
            bw.write(upper(key) - lower(key) + " ");
        }
        bw.flush();
        bw.close();
    }

    public static int lower(int target) {
        int start = 0;
        int end = num.length -1 ;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (num[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

    public static int upper(int target) {
        int start = 0;
        int end = num.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (num[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
}
