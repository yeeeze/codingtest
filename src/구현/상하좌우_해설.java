package 구현;

import java.util.Scanner;

/**
 * 공간 이동시에는 방향 벡터를 별도 리스트 변수를 활용하여 저장하는 것이 좋다.
 * dx[], dy[]
 */
public class 상하좌우_해설 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N을 입력받기
        int n = sc.nextInt();
        sc.nextLine();  // 버퍼 비우기
        String[] plans = sc.nextLine().split(" ");
        int x = 1, y = 1;

        // L, R, U, D에 따른 이동 방향
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        char[] moveTypes = {'L', 'R', 'U', 'D'};

        // 이동 계획을 하나씩 확인
        for(int i = 0; i < plans.length; i++) {
            char plan = plans[i].charAt(0);
            // 이동 후 좌표 구하기
            int nx = -1, ny = -1;   // -1로 초기화
            for(int j = 0; j < 4; j++) {
                if (plan == moveTypes[j]) {
                    nx = x + dx[j];
                    ny = y + dy[j];
                }
            }

            // 공간을 벗어나는 경우 무시
            if(nx < 1 || ny < 1 || nx > n || ny > n) {
                continue;
            }
            x = nx;
            y = ny;
        }
        System.out.println(x + " " + y);
    }

}
