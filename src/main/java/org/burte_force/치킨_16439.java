package org.burte_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 치킨_16439 {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static int N;   // 회원의 수
    private static int M;   // 치킨 종류의 수
    private static int[][] favorites;
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        setBase();

        dfs(0, new int[3]);
        System.out.println(result);
    }

    private static void dfs(int count, int save[]) {
        if (count == 3) {
            int sum = 0;
            for (int i = 0; i < N; i++) {
                int max = 0;
                for (int j = 0; j < 3; j++) {
                    max = Math.max(max, favorites[i][save[j]]);
                }
                sum += max;
            }
            result = Math.max(result, sum);
            return;
        }

        for (int i = 0; i < M; i++) {
            save[count] = i;
            dfs(count + 1, save);
        }
    }

    private static void setBase() throws IOException {
        String input = reader.readLine();
        String[] inputNandM = input.split(" ");
        N = Integer.parseInt(inputNandM[0]);
        M = Integer.parseInt(inputNandM[1]);

        favorites = new int[N][M];
        for (int i = 0; i < N; i++) {
            String inputFavorite = reader.readLine();
            String[] inputFavorites = inputFavorite.split(" ");
            for (int j = 0; j < M; j++) {
                favorites[i][j] = Integer.parseInt(inputFavorites[j]);
            }
        }
    }
}
