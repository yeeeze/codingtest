package 탐색_DFS_BFS;

import java.util.Scanner;

public class 미로탈출 {

    public static int n, m, cnt;
    public static int[][] graph = new int[200][200];

    public static boolean move(int x, int y) {
        cnt += 1;

        if(x == n && y == m) {
            return false;
        }
        if(graph[x + 1][y] == 1) {
            move(x + 1, y);
            return true;
        }
        else {
            move(x, y + 1);
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i < n + 1; i++) {
            String str = sc.nextLine();
            for (int j = 1; j < m + 1; j++) {
                graph[i][j] = str.charAt(j - 1) - '0';
            }
        }

        move(1, 1);

        System.out.println(cnt);
    }
}
