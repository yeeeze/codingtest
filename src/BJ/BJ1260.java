package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 그래프는 정점과 간선으로 이루어짐
 * 간선의 연결을 판단하기 위해서 인접행렬 or 인접리스트가 필요함
 */

public class BJ1260 {

    private static int n, m, v;
    private static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    private static int[][] ar = new int[1000][1000];
    private static boolean visited[];

    public static void dfs(int v) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int i = 0; i < arr.get(v).size(); i++) {
            int y = arr.get(v).get(i);
            if (!visited[y]) {
                dfs(y);
            }
        }
    }

    // 행렬 dfs
    public static void ardfs(int v) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int i = 1; i < n + 1; i++) {
            if (ar[v][i] == 1 && !visited[i]) {
                ardfs(i);
            }
        }
    }

    // 행렬 bfs
    public static void arbfs(int v) {
        Queue<Integer> q = new LinkedList<>();

        visited[v] = true;
        q.offer(v);

        while (!q.isEmpty()) {
            int y = q.poll();
            System.out.print(y + " ");

            for (int i = 1; i < n + 1; i++) {
                if (ar[y][i] == 1 && !visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void bfs(int v) {
        Queue<Integer> q = new LinkedList();

        visited[v] = true;
        q.offer(v);

        while (!q.isEmpty()) {
            int y = q.poll();
            System.out.print(y + " ");

            for (int i = 0; i < arr.get(y).size(); i++) {
                int z = arr.get(y).get(i);
                if (!visited[z]) {
                    q.offer(z);
                    visited[z] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];

        // 그래프 인접리스트 초기화
        for (int i = 0; i < n + 1; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 인접 행렬 간선 입력
            ar[a][b] = 1;
            ar[b][a] = 1;

            // 인접 리스트 간선 입력
            arr.get(a).add(b);
            arr.get(b).add(a);
        }

        // 인접 리스트 정렬!!! 작은 것을 먼저 방문
        for (int i = 0; i < arr.size(); i++) {
            Collections.sort(arr.get(i));
        }

        ardfs(v);
        System.out.println();
        Arrays.fill(visited, false);
        arbfs(v);
    }
}