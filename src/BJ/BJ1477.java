package BJ;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1477 {

    private static int N, M, L;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        arr = new int[N + 2];
        arr[0] = 0;
        arr[N + 1] = L;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        bw.write(String.valueOf(search(1, L)));
        bw.flush();
        bw.close();
    }

    public static int search(int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            int cnt = count(mid);

            if (cnt <= M) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    // 더 짓는 갯수
    public static int count(int distance) {
        int answer = 0;
        int length = 0;
        for (int i = 1; i < arr.length; i++) {
            if (distance < arr[i] - length) {
                answer++;
                length += distance;
                i--;
            } else {
                length = arr[i];
            }
        }
        return answer;
    }


    /**
     * 범위 내에서 간격 x로 몇개 설치? 인지 갯수를 세는 거니까
     * 전체 범위 / distance 해주면 됨.....
     */
    public static int count1(int distance) {
        int answer = 0;
        for (int i = 1; i < arr.length; i++) {
            answer += (arr[i] - arr[i - 1] - 1) / distance;
        }

        return answer;
    }
}
