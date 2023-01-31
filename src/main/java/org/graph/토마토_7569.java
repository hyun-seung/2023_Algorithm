package org.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토_7569 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int N;
    private static int M;
    private static int H;

    private static int[][][] map;
    private static Queue<Tomato> queue;
    private static int result;

    private static int[] dx = {-1, 1, 0, 0, 0, 0};
    private static int[] dy = {0, 0, -1, 1, 0, 0};
    private static int[] dz = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        setBase();

        bfs();

        if(result == -1) {
            System.out.println(result);
        } else if(result == 1) {
            System.out.println(0);
        } else {
            System.out.println(result - 1);
        }
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            Tomato now = queue.poll();

            int x = now.x;
            int y = now.y;
            int z = now.z;

            for(int i=0; i<6; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                int nz = now.z + dz[i];

                if(nx >= 0 && ny >= 0 && nz >= 0 && nx < N && ny < M && nz < H) {
                    if(map[nz][nx][ny] == 0) {
                        queue.add(new Tomato(nx, ny, nz));
                        map[nz][nx][ny] = map[z][x][y] + 1;
                    }
                }
            }
        }

        for(int i=0; i<H; i++) {
            for(int j=0; j<N; j++) {
                for(int k=0; k<M; k++) {
                    if(map[i][j][k] == 0) {
                        result = -1;
                        return;
                    }
                    result = Math.max(result, map[i][j][k]);
                }
            }
        }
    }

    private static class Tomato {
        int x;
        int y;
        int z;

        Tomato(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    private static void setBase() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][N][M];
        queue = new LinkedList<>();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < M; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if (map[i][j][k] == 1) {
                        queue.add(new Tomato(j, k, i));
                    }
                }
            }
        }
        result = 0;
    }
}
