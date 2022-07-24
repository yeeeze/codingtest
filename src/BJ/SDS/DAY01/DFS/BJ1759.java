package BJ.SDS.DAY01.DFS;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 정렬된 순서대로만 탐색을 하고자 할 때는
 * 미리 정렬을 시키고, 현재 데이터보다 1개 다음 데이터부터 dfs를 돌도록 설계한다.
 */
public class BJ1759 {

    private static int L, C;
    private static char[] data;
    private static LinkedList<String> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/BJ/SDS/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        data = new char[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            data[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(data);

        // 루트 노드를 빈노드로 세팅
        dfs(0, 0, 0, -1, "");

        for (String word : result) {
            System.out.println(word);
        }
    }

    static void dfs(int length, int ja, int mo, int current, String pwd) {
        // 1. 체크인 - 생략 가능 (정렬한 상태라면 생략해도됨)
        // 2. 목적지인가?    length == L -> ja 개수, mo 개수 확인 암호 가능 판별
        if (length == L) {
            if (ja >= 2 && mo >= 1) {
                // 정답처리 result는 linkedList<String>
                result.add(pwd);
            }
        } else {
            // 3. 연결된 곳을 순회 : current + 1 ~ C
            for (int i = current + 1; i < C; i++) {
                // 4. 갈 수 있는가? : 정렬했으니까 다 갈 수 있음
                // 5. 간다 -> ja, mo
                if (data[i] == 'a' || data[i] == 'e' || data[i] == 'i' || data[i] == 'o' || data[i] == 'u') {
                    dfs(length + 1, ja, mo + 1, i, pwd + data[i]);
                } else {
                    dfs(length + 1, ja + 1, mo, i, pwd + data[i]);
                }
            }
        }
        // 6. 체크아웃 - 생략 가능
    }
}
