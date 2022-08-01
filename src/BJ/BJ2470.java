package BJ;

import java.util.*;
import java.io.*;

public class BJ2470 {

    private static int N;
    private static int[] arr, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        result = new int[2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int l = 0, r = N - 1, distance = Integer.MAX_VALUE;
        while(l < r) {
            int sum = arr[l] + arr[r];

            if(distance > Math.abs(sum)) {
                result[0] = arr[l];
                result[1] = arr[r];
                distance = Math.abs(sum);

                if(sum == 0) {
                    break;
                }
            }

            if(sum > 0){
                r--;
            } else if(sum < 0) {
                l++;
            }
        }

        bw.write(result[0] + " " + result[1]);
        bw.flush();
        bw.close();
    }
}
