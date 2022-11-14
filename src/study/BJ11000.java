package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ11000 {

    /**
     * 시간이 같을 때를 생각해보면....
     * 끝난 강의를 먼저 -1 빼줘야
     * 새로운 강의가 기존의 강의실에 그대로!!! 들어갈 수 있다 +1
     *
     * 그래서 isStart 기준으로도 정렬이 필요함
     * 안그러면 새로운 강의실에 +1 해준 값이 Max에 카운트가 되버리니까....!!!!!!!!
     */
    static class Time implements Comparable<Time>{
        int time;
        boolean isStart;

        public Time(int time, boolean isStart) {
            this.time = time;
            this.isStart = isStart;
        }

        @Override
        public int compareTo(Time o) {
            if (this.time == o.time) {
                return this.isStart ? 1 : -1;       // 여기가 포인트
            }
            return this.time - o.time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Time[] times = new Time[n * 2];

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            times[cnt++] = new Time(Integer.parseInt(st.nextToken()), true);
            times[cnt++] = new Time(Integer.parseInt(st.nextToken()), false);
        }

        Arrays.sort(times);

        int answer = Integer.MIN_VALUE;
        int c = 0;
        for (int i = 0; i < times.length; i++) {
            if (times[i].isStart) {
                c++;
            } else {
                c--;
            }
            answer = Math.max(answer, c);
        }

        System.out.println(answer);
    }


    public static void min(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Course[] courses = new Course[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            courses[i] = new Course(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(courses);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(courses[0].end);
        int i = 1;
        int cnt = 1;
        while (i < n) {
            if (!pq.isEmpty() && pq.peek() <= courses[i].start) {
                pq.poll();
            } else {
                cnt++;
            }

            pq.add(courses[i].end);
            i++;
        }

        System.out.println(cnt);
    }

    static class Course implements Comparable<Course> {
        int start, end;

        public Course(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Course o) {
            return this.start - o.start;
        }
    }
}
