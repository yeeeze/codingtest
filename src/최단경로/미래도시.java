package 최단경로;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 미래도시 {

    private static int n, m, x, k;
    private static int[][] graph;
    private static int INF = (int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n+1][n+1];

        // 최단거리 테이블 무한으로 초기화
        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i], INF);
        }

        // 자기 자신에게 가는 경로 0으로 초기화
        for (int a = 1; a < n; a++) {
            for (int b = 1; b < n; b++) {
                if (a == b) {
                    graph[a][b] = 0;
                }
            }
        }

        // 그래프 경로 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][i] + graph[i][b]);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int result = graph[1][k] + graph[k][x];

        if (result == INF) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }

        br.close();
    }
}
