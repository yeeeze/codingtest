package 이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 입력값의 최대치로 배열 공간 선언!!
 * 계수정렬은 n + 1만큼의 공간 필요
 */
public class 부품찾기_계수정렬 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[1000001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int target = Integer.parseInt(st.nextToken());
            arr[target] = 1;
        }

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());
            if (arr[target] == 1) {
                System.out.print("yes ");
            } else {
                System.out.print("no ");
            }
        }
    }
}
