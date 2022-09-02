package BJ;

import java.io.*;

/**
 * 구현, 재귀
 */
public class BJ16719 {

    private static char[] arr;
    private static boolean[] check;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = br.readLine();
        arr = new char[word.length()];
        check = new boolean[arr.length];
        for (int i = 0; i < word.length(); i++) {
            arr[i] = word.charAt(i);
        }

        sort(0, arr.length - 1);
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }

    public static void sort(int start, int end) {
        if (start > end) {
            return;
        }

        int smallIndex = start;
        for (int i = start; i <= end; i++) {
            if (!check[i] && arr[smallIndex] > arr[i]) {
                smallIndex = i;
            }
        }

        check[smallIndex] = true;
        sb.append(print() + "\n");

        sort(smallIndex + 1, end);
        sort(start, smallIndex - 1);
    }

    public static String print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < check.length; i++) {
            if (check[i]) {
                sb.append(arr[i]);
            }
        }
        return String.valueOf(sb);
    }
}
