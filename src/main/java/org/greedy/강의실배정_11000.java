package org.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class 강의실배정_11000 {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static int N;
    private static List<Time> times = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        setBase();

        System.out.print(solve());
    }

    private static int solve() {
        Collections.sort(times);

        // 낮은 숫자 우선순위인 큐
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(times.get(0).end);
        for (int i = 1; i < N; i++) {
            if(queue.peek() <= times.get(i).start) {
                queue.poll();
            }

            queue.add(times.get(i).end);
        }

        return queue.size();
    }

    private static class Time implements Comparable<Time> {
        private int start;
        private int end;

        Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        // 시작시간 오름차순 (같을 시 종료시간 오름차순)
        @Override
        public int compareTo(Time o) {
            if (this.start == o.start) {
                return this.end - o.end;
            }

            return this.start - o.start;
        }
    }

    private static void setBase() throws IOException {
        N = Integer.parseInt(reader.readLine());

        for (int i = 0; i < N; i++) {
            String input = reader.readLine();
            String[] inputTimes = input.split(" ");
            times.add(new Time(Integer.parseInt(inputTimes[0]), Integer.parseInt(inputTimes[1])));
        }
    }
}
