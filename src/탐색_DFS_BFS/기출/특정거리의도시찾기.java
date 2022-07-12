package 탐색_DFS_BFS.기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 특정거리의도시찾기 {

    private static int n, m, k, x;
    private static int[] visited = new int[300001];
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int i = 0; i < graph.get(now).size(); i++) {
                if (visited[graph.get(now).get(i)] == 0) {
                    visited[graph.get(now).get(i)] = visited[now] + 1;
                    queue.offer(graph.get(now).get(i));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
        }

        bfs(x);

        int cnt = 0;
        for (int i = 1; i < n + 1; i++) {
            if (visited[i] == k) {
                System.out.println(i);
                cnt++;
            }
        }

        if (cnt == 0) {
            System.out.println(-1);
        }

    }
}
