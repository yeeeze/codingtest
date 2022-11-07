package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ7576 {

    static int n, m, result = 0;
    static int[][] map;
    static boolean[][] visited;
    private static int[] dy = {-1, 1, 0, 0};
    private static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        ArrayList<Node> one = new ArrayList<>();
        int impossible = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    one.add(new Node(i, j, 0));
                    visited[i][j] = true;
                    impossible++;
                } else if (map[i][j] == -1) {
                    impossible++;
                }
            }
        }

        int cnt = n * m - impossible;
        int v = 0;
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < one.size(); i++) {
            queue.add(one.get(i));
        }

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int y = poll.y;
            int x = poll.x;
            int data = poll.data;
            result = Math.max(result, data);

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (0 <= ny && ny < n && 0 <= nx && nx < m && map[ny][nx] != -1 && !visited[ny][nx]) {
                    queue.add(new Node(ny, nx, data + 1));
                    visited[ny][nx] = true;
                    v++;
                }
            }
        }

        if (cnt != v) {
            System.out.println(-1);
            return;
        }

        System.out.println(result);
    }

    static class Node {
        int y, x, data;

        public Node(int y, int x, int data) {
            this.y = y;
            this.x = x;
            this.data = data;
        }
    }
}
