package BJ.SDS;

import java.io.*;
import java.util.*;

/**
 * BJ1202 다시 풀어봄
 */

class jewel implements Comparable<jewel> {
    int weight, value;

    public jewel(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(jewel o) {
        return Integer.compare(this.weight, o.weight);
    }
}

public class test {

    private static int n, k;
    private static ArrayList<Integer> bag = new ArrayList<>();
    private static ArrayList<jewel> juwels = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        // 보석 정보들
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            juwels.add(new jewel(weight, value));
        }

        // 가방 정보
        for (int i = 0; i < k; i++) {
            bag.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(bag);
        Collections.sort(juwels);       // 무게순 정렬

        // 우선순위 큐에 정렬기준은 어떻게 설정하지?? -> pq 생성시에 선언함
        PriorityQueue<jewel> pq = new PriorityQueue<>(Comparator.comparingInt(jewel::getValue).reversed());

        long result = 0;
        int point = 0;
        for (int i = 0; i < k; i++) {
            int bagSize = bag.get(i);

            // 가방 1개마다 보석바구니 전체를 탐색한다 -> 아님!!!!!!!
            // 가방 전체를 돌 때 보석바구니 전체를 한번만 돈다!!!
            while (point < n && juwels.get(point).weight <= bagSize) {
                pq.add(juwels.get(point++));
            }
            if (!pq.isEmpty()) {
                result += pq.poll().value;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
