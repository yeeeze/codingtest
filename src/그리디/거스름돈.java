package 그리디;

public class 거스름돈 {
    public static void main(String[] args) {
        int n = 1260;
        int[] coin = {500, 100, 50, 10};
        int result = 0;

        for(int count: coin) {
          result += n/count;
          n %= count;
        }

        System.out.println(result);
    }
}
