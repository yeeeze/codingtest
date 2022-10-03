package BJ.n과m시리즈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 중복조합, 비내림차순 (현재 숫자보다 큰 숫자만 세기)
 */
public class BJ15652 {

    private static int n, m;
    private static int[] result;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        result = new int[m];

        dfs(0, 1);
        System.out.println(sb);
    }

    public static void dfs(int depth, int index) {
        if (depth == m) {
            for (int i = 0; i < result.length; i++) {
                sb.append(result[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = index; i < n + 1; i++) {
            result[depth] = i;
            dfs(depth + 1, i);
        }
    }
}