package 프로그래머스;

import java.util.LinkedList;
import java.util.Queue;

class 공원산책 {

  static Queue<Node> queue = new LinkedList<>();
  static int[] dy = {-1, 1, 0, 0};
  static int[] dx = {0, 0, -1, 1};
  static char[][] map;

  public static void main(String[] args) {
    String[] park = {"SOO","OOO","OOO"};
    String[] rou = {"E 2","S 2","W 1"};
    solution(park, rou);
  }

  public static int[] solution(String[] park, String[] routes) {
    map = new char[park.length][park[0].length()];

    for (int i = 0; i < park.length; i++) {
      String str = park[i];
      for (int j = 0; j < park[0].length(); j++) {
        map[i][j] = str.charAt(j);

        if (map[i][j] == 'S') {
          Node start = new Node(i, j);
          queue.add(start);
        }
      }
    }

    for (int i = 0; i < routes.length; i++) {
      boolean flag = false;
      String[] split = routes[i].split(" ");
      String op = split[0];
      int n = Integer.parseInt(split[1]);

      Node node = queue.peek();
      int y = node.y;
      int x = node.x;
      int ny = 0;
      int nx = 0;

      if (op.equals("N")) {
        for (int j = 0; j < n; j++) {
          ny = y + dy[0];
          nx = x + dx[0];

          if (!go(ny, nx, park.length, park[0].length())) {
            flag = true;
            break;
          }
          y = ny;
          x = nx;
        }
      }

      if (op.equals("S")) {
        for (int j = 0; j < n; j++) {
          ny = y + dy[1];
          nx = x + dx[1];

          if (!go(ny, nx, park.length, park[0].length())) {
            flag = true;
            break;
          }
          y = ny;
          x = nx;
        }
      }

      if (op.equals("W")) {
        for (int j = 0; j < n; j++) {
          ny = y + dy[2];
          nx = x + dx[2];

          if (!go(ny, nx, park.length, park[0].length())) {
            flag = true;
            break;
          }
          y = ny;
          x = nx;
        }
      }

      if (op.equals("E")) {
        for (int j = 0; j < n; j++) {
          ny = y + dy[3];
          nx = x + dx[3];

          if (!go(ny, nx, park.length, park[0].length())) {
            flag = true;
            break;
          }
          y = ny;
          x = nx;
        }
      }

      if (!flag) {
        queue.poll();
        queue.add(new Node(ny, nx));
      }

    }

    Node end = queue.poll();
    int[] answer = {end.y, end.x};
    return answer;
  }

  public static boolean go(int ny, int nx, int n, int m) {
    if (0 <= ny && ny < n && 0 <= nx && nx < m) {
      if (map[ny][nx] != 'X') {
        return true;
      }
    }

    return false;
  }

  static class Node {

    int y, x;

    public Node(int y, int x) {
      this.y = y;
      this.x = x;
    }
  }

}

