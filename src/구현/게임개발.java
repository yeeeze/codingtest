package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 게임개발 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 맵 생성
        int[][] map = new int[n][m];

        // 캐릭터 시작 위치
        st = new StringTokenizer(br.readLine());
        int currentRow = Integer.parseInt(st.nextToken());
        int currentColumn = Integer.parseInt(st.nextToken());
        int direction = Integer.parseInt(st.nextToken());

        // 맵 정보 삽입
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 캐릭터 이동 방향 (북, 동, 남, 서)
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int cnt = 0;
        int turn = 0;

        while (true) {
            int row = 0;
            int column = 0;

            // 왼쪽으로 회전
            direction = turnLeft(direction);
            turn++;

            row = currentRow + dx[direction];
            column = currentColumn + dy[direction];

            // 가보지 않은 칸이 존재한다면 왼쪽 한칸 전진
            if(map[row][column] == 0) {
                currentRow = row;
                currentColumn = column;

                cnt++;
                turn = 0;
                map[row][column] = 2;   // 가본 칸은 2로 바꿈
            }
            else {
                // 네 방향 모두 이비 가본 칸이거나 바다로 되어 있는 경우 뒤로 후진
                if(turn == 4) {
                    // 뒤쪽 방향이 바다이면 움직임을 멈춘다
                    if(map[currentRow - dx[direction]][currentRow - dy[direction]] ==  1) {
                        break;
                    }
                    else {
                        currentRow = currentRow - dx[direction];
                        currentRow = currentRow - dy[direction];
                    }
                }
            }
        }

        System.out.println(cnt);
    }

    // 왼쪽으로 회전 함수
    public static int turnLeft(int direction) {
        int result = 0;
        result = direction-1;

        if(result == -1) {
            return 3;
        }
        else {
            return result;
        }
    }
}
