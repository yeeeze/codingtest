package 이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 순차탐색 {
    public static void main(String[] args) throws IOException {
        System.out.println("생성할 원소 개수를 입력한 다음 한 칸 띄고 찾을 문자열을 입력하세요.");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        String str = st.nextToken();

        System.out.println("앞서 적은 원소 개수만큼 문자열을 입력하세요. 구분은 띄어쓰기 한 칸으로 합니다.");
        st = new StringTokenizer(br.readLine());

        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = st.nextToken();
        }

        int result = 1;
        for (String s : arr) {
            if (s.equals(str)) {
                break;
            } else {
                result++;
            }
        }
        System.out.println(result);
    }
}
