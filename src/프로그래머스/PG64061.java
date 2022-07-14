package 프로그래머스;

import java.util.*;

class PG64061 {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack();
        int answer = 0;

        for(int i = 0; i < moves.length; i++) {
            int mx = moves[i];  // 열
            for(int j = 0; j < board.length; j++) {
                if(board[j][mx-1] == 0) {
                    continue;
                }

                int now = board[j][mx-1];
                board[j][mx-1] = 0;

                if(!stack.isEmpty() && now == stack.peek()) {
                    stack.pop();
                    answer += 2;
                } else {
                    stack.push(now);
                }

                break;
            }
        }

        return answer;
    }
}
