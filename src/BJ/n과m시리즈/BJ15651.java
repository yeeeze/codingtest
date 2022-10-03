package BJ.n과m시리즈;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 중복순열 : System.out.print()로 출력하면 시간초과남
 */
public class BJ15651 {

    private static int n, m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[] result = new int[m];

        peek(0, result);
        System.out.println(sb);
    }

    public static void peek(int cnt, int[] result) {
        if (cnt == m) {
            for (int i = 0; i < result.length; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i < n + 1; i++) {
            result[cnt] = i;
            peek(cnt + 1, result);
        }
    }
}
