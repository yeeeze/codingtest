package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 바닥공사 {

    private static int x;
    private static int[] d = new int[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        x = Integer.parseInt(br.readLine());

        d[1] = 1;
        d[2] = 3;
        for (int i = 3; i < x; i++) {
            d[i] = (d[i - 1] + d[i - 2] * 2) % 796796;
        }

        System.out.println(d[x]);
    }
}
