package BJ.SDS.DAY01.DFS;

import com.sun.source.tree.ReturnTree;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문제 접근 잘못함... bfs인 줄 알았는데 dfs로 푸는 문제였음
 * 가장 깊이 오랫동안 방문해야하는 문제임.....
 * 최단경로가 아님...
 */
public class BJ1103 {

    private static int n, m, max = 0;
    private static String[][] map;
    private static int[][] dp;
    private static boolean[][] visited;
    private static int[] dy = {-1, 1, 0, 0};
    private static int[] dx = {0, 0, -1, 1};
    private static boolean inf = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new String[n][m];
        dp = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.substring(j, j + 1);
            }
        }

        dfs(0, 0, 1);
        if (inf) {
            bw.write(String.valueOf(-1));
        } else {
            bw.write(String.valueOf(max));
        }
        bw.flush();
        bw.close();
    }

    public static void dfs(int y, int x, int cnt) {
        visited[y][x] = true;
        dp[y][x] = cnt;
        max = Math.max(max, cnt);

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i] * Integer.parseInt(map[y][x]);
            int nx = x + dx[i] * Integer.parseInt(map[y][x]);

            if (0 <= ny && ny < n && 0 <= nx && nx < m) {
                if (visited[ny][nx]) {
                    inf = true;
                    return;
                }

                if (!map[ny][nx].equals("H") && !visited[ny][nx]) {
                    // cnt 값 자체를 +1 해주면 안됨. dfs 호출 시에 +1해서 호출하고 max에만 저장한뒤 막다른 길이면 cnt가 다시 직전값으로 돌아와야하니까..
                    if (dp[ny][nx] > cnt) {
                        continue;
                    }
                    dfs(ny, nx, cnt + 1);
                }
            }
        }
        visited[y][x] = false;
    }

    public static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0, Integer.parseInt(map[0][0])));
        visited[0][0] = true;
        dp[0][0] = 1;
        int y = 0, x = 0, turn = 0;
        boolean inf = false;
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            x = now.x;
            y = now.y;
            turn = 0;
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i] * now.data;
                int nx = x + dx[i] * now.data;
                if (0 <= ny && ny < n && 0 <= nx && nx < m) {
                    if (!map[ny][nx].equals("H")) {
                        if (visited[ny][nx]) {
                            inf = true;
                            break;
                        }
                        queue.offer(new Node(ny, nx, Integer.parseInt(map[ny][nx])));
                        visited[ny][nx] = true;
                        dp[ny][nx] = dp[y][x] + 1;
                    } else {
                        turn++;
                    }
                } else {
                    turn++;
                }
            }

            if (turn == 4) {
//                bw.write(String.valueOf(count[y][x]));
                break;
            }
            if (inf) {
//                bw.write(String.valueOf(-1));
                break;
            }
        }
    }
}

class Node {
    int y, x, data;

    public Node(int y, int x, int data) {
        this.y = y;
        this.x = x;
        this.data = data;
    }
}
