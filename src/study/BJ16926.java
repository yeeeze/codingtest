package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ16926 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //min(N, M) mod 2 = 0

            int[] dy = {1, 0, -1, 0};
            int[] dx = {0, 1, 0, -1};   // 하 우 상 좌
            for (int i = 0; i < r; i++) {
                int startY = 0;
                int startX = 0;
                int yCnt = n - 1;
                int xCnt = m - 1;
                while (yCnt > 0 && xCnt > 0) {
                    int now = arr[startY][startX];
                    for (int j = 0; j < 4; j++) {
                        int loop = 0;
                        if (j % 2 == 0) {   // 행 갯수-1 만큼 반복
                            loop = yCnt;
                        } else {
                            loop = xCnt;
                        }
                        for (int k = 0; k < loop; k++) {
                            int ny = startY + dy[j];
                            int nx = startX + dx[j];
                            int temp = arr[ny][nx];

                            arr[ny][nx] = now;
                            now = temp;
                            startY = ny;
                            startX = nx;
                        }
                    }
                    yCnt -= 2;
                    xCnt -= 2;
                    startY += 1;
                    startX += 1;
                }
            }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
