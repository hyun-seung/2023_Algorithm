package org.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질_13549 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int N;
    private static int K;

    private static int[] time;

    public static void main(String[] args) throws IOException {
        setBase();

        bfs();
        System.out.println(time[K] - 1);
    }

    private static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(N, 1));
        time[N] = 1;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            if (now.index + 1 >= 0 && now.index + 1 <= 100_000) {
                if (time[now.index + 1] == 0 || time[now.index + 1] > now.time + 1) {
                    time[now.index + 1] = now.time + 1;
                    queue.add(new Point(now.index + 1, now.time + 1));
                }
            }

            if (now.index - 1 >= 0 && now.index - 1 <= 100_000) {
                if (time[now.index - 1] == 0 || time[now.index - 1] > now.time + 1) {
                    time[now.index - 1] = now.time + 1;
                    queue.add(new Point(now.index - 1, now.time + 1));
                }
            }

            if (now.index * 2 >= 0 && now.index * 2 <= 100_000) {
                if (time[now.index * 2] == 0 || time[now.index * 2] > now.time) {
                    time[now.index * 2] = now.time;
                    queue.add(new Point(now.index * 2, now.time));
                }
            }
        }
    }

    private static class Point {
        int index;
        int time;

        Point(int index, int time) {
            this.index = index;
            this.time = time;
        }
    }

    private static void setBase() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        time = new int[100_001];
    }
}
