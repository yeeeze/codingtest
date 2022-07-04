package 최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node2 implements Comparable<Node2> {
    private int index;
    private int distance;

    public Node2(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return index;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(Node2 o) {
        if (this.distance < o.distance) {
            return -1;
        }
        return 1;
    }
}

public class 전보 {

    private static int n, m, c;
    private static ArrayList<ArrayList<Node2>> graph = new ArrayList<>();
    private static int[] d = new int[30000];
    private static int INF = (int) 1e9;

    public static void move(int start) {
        PriorityQueue<Node2> pq = new PriorityQueue();
        d[start] = 0;
        pq.offer(new Node2(start, 0));

        while (!pq.isEmpty()) {
            Node2 n = pq.poll();
            int distance = n.getDistance();
            int index = n.getIndex();

            if (d[index] < distance) {
                continue;
            }

            for (int i = 0; i < graph.get(index).size(); i++) {
                int cost = graph.get(index).get(i).getDistance() + d[index];
                if (cost < d[graph.get(index).get(i).getIndex()]) {
                    d[graph.get(index).get(i).getIndex()] = cost;
                    pq.offer(new Node2(graph.get(index).get(i).getIndex(), cost));
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            graph.get(x).add(new Node2(y, z));
        }

        Arrays.fill(d, INF);

        move(c);

        int cnt = 0;
        int time = 0;
        for (int i = 1; i <= n; i++) {
            if (d[i] != INF) {
                cnt++;
                time = Math.max(d[i], time);
            }
        }

        System.out.println(cnt-1 + " " + time);
    }
}
