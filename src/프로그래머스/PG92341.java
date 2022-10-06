package 프로그래머스;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 반례를 못 찾겠다 ㅠㅠㅠㅠㅠㅠㅠㅠㅠ^ㅠㅠㅠㅠㅠㅠㅠㅠㅠ...
 * 56.3 / 100
 *
 * 토탈 시간 계산하는 방식이 틀렸었음. 시간을 처음부터 모두 '분'단위로 환산하여 저장했더니 맞았음. (시 * 60)
 * 올림처리할 때 int, double 처리 주의 (0.067 -> 1 이 되야되는데 int로 하면 0으로 들어가서 0이 리턴됨)
 */
public class PG92341 {

    public static void main(String[] args) {
        int[] fees = {120, 0, 60, 591};
        String[] records = {"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"};
//
//        int[] fees = {60, 10, 59, 1};
//        String[] records = {"21:59 1234 IN"};

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
            String t[] = time.split(":");
            int nowTime = Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);

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
                    int inTime = Integer.parseInt(in[0]) * 60 + Integer.parseInt(in[1]);

                    car.totaltime += nowTime - inTime;
                }
                car.state = state;
            }
        }

        // Out이 안 찍힌 경우 합산
        for (String key : hashMap.keySet()) {
            Car car = hashMap.get(key);
            if (car.state.equals("IN")) {
                String in[] = car.time.split(":");
                int inTime = Integer.parseInt(in[0]) * 60 + Integer.parseInt(in[1]);

                car.totaltime += 1439 - inTime;     // 23:59 -> 1439분
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