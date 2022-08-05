package BJ.SDS.DAY01.DFS;

import java.io.*;
import java.util.*;

public class BJ1039 {

    /**
     * 각 자릿수 숫자가 중복값이 있을 수도 있음 -> set, map 활용하여 푸는 문제 X
     * <p>
     * 최댓값을 구하는 논리로 접근하는게 아니라
     * 연산을 무조건 K번 실행하는게 중요한 것
     * 최소 경우로 최고의 효율을 구하는 문제가 아니라, 기본적으로 K번 모두 실행해봐야 값을 알 수 있는 완탐 문제
     * 단계(깊이) 순서로 퍼져나가면서 경우의 수를 체크하기 때문에 BFS
     * 단순 BFS로 완탐 실행하면 시간초과 발생 (7c2 -> 21 ^10 -> 100억....)
     * -> 메모제이션을 통해 가지치기 필요
     * -> 몇번 실행했는지 깊이를 알아야하기 때문에 2차원 배열로 선언 dp[깊이][숫자]
     */

    private static boolean[][] visited = new boolean[11][1000001]; // 깊이, 숫자

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String numbers = st.nextToken();
        int k = Integer.parseInt(st.nextToken());

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, Integer.parseInt(numbers)));
        visited[0][Integer.parseInt(numbers)] = true;

        int max = -1;
        while (!queue.isEmpty()) {
            Node now = queue.poll();

            // 연산을 K번까지 실행
            if (now.depth == k) {
                max = Math.max(max, now.num);   // k번 실행했을 때만 max값 후보
                continue;
            }

            // 2개 숫자 조합 (n - 1 까지만 방문해야함)
            for (int i = 0; i < numbers.length() - 1; i++) {
                for (int j = i + 1; j < numbers.length(); j++) {
                    int next = swap(i, j, now.num);

                    if (next != -1 && !visited[now.depth + 1][next]) {
                            queue.add(new Node(now.depth + 1, next));
                            visited[now.depth + 1][next] = true;
                    }
                }
            }
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }

    public static int swap(int i, int j, int num) {
        char[] numArr = String.valueOf(num).toCharArray();

        if (i == 0 && numArr[j] == '0') {
            return -1;
        }
        char temp = numArr[i];
        numArr[i] = numArr[j];
        numArr[j] = temp;

        return Integer.parseInt(new String(numArr));
    }

    static class Node {
        int depth;
        int num;

        public Node(int depth, int num) {
            this.depth = depth;
            this.num = num;
        }
    }
}
