package org.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class 최소회의실개수_19598 {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static int N;
    private static List<Time> times = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        setBase();

        System.out.print(solve());
    }

    private static int solve() {
        Collections.sort(times);

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
        int start;
        int end;

        Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time o) {
            if(this.start == o.start) {
                return this.end - o.end;
            }

            return this.start - o.start;
        }
    }

    private static void setBase() throws IOException {
        N = Integer.parseInt(reader.readLine());

        times.clear();
        for (int i = 0; i < N; i++) {
            String input = reader.readLine();
            String[] inputTime = input.split(" ");
            times.add(new Time(Integer.parseInt(inputTime[0]), Integer.parseInt(inputTime[1])));
        }
    }
}
