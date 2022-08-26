package BJ;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ14502 {

    private static int n, m, result = Integer.MAX_VALUE;
    private static int[][] map;
    private static ArrayList<Node> wall = new ArrayList<>();
    private static ArrayList<Node> virus = new ArrayList<>();
    private static int[] dy = {-1, 1, 0, 0};
    private static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    wall.add(new Node(i, j));
                } else if (map[i][j] == 2) {
                    virus.add(new Node(i, j));
                }
            }
        }

        // 0칸 중에 3개를 뽑는다. 19만번
        // 0칸의 좌표를 저장하고 있어야함
        pick(0, 0);

        bw.write(String.valueOf(wall.size() - 3 - result));
        bw.flush();
        bw.close();
    }

    // 3중 for문을 재귀함수로...
    public static void pick(int start, int cnt) {
        // 탈출조건
        if (cnt == 3) {
            // 3개를 뽑고 나서 dfs로 돌려본다. 2가 퍼짐
            // 2가 퍼지는 갯수를 센다. 64번
            // Math.min 2의 갯수 최소 크기 계속 갱신
            result = Math.min(result, count());
            return;
        }

        for (int i = start; i < wall.size(); i++) {
            Node node = wall.get(i);
            map[node.y][node.x] = 5;
            pick(i + 1, cnt + 1);
            map[node.y][node.x] = 0;
        }
    }

    public static int count() {
        int[][] next = deepCopy(map);
        Queue<Node> queue = new LinkedList();
        for (Node n : virus) {
            queue.add(n);
        }

        int count = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];
                if (0 <= ny && ny < n && 0 <= nx && nx < m && map[ny][nx] == 0) {
                    map[ny][nx] = -1;   // 방문처리
                    queue.add(new Node(ny, nx));
                    count++;
                }
            }
        }
        map = deepCopy(next);
        return count;
    }

    public static int[][] deepCopy(int[][] origin) {
        int[][] next = new int[n][m];
        for (int i = 0; i < n; i++) {
            next[i] = origin[i].clone();
        }
        return next;
    }

    static class Node {
        int x, y;

        public Node(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }
}
