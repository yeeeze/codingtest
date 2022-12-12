package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

class Nod {
    int y, x;

    public Nod(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class BJ10026 {

    // 24분
    static int n;
    static Character[][] map, mapRG;
    static boolean[][] visited, visitedRG;
    static int result, resultRG;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new Character[n][n];
        mapRG = new Character[n][n];
        visited = new boolean[n][n];
        visitedRG = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                char c = s.charAt(j);
                map[i][j] = c;

                if (c == 'R') {
                    mapRG[i][j] = 'G';
                } else {
                    mapRG[i][j] = c;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                    result++;
                }
                if (!visitedRG[i][j]) {
                    bfsRG(i, j);
                    resultRG++;
                }
            }
        }

        System.out.print(result + " " + resultRG);
    }

    private static void bfsRG(int i, int j) {
        Queue<Nod> queue = new LinkedList<>();
        queue.add(new Nod(i, j));
        visitedRG[i][j] = true;

        while (!queue.isEmpty()) {
            Nod now = queue.poll();

            for (int k = 0; k < 4; k++) {
                int ny = now.y + dy[k];
                int nx = now.x + dx[k];

                if (0 <= ny && ny < n && 0 <= nx && nx < n && !visitedRG[ny][nx]) {
                    if (Objects.equals(mapRG[ny][nx], mapRG[now.y][now.x])) {
                        queue.add(new Nod(ny, nx));
                        visitedRG[ny][nx] = true;
                    }
                }
            }
        }
    }

    public static void bfs(int i, int j) {
        Queue<Nod> queue = new LinkedList<>();
        queue.add(new Nod(i, j));
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            Nod now = queue.poll();

            for (int k = 0; k < 4; k++) {
                int ny = now.y + dy[k];
                int nx = now.x + dx[k];

                if (0 <= ny && ny < n && 0 <= nx && nx < n && !visited[ny][nx]) {
                    if (Objects.equals(map[ny][nx], map[now.y][now.x])) {
                        queue.add(new Nod(ny, nx));
                        visited[ny][nx] = true;
                    }
                }
            }
        }
    }
}
