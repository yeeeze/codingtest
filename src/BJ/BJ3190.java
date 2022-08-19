package BJ;

import java.io.*;
import java.util.*;

public class BJ3190 {

    /**
     * 구현
     * 1. 뱀이 머리와 꼬리를 별도로 움직이니까 꼬리의 정보를 저장하고 있어야함
     *    머리만 체크하면 꼬리를 비워줄 때 다음 꼬리가 어느 부분인지 알 수 없음
     *    -> 삽입(머리), 삭제(꼬리)가 분리되어 있으니까 큐를 사용하면 될 것 (처음에는 리스트로 적용했으나 큐로 해도 될 것 같다)
     * 2. 뱀이 새로 움직일 때 map에 그대로 체크했더니 사과 자리 표시와 겹쳐서 오류났음
     * 3. 방향 전환을 어떻게 해야되지? -> 음수 방향 전환 시에는 나머지로 구하면 안됨. 새로운 규칙 찾아서 적용.
     */
    private static int[] dy = {-1, 0, 1, 0};
    private static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[][] map = new int[n + 1][n + 1];

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            map[y][x] = 1;  // 사과 = 1
        }

        int l = Integer.parseInt(br.readLine());
        HashMap<Integer, String> snake = new HashMap<>();
        for (int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            snake.put(X, st.nextToken());
        }

        int direction = 3;  // 오른쪽
        int x = 1, y = 1, cnt = 0;
        int tailX = 1, tailY = 1;
        boolean[][] snakeVisited = new boolean[n + 1][n + 1];
        snakeVisited[y][x] = true;

        Queue<Body> body = new LinkedList<>();
        body.add(new Body(1, 1));
        while (true) {
            cnt++;
            int ny = y + dy[direction];
            int nx = x + dx[direction];

            if (1 <= nx && nx <= n && 1 <= ny && ny <= n && !snakeVisited[ny][nx]) {
                snakeVisited[ny][nx] = true;
                body.add(new Body(ny, nx));
                if (map[ny][nx] == 1) {
                    map[ny][nx] = 0;
                } else {
                    snakeVisited[tailY][tailX] = false;
                    body.poll();
                    Body tail = body.peek();    // 큐 peek : 맨 처음 들어간 데이터(index 0) 선택
                    tailX = tail.x;
                    tailY = tail.y;
                }
                y = ny;
                x = nx;
            } else {
                break;
            }

            if (snake.containsKey(cnt)) {
                String rotate = snake.get(cnt);
                if (rotate.equals("L")) {
                    direction = ++direction % 4;
                } else {
                    --direction;
                    if (direction < 0) {
                        direction += 4;
                    }
                }
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }

    static class Body {
        int y, x;

        public Body(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
