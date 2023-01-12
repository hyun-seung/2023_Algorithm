package org.burte_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 꽃길_14620 {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static int[][] prices;
    private static boolean[][] visited;
    private static int result;

    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        setBase();

        dfs(0, 0);
        System.out.println(result);
    }

    private static void dfs(int count, int total) {
        if (count == 3) {
            result = Math.min(result, total);
            return;
        }

        for (int i = 1; i < N-1; i++) {
            for (int j = 1; j < N-1; j++) {
                if (!visited[i][j] && check(i, j)) {
                    visited[i][j] = true;
                    int sum = getSum(i, j);

                    dfs(count + 1, total + sum);

                    visitedClear(i, j);
                    visited[i][j] = false;
                }
            }
        }
    }

    private static void visitedClear(int x, int y) {
        for (int i = 0; i < dx.length; i++) {
            int tempX = x + dx[i];
            int tempY = y + dy[i];

            visited[tempX][tempY] = false;
        }
    }

    private static int getSum(int x, int y) {
        int result = prices[x][y];

        for (int i = 0; i < dx.length; i++) {
            int tempX = x + dx[i];
            int tempY = y + dy[i];

            visited[tempX][tempY] = true;
            result += prices[tempX][tempY];
        }
        return result;
    }

    private static boolean check(int x, int y) {
        for (int i = 0; i < dx.length; i++) {
            int tempX = x + dx[i];
            int tempY = y + dy[i];

            if (visited[tempX][tempY]) {
                return false;
            }
        }
        return true;
    }

    private static void setBase() throws IOException {
        N = Integer.parseInt(reader.readLine());

        prices = new int[N][N];
        for (int i = 0; i < N; i++) {
            String input = reader.readLine();
            String[] inputs = input.split(" ");
            for (int j = 0; j < N; j++) {
                prices[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        visited = new boolean[N][N];
        result = Integer.MAX_VALUE;
    }
}
