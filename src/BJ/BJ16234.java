package BJ;

import java.io.*;
import java.util.*;

/**
 * 날짜 세는 기준 제대로 복습..
 */
public class BJ16234 {

    private static int N, L, R;
    private static Node2[][] map;
    private static boolean[][] visited;
    private static int[] dy = {-1, 1, 0, 0};
    private static int[] dx = {0, 0, -1, 1};
    private static ArrayList<Node2> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new Node2[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = new Node2(i, j, Integer.parseInt(st.nextToken()));
            }
        }

        bw.write(String.valueOf(move()));
        bw.flush();
        bw.close();
    }

    public static int move() {
        int day = 0;
        while (true) {
            boolean flag = false;
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        open(i, j);
                        if (calcul()) {        // 연합국가가 있으면
                            flag = true;
                        }
                    }
                }
            }

            if (flag) {
                day += 1;
            } else {
                return day;
            }
        }
    }
    public static void open(int y, int x) {
        Queue<Node2> queue = new LinkedList<>();
        queue.add(new Node2(y, x, map[y][x].num));
        visited[y][x] = true;
        list.add(new Node2(y, x, map[y][x].num));

        while (!queue.isEmpty()) {
            Node2 poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = poll.y + dy[i];
                int nx = poll.x + dx[i];

                if (0 <= ny && ny < N && 0 <= nx && nx < N && !visited[ny][nx]) {
                    int n = Math.abs(poll.num - map[ny][nx].num);
                    if (L <= n && n <= R) {
                        visited[ny][nx] = true;
                        queue.add(map[ny][nx]);
                        list.add(new Node2(ny, nx, map[ny][nx].num));
                    }
                }
            }
        }
    }

    // 인구수 갱신
    public static boolean calcul() {
        if (list.size() == 1) {
            list.clear();
            return false;
        }

        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i).num;
        }

        for (int i = 0; i < list.size(); i++) {
            map[list.get(i).y][list.get(i).x].num = sum / list.size();
        }

        list.clear();
        return true;
    }
}

class Node2 {
    int y, x, num;

    public Node2(int y, int x, int num) {
        this.y = y;
        this.x = x;
        this.num = num;
    }
}
