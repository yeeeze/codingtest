package BJ.SDS.DAY03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * int 범위 = 2 ^ 63 - 1
 */
public class BJ2042 {

    private static int N, M, K, S;
    private static long[] tree, data;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        data = new long[N];

        for (int i = 0; i < N; i++) {
            data[i] = Long.parseLong(br.readLine());
        }

        // S 구하기
        S = 1;
        while (S < N) {
            S *= 2;
        }
        tree = new long[S * 2];
        init();

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                // b -> c : diff 구해야함
                update(1, S, 1, b, c - tree[S + b -1]);
            } else {
                System.out.println(query(1, S, 1, b, c));
            }
        }
    }

    public static void init() {
        // 리프
        for (int i = 0; i < N; i++) {
            tree[S + i] = data[i];
        }
        // 내부
        for (int i = S - 1; i >= 1; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
    }

    public static void update(int left, int right, int node, long target, long diff) {
        // 범위 내에 없음 -> 끝
        if (left > target || right < target) {
            return;
        }
        // 범위 내에 있음 -> 해당 노드 diff 변환 -> 자식 판단 (리프 노드면!!!!!!!!!!!!!!!!!!!!! 자식 부르면 안됨)
        else {
            int mid = (left + right) / 2;
            tree[node] += diff;
            if (left != right) {
                update(left, mid, node * 2, target, diff);
                update(mid + 1, right, node * 2 + 1, target, diff);
            }
        }
    }

    public static long query(int left, int right, int node, int queryLeft, long queryRight) {
        // 연관 없음 -> 끝
        if (right < queryLeft || left > queryRight) {
            return 0;
        }
        // 가능범위 -> 정답 리턴
        else if (queryLeft <= left && right <= queryRight) {
            return tree[node];
        }
        // 걸쳐있음 -> 자식에게 위임 -> 자식에서 리턴된 값 더해서 리턴
        else {
            int mid = (left + right) / 2;
            long resultL = query(left, mid, node * 2, queryLeft, queryRight);
            long resultR = query(mid + 1, right, node * 2 + 1, queryLeft, queryRight);
            return resultL + resultR;
        }
    }
}
