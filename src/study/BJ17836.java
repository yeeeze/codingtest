package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int y, x, data, time;
    boolean flag;

    public Node(int y, int x, int data) {
        this.y = y;
        this.x = x;
        this.data = data;
        this.time = 0;
    }

    public Node(int y, int x, int data, int time, boolean flag) {
        this.y = y;
        this.x = x;
        this.data = data;
        this.time = time;
        this.flag = flag;
    }
}
public class BJ17836 {

    // 첫 제출까지 22분, 최종 맞을 때까지 디버깅 시간 50분 (게시판에서 반례 참고해서 풀었음 ㅠ ㅠ)
    // 검을 가진 경로와 아닌 경로를 분리해서 체크하는 것이 포인트!!

    static int N, M, T;
    static Node[][] map;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static boolean[][] visited, sword;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new Node[N][M];
        visited = new boolean[N][M];
        sword = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = new Node(i, j, Integer.parseInt(st.nextToken()));
            }
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(map[0][0]);

        int answer = 0;
        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (now.y == N - 1 && now.x == M - 1) {
                answer = now.time;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int ny = dy[i] + now.y;
                int nx = dx[i] + now.x;

                if (0 <= ny && ny < N && 0 <= nx && nx < M) {
                    if (!now.flag && !visited[ny][nx]) {
                        if (map[ny][nx].data == 1) {
                            continue;
                        } else if (map[ny][nx].data == 0) {
                            queue.add(new Node(ny, nx, map[ny][nx].data, now.time + 1, false));
                            visited[ny][nx] = true;
                        } else {
                            queue.add(new Node(ny, nx, map[ny][nx].data, now.time + 1, true));
                            visited[ny][nx] = true;
                        }
                    } else if(now.flag && !sword[ny][nx]) {
                        queue.add(new Node(ny, nx, map[ny][nx].data, now.time + 1, true));
                        sword[ny][nx] = true;
                    }
                }
            }
        }

        if (answer > T || answer == 0) {
            System.out.println("Fail");
        } else {
            System.out.println(answer);
        }
    }
}
