package BJ.투포인터;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class BJ2075 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (pq.size() == n) {
                    int min = pq.peek();
                    if (num > min) {
                        pq.poll();
                    } else {
                        continue;
                    }
                }
                pq.add(num);
            }
        }

        bw.write(String.valueOf(pq.peek()));
        bw.flush();
        bw.close();
    }
}
