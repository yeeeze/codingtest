package BJ;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2110 {

    private static int N, C;
    private static int[] house;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        house = new int[N];
        for (int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);

        bw.write(String.valueOf(search(1, house[house.length - 1] - house[0])));
        bw.flush();
        bw.close();
    }

    public static int search(int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            int cnt = count(mid);

            if (C <= cnt) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start - 1;
    }

    public static int count(int pivot) {
        int answer = 1; // 첫번째는 무조건 설치
        int point = 0;
        for (int i = 1; i < house.length; i++) {
            // 설정한 최대 거리보다 간격이 같거나 크면 설치
            if (pivot <= house[i] - house[point]) {
                point = i;
                answer++;
            }
        }

        return answer;
    }
}
