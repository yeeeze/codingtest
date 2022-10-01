package 프로그래머스;

import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 뭔가 더 좋은 방법이 있을 것 같은데 문제를 다시 볼 수가 없따 ㅠ^ㅠ
 */
public class 스킬체크_레벨2_2 {

    public static void main(String[] args) {
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
//        System.out.println(s.replaceAll("[{|}]", ""));
        int[] solution = solution(s);
        for (int ss : solution) {
            System.out.println(ss);
        }
    }

    public static int[] solution(String s) {
        // 가장 많이 등장하면 맨앞에
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        s = s.replaceAll("[{|}]", "");

        StringTokenizer st = new StringTokenizer(s, ",");
        while (st.hasMoreTokens()) {
            Integer num = Integer.valueOf(st.nextToken());
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }

        int[] answer = new int[hashMap.size()];
        Object[] keySet = hashMap.keySet().toArray();
        int id = -1;
        for (int k = 0; k < hashMap.size(); k++) {
            int max = -1;
            for (int i = 0; i < keySet.length; i++) {
                if ((int)keySet[i] != 0 && max < hashMap.get(keySet[i])) {
                    max = hashMap.get(keySet[i]);
                    id = i;
                }
            }
            answer[k] = (int) keySet[id];
            keySet[id] = 0;
        }

        return answer;
    }
}
