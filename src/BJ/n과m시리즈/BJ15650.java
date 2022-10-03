package BJ.n과m시리즈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 조합 (작은 숫자부터 차례대로 나열하기)
 * 방문체크 필요없음. 어짜피 현재 숫자 다음 숫자부터 탐색함
 */
public class BJ15650 {

    private static int n, m;
//    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
//        visited = new boolean[n + 1];
        int[] arr = new int[m];

        peek(0, 1, arr);
    }

    public static void peek(int cnt, int index, int[] arr) {
        if (cnt == m) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = index; i < n + 1; i++) {
            arr[cnt] = i;
            peek(cnt + 1, i + 1, arr);
        }
    }
}
