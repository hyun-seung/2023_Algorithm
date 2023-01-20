package org.burte_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 죽음의비_22944 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static Position player;
    private static int N;
    private static int H;
    private static int D;
    private static int result;

    private static char[][] map;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static int[][] visited;

    public static void main(String[] args) throws IOException {
        setBase();

        bfs();
        System.out.println(result);
    }

    private static void bfs() {
        Queue<Position> queue = new LinkedList<>();
        visited[player.x][player.y] = player.life;
        queue.offer(player);

        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size >= 1) {
                size--;
                Position p = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = p.x + dx[i];
                    int ny = p.y + dy[i];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                        continue;
                    }

                    if (map[nx][ny] == 'E') {
                        result = count + 1;
                        return;
                    }

                    int nu = p.u;
                    int nlife = p.life;
                    if (map[nx][ny] == 'U') {
                        nu = D;
                    }

                    if (nu > 0) {
                        nu--;
                    } else {
                        nlife--;
                    }

                    if (nlife == 0) {
                        continue;
                    }

                    if (visited[nx][ny] < nlife + nu) {
                        visited[nx][ny] = nlife + nu;
                        queue.offer(new Position(nx, ny, nu, nlife));
                    }
                }
            }
            count++;
        }
    }

    private static class Position {
        int x;
        int y;
        int u;
        int life;

        Position(int x, int y, int u, int life) {
            this.x = x;
            this.y = y;
            this.u = u;
            this.life = life;
        }
    }

    private static void setBase() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new char[N][N];
        visited = new int[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'S') {
                    player = new Position(i, j, 0, H);
                }
            }
        }
        result = -1;
    }
}
