package 그래프이론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 커리큘럼 {

    private static int n;
    private static int[] indegree = new int[501];
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private static int[] times = new int[501];

    public static void sort() {
        Queue<Integer> queue = new LinkedList();
        int[] result = new int[501];

        for (int i = 1; i < n + 1; i++) {
            result[i] = times[i];
        }

        for (int i = 1; i < n + 1; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int i = 0; i < graph.get(now).size(); i++) {
                int x = graph.get(now).get(i);
                indegree[x] -= 1;

                result[x] = Math.max(result[x], result[now] + times[x]);

                if (indegree[x] == 0) {
                    queue.offer(x);
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            System.out.println(result[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            times[i] = time;

            while (true) {
                int a = Integer.parseInt(st.nextToken());
                if (a == -1) {
                    break;
                }
                graph.get(a).add(i);
                indegree[i] += 1;
            }
        }
        sort();
    }
}
