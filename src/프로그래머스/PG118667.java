package 프로그래머스;

/**
 * 그리디, 투포인터
 */

public class PG118667 {

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
        // 두 큐의 합을 목표값과 비교해서 옮겨야함....

        // 어떻게 비교?
        // 큐에 넣고 직접 뺐다 더했다 하는게 아니라 투포인터로 범위 조정하면서 움직이는 것

        // 투포인터
        // 범위는.... 총 옮기는 횟수가 최대 합친 배열의 길이(2n) 2배... -> 4n
        // 1 -> 2 다 옮겨봄, 2 -> 1 다 옮겨봄, 1과 2 번갈아가면서 옮겨봄
        // 포인터 2개를 가지고 체크했더니 틀렸음..

        // 1. 배열 2개 하나로 합치기
        Long total = 0L;
        Long sum = 0L;
        int[] arr = new int[queue1.length * 2];
        for (int i = 0; i < queue1.length; i++) {
            sum += queue1[i];
            arr[i] = queue1[i];
            total += queue1[i];
        }
        int index = 0;
        for (int i = queue1.length; i < queue2.length * 2; i++) {
            total += queue2[index];
            arr[i] = queue2[index++];
        }

        int left = 0;
        int right = queue1.length - 1;
        if (total % 2 != 0) {
            return -1;
        }
        total = total / 2;  // 절반 값으로 타켓값 변경

        // 2. 포인터 조정하면서 체크
        // 2개의 포인터가 모두 범위 밖으로 벗어나면 끝내기
        Long count = 0L;
        while (true) {

            if (sum < total) {
                right++;
                right %= arr.length;
                sum += arr[right];
                answer++;
            } else if (sum > total) {
                sum -= arr[left];
                left++;
                left %= arr.length;
                answer++;
            } else {
                break;
            }

            count++;

            if(count > (queue1.length + queue2.length) * 3L) {
                return -1;
            }
        }

        return answer;
    }

}
