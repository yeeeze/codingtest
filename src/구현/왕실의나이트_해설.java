package 구현;

import java.util.Scanner;

public class 왕실의나이트_해설 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 현재 나이트의 위치 입력 받기
        String intput = sc.nextLine();
        int row = intput.charAt(1) - '0';
        int column = intput.charAt(0) - 'a' + 1;

        // 나이트가 이동할 수 있는 8가지 방향 정의
        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

        int result = 0;
        for (int i = 0; i < dx.length; i++) {
            int nextRow = row + dx[i];
            int nextColumn = column + dy[i];

            if (nextRow >= 1 && nextColumn >= 1 && nextRow <= 8 && nextColumn <= 8) {
                result++;
            }
        }

        System.out.println(result);
    }
}
