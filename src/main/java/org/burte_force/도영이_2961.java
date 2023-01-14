package org.burte_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 도영이_2961 {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static int N;
    private static List<Ingredient> ingredients = new ArrayList<>();
    private static boolean[] visited;
    private static int result;

    public static void main(String[] args) throws IOException {
        setBase();

        dfs(0);
        System.out.println(result);
    }

    private static void dfs(int now) {
        if (now == N) {
            int sour = 1;
            int bitter = 0;
            int count = 0;
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    count++;
                    sour *= ingredients.get(i).sour;
                    bitter += ingredients.get(i).bitter;
                }
            }
            if (count == 0) {
                return;
            }
            result = Math.min(result, Math.abs(sour - bitter));
            return;
        }

        visited[now] = true;
        dfs(now + 1);

        visited[now] = false;
        dfs(now + 1);
    }

    private static class Ingredient {
        int sour;
        int bitter;

        Ingredient(int sour, int bitter) {
            this.sour = sour;
            this.bitter = bitter;
        }
    }

    private static void setBase() throws IOException {
        N = Integer.parseInt(reader.readLine());

        ingredients.clear();
        for (int i = 0; i < N; i++) {
            String input = reader.readLine();
            String[] inputs = input.split(" ");
            ingredients.add(new Ingredient(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1])));
        }

        visited = new boolean[N];
        result = Integer.MAX_VALUE;
    }
}
