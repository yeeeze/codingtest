package BJ;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ21608 {

    private static int n;
    private static int[][] arr;
    private static ArrayList<ArrayList<Integer>> like = new ArrayList<>();
    private static int[] dy = {-1, 1, 0, 0};
    private static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        // 학생수 만큼 좋아하는 학생 리스트 생성 (학생수 : n * n명)
        for (int i = 0; i < n * n + 1; i++) {
            like.add(new ArrayList<>());
        }

        for (int i = 0; i < n * n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());
            for (int j = 0; j < 4; j++) {
                like.get(student).add(Integer.parseInt(st.nextToken()));
            }

            int maxLike = -1, maxBlank = -1;
            int stdX = 0, stdY = 0;     // 학생 자리
            // 2차원 배열 순회
            for (int k = 0; k < n; k++) {
                for (int m = 0; m < n; m++) {
                    // 비어있는 칸들에 대하여 상하좌우 확인
                    if (arr[k][m] == 0) {
                        int cntLike = 0;
                        int cntBlank = 0;
                        for (int l = 0; l < 4; l++) {
                            int ny = k + dy[l];
                            int nx = m + dx[l];

                            // 좋아하는 학생 갯수, 비어있는 칸 갯수
                            if (0 <= ny && ny < n && 0 <= nx && nx < n) {
                                if (like.get(student).contains(arr[ny][nx])) {
                                    cntLike++;
                                }

                                if (arr[ny][nx] == 0) {
                                    cntBlank++;
                                }
                            }
                        }

                        if (cntLike > maxLike) {
                            maxLike = cntLike;
                            maxBlank = cntBlank;
                            stdY = k;
                            stdX = m;
                        } else if (cntLike == maxLike) {
                            if (cntBlank > maxBlank) {
                                maxBlank = cntBlank;
                                stdY = k;
                                stdX = m;
                            } else if (cntBlank == maxBlank) {
                                if (stdY > k) {
                                    stdY = k;
                                    stdX = m;
                                } else if (stdY == k) {
                                    if (stdX > m) {
                                        stdY = k;
                                        stdX = m;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            arr[stdY][stdX] = student;
        }

        // 만족도 조사
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result += getScore(i, j);
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    public static int getScore(int i, int j) {
        int result = 0;
        for (int k = 0; k < 4; k++) {
            int ny = i + dy[k];
            int nx = j + dx[k];

            if (0 <= ny && ny < n && 0 <= nx && nx < n) {
                if (like.get(arr[i][j]).contains(arr[ny][nx])) {
                    result++;
                }
            }
        }

        if (result == 0) {
            return 0;
        } else if (result == 1) {
            return 1;
        } else if (result == 2) {
            return 10;
        } else if (result == 3) {
            return 100;
        } else {
            return 1000;
        }
    }
}