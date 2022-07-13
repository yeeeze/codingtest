package 프로그래머스;

import java.util.*;

class PG92334 {

    public static void main(String[] args) {
        String[] a = {"muzi", "frodo", "apeach", "neo"};
        String[] b = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};

        solution(a, b, 2);
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> users = new HashMap<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Map<String, Integer> reportedUsers = new HashMap<>();
        int[] answer = new int[id_list.length];

        // 유저 인덱스 관리 리스트 입력
        int z = 0;
        for(String s: id_list) {
            users.put(s, z);
            z += 1;
        }

        for(int i = 0; i< id_list.length; i++) {
            list.add(new ArrayList<Integer>());
        }

        // 신고 정보 입력
        for(String s: report) {
            StringTokenizer st = new StringTokenizer(s);
            String reportUser = st.nextToken();
            String reported = st.nextToken();

            // 신고자 - 신고받은자 입력
            int index = users.get(reportUser);
            // 여러번 신고한 경우 제외
            if(!list.get(index).contains(users.get(reported))) {
                list.get(index).add(users.get(reported));

                // 신고 받은 사람 횟수 입력
                int reportedCount = reportedUsers.getOrDefault(reported, 0);
                reportedUsers.put(reported, reportedCount + 1);
            }
        }

        // 회원 정지 체크
        for(String s: reportedUsers.keySet()) {
            if(reportedUsers.get(s) >= k) {
                // 정지, 신고한 유저에게 Mail+1
                // list 전체 완탐
                for(int i = 0; i < list.size(); i++) {
                    for(int j = 0; j < list.get(i).size(); j++) {
                        if(list.get(i).get(j) == users.get(s)) {
                            answer[i] += 1;
                        }
                    }
                }
            }
        }

        return answer;
    }
}
