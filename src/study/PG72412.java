package study;

import java.util.*;

public class PG72412 {

    private static String[][] querys = {{"cpp", "java", "python", "-"}, {"backend", "frontend", "-"}, {"junior", "senior", "-"}, {"chicken", "pizza", "-"}};
    private static Map<String, List<Integer>> map = new HashMap<>();
    private static boolean[] visited;

    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] q = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};

        int[] solution = solution(info, q);
        for (int s : solution) {
            System.out.println(s);
        }
    }

    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        // 모든 조합 저장
        combination(0, new StringBuilder());

        // map 값 저장
        for (int i = 0; i < info.length; i++) {
            String[] split = info[i].split(" ");

            String[] keys = {split[0], split[1], split[2], split[3]};
            for (int j = 0; j <= 4; j++) {
                visited = new boolean[4];
                makeKey(j, 0, keys, Integer.parseInt(split[4]), 0);
            }
        }

        // 정렬
        Set<String> keys = map.keySet();
        for (String key : keys) {
            Collections.sort(map.get(key));
        }

        // query 검색
        for (int i = 0; i < query.length; i++) {
            String replaceQuery = query[i].replaceAll("and ", "");
            String[] split = replaceQuery.split(" ");

            StringBuilder sb = new StringBuilder();
            String key = sb.append(split[0]).append(split[1]).append(split[2]).append(split[3]).toString();
            int score = Integer.parseInt(split[4]);

            List<Integer> scores = map.get(key);

            if (scores.isEmpty()) {
                answer[i] = 0;
            } else {
                int cnt = scores.size() - search(score, scores);
                answer[i] = cnt;
            }
        }

        return answer;
    }

    public static void makeKey(int targetSize, int depth, String[] keys, int score, int index) {
        if (targetSize == depth) {
            String key = Arrays.stream(keys).reduce((a, b) -> a + b).get();
//            System.out.println(key + " : " + score);
            map.get(key).add(score);
            return;
        }

        for (int i = index; i < keys.length; i++) {
            if (!visited[i]) {
                String key = keys[i];
                keys[i] = "-";
                visited[i] = true;
                makeKey(targetSize, depth + 1, keys, score, i + 1);
                keys[i] = key;
                visited[i] = false;
            }
        }
    }

    // lower : target 이상 값이 처음 나오는 인덱스
    public static int search(int target, List<Integer> scores) {
        // 정답 범위보다 하나 작게 크게 선언해야함
        int start = -1;
        int end = scores.size();

        while (start + 1 < end) {
            int mid = (start + end) / 2;

            if (scores.get(mid) < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return end;
    }

    public static void combination(int depth, StringBuilder key) {
        if (depth == 4) {
            map.put(key.toString(), new ArrayList<>());
            return;
        }

        for (int i = 0; i < querys[depth].length; i++) {
            key.append(querys[depth][i]);
            combination(depth + 1, key);
            key.delete(key.length() - querys[depth][i].length(), key.length());
        }
    }
}
