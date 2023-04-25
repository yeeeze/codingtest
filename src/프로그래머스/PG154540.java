package 프로그래머스;

import java.util.*;

class PG154540 {

  boolean[][] visited;
  int[] dy = {-1, 1, 0, 0};
  int[] dx = {0, 0, -1, 1};
  List<Integer> answerList = new ArrayList<>();

  public int[] solution(String[] maps) {
    boolean flag = false;
    visited = new boolean[maps.length][maps[0].length()];

    for(int i = 0; i < maps.length; i++) {
      String map = maps[i];
      for(int j = 0; j < maps[0].length(); j++) {
        if(map.charAt(j) != 'X' && !visited[i][j]) {
          bfs(i, j, maps);
          flag = true;
        }
      }
    }

    int[] answer = {};

    if(!flag) {
      answer = new int[]{-1};
    } else {
      Collections.sort(answerList);
      answer = new int[answerList.size()];

      for(int i = 0; i < answerList.size(); i++) {
        answer[i] = answerList.get(i);
      }
    }

    return answer;
  }

  public void bfs(int y, int x, String[] maps) {
    Queue<Node> queue = new LinkedList<>();
    queue.add(new Node(y, x, getDay(y, x, maps)));
    visited[y][x] = true;

    int resultSum = 0;

    while(!queue.isEmpty()) {
      Node now = queue.poll();
      resultSum += now.sum;

      for(int i=0; i<4; i++) {
        int ny = now.y + dy[i];
        int nx = now.x + dx[i];

        if(0 <= ny && ny < maps.length && 0 <= nx && nx < maps[0].length() && !visited[ny][nx] && maps[ny].charAt(nx) != 'X') {
          int plus = getDay(ny, nx, maps);
          queue.add(new Node(ny, nx, plus));
          visited[ny][nx] = true;
        }
      }
    }

    answerList.add(resultSum);
  }

  public int getDay(int y, int x, String[] maps) {
    if(maps[y].charAt(x) != 'X') {
      return maps[y].charAt(x) - '0';
    } else {
      return 0;
    }
  }
}

class Node {
  int y, x, sum;

  public Node(int y, int x, int sum) {
    this.y = y;
    this.x = x;
    this.sum = sum;
  }
}