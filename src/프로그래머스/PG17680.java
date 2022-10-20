package 프로그래머스;

import java.util.HashMap;
import java.util.Set;

/**
 * 그냥 들어온 순서대로 처리하면 되니까 list로 해도 되는데
 * 너무 복잡하게 생각하고 짠 것 같다
 * list로 짰으면 굳이 반복문 돌면서 탐색 안 하고 0번째 데이터 지워주면 됨..
 *
 * 영어 대소문자를 구분하지않는다!?!?!?
 * string 대문자 <-> 소문자 비교하는 방법
 * equalsIgnoreCase(), compareToIgnoreCase()
 *
 * 아니 애초에 처음부터 모든 문자를 소문자로 바꾸고 시작하면 됨
 * 기준을 맞춰주고 시작하는게 더 좋을 듯
 */
public class PG17680 {

    public static void main(String[] args) {
        System.out.println(solution(3, new String[]{"a","b","c","B","d"}));
    }

    // <이름, 참조 순서>
    private static HashMap<String, Integer> cash = new HashMap<>();

    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;

        for (int i = 0; i < cities.length; i++) {
            // 캐시 hit? miss?
            // 예외 : 캐시 사이즈가 0일 때는 무조건 miss..
            if (cacheSize == 0) {
                answer = cities.length * 5;
                break;
            }

            if (cash.containsKey(cities[i]) || compare(cities[i])) {
                answer += 1;
            } else {
                answer += 5;
                // 캐시가 꽉 찼을 경우 -> LRU 실행
                if (cacheSize == cash.size()) {
                    lru();
                }
            }

            cash.put(cities[i], i);
        }

        return answer;
    }

    private static boolean compare(String city) {
        Set<String> strings = cash.keySet();

        for (String s : strings) {
            if (city.equalsIgnoreCase(s)) {
                // 대소문자 비교해서 똑같은 문자가 있으면 기존 문자는 캐시에서 제거해야함
                cash.remove(s);
                return true;
            }
        }

        return false;
    }

    // 캐시 교체 (가장 오래전에 참조된 데이터 삭제)
    public static void lru() {
        Set<String> strings = cash.keySet();
        int min = Integer.MAX_VALUE;
        String key = null;
        for (String s : strings) {
            if (min > cash.get(s)) {
                min = cash.get(s);
                key = s;
            }
        }

        cash.remove(key);
    }
}
