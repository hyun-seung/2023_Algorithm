package org.burte_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 링크와스타트_15661 {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static int N;
    private static int[][] S;
    private static boolean[] visited;
    private static int result = 0;

    private static int T;

    public static void main(String[] args) throws IOException {
        setBase();

        for (T = 1; T < N; T++) {
            dfs(0, 0);
        }
        System.out.println(result);
    }

    private static void dfs(int depth, int start) {
        if (depth == T) {
            result = Math.min(result, diff());
            return;
        }

        for (int i = start; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    private static int diff() {
        int start = 0;
        int link = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    start += (S[i][j] + S[j][i]);
                } else if (!visited[i] && !visited[j]) {
                    link += (S[i][j] + S[j][i]);
                }
            }
        }
        return Math.abs(start - link);
    }

    private static void setBase() throws IOException {
        N = Integer.parseInt(reader.readLine());

        S = new int[N][N];
        for (int i = 0; i < N; i++) {
            String input = reader.readLine();
            String[] inputs = input.split(" ");
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        visited = new boolean[N];
        result = Integer.MAX_VALUE;
    }
}
