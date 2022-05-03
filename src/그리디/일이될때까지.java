package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * n < k인 경우에는 n/k가 안되니까.. 나눌 수 없기 때문에 그냥 1씩 빼줘야함
 * n >= k, n < k 케이스를 나눠서 처리해주어야하는데 그걸 생각 못 했음..
 */

public class 일이될때까지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int cnt = 0;

        while (n != 1) {
            if(n >= k) {
                if(n % k != 0) {
                    cnt += n % k;
                    n = n - (n % k);
                }
                n = n / k;
                cnt++;
            }
            else {
                n = n - 1;
                cnt++;
            }
        }



        System.out.println(cnt);
    }
}
