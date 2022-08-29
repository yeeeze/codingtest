package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ15686 {

    private static int N, M, result = Integer.MAX_VALUE;
    private static int[][] map;
    private static ArrayList<Node> chicken = new ArrayList<>();
    private static ArrayList<Node> house = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1) {
                    house.add(new Node(i, j));
                }
                if (map[i][j] == 2) {
                    chicken.add(new Node(i, j));
                }
            }
        }

        ArrayList<Node> peekM = new ArrayList<>();
        peek(0, 0, peekM);
        System.out.println(result);
    }

    public static void peek(int cnt, int index, ArrayList<Node> list) {
        if (cnt == M) {
            result = Math.min(distance(list), result);
            return;
        }

        for (int i = index; i < chicken.size(); i++) {
            list.add(chicken.get(i));
            peek(cnt + 1, i + 1, list);
            list.remove(list.size() - 1);
        }
    }

    public static int distance(ArrayList<Node> chickList) {
        int answer = 0;
        for (int i = 0; i < house.size(); i++) {
            int nodeDis = Integer.MAX_VALUE;
            for (int j = 0; j < chickList.size(); j++) {
                nodeDis = Math.min(nodeDis, Math.abs(house.get(i).y - chickList.get(j).y) + Math.abs(house.get(i).x - chickList.get(j).x));
            }
            answer += nodeDis;
        }
        return answer;
    }
}

class Node {
    int y, x;

    public Node(int y, int x) {
        this.y = y;
        this.x = x;
    }
}
