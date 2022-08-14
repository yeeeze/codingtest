package BJ;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 슬라이딩윈도우 n^2 -> n
 */
public class BJ15961 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        HashMap<Integer, Integer> map = new HashMap();
        int p1 = 0, p2 = k - 1, max = 0;
        for (int i = p1; i <= p2; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        while (p1 < n) {
            // p1 빼기
            map.put(arr[p1], map.get(arr[p1]) - 1);
            // 값이 0이면 세면 안됨..
            if (map.get(arr[p1]) == 0) {
                map.remove(arr[p1]);
            }
            p1++;

            //p2 더하기
            p2++;
            p2 = p2 % n;
            map.put(arr[p2], map.getOrDefault(arr[p2], 0) + 1);

            map.put(c, map.getOrDefault(c, 0) + 1);
            max = Math.max(max, map.size());
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
}
