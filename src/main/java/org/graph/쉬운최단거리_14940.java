package org.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 쉬운최단거리_14940 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int N;
    private static int M;
    private static int[][] map;
    private static int[][] result;
    private static boolean[][] visited;

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    private static int startX;
    private static int startY;

    public static void main(String[] args) throws IOException {
        setBase();

        bfs(startX, startY);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    sb.append(-1 + " ");
                } else {
                    sb.append(result[i][j] + " ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M) {
                    if (map[nextX][nextY] == 0 || visited[nextX][nextY]) {
                        continue;
                    }

                    queue.add(new Point(nextX, nextY));
                    result[nextX][nextY] = result[current.x][current.y] + 1;
                    visited[nextX][nextY] = true;
                }
            }
        }
    }

//    private static void bfs(int x, int y) {
//        Queue<Point> queue = new LinkedList<>();
//        queue.add(new Point(x, y));
//        visited[x][y] = true;
//
//        while (!queue.isEmpty()) {
//            Point current = queue.poll();
//
//            for (int i = 0; i < 4; i++) {
//                int nextX = current.x + dx[i];
//                int nextY = current.y + dy[i];
//
//                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
//                if (map[nextX][nextY] == 0) continue;
//                if (visited[nextX][nextY]) continue;
//
//                queue.add(new Point(nextX, nextY));
//                result[nextX][nextY] = result[current.x][current.y] + 1; // 거리는 이전 지점으로부터 +1
//                visited[nextX][nextY] = true;
//            }
//        }
//    }

    private static class Point {
        public int x;
        public int y;

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
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                int temp = Integer.parseInt(st.nextToken());
                map[i][j] = temp;
                if (temp == 2) {
                    startX = i;
                    startY = j;
                }
            }
        }

        result = new int[N][M];
        visited = new boolean[N][M];
    }
}
