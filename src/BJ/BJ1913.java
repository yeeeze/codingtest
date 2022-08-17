package BJ;

import java.io.*;

public class BJ1913 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int num = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};

        int x = n / 2, y = n / 2, direction = -1, cnt = 2;
        // 처음 1은 찍은 상태에서 2부터 반복문 내에서 찍음
        // 결과 초기값 : 1을 기준으로 세팅
        arr[x][y] = 1;
        int resultX = x, resultY = y;
        // 0,0에 도달할 때까지 무한반복
        while (x != 0 || y != 0) {
            direction %= 4;
            int ny = y + dy[(direction + 1) % 4];
            int nx = x + dx[(direction + 1) % 4];

            if (0 <= ny && ny < n && 0 <= nx && nx < n && arr[ny][nx] == 0) {
                direction++;
                y = ny;
                x = nx;
            } else {
                y = y + dy[direction];
                x = x + dx[direction];
            }

            if (cnt == num) {
                resultY = y;
                resultX = x;
            }
            arr[y][x] = cnt;
            cnt++;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bw.write(arr[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.write((resultY + 1) + " " + (resultX + 1));
        bw.flush();
        bw.close();
    }
}
