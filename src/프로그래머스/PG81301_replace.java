package 프로그래머스;

/**
 * string에서 일부분만 바꾸고싶을 때는 replace (문자 그대로 사용), replaceAll (정규식)
 * 문제 조건에 나와있는 것을 그대로 쳐도됨. 의심하지말고 일단 구현
 * zero 부터 nine을 일일히 치는게 맞는지를 고민하고 있었음 ㄱ-
 */
class PG81301_replace {
    public int solution(String s) {

        String[] str = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        int answer = 0;
        int index = 0;
        for(String word: str) {
            s = s.replace(word, String.valueOf(index++));
        }

        answer = Integer.parseInt(s);
        return answer;
    }
}
