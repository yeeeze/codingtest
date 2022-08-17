package BJ;

import java.io.*;
import java.util.StringTokenizer;

public class BJ2578 {

    private static int countLine = 0;
    private static int[][] bingo = new int[5][5];
    private static boolean[][] visited = new boolean[5][5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] xy = new int[26][2];

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                bingo[i][j] = num;
                xy[num][0] = i;
                xy[num][1] = j;
            }
        }

        int cnt = 1;
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                // 빙고판 좌표 찾기
                int y = xy[num][0];
                int x = xy[num][1];

                visited[y][x] = true;

                check(y, x);
                if (countLine >= 3) {
                    break;
                }

                cnt++;
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }

    public static void check(int i, int j) {
        // 행
        for (int k = 0; k < 5; k++) {
            if (!visited[i][k]) {
                break;
            }
            if (k == 4) {
                countLine++;
            }
        }
        // 열
        for (int k = 0; k < 5; k++) {
            if (!visited[k][j]) {
                break;
            }
            if (k == 4) {
                countLine++;
            }
        }
        // 대각선
        if (i - j == 0) {
            for (int k = 0; k < 5; k++) {
                if (!visited[k][k]) {
                    break;
                }
                if (k == 4) {
                    countLine++;
                }
            }
        }
        if (i + j == 4) {
            for (int k = 0; k < 5; k++) {
                if (!visited[k][4 - k]) {
                    break;
                }
                if (k == 4) {
                    countLine++;
                }
            }
        }
    }
}
