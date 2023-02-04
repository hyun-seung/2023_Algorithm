package org.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 치즈_2636 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int N;
    private static int M;
    private static int[][] map;

    private static boolean[][] visited;

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    private static int cheese;

    public static void main(String[] args) throws IOException {
        setBase();

        int count = 0;
        int time = 0;
        while (cheese != 0) {
            time++;
            count = cheese;
            melting();
        }

        System.out.println(time);
        System.out.println(count);
    }


    private static void melting() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));

        visited = new boolean[N][M];
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny]) {
                    if (map[nx][ny] == 1) {
                        cheese--;
                        map[nx][ny] = 0;
                    } else if (map[nx][ny] == 0) {
                        queue.add(new Point(nx, ny));
                    }
                    visited[nx][ny] = true;
                }
            }
        }
    }

    private static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void setBase() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        cheese = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    cheese++;
                }
            }
        }
    }
}
