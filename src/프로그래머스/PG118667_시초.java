package 프로그래머스;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * dfs + 큐로 푸는 문제 아님.......... 투포인터로 하는거임.. ㄱ-
 * 시간초과
 */
public class PG118667_시초 {

    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        int[] a = {1,1};
        int[] b = {1,5};
        System.out.println(solution(a, b));
    }

    public static int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        // 그냥 한번씩 번갈아가면서 옮겨
        // 옮길 때마다 계산해봐

        // -> 아님 !!!!!!!!!!!!
        // 한번씩 번갈아가면서 옮기면 정답이 절대 안 나옴
        // 두 큐의 합을 비교해서 옮겨야함....

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        Long sum1 = 0L;
        Long sum2 = 0L;
        for (int i = 0; i < queue1.length; i++) {
            list.add(queue1[i]);
            list.add(queue2[i]);

            q1.add(queue1[i]);
            sum1 += queue1[i];
            q2.add(queue2[i]);
            sum2 += queue2[i];
        }
        boolean flag = false;
        for (int i = 0; i < list.size(); i++) {
            ArrayList<Integer> peek = new ArrayList<>();
            flag = check(0, 0, i + 1, (sum1 + sum2) / 2, peek);

            if (flag) {
                break;
            }
        }

        if (!flag) {
            return -1;
        }

        while (true) {
            // q1 -> q2
            if(sum1 > sum2){
                int poll1 = q1.poll();
                q2.add(poll1);
                sum1 -= poll1;
                sum2 += poll1;
                answer++;
            }

            if (sum1 == sum2) {
                break;
            }

            // q2 -> q1
            if(sum1 < sum2) {
                int poll2 = q2.poll();
                q1.add(poll2);
                sum1 += poll2;
                sum2 -= poll2;
                answer++;
            }

            if (sum1 == sum2) {
                break;
            }
        }

        return answer;
    }

    private static boolean check(int index, int depth, int n, long l, ArrayList<Integer> peek) {
        if (depth == n) {
            Long sum = 0L;
            for (int i = 0; i < peek.size(); i++) {
//                System.out.print(peek.get(i) + " ");
                sum += peek.get(i);
            }
//            System.out.println();
            if (sum == l) {
                return true;
            } else {
                return false;
            }
        }

        for (int i = index; i < list.size(); i++) {
            peek.add(list.get(i));
            boolean flag = check(i + 1, depth + 1, n, l, peek);
            if (flag) {
                return true;
            }
            peek.remove(depth);
        }

        return false;
    }

}
