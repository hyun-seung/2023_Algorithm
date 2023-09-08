package org.implementation;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 호텔대실 {
    public int solution(String[][] book_time) {
        int[][] times = new int[book_time.length][2];

        for(int i=0; i<book_time.length; i++) {
            int start = getTime(book_time[i][0]);
            int end = getTime(book_time[i][1]);
            end += 10;

            times[i][0] = start;
            times[i][1] = end;
        }

        Arrays.sort(times, (a, b) -> {
            if (a[0] > b[0]) {
                return 1;
            } else if (a[0] == b[0]) {
                if (a[0] > b[0]) {
                    return 1;
                }
            }
            return -1;
        });

        PriorityQueue<Integer> rooms = new PriorityQueue<>();

        for (int[] time : times) {
            if (rooms.size() == 0) {
                rooms.add(time[1]);
                continue;
            }

            int lastRoom = rooms.peek();
            if (time[0] >= lastRoom) {
                rooms.poll();
                rooms.add(time[1]);
            } else {
                rooms.add(time[1]);
            }
        }

        return rooms.size();
    }

    public int getTime(String s) {
        String[] ss = s.split(":");

        int h = Integer.parseInt(ss[0]);
        int m = Integer.parseInt(ss[1]);

        return (h * 60) + m;
    }
}
