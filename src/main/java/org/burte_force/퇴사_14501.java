package org.burte_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 퇴사_14501 {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static int N;
    private static int[] T;
    private static int[] P;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        setBase();

        System.out.println(solve());
    }

    private static int solve() {
        dp = new int[N+1];
        for (int i = 0; i < N; i++) {
            if(i + T[i] <= N) {
                dp[i + T[i]] = Math.max(dp[i + T[i]], dp[i] + P[i]);
            }

            dp[i+1] = Math.max(dp[i+1], dp[i]);
        }
        return dp[N];

    }

    private static void setBase() throws IOException {
        N = Integer.parseInt(reader.readLine());

        T = new int[N];
        P = new int[N];
        for (int i = 0; i < N; i++) {
            String input = reader.readLine();
            String[] inputTandP = input.split(" ");

            T[i] = Integer.parseInt(inputTandP[0]);
            P[i] = Integer.parseInt(inputTandP[1]);
        }
    }
}
