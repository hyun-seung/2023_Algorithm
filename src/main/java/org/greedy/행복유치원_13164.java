package org.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 행복유치원_13164 {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static int N;
    private static int K;
    private static List<Integer> talls = new ArrayList<>();
    private static List<Integer> diffs = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        setBase();

        System.out.print(solve());
    }

    private static int solve() {
        getDiffs();
        int result = 0;

        for (int i = 0; i < N - K; i++) {
            result += diffs.get(i);
        }
        return result;
    }

    private static void getDiffs() {
        for (int i = 0; i < talls.size() - 1; i++) {
            diffs.add(talls.get(i + 1) - talls.get(i));
        }

        Collections.sort(diffs);
    }

    private static void setBase() throws IOException {
        String input = reader.readLine();
        String[] nk = input.split(" ");
        N = Integer.parseInt(nk[0]);
        K = Integer.parseInt(nk[1]);

        input = reader.readLine();
        String[] inputTalls = input.split(" ");
        for (int i = 0; i < N; i++) {
            talls.add(Integer.parseInt(inputTalls[i]));
        }
    }
}
