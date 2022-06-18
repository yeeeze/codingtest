package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 효율적인화폐구성 {

    private static int n, m;
    private static ArrayList<Integer> arr;
    private static int[] d = new int[10001];

    public static int money(int x) {
//        for (int i = 0; i <= x; i++) {
//            // 초기화
//            d[i] = 10001;
//        }

        Arrays.fill(d, 10001);

        d[0] = 0;

        for (int j = 0; j < n; j++) {
            int k = arr.get(j);
            for(int i = k; i <= x; i++) {
                d[i] = Math.min(d[i], d[i - k] + 1);
            }
        }

        if (d[x] == 10001) {
            return -1;
        } else {
            return d[x];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new ArrayList();

        // 화폐 단위 입력
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }

        System.out.println(money(m));
    }
}
