package org.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 일루미네이션_5547 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int W;
    private static int H;
    private static int[][] map;
    private static boolean[][] isVisited;

    private static int[][] odd = {{-1, 0}, {0, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}};
    private static int[][] even = {{-1, -1}, {0, -1}, {1, -1}, {1, 0}, {0, 1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        setBase();

        bfs();

        int sum = 0;
        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= W; j++) {
                if (map[i][j] == 0) {
                    continue;
                }
                for (int k = 0; k < 6; k++) {
                    int nx;
                    int ny;
                    if (i % 2 == 0) {
                        nx = i + even[k][0];
                        ny = j + even[k][1];
                    } else {
                        nx = i + odd[k][0];
                        ny = j + odd[k][1];
                    }

                    if (isVisited[nx][ny]) {
                        sum++;
                    }
                }
            }
        }
        System.out.println(sum);
    }

    private static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));
        isVisited[0][0] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            int nx = now.x;
            int ny = now.y;
            for (int i = 0; i < 6; i++) {
                int px;
                int py;
                if (nx % 2 == 0) {
                    px = nx + even[i][0];
                    py = ny + even[i][1];
                } else {
                    px = nx + odd[i][0];
                    py = ny + odd[i][1];
                }

                if (px >= 0 && py >= 0 && px <= H + 1 && py <= W + 1) {
                    if (!isVisited[px][py]) {
                        if (map[px][py] == 0) {
                            isVisited[px][py] = true;
                            queue.add(new Point(px, py));
                        }
                    }
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
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H + 2][W + 2];
        for (int i = 1; i < H + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j < W + 1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        isVisited = new boolean[H + 2][W + 2];
    }
}
