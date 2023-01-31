package org.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 인구이동_16234 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int N;
    private static int L;
    private static int R;
    private static int[][] map;

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    private static int result;
    private static List<Point> list;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        setBase();

        move();
        System.out.println(result);
    }

    private static void move() {
        while (true) {
            boolean isMove = false;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        int sum = bfs(i, j);
                        if (list.size() > 1) {
                            change(sum);
                            isMove = true;
                        }
                    }
                }
            }
            if (!isMove) {
                return;
            } else {
                result++;
            }
        }
    }

    private static int bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        list = new ArrayList<>();

        queue.add(new Point(x, y));
        list.add(new Point(x, y));
        visited[x][y] = true;

        int sum = map[x][y];
        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
                    int diff = Math.abs(map[now.x][now.y] - map[nx][ny]);
                    if (L <= diff && diff <= R) {
                        queue.add(new Point(nx, ny));
                        list.add(new Point(nx, ny));
                        sum += map[nx][ny];
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return sum;
    }

    private static void change(int sum) {
        int avg = sum / list.size();
        for (Point p : list) {
            map[p.x][p.y] = avg;
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
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        result = 0;
    }
}
