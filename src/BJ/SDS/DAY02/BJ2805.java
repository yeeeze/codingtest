package BJ.SDS.DAY02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 파라메트릭 서치 (이진탐색)
 */
public class BJ2805 {

    private static int[] trees;
    private static int sum, N, M;
    private static long result;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/BJ/SDS/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        trees = new int[N];

        int max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(trees[i], max);
        }

        long start = 0, end = max;
        long mid;
        // 반복문으로 구현
        // 매번 sum 계산
        while (true) {
            mid = (end + start) / 2;
            getSum(mid);

            // sum == M 종료
            if (sum == M) {
                result = mid;
                break;
            }
            // sum < M
            else if (sum < M) {
                end = mid - 1;
            }
            // sum > M
            else {
                result = mid;
                start = mid + 1;
            }
            /**
             * 이거 안 해서 무한루프, 이진탐색의 탈출조건!!!
             */
            if (start > end) {
                break;
            }
        }

        System.out.println(result);
    }

    // 재귀함수로 구현하는 경우
    public static void getHeight(long start, long end) {
        long mid = (start + end) / 2;

        if (start > end) {
            return;
        }

        getSum(mid);
        if (sum == M) {
            result = mid;
        } else if (sum > M) {
            result = mid;
            getHeight(mid + 1, end);
        } else {
            getHeight(start, mid - 1);
        }
    }

    public static void getSum(long h) {
        for (int tree : trees) {
            if (tree > h) {
                sum += tree - h;
            }
        }
    }
}
