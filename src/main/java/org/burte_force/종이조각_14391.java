package org.burte_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 종이조각_14391 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int N;   //세로크기
    private static int M;   //가로크기
    private static int[][] map;
    private static boolean[][] visited;
    private static int result;

    public static void main(String[] args) throws IOException {
        setBase();

        dfs(0, 0);
        System.out.println(result);
    }

    private static void dfs(int row, int col) {
        if (row >= N) {
            sum();
            return;
        }

        if (col >= M) {
            dfs(row + 1, 0);
            return;
        }

        visited[row][col] = true;
        dfs(row, col + 1);

        visited[row][col] = false;
        dfs(row, col + 1);
    }

    private static void sum() {
        int sum = 0;
        int temp = 0;

        for (int i = 0; i < N; i++) {
            temp = 0;
            for (int j = 0; j < M; j++) {
                if (visited[i][j]) {
                    temp *= 10;
                    temp += map[i][j];
                } else {
                    sum += temp;
                    temp = 0;
                }
            }
            sum += temp;
        }

        for (int i = 0; i < M; i++) {
            temp = 0;
            for (int j = 0; j < N; j++) {
                if(!visited[j][i]) {
                    temp *= 10;
                    temp += map[j][i];
                } else {
                    sum += temp;
                    temp = 0;
                }
            }
            sum += temp;
        }

        result = Math.max(result, sum);
    }

    private static void setBase() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }
        visited = new boolean[N][M];
        result = 0;
    }
}
