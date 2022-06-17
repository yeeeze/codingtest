package DP;

/**
 * 중복하여 호출되는 함수가 존재하기 때문에 비효율적이다!
 */
public class 피보나치수열 {

    // 피보나치 함수를 재귀함수로 구현
    public static int fibo(int x) {
        if (x == 1 || x == 2) {
            return 1;
        }

        return fibo(x - 1) + fibo(x - 2);
    }

    public static void main(String[] args) {
        System.out.println(fibo(4));
    }
}
