package BJ;


import java.io.*;
import java.util.*;

/**
 * 각 알파벳을 0~9 숫자 중 하나로 바꾼다.
 * 자릿수가 큰 알파벳 순으로 할당해준다. : 가장 좋은 것(자릿수가 큰)부터 선택하는 그리디
 *
 * 자바 제곱수 구하기 -> Math.pow()
 */
public class BJ1339 {

    private static Map<Integer, Integer> map = new HashMap<>();
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        // 자릿수 계산
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            for (int j = 0; j < word.length(); j++) {
                int num = map.getOrDefault(word.charAt(j) - 'A', 0);
                map.put(word.charAt(j) - 'A', num + (int) Math.pow(10, word.length() - 1 - j));
            }
        }

        List<Integer> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList, Comparator.comparingInt(o -> map.get(o)));  // 오름차순
        // 정렬 기준 없으면 에러남

        int result = 0;
        int num = 10 - map.size();  // 최솟값부터 할당
        for (int key : keyList) {
            result += map.get(key) * num;
            num++;
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
