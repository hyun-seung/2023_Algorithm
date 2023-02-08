package org.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽부수고이동하기_2206 {

    private static int N;
    private static int M;
    private static int[][] map;

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    private static int result;

    public static void main(String[] args) throws IOException {
        setBase();

        bfs();
        System.out.println(result);
    }

    private static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0, 1, false));

        boolean[][][] visited = new boolean[N][M][2];
//        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            if (now.x == N - 1 && now.y == M - 1) {
                result = now.count;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }

                if (map[nx][ny] == 0) {
                    if (!now.destroy && !visited[nx][ny][0]) {
                        queue.add(new Point(nx, ny, now.count + 1, false));
                        visited[nx][ny][0] = true;
                    } else if (now.destroy && !visited[nx][ny][1]) {
                        queue.add(new Point(nx, ny, now.count + 1, true));
                        visited[nx][ny][1] = true;
                    }
                } else if (map[nx][ny] == 1) {
                    if (!now.destroy) {
                        queue.add(new Point(nx, ny, now.count + 1, true));
                        visited[nx][ny][1] = true;
                    }
                }
            }
        }
        result = -1;
    }

    private static class Point {
        int x;
        int y;
        int count;
        boolean destroy;

        Point(int x, int y, int count, boolean destroy) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.destroy = destroy;
        }
    }

    private static void setBase() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        result = 0;
    }
}
