package study;

import java.util.Arrays;

public class test {
    static boolean[] visited;

    public static void main(String[] args) {
        for (int j = 0; j <= 4; j++) {
            visited = new boolean[4];
            String[] keys = {"1", "2", "3", "4"};
            makeKey(j, 0, keys, 0);
        }
    }

    public static void makeKey(int targetSize, int depth, String[] keys, int index) {
        if (targetSize == depth) {
            String key = Arrays.stream(keys).reduce((a, b) -> a + b).get();
            System.out.println(key);
            return;
        }

        for (int i = index; i < keys.length; i++) {
            if (!visited[i]) {
                String key = keys[i];
                keys[i] = "-";
                visited[i] = true;
                makeKey(targetSize, depth + 1, keys, i + 1);
                keys[i] = key;
                visited[i] = false;
            }
        }
    }
}
