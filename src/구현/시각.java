package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * java에서 특정 숫자의 포함 여부를 확인하는 방법 : 10의 단위를 활용한다
 */
public class 시각 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < 60; j++) {
                for (int k = 0; k < 60; k++) {
                    // 매 시각 3이 들어있는지 체크
                    if(checkThree(i, j, k)) {
                        cnt++;
                    }
                }
            }
        }

        System.out.println(cnt);
    }

    public static boolean checkThree(int h, int m, int s) {
        if (h % 10 == 3 || m % 10 == 3 || m / 10 == 3 || s / 10 == 3 || s % 10 == 3) {
            return true;
        }
        else {
            return false;
        }
    }
}
