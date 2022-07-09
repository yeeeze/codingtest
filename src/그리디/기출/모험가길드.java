package 그리디.기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 해설에서는 배열이 아닌 List 사용, cnt >= 해당원소 (큰 경우도 포함시킴)
 */
public class 모험가길드 {

    private static int n;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new int[n];

        // 배열 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (x > n) {
                continue;
            } else {
                arr[i] = x;
            }
        }

        // 정렬
        Arrays.sort(arr);

        int cnt = 0;    // 현재 그룹에 포함된 멤버 수
        int result = 0;     // 그룹 갯수

        // 최대한 작은 숫자부터 그룹 생성
        for (int i = 0; i < n; i++) {
            cnt += 1;   // 현재 그룹에 해당 모험가를 포함시키기
            if (cnt == arr[i]) {
                cnt = 0;
                result += 1;
            }
        }

        System.out.println(result);
    }

}
