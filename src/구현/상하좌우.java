package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 상하좌우 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int x = 1;
        int y = 1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] arr = new String[st.countTokens()];
        // 계획서 입력
        int cnt = st.countTokens();
        for (int i = 0; i < cnt; i++) {
            arr[i] = st.nextToken();
        }

        // 이동
        for(String s: arr) {
            switch (s) {
                case "R":
                    if(y+1 > n) {
                        break;
                    }
                    y++;
                    break;
                case "L":
                    if(y-1 <= 0) {
                        break;
                    }
                    y--;
                    break;
                case "U":
                    if(x-1 <= 0) {
                        break;
                    }
                    x--;
                    break;
                case "D":
                    if(x+1 > n) {
                        break;
                    }
                    x++;
                    break;
            }
        }

        System.out.print(x + " " +y);
    }
}
