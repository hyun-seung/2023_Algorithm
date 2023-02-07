package org.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 말이되고픈원숭이_1600 {

    private static int K;
    private static int W;   //가로길이
    private static int H;   //세로길이
    private static int[][] map;
    private static boolean[][][] visited;

    private static int[] hdx = {-2, -2, -1, -1, 1, 1, 2, 2};
    private static int[] hdy = {-1, 1, -2, 2, -2, 2, -1, 1};
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        setBase();

        System.out.println(bfs(0, 0));
    }

    private static int bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y, 0, K));
        visited[x][y][K] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if (now.x == H - 1 && now.y == W - 1) {
                return now.count;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < H && ny < W && !visited[nx][ny][now.k] && map[nx][ny] == 0) {
                    visited[nx][ny][now.k] = true;
                    queue.add(new Node(nx, ny, now.count + 1, now.k));
                }
            }

            if (now.k > 0) {
                for (int i = 0; i < 8; i++) {
                    int nx = now.x + hdx[i];
                    int ny = now.y + hdy[i];

                    if (nx >= 0 && ny >= 0 && nx < H && ny < W && !visited[nx][ny][now.k - 1] && map[nx][ny] == 0) {
                        visited[nx][ny][now.k - 1] = true;
                        queue.offer(new Node(nx, ny, now.count + 1, now.k - 1));
                    }
                }
            }
        }
        return -1;
    }

    private static class Node {
        int x;
        int y;
        int count;
        int k;

        Node(int x, int y, int count, int k) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.k = k;
        }
    }

    private static void setBase() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[H][W][K + 1];
    }
}
