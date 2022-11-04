package 프로그래머스;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * 1. course 반복문 안에서 주문마다 발생할 수 있는 조합을 뽑는다. course의 갯수 == 조합 갯수 (알파벳 2개부터 가능)
 * 2. 가장 많이 나온 조합을 정답으로 추가한다.
 */

public class PG72411 {

    public static void main(String[] args) {
        String[] solution = solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4});

        for (String s : solution) {
            System.out.println(s);
        }
    }

    private static HashMap<String, Integer> map = new HashMap();

    public static String[] solution(String[] orders, int[] course) {
        String[] answer = {};

        ArrayList<String> list = new ArrayList<>();

        // 정렬
        for (int i = 0; i < orders.length; i++) {
            char[] chars = orders[i].toCharArray();
            Arrays.sort(chars);
            orders[i] = new String(chars);
        }

        for (int i = 0; i < course.length; i++) {
            for (int j = 0; j < orders.length; j++) {
                peek(orders[j], 0, course[i], 0, "");
            }

            int max = Integer.MIN_VALUE;
            String maxKey = "";
            for (String key : map.keySet()) {
                if (max < map.get(key) && map.get(key) > 1) {
                    max = map.get(key);
                    maxKey = key;
                }
            }
            if (maxKey != "") {
                list.add(maxKey);
            }

            for (String key : map.keySet()) {
                if (!list.contains(key) && max == map.get(key) && map.get(key) > 1) {
                    list.add(key);
                }
            }

            map.clear();
        }

        Collections.sort(list);
        answer = list.toArray(new String[0]);
        return answer;
    }

    // 조합
    public static void peek(String menu, int cnt, int size, int index, String peekMenu) {
        if (cnt == size) {
            map.put(peekMenu, map.getOrDefault(peekMenu, 0) + 1);
            return;
        }

        for (int i = index; i < menu.length(); i++) {
            peek(menu, cnt + 1, size, i + 1, peekMenu + menu.charAt(i));
        }
    }

}
