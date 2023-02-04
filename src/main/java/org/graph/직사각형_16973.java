package org.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 직사각형_16973 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int N;
    private static int M;
    private static int[][] map;
    private static boolean[][] visited;

    private static int H;
    private static int W;
    private static int sx;
    private static int sy;
    private static int fx;
    private static int fy;

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    private static List<Point> list;
    private static int result;

    public static void main(String[] args) throws IOException {
        setBase();

        bfs();

        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

    private static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        visited[sx][sy] = true;
        queue.add(new Point(sx, sy, 0));

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            if (now.x == fx && now.y == fy) {
                result = Math.min(result, now.count);
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 1 || ny < 1 || nx > N || ny > M || visited[nx][ny]) {
                    continue;
                }
                if (!isOk(nx, ny)) {
                    continue;
                }
                visited[nx][ny] = true;
                queue.add(new Point(nx, ny, now.count + 1));
            }
        }
    }

    private static boolean isOk(int x, int y) {
        if (x + H - 1 > N || y + W - 1 > M) {
            return false;
        }

        // 벽과 마주치지 않는지 확인
        for (int i = 0; i < list.size(); i++) {
            Point now = list.get(i);

            int nx = now.x;
            int ny = now.y;

            if (nx >= x && nx <= x + H - 1 && ny >= y && ny <= y + W - 1) {
                return false;
            }
        }
        return true;
    }

    private static class Point {
        int x;
        int y;
        int count;

        Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    private static void setBase() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    list.add(new Point(i, j ,0));
                }
            }
        }
        visited = new boolean[N + 1][M + 1];

        st = new StringTokenizer(br.readLine(), " ");
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        sx = Integer.parseInt(st.nextToken());
        sy = Integer.parseInt(st.nextToken());
        fx = Integer.parseInt(st.nextToken());
        fy = Integer.parseInt(st.nextToken());

        result = Integer.MAX_VALUE;
    }
}
