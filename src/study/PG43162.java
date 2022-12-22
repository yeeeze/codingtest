package study;

public class PG43162 {

    public static void main(String[] args) {
        int[][] arr = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(solution(3, arr));
    }

    public static boolean[] visited;

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                answer++;
                dfs(i, computers);
            }
        }
        return answer;
    }

    public static void dfs(int num, int[][] computers) {
        for (int i = 0; i < computers.length; i++) {
            int next = i;
            // 연결된 곳이고 방문하지 않았으면 간다!
            if (!visited[next] && computers[num][next] == 1) {
                visited[next] = true;
                dfs(next, computers);
            }
        }
    }

    public void d() {

    }
}