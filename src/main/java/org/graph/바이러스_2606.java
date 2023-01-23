package org.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 바이러스_2606 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int N;
    private static int M;
    private static int[][] map;

    private static boolean[] check;
    private static int result;

    public static void main(String[] args) throws IOException {
        setBase();

        bfs(1);
        System.out.println(result);
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        check[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int temp = queue.poll();

            for (int i = 1; i < map.length; i++) {
                if (map[temp][i] == 1 && check[i] == false) {
                    queue.offer(i);
                    check[i] = true;
                    result++;
                }
            }
        }
    }

    private static void setBase() throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        map = new int[N + 1][N + 1];
        check = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
            map[b][a] = 1;
        }
        result = 0;
    }
}
