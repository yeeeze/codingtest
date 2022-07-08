package 그래프이론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 간선들을 정렬하고, 모든 간선을 확인하면서 사이클이 없는 경우에만 같은 집합 (union)
 * 2개의 최소신장트리 만드는법 : 하나의 최소신장트리에서 가장 큰 비용의 간선을 제거한다.
 */

class Edge1 implements Comparable<Edge1> {
    private int nodeA;
    private int nodeB;
    private int cost;

    public Edge1(int cost, int nodeA, int nodeB) {
        this.nodeA = nodeA;
        this.nodeB = nodeB;
        this.cost = cost;
    }

    public int getNodeA() {
        return nodeA;
    }

    public int getNodeB() {
        return nodeB;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public int compareTo(Edge1 o) {
        if (this.cost < o.cost) {
            return -1;
        }
        return 1;
    }
}

public class 도시분할계획 {

    private static int n, m, result;
    private static ArrayList<Edge1> edge1s = new ArrayList<>();
    private static int[] parents = new int[100001];

    public static void union(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if (a < b) {
            parents[b] = a;
        } else {
            parents[a] = b;
        }
    }

    public static int findParent(int x) {
        if (parents[x] == x) {
            return x;
        }

        return parents[x] = findParent(parents[x]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 간선 정보 입력
        for (int i = 0; i < m; i++) {
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edge1s.add(new Edge1(c, a, b));
        }

        // 부모 테이블 초기화
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        // 정렬
        Collections.sort(edge1s);
        int last = 0;

        // 사이클이 없으면 집합에 포함
        for (int i = 0; i < edge1s.size(); i++) {
            int cost = edge1s.get(i).getCost();
            int a = edge1s.get(i).getNodeA();
            int b = edge1s.get(i).getNodeB();

            if (findParent(a) != findParent(b)) {
                result += cost;
                last = cost;
                union(a, b);
            }
        }

        System.out.println(result - last);
    }
}
