package BJ.n과m시리즈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 순열 (중복되는 배열 제외)
 * 주어진 숫자에 똑같은 숫자가 존재함 ex) 1 7 9 9
 *
 * 이미 뽑은 모양의 배열이면, 중복 되는 배열이면 -> 어떻게 뺄 수 있을까??
 * set(집합) 활용
 * set 없이 변수로 걸러내기
 */

public class BJ15663 {

    private static int n, m;
    private static int[] input, result;
    private static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();
    static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        input = new int[n];
        result = new int[m];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(input);
//        dfs(0);
//        func(0);
        dfs2(0);
        System.out.println(sb);
    }

    // set 자료구조 활용
    public static void dfs(int depth) {
        if (depth == m) {
            String nums = "";
            for (int i = 0; i < m; i++) {
                nums += result[i] + " ";
            }

            if (!set.contains(nums)) {
                sb.append(nums + "\n");
                set.add(nums);
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                result[depth] = input[i];
                visited[i] = true;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }

    // 올바른 예시 // 같은 depth에서만 중복값이 나오지 않도록 하면 됨
    // depth에서 한번 전체 탐색할 때...
    private static void func(int k) {
        if (k == m) {
            for (int i = 0; i < m; i++) {
                sb.append(result[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        int temp = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && temp != input[i]) {
                visited[i] = true;
                result[k] = input[i];
                temp = result[k];
                func(k+1);
                visited[i] = false;
            }
        }
    }

    // 틀린 예시
    public static void dfs2(int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(result[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i] && result[depth] != input[i]) {
                result[depth] = input[i];
                visited[i] = true;
                dfs2(depth + 1);
                visited[i] = false;
            }
        }
    }
}
