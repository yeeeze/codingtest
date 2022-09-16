package BJ;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 조합 재귀함수 부를 때 인자 확인하기........
 * pick(index + 1) 가 아니고 pick(i + 1)................ start index로 계속 부르면 어떡해~~~~~~~~
 */

public class BJ18428 {

    private static int N;
    private static String[][] map;
    private static ArrayList<Node> list = new ArrayList<>();
    private static ArrayList<Node> tea = new ArrayList<>();
    private static int[] dy = {-1, 1, 0, 0};
    private static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        map = new String[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken();
                if (map[i][j].equals("X")) {
                    list.add(new Node(i, j));
                } else if (map[i][j].equals("T")) {
                    tea.add(new Node(i, j));
                }
            }
        }

        if (pick(0, 0)) {
            bw.write("YES");
        } else {
            bw.write("NO");
        }

        bw.flush();
        bw.close();
    }

    public static boolean pick(int index, int cnt) {        // 헷갈리니까 index -> start로 적자
        if (cnt == 3) {
            if (check()) {
                return true;
            }
            return false;
        }

        for (int i = index; i < list.size(); i++) {
            map[list.get(i).y][list.get(i).x] = "O";
            if (pick(i + 1, cnt + 1)) {
                return true;
            } else {
                map[list.get(i).y][list.get(i).x] = "X";
            }
        }

        return false;
    }

    public static boolean check() {
        // 선생님 상하좌우 확인
        for (int i = 0; i < tea.size(); i++) {
            Node teacher = tea.get(i);
            for (int j = 0; j < 4; j++) {
                int ny = teacher.y + dy[j];
                int nx = teacher.x + dx[j];

                while (0 <= ny && ny < N && 0 <= nx && nx < N) {
                    if (map[ny][nx].equals("S")) {
                        return false;       // 학생 찾았다. 감시 못피함 프로그램 종료
                    }
                    if (map[ny][nx].equals("O")) {
                        break;      // 장애물에 막힘. 다음 방향 탐색
                    }

                    ny += dy[j];
                    nx += dx[j];
                }
                }
            }
        return true;        // 모든 선생님 전체 탐색 완료. 감시 피함.
    }

    static class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}

