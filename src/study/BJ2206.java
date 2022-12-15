package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node2 {
    int y, x, distane;

    public Node2(int y, int x, int distane) {
        this.y = y;
        this.x = x;
        this.distane = distane;
    }
}

public class BJ2206 {

    static int[][] map;
    static boolean[][] visited;
    static int n, m;
    static ArrayList<Node2> wallList = new ArrayList<>();
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    // 벽을 내가 뿌셨는지, 안 뿌셨는지 노드에 상태를 들고다님
    // 벽을 내가 안 뿌셨는데, 지금 벽이면 뿌심! (안 뿌서진 벽만 : visited 체크) 누군가가 뿌셨으면, 이미 늦은거임
    // 방문체크를 통해 누가 왔으면 이미 늦었으니까 안 가도 됨.
    // 나의 상태에 따라서 방문체크 하는 배열을 다르게 지정. visited[y][x][상태] -> 상태 1: 이미 뿌심, 0: 아직 안 뿌심

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j) - '0';
                if (map[i][j] == 1) {
                    wallList.add(new Node2(i, j, 0));
                }
            }
        }

        int result = bfs();

        for (Node2 node : wallList) {
            map[node.y][node.x] = 0;
            result = Math.min(result, bfs());
            map[node.y][node.x] = 1;
        }

        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

    public static int bfs() {
        visited = new boolean[n][m];
        Queue<Node2> queue = new LinkedList<>();
        queue.add(new Node2(0, 0, 1));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Node2 now = queue.poll();

            if (now.y == n - 1 && now.x == m - 1) {
                return now.distane;
            }

            for (int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];

                if (0 <= ny && ny < n && 0 <= nx && nx < m && !visited[ny][nx] && map[ny][nx] == 0) {
                    visited[ny][nx] = true;
                    queue.add(new Node2(ny, nx, now.distane + 1));
                }
            }
        }

        return Integer.MAX_VALUE;
    }
}
