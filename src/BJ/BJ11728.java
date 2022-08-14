package BJ;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ11728 {

    private static int[] A, B;
    private static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        A = new int[n];
        B = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            result.add(A[i]);
        }

        for (int i = 0; i < m; i++) {
            result.add(B[i]);
        }

        Collections.sort(result);

        for (int a : result) {
            bw.write(a + " ");
        }
        bw.flush();
        bw.close();
    }
}
