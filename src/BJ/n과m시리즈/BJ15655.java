package BJ.n과m시리즈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 조합 (중복되지 않기 위해서.. index 다음부터 뽑음)
 */

public class BJ15655 {

    private static int n, m;
    private static int[] input, result;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        input = new int[n];
        result = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(input);
        dfs(0, 0);
        System.out.println(sb);
    }

    public static void dfs(int depth, int index) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(result[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = index; i < n; i++) {
//            if (!visited[i]) {
                result[depth] = input[i];
                dfs(depth + 1, i + 1);      // i + 1부터 탐색. 방문체크 필요 없음!!
//            }
        }
    }
}
