package org.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFSBFS_1260 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int N;
    private static int M;
    private static int V;
    private static int[][] map;
    private static boolean[] check;

    private static StringBuilder sb = new StringBuilder();
    private static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        setBase();

        check = new boolean[N + 1];
        dfs(V);

        sb.append("\n");
        check = new boolean[N + 1];
        queue.clear();
        bfs(V);

        System.out.println(sb.toString());
    }

    private static void dfs(int start) {
        check[start] = true;
        sb.append(start + " ");

        for (int i = 1; i <= N; i++) {
            if (map[start][i] == 1 && !check[i]) {
                dfs(i);
            }
        }
    }

    private static void bfs(int start) {
        queue.add(start);
        check[start] = true;

        while (!queue.isEmpty()) {
            start = queue.poll();
            sb.append(start + " ");

            for (int i = 1; i <= N; i++) {
                if (map[start][i] == 1 && !check[i]) {
                    check[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    private static void setBase() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
            map[b][a] = 1;
        }
    }
}
