package BJ.SDS.DAY03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1202 {
    private static int N, K;
    private static ArrayList<Integer> bag = new ArrayList<>();
    private static ArrayList<Ju> ju = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i <N; i++) {
            st = new StringTokenizer(br.readLine());
            ju.add(new Ju(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        for (int i = 0; i < K; i++) {
            bag.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(bag);
        Collections.sort(ju);

        PriorityQueue<Ju> pq = new PriorityQueue<>(Comparator.comparingInt(Ju::getValue).reversed());

        int juPointer = 0;
        long sum = 0;
        for (int i = 0; i < bag.size(); i++) {
            while (juPointer < N && bag.get(i) >= ju.get(juPointer).getWeight()) {
                    pq.add(ju.get(juPointer++));
            }
            if (!pq.isEmpty()) {
                sum += (long) pq.poll().getValue();
            }
        }

        System.out.println(sum);
    }
}

class Ju implements Comparable<Ju> {
    private int weight;
    private int value;

    public Ju(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(Ju o) {
        return Integer.compare(this.weight, o.weight);
    }
}