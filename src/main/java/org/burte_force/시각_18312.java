package org.burte_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 시각_18312 {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static int N;
    private static int K;

    public static void main(String[] args) throws IOException {
        setBase();

        System.out.println(solve());
    }

    private static int solve() {
        String target = Integer.toString(K);

        int count = 0;
        for (int i = 0; i <= N; i++) {
            String hour = String.format("%02d", i);
            for (int j = 0; j < 60; j++) {
                String minute = String.format("%02d", j);
                for (int k = 0; k < 60; k++) {
                    String second = String.format("%02d", k);

                    if (hour.contains(target) || minute.contains(target) || second.contains(target)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private static void setBase() throws IOException {
        String input = reader.readLine();
        String[] inputNandK = input.split(" ");
        N = Integer.parseInt(inputNandK[0]);
        K = Integer.parseInt(inputNandK[1]);
    }
}
