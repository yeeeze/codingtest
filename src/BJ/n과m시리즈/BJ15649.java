package BJ.n과m시리즈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 순열 (순서가 있는 채로 m개 나열)
 */
public class BJ15649 {

    private static int n, m;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];
        int[] arr = new int[m];

        peek(0, arr);

    }

    public static void peek(int cnt, int[] arr) {
        if (cnt == m) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[cnt] = i;
                peek(cnt + 1, arr);
                visited[i] = false;
                arr[cnt] = 0;
            }
        }
    }
}
