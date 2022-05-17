package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 왕실의나이트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int a = input.charAt(0) - 'a' + 1;
        int b = Integer.parseInt(input.substring(1, 2));
        int cnt = 0;


        // 경우의수
        int[][] arr = {{2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, -2}, {1, 2}, {-1, 2}, {-1, -2}};

        // 최종 목적지 확인
        int x = 0, y = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(j == 0) {
                   x = a + arr[i][j];
                }

                else {
                    y = b + arr[i][j];
                }
            }

            if (x >= 1 && x <= 8 && y >= 1 && y <= 8) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
