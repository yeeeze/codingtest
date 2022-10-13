package 프로그래머스;

public class PG77485 {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        int[][] q = {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}};
        int[] solution = solution(6, 6, q);
        for (int s : solution) {
            System.out.println(s);
        }
    }

    // 회전 어떻게?
    // for문을 따로 4개 작성해도 되고... 지금처럼 반복횟수와 회전 시점을 계산해도 되고..
    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        int[][] map = new int[rows][columns];
        int num = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = num;
                num++;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int x1 = queries[i][0] - 1;     // 행
            int y1 = queries[i][1] - 1;     // 열
            int x2 = queries[i][2] - 1;
            int y2 = queries[i][3] - 1;

            int temp = map[x1][y1]; // 옮기는 숫자
            int temp2 = 0;  // 지워진 숫자 (미래에 옮김)
            int min = Integer.MAX_VALUE;
            int direc = 0;

            int px = x1;     // 현재
            int py = y1;
            // 행,열 숫자 -1 만큼 간다음에 방향 전환
            for (int j = 0; j < ((x2 - x1 + 1) * 2) + ((y2 - y1 + 1) * 2) - 4; j++) {
                int nx = px + dx[direc];
                int ny = py + dy[direc];

                min = Math.min(min, temp);
                temp2 = map[nx][ny];
                map[nx][ny] = temp;
                px = nx;
                py = ny;
                temp = temp2;

                // 방향 전환 3번
                if ((px == x1 && py == y2) || (px == x2 && py == y2) || (px == x2 && py == y1)) {
                    direc++;
                }
            }

            answer[i] = min;
        }


        return answer;
    }

}
