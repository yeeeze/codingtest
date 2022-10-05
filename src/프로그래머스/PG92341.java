package 프로그래머스;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 반례를 못 찾겠다 ㅠㅠㅠㅠㅠㅠㅠㅠㅠ^ㅠㅠㅠㅠㅠㅠㅠㅠㅠ...
 * 56.3 / 100
 */
public class PG92341 {

    public static void main(String[] args) {
//        int[] fees = {120, 0, 60, 591};
//        String[] records = {"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"};

        int[] fees = {60, 10, 59, 1};
        String[] records = {"21:59 1234 IN"};

        int a = 1 / 60;
        int b = (int) Math.ceil(a);         // 0
        int c = (int) Math.ceil(0.06711);   // 1
        double d = Math.ceil(1 / 60);    // 0

        int[] solution = solution(fees, records);
        for (int s : solution) {
            System.out.println(s);
        }
    }

    public static int[] solution(int[] fees, String[] records) {
        // id, Car
        HashMap<String, Car> hashMap = new HashMap<>();
        ArrayList<Car> carArrayList = new ArrayList<>();

        // 1. 차량별 누적 주차 시간을 구한다
        for (int i = 0; i < records.length; i++) {
            StringTokenizer st = new StringTokenizer(records[i]);
            String time = st.nextToken();
            String id = st.nextToken();
            String state = st.nextToken();

            if (!hashMap.containsKey(id)) {
                Car car = new Car(time, id, state);
                hashMap.put(car.id, car);
                carArrayList.add(car);
            } else {
                Car car = hashMap.get(id);
                if (state.equals("IN")) {
                    car.time = time;
                } else {
                    String in[] = car.time.split(":");
                    String out[] = time.split(":");

                    int hour = Integer.parseInt(out[0]) - Integer.parseInt(in[0]);
                    int mini = 0;

                    int outMini = Integer.parseInt(out[1]);
                    int inMini = Integer.parseInt(in[1]);
                    // out - in
                    if (outMini >= inMini) {
                        mini = outMini - inMini;
                    } else {
                        mini = 60 - inMini;
                        hour -= 1;
                    }
                    mini += hour * 60;  // 시간 -> 분 환산
                    car.totaltime += mini;
                }
                car.state = state;
            }
        }

        // Out이 안 찍힌 경우 합산
        for (String key : hashMap.keySet()) {
            Car car = hashMap.get(key);
            if (car.state.equals("IN")) {
                String in[] = car.time.split(":");

                int hour = 23 - Integer.parseInt(in[0]);
                int mini = 0;

                int outMini = 59;
                int inMini = Integer.parseInt(in[1]);
                // out - in
                if (outMini >= inMini) {
                    mini = outMini - inMini;
                } else {
                    mini = 60 - inMini;
                    hour -= 1;
                }
                mini += hour * 60;  // 시간 -> 분 환산
                car.totaltime += mini;
            }
        }

        // 2. 주차요금 계산
        Collections.sort(carArrayList);
        int[] answer = new int[carArrayList.size()];

        for (int i = 0; i < carArrayList.size(); i++) {
            int totalFee = 0;
            if (carArrayList.get(i).totaltime <= fees[0]) {
                totalFee = fees[1];
            } else {
                totalFee = fees[1] + (int)Math.ceil((double) (carArrayList.get(i).totaltime - fees[0]) / fees[2]) * fees[3];
            }
            carArrayList.get(i).fee = totalFee;
            answer[i] = carArrayList.get(i).fee;
        }

        // 3. 차량번호 오름차순으로 결과배열 리턴
        return answer;
    }
}

class Car implements Comparable<Car>{
    String time, id, state;
    int totaltime, fee;

    public Car(String time, String id, String state) {
        this.time = time;
        this.id = id;
        this.state = state;
    }

    @Override
    public int compareTo(Car o) {
        if (Integer.parseInt(this.id) < Integer.parseInt(o.id)) {
            return -1;
        }
        return 1;
    }
}