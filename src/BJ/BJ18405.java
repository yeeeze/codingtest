package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ18405 {

    private static int n, k, s, x, y, kCnt = 0;
    private static int[][] map, timeCheck;
    private static ArrayList<virus> location = new ArrayList<>();
    private static int[] dy = {-1, 1, 0, 0};
    private static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        timeCheck = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) {
                    location.add(new virus(i, j, map[i][j]));
                    kCnt++;
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        // 1. 숫자 순서대로 정렬한다
        Collections.sort(location);
        bfs();

        if (map[x-1][y-1] == 0) {
            System.out.println(0);
        } else {
            System.out.println(map[x-1][y-1]);
        }
    }

    // 2. bfs 돌린다
    public static void bfs() {
        Queue<virus> queue = new LinkedList<>();
        for (virus v : location) {
            queue.add(v);
        }

        while (!queue.isEmpty()) {
            virus now = queue.poll();

            // 목적지인가? -> s초 동안 반복 (초 체크!)
            if (timeCheck[now.vy][now.vx] == s) {
                break;
            }

            for (int j = 0; j < 4; j++) {
                int ny = now.vy + dy[j];
                int nx = now.vx + dx[j];

                if (0 <= ny && ny < n && 0 <= nx && nx < n && map[ny][nx] == 0) {
                    map[ny][nx] = map[now.vy][now.vx];
                    timeCheck[ny][nx] = timeCheck[now.vy][now.vx] + 1;
                    queue.add(new virus(ny, nx, now.num));
                }
            }
        }

        //print
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        //print
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(timeCheck[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

    static class virus implements Comparable<virus> {
        int vy, vx, num;

        public virus(int vy, int vx, int num) {
            this.vy = vy;
            this.vx = vx;
            this.num = num;
        }

        // 번호 오름차순 정렬
        @Override
        public int compareTo(virus o) {
            if (this.num < o.num) {
                return -1;
            }
            return 1;
        }
    }

}