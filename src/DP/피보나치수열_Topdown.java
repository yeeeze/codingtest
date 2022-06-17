package DP;

public class 피보나치수열_Topdown {

    private static long[] d = new long[100];

    // 피보나치 함수를 재귀함수로 구현
    public static long fibo(int x) {
        if (x == 1 || x == 2) {
            return 1;
        }

        if (d[x] != 0) {
            return d[x];
        }

        d[x] = fibo(x - 1) + fibo(x - 2);
        return d[x];
    }

    public static void main(String[] args) {
        System.out.println(fibo(50));
    }
}
