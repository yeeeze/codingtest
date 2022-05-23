package 탐색_DFS_BFS;

import java.util.ArrayList;
import java.util.Scanner;

public class 음료수얼려먹기 {

    public static int N, M, cnt;
    public static int[][] graph = new int[1000][1000];

    // DFS
    public static boolean dfs(int x, int y) {
        if (x <= -1 || x >= N || y <= -1 || y >= M) {
            return false;
        }

        if (graph[x][y] == 0) {
            graph[x][y] = 1;
            dfs(x - 1, y);
            dfs(x, y - 1);
            dfs(x + 1, y);
            dfs(x, y + 1);
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();

        // 얼음 틀 정보 삽입
        for (int i = 0; i < N; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(dfs(i, j)) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
