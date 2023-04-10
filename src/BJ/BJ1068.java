package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1068 {
  static int n;
  static int[] tree;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    tree = new int[n];
    int answer = 0;

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      tree[i] = Integer.parseInt(st.nextToken());
    }

    int removeNode = Integer.parseInt(br.readLine());
    tree[removeNode] = -2;

    remove(removeNode);

    for (int i = n - 1; i >= 0; i--) {
      boolean isExisted = false;
      for (int j = 0; j < n; j++) {
        if (tree[j] == i) {
          isExisted = true;
          break;
        }
      }

      if (!isExisted && tree[i] != -2) {
        answer++;
      }
    }

    System.out.println(answer);
  }

  public static void remove(int removeNode) {
    for (int i = 0; i < n; i++) {
      if (tree[i] == removeNode) {
        tree[i] = -2;
        remove(i);
      }
    }
  }
}
