package org.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 빙산_2573 {

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    private static int N;
    private static int M;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        setBase();

        int answer = 0;
        int count = 0;
        while ((count = separate()) < 2) {
            if (count == 0) {
                answer = 0;
                break;
            }

            melting();
            answer++;
        }

        System.out.println(answer);
    }

    private static int separate() {
        boolean[][] visited = new boolean[N][M];

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    dfs(i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(int x, int y, boolean[][] visited) {
        visited[x][y] = true;

        int nx;
        int ny;
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];

            if (!isInRange(nx, ny)) {
                continue;
            }

            if (map[nx][ny] != 0 && !visited[nx][ny]) {
                dfs(nx, ny, visited);
            }
        }
    }

    private static void melting() {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) {
                    queue.add(new Point(i, j));
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            int sea = 0;

            int nx;
            int ny;
            for (int i = 0; i < 4; i++) {
                nx = now.x + dx[i];
                ny = now.y + dy[i];

                if (!isInRange(nx, ny)) {
                    continue;
                }

                if (!visited[nx][ny] && map[nx][ny] == 0) {
                    sea++;
                }
            }

            if (map[now.x][now.y] - sea < 0) {
                map[now.x][now.y] = 0;
            } else {
                map[now.x][now.y] -= sea;
            }
        }
    }

    private static boolean isInRange(int x, int y) {
        if (x < 0 || y < 0 || x >= N || y >= M) {
            return false;
        }
        return true;
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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
