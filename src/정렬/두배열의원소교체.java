package 정렬;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 반례 생각하기 : A의 최솟값이 B의 최댓값 보다 진짜로 작을 때에만 교환해야함
 */
public class 두배열의원소교체 {

    private static int N, K;
    private static int[] A, B;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N];
        B = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < K; i++) {
            if (A[i] < B[B.length - 1 - i]) {
                int temp = B[B.length - 1 - i];
                B[B.length - 1 - i] = A[i];
                A[i] = temp;
            }
            // A의 원소가 B의 원소 보다 크거나 같을 때, 반복문을 다 돌지 말고 탈출
            else {
                break;
            }
        }

        int result = 0;
        for (int a : A) {
            result += a;
        }
        System.out.println(result);
    }

}
