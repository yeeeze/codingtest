package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 최단시간 미로 도착하기  (bfs)
public class BJ2178 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int result = 0;
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Node[][] arr = new Node[n][m];
        for (int i = 0; i < n; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                arr[i][j] = new Node(i, j, chars[j] - '0', 1);
            }
        }

        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        boolean[][] visited = new boolean[n][m];
        Queue<Node> queue = new LinkedList<>();
        queue.add(arr[0][0]);

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (poll.y == n - 1 && poll.x == m - 1) {
                result = poll.distance;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int ny = poll.y + dy[i];
                int nx = poll.x + dx[i];
                if (0 <= ny && ny < n && 0 <= nx && nx < m) {
                    Node next = arr[ny][nx];
                    if (next.num == 1 && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        next.distance = poll.distance + 1;
                        queue.add(next);
                    }
                }
            }
        }

        System.out.println(result);
    }

    static class Node {
        int y, x, num, distance;

        public Node(int y, int x, int num, int distance) {
            this.y = y;
            this.x = x;
            this.num = num;
            this.distance = distance;
        }
    }
}
