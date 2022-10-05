package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 삼성 구현
 */
public class BJ21611 {

    private static int n, m, count, result;
    private static int[][] map;
    private static int[] dy = {-1, 1, 0, 0};
    private static int[] dx = {0, 0, -1, 1};

//    public static void print() {
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 블리자드 마법 시전 (m번)
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            int ny = n / 2;
            int nx = n / 2;

            for (int j = 0; j < s; j++) {
                ny += dy[d - 1];
                nx += dx[d - 1];

                // 구슬 파괴
                if (0 <= ny && ny < n && 0 <= nx && nx < n) {
                    map[ny][nx] = -1;
                } else {
                    break;
                }
            }

            // 빈칸 구슬 이동
            move();

            // 구슬 폭발
            while (explosion()) {
                move();
            }

            // 구슬 변화
            change();
        }

        System.out.println(result);
    }

    private static void change() {
        ArrayList<Integer> changeMap = new ArrayList<>();
        int py = n / 2, px = n / 2;     // 이전 구슬
        int ny = n / 2, nx = n / 2;     // 현재 구슬
        int cnt = 1;    // 이동하는 칸 수
        int d = 0;  // 이동 방향
        int c = -1; // 그룹에 들어있는 구슬의 개수
        boolean flag = false;

        int[] my = {0, 1, 0, -1};
        int[] mx = {-1, 0, 1, 0};
        while (true) {

            for (int i = 0; i < 2; i++) {   // n칸을 2번 이동
                for (int j = 0; j < cnt; j++) {
                    ny += my[d % 4];
                    nx += mx[d % 4];

                    // 다 돌았으면 끝!
                    if (ny < 0 || nx < 0) {
                        flag = true;
                        break;
                    }

                    c++;
                    if (map[ny][nx] != map[py][px] && map[py][px] != 0) {
                        changeMap.add(c);
                        changeMap.add(map[py][px]);
                        c = 0;
                    }

                    py = ny;
                    px = nx;
                }
                d += 1;

                if (flag) {
                    break;
                }
            }
            cnt += 1;

            if (flag) {
                break;
            }
        }

        // 새로운 구슬로 변화시키기
        ny = n / 2; nx = n / 2;     // 현재 구슬
        cnt = 1;    // 이동하는 칸 수
        d = 0;  // 이동 방향
        int size = 0;
        flag = false;
        while (true) {
            for (int j = 0; j < 2; j++) {   // n칸을 2번 이동
                for (int k = 0; k < cnt; k++) {
                    ny += my[d % 4];
                    nx += mx[d % 4];

                    // 다 돌았으면 끝!
                    if (size == changeMap.size() || ny < 0 || nx < 0) {
                        return;
                    }

                    map[ny][nx] = changeMap.get(size);

                    size++;
                }
                d += 1;
            }
            cnt += 1;
        }
    }

    public static void move() {
        int ny = n / 2, nx = n / 2;     // 현재 구슬
        int py = n / 2, px = n / 2;     // 이전 구슬
        boolean flag = false;   // 옮길 구슬 존재 여부
        int cnt = 1;    // 이동하는 칸 수
        int d = 0;  // 이동 방향
        boolean stop = false;

        int[] my = {0, 1, 0, -1};
        int[] mx = {-1, 0, 1, 0};
        while (true) {

            for (int i = 0; i < 2; i++) {   // n칸을 2번 이동
                for (int j = 0; j < cnt; j++) {
                    ny += my[d % 4];
                    nx += mx[d % 4];

                    // 다 돌았으면 끝!
                    if (ny < 0 || nx < 0) {
                        stop = true;
                        break;
                    }

                    if (flag) {
                        map[py][px] = map[ny][nx];
                    }

                    // 파괴된 구슬 발견
                    if (map[ny][nx] == -1) {
                        // 이전 구슬 자리에 넣어놓고 다음 턴에 옮김
                        flag = true;
                    }

                    py = ny;
                    px = nx;
                }
                d += 1;

                if (stop) {
                    break;
                }
            }
            cnt += 1;

            if (stop) {
                // 더이상 파괴된 구슬이 없다면
                if (getEmptyCnt() == 0) {
                    break;
                } else {
                    // 초기화 후 while문 다시 실행
                    ny = n / 2; nx = n / 2;     // 현재 구슬
                    py = n / 2; px = n / 2;     // 이전 구슬
                    flag = false;   // 옮길 구슬 존재 여부
                    cnt = 1;    // 이동하는 칸 수
                    d = 0;  // 이동 방향
                    stop = false;
                }
            }
        }
    }

    public static int getEmptyCnt() {
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == -1) {
                    result++;
                }
            }
        }
        return result;
    }

    public static boolean explosion() {
        ArrayList<Node1> go = new ArrayList<>();
        int ny = n / 2, nx = n / 2;     // 현재 구슬
        int py = n / 2, px = n / 2;     // 이전 구슬
        boolean flag = false;
        boolean isExplosioned = false;
        int cnt = 1;    // 이동하는 칸 수
        int d = 0;  // 이동 방향
        int same = 1;

        int[] my = {0, 1, 0, -1};
        int[] mx = {-1, 0, 1, 0};
        while (true) {

            for (int i = 0; i < 2; i++) {   // n칸을 2번 이동
                for (int j = 0; j < cnt; j++) {
                    ny += my[d % 4];
                    nx += mx[d % 4];

                    // 다 돌았으면 끝!
                    if (ny < 0 || nx < 0) {
                        flag = true;
                        break;
                    }

                    if (map[ny][nx] == map[py][px]) {
                        same++;
                    } else {
                        // 폭발
                        if (same >= 4) {
                            int num = map[go.get(0).y][go.get(0).x];
                            result += num * go.size();
                            for (int k = 0; k < go.size(); k++) {
                                map[go.get(k).y][go.get(k).x] = -1;
                            }
                            isExplosioned = true;
                        }
                        same = 1;
                        go.clear();
                    }
                    go.add(new Node1(ny, nx));
                    py = ny;
                    px = nx;
                }
                d += 1;

                if (flag) {
                    break;
                }
            }
            cnt += 1;

            if (flag) {
                break;
            }
        }
        return isExplosioned;
    }
}

class Node1 {
    int y, x;

    public Node1(int y, int x) {
        this.y = y;
        this.x = x;
    }
}