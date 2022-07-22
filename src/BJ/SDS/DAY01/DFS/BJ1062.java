package BJ.SDS.DAY01.DFS;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ1062 {

    private static int N, K, result, cnt;
    private static String[] words;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        // antic
        System.setIn(new FileInputStream("src/BJ/SDS/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        words = new String[N];
        visited = new boolean[26];
        cnt = 5;

        // K가 기본 5개 보다 작은 수일 수도 있음 -> 무조건 못 읽음
        if (K < 5) {
            System.out.println(0);
            return;
        } else if (K == 26) {
            System.out.println(N);
            return;
        }

        visited['a' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['c' - 'a'] = true;

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        // 기본 5개로만 읽을 수 있는 값을 결과값으로 미리 세팅 // 단어가 기본 알파벳으로만 이루어진 경우 체크
        result = read();
        for (char i = 'b'; i <= 'z'; i++) {
            if (!visited[i - 'a']) {
                dfs(i);
            }
        }

        System.out.println(result);
    }

    public static void dfs(char c) {
        // 1. 체크인
        visited[c - 'a'] = true;
        cnt++;
        // 2. 목적지인가?
        if (cnt == K) {
            // 읽을 수 있는 단어 개수 최댓값 갱신
            result = Math.max(result, read());
        } else {
            // 3. 연결되어 있는 곳 순회
            for (char i = (char) (c + 1); i <= 'z'; i++) {
                // 갈 수 있는가? -> 기본 5개 문자는 안 감! main에서 이미 방문했으니까
                if (!visited[i - 'a']) {
                    dfs(i);
                }
            }
        }
        // out
        visited[c - 'a'] = false;
        cnt--;
    }

    public static int read() {
        int re = 0;
        for (String s : words) {
            boolean read = true;
            for (int i = 0; i < s.length(); i++) {
                if (!visited[s.charAt(i) - 'a']) {
                    read = false;
                    break;
                }
            }
            if (read) {
                re++;
            }
        }
        return re;
    }
}
