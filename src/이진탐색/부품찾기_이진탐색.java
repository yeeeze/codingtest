package 이진탐색;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Arrays;

/**
 * 이진탐색의 전제 조건 : 정렬!!!
 */
public class 부품찾기_이진탐색 {

    public static boolean binarySearch(int[] arr, int start, int end, int target) {
        if (start > end) {
            return false;
        }

        int mid = (start + end) / 2;
        if (target > arr[mid]) {
            return binarySearch(arr, mid + 1, end, target);
        } else if (target < arr[mid]) {
            return binarySearch(arr, start, mid - 1, target);
        } else {
            return true;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 이진 탐색 하기 전에 정렬함
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int j = 0; j < m; j++) {
            boolean result = binarySearch(arr, 0, arr.length - 1, Integer.parseInt(st.nextToken()));
            if (result == true) {
                System.out.print("yes ");
            } else {
                System.out.print("no ");
            }
        }
    }
}

