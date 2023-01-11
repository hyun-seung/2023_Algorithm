package org.burte_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class 카드놓기_5568 {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static int N;
    private static int K;
    private static List<String> numbers = new ArrayList<>();
    private static boolean[] visited;
    private static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        setBase();

        visited = new boolean[N];
        set.clear();
        dfs(K, "");
        System.out.println(set.size());
    }

    private static void dfs(int leavings, String k) {
        if (leavings == 0) {
            set.add(k);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(leavings-1, k+numbers.get(i));
                visited[i] = false;
            }
        }
    }

    private static void setBase() throws IOException {
        N = Integer.parseInt(reader.readLine());
        K = Integer.parseInt(reader.readLine());

        numbers.clear();
        for (int i = 0; i < N; i++) {
            numbers.add(reader.readLine());
        }
    }
}
