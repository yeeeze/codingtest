package 이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 중복되지 않는 데이터들 중에 특정 데이터가 존재하는지 검사할 때
 * set 자료형이 효과적으로 사용될 수 있다.
 */

public class 부품찾기_집합자료형 {

    private static int n, m;
    private static HashSet<Integer> s;

    public static void main(String[] args) throws IOException {
        s = new HashSet<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 부품 저장
        for (int i = 0; i < n; i++) {
            s.add(Integer.parseInt(st.nextToken()));
        }

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            if (s.contains(Integer.parseInt(st.nextToken()))) {
                System.out.print("yes ");
            } else {
                System.out.print("no ");
            }

        }
    }
}
