package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 큰수의법칙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);

        // n, m, k 공백 기준으로 구분하여 입력 받음
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // n개의 수를 공백 기준으로 구분하여 입력 받아서 배열 생성
        int[] ar = new int[n];
        String arr = br.readLine();
        StringTokenizer st1 = new StringTokenizer(arr);
        int ss=0;
        while (st1.hasMoreTokens()) {
            ar[ss] = Integer.parseInt(st1.nextToken());
            ss++;
        }

        // 배열 정렬
        int tmp;
        for(int i=1; i<ar.length; i++) {
            for(int j=0; j < ar.length-i; j++) {
                if(ar[j] < ar[j+1]) {
                    tmp = ar[j+1];
                    ar[j+1] = ar[j];
                    ar[j] = tmp;
                }
            }
        }

        // 더하기 계산
        int result = 0;
        if(ar[0] == ar[1]) {
            result = ar[0] * m;
        }
        else {
            int cnt = m / k;
            int sum = m % k;
            result = (cnt * ar[0] * k) + (sum * ar[1]);
        }

        System.out.println("큰 수는 : " + result);
    }
}
