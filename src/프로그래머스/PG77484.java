package 프로그래머스;

import java.util.*;

class PG77484 {

    public int rank(int x) {
        switch(x) {
            case 6:
                return 1;
            case 5:
                return 2;
            case 4:
                return 3;
            case 3:
                return 4;
            case 2:
                return 5;
            default:
                return 6;
        }
    }

    public int[] solution(int[] lottos, int[] win_nums) {
        Arrays.sort(lottos);
        Arrays.sort(win_nums);

        int cnt = 0;
        int high = 0;
        int zero = 0;
        for(int i : lottos) {
            if(i == 0) {
                zero += 1;
                continue;
            }
            for(int j : win_nums) {
                if(j > i) {
                    break;
                } else if(i == j) {
                    cnt += 1;
                }
            }
        }

        high = cnt + Math.min(zero, 6 - cnt);

        high = rank(high);
        cnt = rank(cnt);

        // 최고순위와 최저순위
        int[] answer = {high, cnt};
        return answer;
    }
}