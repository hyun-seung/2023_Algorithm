package org.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 움직이는미로탈출_16954 {

    private static char[][] map;

    private static int[] dx = {0, -1, 0, 1, 0, 1, -1, -1, 1};
    private static int[] dy = {-1, 0, 1, 0, 0, -1, 1, -1, 1};

    public static void main(String[] args) throws IOException {
        setBase();

        if (bfs()) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static boolean bfs() {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited;
        queue.add(new Point(7, 0));

        while (!queue.isEmpty()) {
            int size = queue.size();

            visited = new boolean[8][8];
            for (int i = 0; i < size; i++) {
                Point now = queue.poll();

                if (map[now.x][now.y] == '#') {
                    continue;
                }
                if (now.x == 0 && now.y == 7) {
                    return true;
                }

                for (int k = 0; k < 9; k++) {
                    int nx = now.x + dx[k];
                    int ny = now.y + dy[k];

                    if (nx < 0 || ny < 0 || nx >= 8 || ny >= 8) {
                        continue;
                    }
                    if (visited[nx][ny] || map[nx][ny] == '#') {
                        continue;
                    }

                    queue.add(new Point(nx, ny));
                    visited[nx][ny] = true;
                }
            }

            move();
        }
        return false;
    }

    private static void move() {
        for (int i = 7; i >= 0; i--) {
            for (int j = 0; j < 8; j++) {
                if (map[i][j] == '#') {
                    map[i][j] = '.';

                    if (i != 7) {
                        map[i + 1][j] = '#';
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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[8][8];
        for (int i = 0; i < 8; i++) {
            String line = br.readLine();
            for (int j = 0; j < 8; j++) {
                map[i][j] = line.charAt(j);
            }
        }
    }
}
