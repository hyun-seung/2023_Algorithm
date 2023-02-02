package org.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 공주님_17836 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int N;
    private static int M;
    private static int T;

    private static int[][] map;
    private static boolean[][][] visited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        setBase();

        int result = bfs(0, 0);
        if (result == -1) {
            System.out.println("Fail");
        } else {
            System.out.println(result);
        }
    }

    private static int bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y, 0, false));
        visited[x][y][0] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            if (now.count > T) {
                break;
            }
            if (now.x == N - 1 && now.y == M - 1) {
                return now.count;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (!now.isGram) {
                        if (!visited[nx][ny][0] && map[nx][ny] == 0) {
                            queue.add(new Point(nx, ny, now.count + 1, now.isGram));
                            visited[nx][ny][0] = true;
                        } else if (!visited[nx][ny][0] && map[nx][ny] == 2) {
                            queue.add(new Point(nx, ny, now.count + 1, true));
                            visited[nx][ny][0] = true;
                        }
                    } else {
                        if (!visited[nx][ny][1]) {
                            queue.add(new Point(nx, ny, now.count + 1, now.isGram));
                            visited[nx][ny][1] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }

    private static class Point {
        int x;
        int y;
        int count;
        boolean isGram;

        Point(int x, int y, int count, boolean isGram) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.isGram = isGram;
        }
    }

    private static void setBase() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][M][2];
    }
}
