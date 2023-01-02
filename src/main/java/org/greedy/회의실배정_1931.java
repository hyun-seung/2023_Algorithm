package org.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 회의실배정_1931 {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static int N;
    private static List<Time> times = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        setBase();

        System.out.print(solve());
    }

    private static int solve() {
        int result = 0;

        Collections.sort(times);

        int lastEndTime = 0;
        for (int i = 0; i < N; i++) {
            if(lastEndTime <= times.get(i).start) {
                lastEndTime = times.get(i).end;
                result++;
            }
        }

        return result;
    }

    private static class Time implements Comparable<Time> {
        public int start;
        public int end;

        Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        // 종료시간 오름차순 정렬 (종료시간 같을 시 시작시간 오름차순)
        @Override
        public int compareTo(Time o) {
            if (o.end == this.end) {
                return this.start - o.start;
            }

            return this.end - o.end;
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
