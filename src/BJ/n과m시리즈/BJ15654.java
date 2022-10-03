package BJ.n과m시리즈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 순열
 * 1 ~ N까지의 자연수 중에서가 아니라!
 * N개의 자연수 중(별도의 숫자 배열 제공)에서 M개를 고른 수열
 */
public class BJ15654 {

    private static int n, m;
    private static int[] input, result;
    private static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        input = new int[n];
        result = new int[m];

        st = new StringTokenizer(br.readLine());
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, input[i]);
        }
        visited = new boolean[max + 1];

        Arrays.sort(input);
        dfs(0);
        System.out.println(sb);
    }

    public static void dfs(int depth) {
        if (depth == m) {
            for (int i = 0; i < result.length; i++) {
                sb.append(result[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < input.length; i++) {
            if (!visited[i]) {
                result[depth] = input[i];
                visited[i] = true;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}
