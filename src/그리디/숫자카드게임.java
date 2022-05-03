package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 숫자카드게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[m];
        int[] arhang = new int[n];

        for(int i=0; i < n; i++) {
            String s1 = br.readLine();
            StringTokenizer st1 = new StringTokenizer(s1);
            for(int j=0; j<m; j++) {
                arr[j] = Integer.parseInt(st1.nextToken());
            }
            Arrays.sort(arr);
            arhang[i] = arr[0];
        }

        Arrays.sort(arhang);
        System.out.println(arhang[arhang.length-1]);
    }
}
