package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 정수삼각형 {

    private static int sum, n;
    private static ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            triangle.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                triangle.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        sum = triangle.get(0).get(0);
        int index = 0;
        for (int i = 0; i < n - 1; i++) {
            int sameId = triangle.get(i + 1).get(index);
            int nextId = triangle.get(i + 1).get(index + 1);
            if (sameId < nextId) {
                sum += nextId;
                index++;
            } else {
                sum += sameId;
            }
        }

        System.out.println(sum);

    }
}
