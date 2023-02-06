package org.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 불_4179 {

    private static int N;
    private static int M;
    private static char[][] map;

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    private static Queue<Point> user;
    private static Queue<Point> fire;
    private static int answer;

    public static void main(String[] args) throws IOException {
        setBase();

        bfs();
        if(answer == -1) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(answer);
        }
    }

    private static void bfs() {
        while (!user.isEmpty()) {
            int size = fire.size();

            for (int i = 0; i < size; i++) {
                Point now = fire.poll();

                for (int k = 0; k < 4; k++) {
                    int nx = now.x + dx[k];
                    int ny = now.y + dy[k];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                        continue;
                    }
                    if (map[nx][ny] == '#' || map[nx][ny] == 'F') {
                        continue;
                    }

                    map[nx][ny] = 'F';
                    fire.add(new Point(nx, ny, now.d + 1));
                }
            }

            size = user.size();
            for (int i = 0; i < size; i++) {
                Point now = user.poll();

                for (int k = 0; k < 4; k++) {
                    int nx = now.x + dx[k];
                    int ny = now.y + dy[k];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                        answer = now.d + 1;
                        return;
                    }

                    if(map[nx][ny] == '#' || map[nx][ny] == 'F' || map[nx][ny] == 'J') {
                        continue;
                    }

                    map[nx][ny] = 'J';
                    user.add(new Point(nx, ny, now.d + 1));
                }
            }
        }
    }

    private static class Point {
        int x;
        int y;
        int d;

        Point(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    private static void setBase() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        user = new LinkedList<>();
        fire = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);

                if (map[i][j] == 'J') {
                    user.add(new Point(i, j, 0));
                } else if (map[i][j] == 'F') {
                    fire.add(new Point(i, j, 0));
                }
            }
        }
        answer = -1;
    }
}
