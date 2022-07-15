package 프로그래머스;

import java.util.Arrays;
import java.util.HashMap;

/**
 * string 비교시에 == 쓰면 오류남!!!!!!!!!!!!!!
 * 무 조 건 string.equals()
 */

class PG42576 {

    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);       // O(nlogn)
        Arrays.sort(completion);        // O(nlogn)

        String answer = "";
        for(int i = 0; i < completion.length; i++) {    // O(n)
            if(!participant[i].equals(completion[i])) {
                answer = participant[i];
                break;
            }
        }

        if(answer.equals("")) {
            answer = participant[participant.length-1];
        }

        return answer;
    }

    public String solutionHash(String[] participant, String[] completion) {
        HashMap<String, Integer> user = new HashMap<>();

        for (String p : participant) {
            user.put(p, user.getOrDefault(p, 0) + 1);
        }

        for (String p : completion) {
            user.put(p, user.get(p) - 1);
        }

        String answer = "";
        for (String key : user.keySet()) {
            if (user.get(key) != 0) {
                answer = key;
            }
        }
        return answer;
    }
}