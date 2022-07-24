package BJ.SDS.DAY02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2003 {

    // 슬라이딩 윈도우, 투포인터
    // low, high를 일정한 조건으로 뽑아낼 수 있을 때 사용 -> sum과 비교하여서 범위를 움직인다.

    private static int N, M, result;
    private static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N + 1];          // high가 배열에서 넘어가는 부분까지 체크하기 위해서 1개 더 선언했음....!!!!!!!!!! index 에러 안 나게 하려고
        result = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int low = 0, high = 0, sum = nums[0];
        while (true) {
            if (sum < M) {
                high++;
                sum += nums[high];
            } else if (sum > M) {
                sum -= nums[low];
                low++;
            } else {    // sum == M -> 정답 처리, low ++
                result++;
                sum -= nums[low];
                low++;
            }

            if (high == N) {
                break;
            }
        }

        // low == high -> 같아도 중복으로 더해지는게 아니라 범위로 가고 있기 때문에 해당 배열값 1개만 result로 입력됨
        System.out.println(result);
    }
}
