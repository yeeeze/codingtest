package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ14503 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[][] map = new int[n][m];

    st = new StringTokenizer(br.readLine());
    Node start = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
        Integer.parseInt(st.nextToken()));
    Queue<Node> queue = new LinkedList<>();
    queue.add(start);

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // 상, 우, 하, 좌
    int[] dy = {-1, 0, 1, 0};
    int[] dx = {0, 1, 0, -1};
    int answer = 1;

    while (!queue.isEmpty()) {
      Node now = queue.poll();

      // 현재 칸 청소
      if (map[now.y][now.x] == 0) {
        map[now.y][now.x] = 2;
      }

      int direction = now.direction;
      int rotateCount = 0;
      // 3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우 -> 회전, 전진
      for (int i = 0; i < 4; i++) {
        direction -= 1;

        if (direction < 0) {
          direction = 3;
        }

        int ny = now.y + dy[direction];
        int nx = now.x + dx[direction];
        if (map[ny][nx] == 0) {
          queue.add(new Node(ny, nx, direction));
          answer++;
          map[ny][nx] = 2;
          break;
        }

        rotateCount++;
      }

      // 2. 주변 4칸에 빈 칸이 없는 경우 -> 후진
      direction = now.direction;
      if (rotateCount == 4) {
        int ny = 0;
        int nx = 0;
        if (direction < 2) {
          ny = now.y + dy[direction + 2];
          nx = now.x + dx[direction + 2];
        } else {
          ny = now.y + dy[direction - 2];
          nx = now.x + dx[direction - 2];
        }

        if (map[ny][nx] == 1) {
          System.out.println(answer);
          return;
        } else {
          queue.add(new Node(ny, nx, direction));
        }
      }
    }

    System.out.println(answer);
  }

  static class Node {
    int y, x, direction;

    public Node(int y, int x, int direction) {
      this.y = y;
      this.x = x;
      this.direction = direction;
    }
  }
}
