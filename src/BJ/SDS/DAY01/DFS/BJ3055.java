package BJ.SDS.DAY01.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x, y;
    String type;    // *, S

    public Point(int x, int y, String type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getType() {
        return type;
    }
}

public class BJ3055 {
    private static int R, C;
    private static String[][] map;
    private static int[][] cnt;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new String[R][C];
        cnt = new int[R][C];

        int rx = 0;
        int ry = 0;

        Point go = null;
        Point water = null;
        ArrayList<Point> waterList = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = String.valueOf(s.charAt(j));
                if (map[i][j].equals("S")) {
                    go = new Point(i, j, "S");
                    cnt[i][j] = 0;
                }
                if (map[i][j].equals("*")) {
                    water = new Point(i, j, "*");
                    waterList.add(water);
                }
                if (map[i][j].equals("D")) {
                    rx = i;
                    ry = j;
                }
            }
        }

        bfs(waterList, go);

        System.out.println((cnt[rx][ry] == 0 ? "KAKTUS" : cnt[rx][ry]));
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(cnt[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void bfs(ArrayList<Point> water, Point go) {
        Queue<Point> queue = new LinkedList<>();
        for (Point w :water) {
            queue.offer(w);
        }
        queue.offer(go);

        // 1. 큐에서 꺼냄
        while (!queue.isEmpty()) {
            Point now = queue.poll();
            int x = now.getX();
            int y = now.getY();
            String type = now.getType();

            // 3. 연결된 곳 순회
            for (int i = 0; i < 4; i++) {
                int x1 = x + dx[i];
                int y1 = y + dy[i];

                if (x1 >= 0 && x1 < R && y1 >= 0 && y1 < C) {
                    if (type.equals("*") && map[x1][y1].equals(".")) {
                        queue.offer(new Point(x1, y1, "*"));
                        map[x1][y1] = "*";
                    } else if (type.equals("S")) {
                        if ((map[x1][y1].equals(".") || map[x1][y1].equals("D")) && cnt[x1][y1] == 0) {
                            queue.offer(new Point(x1, y1, "S"));
                            cnt[x1][y1] = cnt[x][y] + 1;
                            if (map[x][y].equals("D")) {
                                return;
                            }
                        }
                    }
                }
            }

        }
    }
}
