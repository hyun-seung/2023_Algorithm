package org.burte_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FourSquares_17626 {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static int N;

    public static void main(String[] args) throws IOException {
        setBase();

        System.out.println(solve());
    }

    private static int solve() {
        int[] dp = new int[N + 1];
        dp[1] = 1;

        int min = 0;
        for (int i = 2; i <= N; i++) {
            min = Integer.MAX_VALUE;

            for (int j = 1; j * j <= i; j++) {
                int temp = i - j * j;
                min = Math.min(min, dp[temp]);
            }

            dp[i] = min + 1;
        }

        return dp[N];
    }

    private static void setBase() throws IOException {
        N = Integer.parseInt(reader.readLine());
    }
}
